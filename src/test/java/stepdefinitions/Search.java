package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchPage;

public class Search {

	//WebDriver Add
	WebDriver driver;
	HomePage homepage;
	SearchPage searchpage;

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
	}

	@When("User enter the valid product {string} into Search box field")
	public void user_enter_the_valid_product_into_search_box_field(String validText) {
		homepage = new HomePage(driver);
		homepage.EnterValidproductsearchBoxField(validText);
		// driver.findElement(By.name("search")).sendKeys(validText);

	}

	@And("User click on search button")
	public void user_click_on_search_button() {
		homepage.clickButtonField();
		// driver.findElement(By.xpath("//button[@class='btn btn-default
		// btn-lg']")).click();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.ValidProductDisplay());
	}

	@When("User enter the invalid product {string} into Search box field")
	public void user_enter_the_invalid_product_into_search_box_field(String invalidText) {
		// driver.findElement(By.name("search")).sendKeys(invalidText);
		homepage = new HomePage(driver);
		homepage.EnterInValidproductsearchBoxField(invalidText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")));
		searchpage = new SearchPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",
				searchpage.InValidProductDisplayMsg());
	}

	@When("User dont enter any product name in search box field")
	public void user_dont_enter_any_product_name_in_search_box_field() {

		homepage = new HomePage(driver);
		Assert.fail();
	}

}