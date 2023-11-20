package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustByNamePOM {
	
WebDriver driver;
	
	public SearchCustByNamePOM(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id="SearchFirstName")
	WebElement txtFirstName;

	@FindBy(id="SearchLastName")
	WebElement txtLastName;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr")
	List<WebElement> tablerow; //row calculate
	
	public void enterFirstName(String Firstname) {
		txtFirstName.sendKeys(Firstname);
	}

	public void enterLastName(String LastName) {
		txtLastName.sendKeys(LastName);
	}


	
	public boolean searchCustomerByName(String ExpectedName) {
		
		boolean found = false;
		int totalrows=tablerow.size();
		
	for(int i=1; i<=totalrows; i++) {
		
		WebElement webelementName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr[\"+ i +\"]/td[3]"));

		String ActualName = webelementName.getText();
		
		if(ActualName.equals(ExpectedName)) {
			
		found=true;

		
	}
	}
	return found;

	}
	
	

}
