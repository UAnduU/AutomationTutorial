package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTEST extends SharedData {

    @Test

    public void testMethod() {

        ElementHelper elementHelper=new ElementHelper(driver);

        WebElement menuElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(menuElement);

        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementHelper.clickJSElement(framesElement);

        driver.switchTo().frame("frame1");
        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame1");
        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement.getText());
    }
}
