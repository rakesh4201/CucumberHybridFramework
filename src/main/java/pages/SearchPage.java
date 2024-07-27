package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {
WebDriver driver;
private ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::P")
	private WebElement noProductMessage;
	
   public boolean displayStatusOfHPValidProduct() {
	   
	  return  elementUtils.displayStatusOfElement(validHPProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
   }
   
   public String retrieveNoProductMessageText() {
	 return  elementUtils.getTextFromElement(noProductMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
   }

}
