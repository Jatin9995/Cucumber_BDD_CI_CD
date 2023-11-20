package Utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Baseclass {
	
	public WebDriver driver;
	public loginPOM page;
	public AddNewCustomerPage AddnewCustpg;
    public Logger log;
	
public String getrandommailid() {
	
	return(RandomStringUtils.randomAlphabetic(5));
}
    
    
}
