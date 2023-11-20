package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPOM {
	
	
	WebDriver driver;

	@FindBy(id="Email")
	WebElement email;

	@FindBy(className="password")
	WebElement pwd;
	
	public loginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enteruid(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}


	public void enterpwd(String Pasword) {
		
        pwd.clear();
		pwd.sendKeys(Pasword);
	}

	
	

}
