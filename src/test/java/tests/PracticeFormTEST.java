package tests;

import helperMethods.ElementHelper;
import helperMethods.PracticeFormHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTEST extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper=new ElementHelper(driver);
        PracticeFormHelper practiceFormHelper=new PracticeFormHelper(driver);

        WebElement menuElement=driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickJSElement(menuElement);

        WebElement submenuElement=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickJSElement(submenuElement);

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstnameElement = driver.findElement(By.cssSelector("input[placeholder ='First Name'"));
        String firstnameValue="John";
        practiceFormHelper.fillPForm(firstnameElement,"John");

        WebElement lastnameElement = driver.findElement(By.cssSelector("input[placeholder ='Last Name'"));
        String lastnameValue="Doe";
        practiceFormHelper.fillPForm(lastnameElement,"Doe");

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder ='name@example.com'"));
        String emailValue="johndoe@email.com";
        practiceFormHelper.fillPForm(emailElement,"johndoe@email.com");

        WebElement phoneElement = driver.findElement(By.cssSelector("input[placeholder ='Mobile Number'"));
        String phoneValue="07231513412";
        practiceFormHelper.fillPForm(phoneElement,"07231513412");;

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Arts", "Accounting", "Maths");
        for (int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            elementHelper.pressElement(subjectsElement,Keys.ENTER);
        }

        String genderValue = "Other";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue) {
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Music", "Sports");
        for(int index = 0; index<hobbiesElementList.size();index++){
            if(hobbiesValues.contains(hobbiesElementList.get(index).getText())){
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/Screenshot 2024-01-13 155908.png";
        File file = new File(uploadValue);
        practiceFormHelper.fillPForm(uploadElement, file.getAbsolutePath());

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        practiceFormHelper.fillPForm(currentAddress,"Street, No, Apt");

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        practiceFormHelper.fillPForm(stateElement,"NY");
        elementHelper.pressElement(stateElement,Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        practiceFormHelper.fillPForm(cityElement,"City");
        elementHelper.pressElement(cityElement,Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstnameValue), "First Name is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastnameValue), "Last Name is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Email is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), phoneValue, "Mobile is not displayed right in the table");
    }
}