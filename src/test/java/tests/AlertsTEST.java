package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTEST {

    public WebDriver driver;

    @Test

    public void testMethod() {

        driver = new EdgeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        //wait implicit
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement menuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", menuElement);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        executor.executeScript("arguments[0].click();", alertsElement);

        WebElement clickButton1 = driver.findElement(By.id("alertButton"));
        clickButton1.click();
        Alert alertOk=driver.switchTo().alert();
        alertOk.accept();

        WebElement clickButton2 = driver.findElement(By.id("timerAlertButton"));
        clickButton2.click();
        //wait explicit pentru alerta
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertWait=driver.switchTo().alert();
        alertWait.accept();

        WebElement clickButton3 = driver.findElement(By.id("confirmButton"));
        clickButton3.click();
        Alert alertCancel=driver.switchTo().alert();
        alertCancel.dismiss();

        WebElement clickButton4 = driver.findElement(By.id("promtButton"));
        clickButton4.click();
        Alert alertPrompt=driver.switchTo().alert();
        alertPrompt.sendKeys("Test field");
        alertPrompt.accept();


    }
}
