package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webelement = waitforElement(element, durationInSeconds);
		element.click();
	}

	public void TypeTextIntoElement(WebElement element, String textTobETyped, long durationInSeconds) {
		WebElement webelement = waitforElement(element, durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textTobETyped);
	}

	public WebElement waitforElement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}

	public void SelectOptionInDropDown(WebElement element, String dropDownOption, long durationInSeconds) {
		WebElement webelement = waitforElement(element, 15);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropDownOption);
	}

	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitforAlert(durationInSeconds);
		alert.accept();
	}

	public void dismisAlert(long durationInSeconds) {
		Alert alert = waitforAlert(durationInSeconds);
		alert.dismiss();
	}

	public Alert waitforAlert(long durationInSeconds) {
		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));

			webelement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click()", webelement);
	}

	public void javaScriptType(WebElement element, long durationInSeconds, String TextToBetyped) {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + TextToBetyped + "'", webelement);
	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webelement = waitforElement(element, durationInSeconds);
		return webelement.getText();
	}

	public boolean displayStatusOfElemement(WebElement element, long durationInSeconds) {
		
		try {
		WebElement webelement = waitForVisibilityOfElement(element, durationInSeconds);
		return webelement.isDisplayed();
		}catch(Throwable e)
		{
			return false;
			//e.printStackTrace();
		}
	}
}
