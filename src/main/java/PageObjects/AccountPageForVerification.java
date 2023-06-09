package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPageForVerification {
	
	WebDriver Driver;
	
	public AccountPageForVerification(WebDriver driver)  {
		this.Driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Edit your account information")
	WebElement editAccountInformationOption;

	public WebElement editAccountInformationOption() {
		return editAccountInformationOption;
	}
}
