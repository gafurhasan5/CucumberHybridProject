package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
     WebDriver driver;
     public HomePage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
     }
     @FindBy(xpath="//span[text()='My Account']")
     private WebElement MyAccountDropMenu;
     public void clickOnMyAccount()
     {
    	 MyAccountDropMenu.click(); 
     }
     @FindBy(xpath="//a[normalize-space()='Login']")
     private WebElement LoginOption;
     public void clickLoginOption()
     {
    	 LoginOption.click(); 
     }
     @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
     private WebElement RegisterOption;
     public void clickRegisterOption()
     {
    	 RegisterOption.click(); 
     }
     
     //search feature
     @FindBy(name="search")
     private WebElement SearchBoxField;
     public void EnterValidproductsearchBoxField(String validtext)
     {
    	 SearchBoxField.sendKeys(validtext);
     }
     @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
     private WebElement SearchButton;
     public void clickButtonField()
     {
    	 SearchButton.click();
     }
     @FindBy(name="search")
     private WebElement InSearchBoxField;
     public void EnterInValidproductsearchBoxField(String invalidtext)
     {
    	 InSearchBoxField.sendKeys(invalidtext);
     }
    
}
