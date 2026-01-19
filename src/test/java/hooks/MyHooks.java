package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setup() {

		Properties prop = null;
		try {
			prop = ConfigReader.initializeProperties();
		} catch (IOException e) {


			e.printStackTrace();
		}
		DriverFactory.initializeBrowser(prop.getProperty("broser"));
		driver = DriverFactory.getDriver();
		// driver = new ChromeDriver();
		// driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@After
	public void teardown() {
		driver.quit();
	}

}