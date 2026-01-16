package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Search {

	WebDriver driver;

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
	}

	@When("User enter the valid product {string} into Search box field")
	public void user_enter_the_valid_product_into_search_box_field(String validText) {
		driver.findElement(By.name("search")).sendKeys(validText);

	}

	@And("User click on search button")
	public void user_click_on_search_button() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enter the invalid product {string} into Search box field")
	public void user_enter_the_invalid_product_into_search_box_field(String invalidText) {
		driver.findElement(By.name("search")).sendKeys(invalidText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")));
		Assert.assertEquals("There is no product that matches the search criteria.",
				driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	}

}