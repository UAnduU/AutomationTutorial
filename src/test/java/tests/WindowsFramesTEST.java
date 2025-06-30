package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowsFramesTEST extends SharedData {

    @Test

    public void testMethod(){

        ElementHelper elementHelper=new ElementHelper(driver);

        WebElement menuElement=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(menuElement);

        WebElement submenuElement=driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickJSElement(submenuElement);

        WebElement tabButton=driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(tabButton);

        List<String> tabsList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(tabsList.get(0));
        System.out.println(driver.getCurrentUrl());

        WebElement windowButton=driver.findElement(By.id("windowButton"));
        windowButton.click();

        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(windowList.get(0));
        System.out.println(driver.getCurrentUrl());
    }
}
