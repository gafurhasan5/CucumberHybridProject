
package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public static WebDriver driver;

	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {

		driver = DriverFactory.getDriver();
		// Thread.sleep("10");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

	}

	@When("User entered the valid email address {string} into the email field")
	public void user_entered_the_valid_email_address_into_the_email_field(String emailtext) {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailtext);

	}

	@And("User entered the valid password {string} into the password field")
	public void user_entered_the_valid_password_into_the_password_field(String password) {
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);

	}

	@And("User click the login button")
	public void user_click_the_login_button() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

	}

	@Then("User should get  successfully  logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@When("User entered the invalid email address into the email field")
	public void user_entered_the_invalid_email_address_into_the_email_field() {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getTimestampEmail());
	}

	@When("User entered the invalid password {string} into the password field")
	public void user_entered_the_invalid_password_into_the_password_field(String invalidpassword) {
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidpassword);

	}

//	@Then("User should get  proper warning message about credential mismatch")
//	public void user_should_get_proper_warning_message_about_credential_mismatch() {
//		String actualmessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
//				.getText();
//		Assert.assertTrue(actualmessage.contains("Warning: No match for E-Mail Address and/or Password."));
//
//	}
	@Then("User should get  proper warning message about credential mismatch")
   public void user_should_get_proper_warning_message_about_credential_mismatch() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   // wait for page reload
	   wait.until(ExpectedConditions.urlContains("account/login"));
	   WebElement warningMessage = wait.until(
	       ExpectedConditions.visibilityOfElementLocated(
	           By.xpath("//div[contains(@class,'alert-danger')]"))
	   );
	   String actualMessage = warningMessage.getText();
	   Assert.assertTrue(
	       actualMessage.contains("Warning: No match for E-Mail Address and/or Password")
	   );
	}

	@When("User dont entered email into the email field")
	public void user_dont_entered_email_into_the_email_field() {
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
	}

	@When("User dont entered password  into the password field")
	public void user_dont_entered_password_into_the_password_field() {
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
	}

	public String getTimestampEmail() {
		Date date = new Date();
		return "rehankhan" + date.toString().replace("", "").replace(":", "") + "@gmail.com";
	}

}
