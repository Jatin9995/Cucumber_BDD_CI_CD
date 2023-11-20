	package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
	WebDriver driver;

	//POM is used here for Add a new customer

	public AddNewCustomerPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	//Find web elements on the web page

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement Customer_menu;

	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement Customer_menuitem;

	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	WebElement btnAddnew;

	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@name='Password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;

	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement MaleGender;

	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtDob;

	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompanyName;

	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement taxEmempt;

	@FindBy(xpath="//select[@id='VendorId']")
	WebElement listItemVendors; 

	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement adcomment;

	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;


////////////////////////////////  Methods for above web elements  /////////////////////////////////////////////////

	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	

	public void clickOnCustomersMenu() {
		Customer_menu.click();
	}

	public void clickOnCustomersMenuItem() {
		Customer_menuitem.click();
	}

	public void clickOnAddnew() {
		btnAddnew.click();
	}

	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	public void enterFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}

	public void enterGender() {

		MaleGender.click();
	}

	public void enterDob(String dob)
	{
		txtDob.sendKeys(dob);
	}

	public void enterCompanyName(String coName)
	{
		txtCompanyName.sendKeys(coName);
	}

	public void IsTaxexempt() {
		taxEmempt.click();
	}

	public void enterManagerOfVendor(String value) {

		Select drp=new Select(listItemVendors);
		drp.selectByVisibleText(value);

	}

	public void enterAdminContent(String content)
	{
		adcomment.sendKeys(content);
	}

	public void clickOnSave()
	{
		savebtn.click();
	}
















	

}
