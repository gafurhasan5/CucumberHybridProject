package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setup() {

		DriverFactory.initializeBrowser("chrome");
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