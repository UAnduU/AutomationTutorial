package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormHelper {

    public WebDriver driver;

    public PracticeFormHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPForm(WebElement element,String value){
        element.sendKeys(value);
    }
}
