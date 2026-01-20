package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	 WebDriver driver;
	 ElementUtils elementutils=null;
     public  RegisterPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
    	 elementutils=new  ElementUtils(driver);
     }
     @FindBy(id="input-firstname")
     private WebElement firstNameField;
     public void EnterFirstNameField(String firstNameText)
     {

    	 elementutils.TypeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //firstNameField.sendKeys(firstNameText);
     }
     @FindBy(id="input-lastname")
     private WebElement lastNameField;
     public void EnterLastNameField(String lastNametext)
     {
    	 elementutils.TypeTextIntoElement(lastNameField, lastNametext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //lastNameField.sendKeys(lastNametext);
     }
     @FindBy(id="input-email")
     private WebElement emailField;
     public void EnterEmailField(String emailText)
     {
    	 elementutils.TypeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //emailField.sendKeys(emailText);
     }
    
     @FindBy(id="input-telephone")
     private WebElement telePhoneField;
     public void EntertelePhoneField(String telePhoneText)
     {
    	 elementutils.TypeTextIntoElement(telePhoneField, telePhoneText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //telePhoneField.sendKeys(telePhoneText);
     }
     @FindBy(id="input-password")
     private WebElement passwordField;
     public void EnterPasswordField(String passwordText)
     {
    	 elementutils.TypeTextIntoElement(passwordField,passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //passwordField.sendKeys(passwordText);
     }
     @FindBy(id="input-confirm")
     private WebElement conpasswordField;
     public void EnterconPasswordField(String confirmpasswordText)
     {
    	 elementutils.TypeTextIntoElement(conpasswordField,confirmpasswordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	// conpasswordField.sendKeys(confirmpasswordText);
     }
     @FindBy(name="agree")
     private WebElement privacypolicyField;
     public void clickPolicyField()
     {
    	 elementutils.clickOnElement(privacypolicyField, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //privacypolicyField.click();
     }
     @FindBy(xpath="//input[@value='Continue']")
     private WebElement continueButton;
     public void clickContinueButton()
     {
    	 elementutils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //continueButton.click();
     }
     @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
     private WebElement WarningMsg;
     public String WarningMsgText()
     {
    	 return elementutils.getTextFromElement(WarningMsg, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //return WarningMsg.getText();
     }
}
