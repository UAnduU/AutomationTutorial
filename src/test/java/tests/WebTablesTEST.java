package tests;

import helperMethods.ElementHelper;
import helperMethods.PracticeFormHelper;
import helperMethods.TabHelper;
import helperMethods.TableHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.sql.Driver;
import java.util.List;

public class WebTablesTEST extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper=new ElementHelper(driver);
        PracticeFormHelper practiceFormHelper=new PracticeFormHelper(driver);
        TableHelper tableHelper=new TableHelper(driver);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement menuElement=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickJSElement(menuElement);

        WebElement submenuElement=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickJSElement(submenuElement);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");

        //identificam un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="John";
        practiceFormHelper.fillPForm(firstnameElement,"John");

        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastnameValue="Doe";
        practiceFormHelper.fillPForm(lastnameElement,"Doe");

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="doejohn@gmail.com";
        practiceFormHelper.fillPForm(emailElement,"doejohn@gmail.com");

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        practiceFormHelper.fillPForm(ageElement,"27");

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="1500";
        practiceFormHelper.fillPForm(salaryElement,"1500");

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="Testing";
        practiceFormHelper.fillPForm(departmentElement,"Testing");

        WebElement submitElement=driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");

        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        //edit functionality
        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editfirstnameElement=driver.findElement(By.id("firstName"));
        String editfirstnameValue="Marcus";
        tableHelper.clearAndfillPForm(editfirstnameElement,"Marcus");

        WebElement editlastnameElement=driver.findElement(By.id("lastName"));
        String editlastnameValue="Riga";
        tableHelper.clearAndfillPForm(editlastnameElement,"Riga");

        WebElement editemailElement=driver.findElement(By.id("userEmail"));
        String editemailValue="riga.marcus@email.com";
        tableHelper.clearAndfillPForm(editemailElement,"riga.marcus@email.com");

        WebElement editageElement=driver.findElement(By.id("age"));
        String editageValue="69";
        tableHelper.clearAndfillPForm(editageElement,"69");

        WebElement editsalaryElement=driver.findElement(By.id("salary"));
        String editsalaryValue="999";
        tableHelper.clearAndfillPForm(editsalaryElement,"999");

        WebElement editdepartmentElement=driver.findElement(By.id("department"));
        String editdepartmentValue="Music";
        tableHelper.clearAndfillPForm(editdepartmentElement,"Music");

        WebElement editlineElement = driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editlineElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");

        Assert.assertTrue(tableList.get(tableSize).getText().contains(editfirstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editlastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editemailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editsalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editdepartmentValue));

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");
    }
}
