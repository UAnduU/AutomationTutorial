package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class WebTablesTEST {
    public WebDriver driver;

    @Test
    public void testMethod(){
        //deschidem o instanta de Chrome
        driver=new EdgeDriver();

        //accesam o pagina specifica
        driver.get("https://demoqa.com/");

        //facem browser ul maximize
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement menuElement=driver.findElement(By.xpath("//h5[text()='Elements']"));
        executor.executeScript("arguments[0].click();", menuElement);

        WebElement submenuElement=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        executor.executeScript("arguments[0].click();", submenuElement);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");

        //identificam un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="John";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastnameValue="Doe";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="johndoe@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="6000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="Testing";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement=driver.findElement(By.id("submit"));
        submitElement.click();

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
        editfirstnameElement.clear();
        editfirstnameElement.sendKeys(editfirstnameValue);

        WebElement editlastnameElement=driver.findElement(By.id("lastName"));
        String editlastnameValue="Riga";
        editlastnameElement.clear();
        editlastnameElement.sendKeys(editlastnameValue);

        WebElement editemailElement=driver.findElement(By.id("userEmail"));
        String editemailValue="marcus.riga@gmail.com";
        editemailElement.clear();
        editemailElement.sendKeys(editemailValue);

        WebElement editageElement=driver.findElement(By.id("age"));
        String editageValue="69";
        editageElement.clear();
        editageElement.sendKeys(editageValue);

        WebElement editsalaryElement=driver.findElement(By.id("salary"));
        String editsalaryValue="9999";
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editdepartmentElement=driver.findElement(By.id("department"));
        String editdepartmentValue="Music";
        editdepartmentElement.clear();
        editdepartmentElement.sendKeys(editdepartmentValue);

        WebElement editlineElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editlineElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");

        Assert.assertTrue(tableList.get(tableSize).getText().contains(editfirstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editlastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editemailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editsalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editdepartmentValue));

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");

        driver.quit();

    }
}
