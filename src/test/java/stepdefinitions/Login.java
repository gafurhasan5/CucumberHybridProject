
package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	LoginPage loginpage;

	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {

		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		homepage.clickLoginOption();
		// driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		loginpage = new LoginPage(driver);
	}

	@When("^User entered the valid email address (.+) into the email field$")
	public void user_entered_the_valid_email_address_into_the_email_field(String emailtext) {
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailtext);
		//loginpage = new LoginPage(driver);
		loginpage.EnterEmailField(emailtext);

	}

	@And("^User entered the valid password (.+) into the password field$")
	public void user_entered_the_valid_password_into_the_password_field(String password) {
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		// loginpage = new LoginPage(driver);
		loginpage.EnterPasswordField(password);

	}
//	@When("User entered the valid email address {string} into the email field")
//	public void user_entered_the_valid_email_address_into_the_email_field(String emailtext) {
//		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailtext);
//		//loginpage = new LoginPage(driver);
//		loginpage.EnterEmailField(emailtext);
//
//	}
//
//	@And("User entered the valid password {string} into the password field")
//	public void user_entered_the_valid_password_into_the_password_field(String password) {
//		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
//		// loginpage = new LoginPage(driver);
//		loginpage.EnterPasswordField(password);
//
//	}

	@And("User click the login button")
	public void user_click_the_login_button() {
		// driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		loginpage.clickButtonField();

	}

	@Then("User should get  successfully  logged in")
	public void user_should_get_successfully_logged_in() {
		// Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit
		// your account information']")).isDisplayed());
		MyAccountPage myaccountpage = new MyAccountPage(driver);
		Assert.assertTrue(myaccountpage.DisplayEditAccountInformationMsg());
	}

	@When("User entered the invalid email address into the email field")
	public void user_entered_the_invalid_email_address_into_the_email_field() {
		//loginpage = new LoginPage(driver);
		loginpage.EnterEmailField(CommonUtils.getTimestampEmail());
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.getTimestampEmail());
	}

	@When("User entered the invalid password {string} into the password field")
	public void user_entered_the_invalid_password_into_the_password_field(String invalidpassword) {
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidpassword);
		loginpage.EnterPasswordField(invalidpassword);

	}

	@Then("User should get  proper warning message about credential mismatch")
	public void user_should_get_proper_warning_message_about_credential_mismatch() {
		Assert.assertTrue(loginpage.getWarningMsg().contains("Warning: No match for E-Mail Address and/or Password"));
	}

	@When("User dont entered email into the email field")
	public void user_dont_entered_email_into_the_email_field() {
		//loginpage = new LoginPage(driver);
		loginpage.EnterEmailField("");
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
	}

	@When("User dont entered password  into the password field")
	public void user_dont_entered_password_into_the_password_field() {
		// loginpage = new LoginPage(driver);
		loginpage.EnterPasswordField("");
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
	}

}
