package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableHelper {

    public WebDriver driver;

    public TableHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void clearAndfillPForm(WebElement element,String value){
        element.sendKeys(value);
        element.clear();
        element.sendKeys(value);
    }
}
