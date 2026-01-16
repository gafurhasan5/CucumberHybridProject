package stepdefinitions;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Register {
	WebDriver driver;

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

	}

	@When("User enter the below details  into below fields")
	public void user_enter_the_below_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(getTimestampEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("telephone");
		driver.findElement(By.id("input-password")).sendKeys("password");
		driver.findElement(By.id("input-confirm")).sendKeys("password");

	}

	@When("User enter the below details  into below fields with duplicate email")
	public void User_enter_the_below_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys("telephone");
		driver.findElement(By.id("input-password")).sendKeys("password");
		driver.findElement(By.id("input-confirm")).sendKeys("password");

	}

	@When("User click the Privacy Policy")
	public void user_click_the_privacy_policy() {
		// driver.findElement(By.linkText("Privacy Policy")).click();
		driver.findElement(By.name("agree")).click();
	}

	@When("User click the register button")
	public void user_click_the_register_button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User account should get created Successfully")
	public void user_account_should_get_created_successfully() {
		System.out.println("passed1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement successmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='content']//p[contains(text(),'Congratulations! Your new account has been successfully created!')]")));
		Assert.assertTrue(
				successmsg.getText().contains("Congratulations! Your new account has been successfully created!"));
		// Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Congratulations!
		// Your new account has been successfully created!')]")),
		// "Congratulations! Your new account has been successfully created!");

	}

	@When("select the newletter")
	public void select_the_newletter() {
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	@Then("User get warning message duplicate account")
	public void user_get_warning_message_duplicate_account() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement successmsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
		System.out.println(successmsg.getText());
		Assert.assertTrue(successmsg.getText().contains("Warning: E-Mail Address is already registered!"));

	}

	@When("User dont enter any fields")
	public void user_dont_enter_any_fields() {
		// kept blank
	}

	@Then("User get warning message with mandatory field")
	public void user_get_warning_message_with_mandatory_field() {
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
//				.contains("Warning: E-Mail Address is already registered!"));
//		Assert.assertTrue(driver
//				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
//				.getText().contains("First Name must be between 1 and 32 characters!"));
//		Assert.assertTrue(
//				driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
//						.getText().contains("Last Name must be between 1 and 32 characters!"));
//		Assert.assertTrue(
//				driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
//						.getText().contains("E-Mail Address does not appear to be valid!"));
//		Assert.assertTrue(
//				driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
//						.getText().contains("Password must be between 4 and 20 characters!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
//				.contains("Warning: You must agree to the Privacy Policy!"));
		String alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();
		Assert.assertTrue(alertText.contains("Warning: You must agree to the Privacy Policy!"));

	}

	private String getTimestampEmail() {
		return "rehankhan" + System.currentTimeMillis() + "@gmail.com";
	}
}