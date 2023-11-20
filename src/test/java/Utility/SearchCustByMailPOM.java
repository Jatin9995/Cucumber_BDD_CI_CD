package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustByMailPOM {

WebDriver driver;
	
	public SearchCustByMailPOM(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	///////////Search customer by mail//////////////////////
	
	@FindBy(name="SearchEmail")
	WebElement emailAdd;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr")
	List<WebElement> tablerow; //row calculate
	
	

public void enterEmailAdd(String email) {
	emailAdd.sendKeys(email);

}

public void clickOnSearchBtn() {
	searchBtn.click();

}
	
public boolean searchcustomermailintable(String email) {
	
	boolean found=false;
	
	int totalrow = tablerow.size();
	
	for(int i=1;i<=totalrow;i++) {
		WebElement webelement=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody/tr[\"+ i +\"]/td[2]"));
		String actualmail = webelement.getText();
		
		if(actualmail.equals(email)) {
			found=true;
		}



}
	return found;
}
}