package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class MealBExpensePage {
    WebDriver driver;
    public MealBExpensePage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[id='navbar-second-toggle'] ul li:nth-child(4) a")
    public WebElement expenseButton;
    @FindBy(css = "#expenses-table_wrapper div div:nth-child(1) a:nth-child(2) span div button")
    public WebElement addExpenseButton;
    @FindBy(css = ".dataTables_wrapper.no-footer div div a:nth-child(2) span div ul li:nth-child(2) a")
    public WebElement meal_entertainmentButton;
    @FindBy(xpath = "(//*[@class='picker__button--today'])[3]")
    public WebElement todayButon;

    @FindBy(id = "ExpenseDateTime")
    public WebElement enterExpenseDateBox;

    @FindBy(id = "Amount")
    public WebElement amountBox;
    @FindBy(id = "name")
    public WebElement expenseNameBox;
    @FindBy(xpath = "(//*[text()='Select expense relationship'])[1]")
    public WebElement expenseRelationshipBox;
    @FindBy(xpath = "(//*[@class='dropdown-menu inner'])[2]/li[3]/a")
    public WebElement vendorDropButton;
    @FindBy(id = "BusinessPurpose")
    public WebElement expenseBusinessPurpose;
    @FindBy(id = "VendorName")
    public WebElement vendorName;
    @FindBy(id = "Company")
    public WebElement companyBox;
    @FindBy(id = "ProjectName")
    public WebElement projectName;
    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;










}
