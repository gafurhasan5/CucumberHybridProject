package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
     WebDriver driver;
     ElementUtils elementutils=null;
     public HomePage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
        elementutils=new  ElementUtils(driver);
     }
     //ElementUtils elementutils=new  ElementUtils(driver);

     @FindBy(xpath="//span[text()='My Account']")
     private WebElement MyAccountDropMenu;
     public void clickOnMyAccount()
     {
    	// MyAccountDropMenu.click(); 
    	 elementutils.clickOnElement(MyAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 
     }
     @FindBy(xpath="//a[normalize-space()='Login']")
     private WebElement LoginOption;
     public void clickLoginOption()
     {
    	 elementutils.clickOnElement(LoginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	// LoginOption.click(); 
     }
     @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
     private WebElement RegisterOption;
     public void clickRegisterOption()
     {
    	 elementutils.clickOnElement(RegisterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	// RegisterOption.click(); 
     }
     
     //search feature
     @FindBy(name="search")
     private WebElement SearchBoxField;
     public void EnterValidproductsearchBoxField(String validtext)
     {
    	 elementutils.TypeTextIntoElement(SearchBoxField, validtext, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //SearchBoxField.sendKeys(validtext);
     }
     @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
     private WebElement SearchButton;
     public void clickButtonField()
     {
    	 elementutils.clickOnElement(SearchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	 //SearchButton.click();
     }
     @FindBy(name="search")
     private WebElement InSearchBoxField;
     public void EnterInValidproductsearchBoxField(String invalidtext)
     {
    	 InSearchBoxField.sendKeys(invalidtext);
     }
    
}
