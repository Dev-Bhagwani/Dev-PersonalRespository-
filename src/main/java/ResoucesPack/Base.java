package ResoucesPack;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeBrowser() throws IOException {
		
		 prop = new Properties();    // imported java properties
		String propertiesPath = System.getProperty("user.dir") +"\\src\\main\\java\\ResoucesPack\\data.properties";   // location of data.properties file
		
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);
		
		
		String broswerName = prop.getProperty("browser");   // given browser which will be retreived from data.properties
		
		if(broswerName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(broswerName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	
		}else if(broswerName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
}
