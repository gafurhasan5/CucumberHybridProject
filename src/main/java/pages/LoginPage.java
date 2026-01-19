package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement enterEmailField;

	public void EnterEmailField(String email) {
		enterEmailField.sendKeys(email);
	}

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement enterPasswordField;

	public void EnterPasswordField(String password) {
		enterPasswordField.sendKeys(password);
	}

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement clickButton;

	public void clickButtonField() {
		clickButton.click();
	}

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMsg;

	public String getWarningMsg() {
		return WarningMsg.getText();
	}
}
