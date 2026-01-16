package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public static WebDriver driver;

	public static void initializeBrowser(String browserName) {
		// if (browserName.equals("chrome")) {
		driver = new ChromeDriver();
//	else if (browserName.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} 
//		} else if (browserName.equals("edge")) {
//
//			driver = new ();
//		} else if (browserName.equals("safari")) {
//
//			driver = new SafariDriver();
//		}

	}

	public static WebDriver getDriver() {
		return driver;
	}
}