package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertsTEST extends SharedData {

    @Test

    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);

        WebElement menuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(menuElement);

        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.clickJSElement(alertsElement);

        WebElement clickButton1 = driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(clickButton1);
        alertHelper.acceptAlert();

        WebElement clickButton2 = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(clickButton2);
        //wait explicit pentru alerta
        alertHelper.acceptAlert();

        WebElement clickButton3 = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(clickButton3);
        alertHelper.dismissAlert();

        WebElement clickButton4 = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(clickButton4);
        alertHelper.fillAlert("Text");


    }
}
