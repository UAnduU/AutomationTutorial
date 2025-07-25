package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstnameElement;
    @FindBy(id = "lastName")
    private WebElement lastnameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "age")
    private WebElement editAgeElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstnameValue, String lastnameValue, String emailValue, String ageValue,
                            String salaryValue, String departmentValue) {
        elementHelper.validateListSize(tableList, tableSize);
        clickAddButton();
        fillFirstName(firstnameValue);
        fillLastName(lastnameValue);
        fillEmailAddress(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList, tableSize + 1);
        elementHelper.validateElementContainsText(tableList.get(tableSize), firstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), lastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);
    }

    public void editNewEntry(int tableSize, String editFirstnameValue, String editLastnameValue, String editEmailValue, String editAgeValue,
                             String editSalaryValue, String editDepartmentValue) {

        clickEditButton();
        fillEditFirstName(editFirstnameValue);
        fillEditLastName(editLastnameValue);
        fillEditEmailAddress(editEmailValue);
        fillEditAge(editAgeValue);
        fillEditSalary(editSalaryValue);
        fillEditDepartment(editDepartmentValue);
        clickSubmit();

        elementHelper.validateListSize(tableList, tableSize + 1);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);

    }

    public void deleteNewEntry(int tableSize) {
        clickDeleteButton();
    }

    public void clickAddButton() {
        elementHelper.clickElement(addElement);
    }

    public void fillFirstName(String firstnameValue) {
        elementHelper.fillElement(firstnameElement, firstnameValue);
    }

    public void fillLastName(String lastnameValue) {
        elementHelper.fillElement(lastnameElement, lastnameValue);
    }

    public void fillEmailAddress(String emailValue) {
        elementHelper.fillElement(emailElement, emailValue);
    }

    public void fillAge(String ageValue) {
        elementHelper.fillElement(ageElement, ageValue);
    }

    public void fillSalary(String salaryValue) {
        elementHelper.fillElement(salaryElement, salaryValue);
    }

    public void fillDepartment(String departmentValue) {
        elementHelper.fillElement(departmentElement, departmentValue);
    }

    public void clickSubmit() {
        elementHelper.clickJSElement(submitElement);
    }

    public void clickEditButton() {

        elementHelper.clickJSElement(editElement);
    }

    public void fillEditFirstName(String firstnameValue) {
        elementHelper.clearFillElement(editFirstNameElement, firstnameValue);
    }

    public void fillEditLastName(String lastnameValue) {
        elementHelper.clearFillElement(editLastNameElement, lastnameValue);
    }

    public void fillEditEmailAddress(String emailValue) {
        elementHelper.clearFillElement(editEmailElement, emailValue);
    }

    public void fillEditAge(String ageValue) {
        elementHelper.clearFillElement(editAgeElement, ageValue);
    }

    public void fillEditSalary(String salaryValue) {
        elementHelper.clearFillElement(editSalaryElement, salaryValue);
    }

    public void fillEditDepartment(String departmentValue) {
        elementHelper.clearFillElement(editDepartmentElement, departmentValue);
    }

    public void clickDeleteButton() {
        elementHelper.clickJSElement(deleteElement);
    }
}