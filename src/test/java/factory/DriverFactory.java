package factory;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.ConfigReader;

public class DriverFactory {
	public static WebDriver driver;

	public static WebDriver initializeBrowser(String browserName) throws IOException {
		//Properties prop= ConfigReader.initializeProperties();
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) 
		{
			driver = new FirefoxDriver();
		}
	
//	else if(browserName.equals("edge"))
//    {
//     driver = new Edge();
//	}
	else if(browserName.equals("safari"))
	{

		driver = new SafariDriver();
	}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}

	public static WebDriver getDriver() {
		return driver;
	}
}