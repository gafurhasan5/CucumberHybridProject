package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setup() throws IOException {
		Properties prop= ConfigReader.initializeProperties();
		//DriverFactory.initializeBrowser(prop.getProperty("browser"));
		//driver = DriverFactory.getDriver();
		driver=DriverFactory.initializeBrowser(prop.getProperty("browser"));
		
        driver.get(prop.getProperty("url"));
	}

	@After
	public void teardown(Scenario scenario) {
		String scenarioName=scenario.getName().replace(" ","_");
		if(scenario.isFailed())
		{
			byte[] Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(Screenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	}

}