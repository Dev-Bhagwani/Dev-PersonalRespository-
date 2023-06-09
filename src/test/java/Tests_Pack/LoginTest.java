package Tests_Pack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPageForVerification;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import ResoucesPack.Base;

public class LoginTest extends Base{     // (Base_Class) is a parent class which is imported for activating the browser  
		
	WebDriver driver;
	
	@Test(dataProvider = "getLoginData")
	public void Login(String email, String password, String expectedResult) throws IOException, InterruptedException{   // creating three parameters for a data
		
		 
		
		
		LandingPage landingPage = new LandingPage(driver);     // calling the constructor from LandPage class
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);   // email is written in data properties file
		loginPage.passwordField().sendKeys(password);    // password is written in data properties
		loginPage.loginButton().click();
		
		AccountPageForVerification accountPage = new AccountPageForVerification(driver); 
		
		String actualResult = null;
		
		try {
	       if(accountPage.editAccountInformationOption().isDisplayed())  {   // if this is displayed then only gave actual result = successfull
	        actualResult = "Successfull";
	       }
	        
		}catch (Exception e) {
			actualResult = "Failure";
		}

		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@BeforeMethod     // this will run first after this above test case will run 
	public void openApplication() throws IOException  {
		
		driver = initializeBrowser();   // method from the Base_Class is called
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void closingbrowser()  {
		
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getLoginData()  {
		
		// there are 3 parameters in this lines
		Object[] [] data = {{"dev2@gmail.com", "@12345", "Successfull"}, {"dummy@gmail.com", "dummy", "Failure"}};   
		
		return data;
	}
	
}
