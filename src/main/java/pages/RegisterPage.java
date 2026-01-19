package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	 WebDriver driver;
     public  RegisterPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }
     @FindBy(id="input-firstname")
     private WebElement firstNameField;
     public void EnterFirstNameField(String firstNameText)
     {
    	 firstNameField.sendKeys(firstNameText);
     }
     @FindBy(id="input-lastname")
     private WebElement lastNameField;
     public void EnterLastNameField(String lastNametext)
     {
    	 lastNameField.sendKeys(lastNametext);
     }
     @FindBy(id="input-email")
     private WebElement emailField;
     public void EnterEmailField(String emailText)
     {
    	 emailField.sendKeys(emailText);
     }
    
     @FindBy(id="input-telephone")
     private WebElement telePhoneField;
     public void EntertelePhoneField(String telePhoneText)
     {
    	 telePhoneField.sendKeys(telePhoneText);
     }
     @FindBy(id="input-password")
     private WebElement passwordField;
     public void EnterPasswordField(String passwordText)
     {
    	 passwordField.sendKeys(passwordText);
     }
     @FindBy(id="input-confirm")
     private WebElement conpasswordField;
     public void EnterconPasswordField(String confirmpasswordText)
     {
    	 conpasswordField.sendKeys(confirmpasswordText);
     }
     @FindBy(name="agree")
     private WebElement privacypolicyField;
     public void clickPolicyField()
     {
    	 privacypolicyField.click();
     }
     @FindBy(xpath="//input[@value='Continue']")
     private WebElement continueButton;
     public void clickContinueButton()
     {
    	 continueButton.click();
     }
     @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
     private WebElement WarningMsg;
     public String WarningMsgText()
     {
    	 return WarningMsg.getText();
     }
}
