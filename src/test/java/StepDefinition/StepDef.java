package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.AddNewCustomerPage;
import Utility.Baseclass;
import Utility.SearchCustByMailPOM;
import Utility.SearchCustByNamePOM;
import Utility.loginPOM;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class StepDef extends Baseclass {

	WebDriver driver;
	loginPOM page;
	AddNewCustomerPage AddnewCustpg;
	SearchCustByMailPOM searchbymail;
	SearchCustByNamePOM SearchCustByName;

	//===================LOG=========================================================================================================================	
	//	public void setuplog() {   //we are hiding the logs as we have to work on hooks that is why hiding this method.
	//		
	//		log=Logger.getLogger("StepDef");
	//		PropertyConfigurator.configure("J:\\eclipse_Jdrive\\Cucumber_BDD_CI_CD\\Logger_folder\\log.properties");
	//		log.info("Logsetup done");
	//	}
	//	
	//=================================================================================================================================================	
	//***************HOOKS****************************

	//@Before   //hooks are the block of code that runs before and after each scenario.@before & @After are called scenario hooks that runs before 
	//and after each scenario.
	//step hooks are used before & after each step of the scenario.
	//Conditionals hooks :-we can associate hooks with tags for conditional execution.

	//@Before ("@Sanity")//As per tag the Before method execute. same also mention in test runner tag. 2 before methods are here and we choose which before method tag should used for sanity testing
//public void setup1() {  //conditional hooks
////
////		System.out.println("Setup1-sanity method executed");
//		System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Chrome\\Chrome2\\chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//
//	}
//
//	@Before ("@regression")  //conditional hooks
//	public void setup2() {  //scenario hooks
//
//		System.out.println("Setup2-regression method executed");
//		System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Cucumber_BDD_CI_CD\\Chrome\\chromedriver.exe");
//		driver=new ChromeDriver();

	//}
	
	
/*@BeforeStep  //this will execute before each step
	public void beforestepMethod() {

		System.out.println("This is before step method..");
	}

@AfterStep   //this will execute after each step
	public void afterstepMethod() {

		System.out.println("This is after step method..");
	}*/



	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {

		System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Chrome\\Chrome2\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

		
		AddnewCustpg=new AddNewCustomerPage(driver);
		searchbymail=new SearchCustByMailPOM(driver);
		SearchCustByName=new SearchCustByNamePOM(driver);
		//  log.info("Chrome Browser Lanuched");
	}

	@When("User opens URL as {string}")
	public void user_opens_url_as(String url) {

		driver.navigate().to(url);
		//log.info("URL opens");
	}

	@And("User enter Email id as {string} and Password as {string}")
	public void user_enter_email_id_as_and_password_as(String emailAdd, String Pasword) {

		page=new loginPOM(driver);
		page.enteruid(emailAdd);
		page.enterpwd(Pasword);
		//log.info("Mail id & Passwor entered");

	}

	@And("Click on Login")
	public void click_on_login() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//log.info("Clicked on login button");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String ExpectedTitle) throws InterruptedException {
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(ExpectedTitle)) {

			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		// log.info("Page title verified");
	}



	@When("User clicks on logout button")
	public void user_clicks_on_logout_button() {

		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		//log.info("clicked on logout button");
	}

	@Then("User close the browser")
	public void user_close_the_browser() {

		driver.close();
		//log.info("Browser closed");

	}

	//====================================================================================================================================	
	//**************ADD NEW CUSTOMER**********************************************************

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {

		String ExpectedTitle = "Dashboard / nopCommerce administration";
		String ActualTitle = AddnewCustpg.getPageTitle();
		if(ExpectedTitle.equals(ActualTitle)) {
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}
		//log.info("Title Verified");

	}

	@And("User clicks on customer menu")
	public void user_clicks_on_customer_menu() {

		AddnewCustpg.clickOnCustomersMenu();

		//log.info("Clicked on customer menu");

	}
	@And("clicks on customer menu item")
	public void clicks_on_customer_menu_item() {

		AddnewCustpg.clickOnCustomersMenuItem();
		//log.info("Clicked on customer menu item");

	}
	@And("Clicks on Add new button")
	public void clicks_on_add_new_button() {

		AddnewCustpg.clickOnAddnew();
		//	log.info("Clicked in Add new button");


	}
	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {

		String ExpectedTitle = "Add a new customer / nopCommerce administration";
		String ActualTitle = AddnewCustpg.getPageTitle();
		if(ExpectedTitle.equals(ActualTitle)) {
			Assert.assertTrue(true);
			//log.info("Title verified");
		}

		else {
			Assert.assertTrue(false);
		}

	}
	@When("user enter the customer info")
	public void user_enter_the_customer_info() {

		AddnewCustpg.enterEmail(getrandommailid() + "@gmail.com");
		AddnewCustpg.enterPassword("Paytm@123");
		AddnewCustpg.enterFirstName("Jatin");
		AddnewCustpg.enterLastName("Rajput");
		AddnewCustpg.enterGender();
		AddnewCustpg.enterDob("3/07/1990");
		AddnewCustpg.enterCompanyName("Prologic web solutions");
		AddnewCustpg.IsTaxexempt();
		AddnewCustpg.enterManagerOfVendor("Vendor 2");
		AddnewCustpg.enterAdminContent("This is a successful company");

		//	log.info("Entered customer info.");

	}
	@When("clicks on save button")
	public void clicks_on_save_button() {
		AddnewCustpg.clickOnSave(); 
		//log.info("Clicked save button");

	}
	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String Expepectedconfirmationmsg) {

		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(Expepectedconfirmationmsg)) {

			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
			//log.info("Verified confirmation message");
		}

	}

	//====================================================================================================================================	
	//**************SEARCH CUSTOMER BY MAIL**********************************************************	

	@When("Enter customer mail id")
	public void enter_customer_mail_id() {
		searchbymail.enterEmailAdd("admin@yourStore.com");



	}
	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		searchbymail.clickOnSearchBtn();
		Thread.sleep(1000);


	}
	@Then("user should found mail id in the search table")
	public void user_should_found_mail_id_in_the_search_table() {

		String expectedemail = "admin@yourStore.com";
		if(searchbymail.searchcustomermailintable(expectedemail)==true) {
			Assert.assertTrue(true);
		}	

		else {
			Assert.assertTrue(false);

		}

	}

	//====================================================================================================================================	
	//**************SEARCH CUSTOMER BY NAME**********************************************************		

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {

		SearchCustByName.enterFirstName("Jatin");
	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() {

		SearchCustByName.enterLastName("Rajput");

	}
	@Then("user should found name in the search table.")
	public void user_should_found_name_in_the_search_table() {

		String ExpectedName = "Jatin Rajput";

		if(SearchCustByName.searchCustomerByName(ExpectedName)==true) {
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}


	}

	/*@After  //used after each scenario. after method is also used as a ITest listeners.
	public void Teardown() throws InterruptedException {


		System.out.println("Tear down method executed");
		driver.quit();
	}*/

@After  //@after method is also used as Listeners and used to take the screenshot.
public void teardown(Scenario sc) throws IOException {
	
	if(sc.isFailed()==true) {
     TakesScreenshot srcshot=((TakesScreenshot)driver);
    File src = srcshot.getScreenshotAs(OutputType.FILE);
    File Destination=new File("J:\\eclipse_Jdrive\\Cucumber_BDD_CI_CD\\Screenshot\\screenshot1.png");
    FileUtils.copyFile(src, Destination);    
	}
	
}




}








