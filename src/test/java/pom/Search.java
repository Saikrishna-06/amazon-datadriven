package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Search {
	private WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//input[@name='field-keywords']")
	private WebElement serchbox;
	
	@CacheLookup
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchButton;
	
	
	@CacheLookup
	@FindBy(xpath = "//span[starts-with(text(), '1-16 of over')]")
	private WebElement results;
	
	@CacheLookup
	@FindBy(xpath = "//span[contains(text() , 'Apple')]")
	private List<WebElement> productscount;
	
	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'iPhone 16e 128 GB') and contains(text(),'Super Retina XDR Display; White')]")
	private WebElement iphone16e;
	
	@CacheLookup
	@FindBy(xpath = "//span[@class = 'a-price-whole']")
	private WebElement priceiphone16e;
	
	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputName() {
	    	serchbox.clear();
	    	serchbox.sendKeys("iphone");
	     }
	
//	  public String getProductName() {
//			return serchbox.getText();
//		}


	  public void clickSearchButton() {
		  searchButton.click();
	    }	  
	  
	  public String searchResults() {
		  return results.getText();
	  }
	  
	  
	    public List<WebElement> listOfElements() {
	        return productscount;
	    }
	
	public void elementClick() {
		iphone16e.click();
	}
	      
	    public String getPriceOfProduct() {
			return priceiphone16e.getText();
		}


	
}




