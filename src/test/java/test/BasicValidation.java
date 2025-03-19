package test;


import static org.testng.Assert.assertTrue;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.Search;


public class BasicValidation extends BaseTest{


	@Test(priority = 1)
	public void urlValidation() {
		String expectedResult = "https://www.amazon.in/";
		String actualResult = driver.getCurrentUrl();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the URL,");		
	}
	
	@Test(priority = 2)
    public void testProductEntry() {
		Search search = new Search(driver);	
		search.inputName();
		
	}
	
	
	@Test(priority = 3)
    public void searchButtonClick() {
		Search search = new Search(driver);
		search.clickSearchButton();
	}
	

	@Test(priority = 4)
	public void resultsValidation() {
		
		Search search = new Search(driver);
		String actualResult = search.searchResults();
		
		Reporter.log("Actual Result = " + actualResult);
		
	}
	
	
	 @Test(priority = 5)
	    public void appleProductsCount() {
	        // Create an instance of the class containing listOfElements()
		 Search search = new Search(driver);
	        List<WebElement> iphoneList = search.listOfElements();
	        
	        Reporter.log("Number of Apple products found: " + iphoneList.size());
	        Assert.assertTrue(iphoneList.size() > 0, "No product found");
	    }
	
	@Test(priority = 6) //element click
    public void clickIphone16e() {
		Search search = new Search(driver);
		search.elementClick();
	}	

	@Test(priority = 7)
	public void priceValidation() {
		String expectedResult = "61,900";
		
		Search search = new Search(driver);
		String actualResult = search.getPriceOfProduct();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the price,");	
	}
}



