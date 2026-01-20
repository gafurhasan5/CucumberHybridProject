package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchPage {
	 WebDriver driver;
	 ElementUtils elementutils=null;
     public SearchPage(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
    	 elementutils=new  ElementUtils(driver);
     }
     @FindBy(linkText="HP LP3065")
     private WebElement validProduct;
     public boolean ValidProductDisplay()
     {
    	 elementutils.displayStatusOfElemement(validProduct,30);
    	 return validProduct.isDisplayed();
     }
     @FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
     private WebElement invalidProduct;
     public String InValidProductDisplayMsg()
     {
    	 return elementutils.getTextFromElement(invalidProduct, 30);
    	 //return invalidProduct.getText();
     }
}
