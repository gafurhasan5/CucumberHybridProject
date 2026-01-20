package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountSuccessPage {
	 WebDriver driver;
	 ElementUtils elementutils=null;
     public  AccountSuccessPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
    	 elementutils=new  ElementUtils(driver);
     }
     @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
     private WebElement pageHeading;
     public String getPageHeading()
     {
    	 return elementutils.getTextFromElement(pageHeading,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // return pageHeading.getText(); 
      
     }

}
