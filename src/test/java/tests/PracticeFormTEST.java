package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTEST {
    public WebDriver driver;

    @Test
    public void testMethod() {
        driver = new EdgeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement menuElement=driver.findElement(By.xpath("//h5[text()='Forms']"));
        executor.executeScript("arguments[0].click();", menuElement);

        WebElement submenuElement=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        executor.executeScript("arguments[0].click();", submenuElement);

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstnameElement = driver.findElement(By.cssSelector("input[placeholder ='First Name'"));
        String firstnameValue = "John";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement = driver.findElement(By.cssSelector("input[placeholder ='Last Name'"));
        String lastnameValue = "Doe";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder ='name@example.com'"));
        String emailValue = "johndoe@email.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneElement = driver.findElement(By.cssSelector("input[placeholder ='Mobile Number'"));
        String phoneValue = "0721523885";
        phoneElement.sendKeys(phoneValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Arts", "Accounting", "Maths");
        for (int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);

        }

        String genderValue = "Male";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue) {
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other ":
                genderElementList.get(0).click();
                break;
        }

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            hobbiesElementList.get(index).click();
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/Screenshot 2024-01-13 155908.png";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Street, Number 1234, Current";
        currentAddress.sendKeys(currentAddressValue);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        stateElement.sendKeys(stateValue);
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "D";
        cityElement.sendKeys(cityValue);
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();

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

        driver.quit();
    }
}