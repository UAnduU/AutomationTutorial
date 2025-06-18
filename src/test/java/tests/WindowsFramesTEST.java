package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsFramesAlertsTEST {

    public WebDriver driver;

    @Test

    public void testMethod(){

        driver = new EdgeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement menuElement=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        executor.executeScript("arguments[0].click();", menuElement);

        WebElement submenuElement=driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        executor.executeScript("arguments[0].click();", submenuElement);

        WebElement tabButton=driver.findElement(By.id("tabButton"));
        tabButton.click();

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
