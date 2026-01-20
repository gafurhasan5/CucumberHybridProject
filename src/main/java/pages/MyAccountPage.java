package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.ElementUtils;

public class MyAccountPage {
	WebDriver driver;
	ElementUtils elementutils=null;
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 elementutils=new  ElementUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInformationOption;

	public boolean DisplayEditAccountInformationMsg() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(CommonUtils.EXPLICIT_WAIT_BASIC_TIME));
//		wait.until(ExpectedConditions.visibilityOf(editAccountInformationOption));
//		return editAccountInformationOption.isDisplayed();
		return  elementutils.displayStatusOfElemement(editAccountInformationOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

}
