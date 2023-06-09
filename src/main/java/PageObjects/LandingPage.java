package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver Driver;
	
	public LandingPage(WebDriver driver) {    // constructor
		
		this.Driver = driver;
		PageFactory.initElements(driver, this);   // this means initialize the objects in this class 
		 
	}
	
	@FindBy(xpath = "//a[@title ='My Account']")           // in page factory we use FindBy instead of driver.find element
	WebElement myAccountDropdown;                  // created myAccountDropdown
	
	@FindBy(linkText = "Login")
	WebElement loginOption;
	
	
	public WebElement myAccountDropdown()  {
	  return myAccountDropdown;
	  
}
	
	public WebElement loginOption() {
		return loginOption; 
		
	}
	

}
