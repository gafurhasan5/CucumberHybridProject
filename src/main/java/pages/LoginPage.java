package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;;
	  ElementUtils elementutils=null;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 elementutils=new  ElementUtils(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement enterEmailField;

	public void EnterEmailField(String email) {
		 elementutils.TypeTextIntoElement(enterEmailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//enterEmailField.sendKeys(email);
	}

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement enterPasswordField;

	public void EnterPasswordField(String password) {
		 elementutils.TypeTextIntoElement(enterPasswordField, password,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//enterPasswordField.sendKeys(password);
	}

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement clickButton;

	public void clickButtonField() {
		 elementutils.clickOnElement(clickButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//clickButton.click();
	}

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMsg;

	public String getWarningMsg() {
		return elementutils.getTextFromElement(WarningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//WarningMsg.getText();
	}
}
