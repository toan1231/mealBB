package ui_automation.step_definitions;
//cai nay thu thoi 08/01
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import ui_automation.pages.MealBExpensePage;
import ui_automation.pages.MealBLoginPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;
import ui_automation.utilities.ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MealBStepDef {

    MealBLoginPage mealBLoginPage=new MealBLoginPage();
    MealBExpensePage mealBExpensePage=new MealBExpensePage();
    WebDriver driver=Driver.getInstance().getDriver();
    /////////////////
    String amount;
    String expenseName;
    String businessPurpose;
    String vendorName;
    String company;
    @Given("user navigates to MealB login page")
    public void user_navigates_to_MealB_login_page() {
       driver= Driver.getInstance().getDriver();


    driver.get(ConfigurationReader.getProperty("ui-config.properties","mealb.url"));


    }

    @Then("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials()throws InterruptedException {
    String username=ConfigurationReader.getProperty("ui-config.properties","mealb.username");
    String password=ConfigurationReader.getProperty("ui-config.properties","mealb.password");
   mealBLoginPage.login(username,password);

    }

    @Then("user clicks on Add Expense button")
    public void user_clicks_on_Add_Expense_button() throws InterruptedException {
        mealBExpensePage.expenseButton.click();
        mealBExpensePage.addExpenseButton.click();



    }

    @Then("user selects Meal and Entertainment option option")
    public void user_selects_Meal_and_Entertainment_option_option() throws InterruptedException {
    mealBExpensePage.meal_entertainmentButton.click();



    }

    @Then("user fill out all fields on Meal and Entertainment modal window")
    public void user_fill_out_all_fields_on_Meal_and_Entertainment_modal_window() throws Exception {

       String path=System.getProperty("user.dir")+"/src/test/resources/testData/Keywords.xlsx";

        mealBExpensePage.enterExpenseDateBox.click();
        //scroll down the medal box
        JavascriptExecutor st=(JavascriptExecutor)driver;
        st.executeScript("arguments[0].scrollIntoView();",mealBExpensePage.todayButon);
        //cannot choose other dates so i choose today button on the bottom of medal
        mealBExpensePage.todayButon.click();
        ExcelUtility.setExcelFile(path,"Sheet1");
      //////////////////////////

         amount= ExcelUtility.getCellData(3,1).toString();
        mealBExpensePage.amountBox.sendKeys(amount);

         expenseName= ExcelUtility.getCellData(6,2).toString();
        mealBExpensePage.expenseNameBox.sendKeys(expenseName);

        mealBExpensePage.expenseRelationshipBox.click();
        mealBExpensePage.vendorDropButton.click();

         businessPurpose= ExcelUtility.getCellData(6,4).toString();
        mealBExpensePage.expenseBusinessPurpose.sendKeys(businessPurpose);
        vendorName= ExcelUtility.getCellData(6,5).toString();
        mealBExpensePage.vendorName.sendKeys(vendorName);
        company= ExcelUtility.getCellData(6,6).toString();
        mealBExpensePage.companyBox.sendKeys(company);
        JavascriptExecutor mt=(JavascriptExecutor) driver;
        /////
        mt.executeScript("arguments[0].value='hoi chung mien nhiem'",mealBExpensePage.projectName);


    }
    @And("user clicks on save button")
    public void userClicksOnSaveButton() throws InterruptedException, IOException {

     TakesScreenshot screenshot=(TakesScreenshot) driver;
     File scr=screenshot.getScreenshotAs(OutputType.FILE);
     String path="src/test/resources/testData/person.png";
        File file=new File("src/test/resources/testData/person.png");
        FileUtils.copyFile(scr,file);
        mealBExpensePage.saveButton.click();



    }

    @Given("user verifies that newly created expense show up on expense table")
    public void userVerifiesThatNewlyCreatedExpenseShowUpOnExpenseTable() throws InterruptedException {


//I just change something something



    }

}
