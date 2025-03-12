package test;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
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
	
	
//	@Test(priority = 3)
//	public void validateName() {
//		String expectedResult = "iphone";
//
//		Search search = new Search(driver);
//		String actualResult = search.getProductName();
//
//		Reporter.log("Expected Result = " + expectedResult);
//		Reporter.log("Actual Result = " + actualResult);
//
//		assertTrue(actualResult.equals(expectedResult), "Mismatch in the price,");
//	}
	
	@Test(priority = 3)
    public void searchButtonClick() {
		Search search = new Search(driver);
		search.clickSearchButton();
	}
	
	@Test(priority = 4) //element click
    public void clickIphone16e() {
		Search search = new Search(driver);
		search.elementClick();
	}	

	@Test(priority = 5)
	public void priceValidation() {
		String expectedResult = "59,900";
		
		Search search = new Search(driver);
		String actualResult = search.getPriceOfProduct();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the price,");		
	}
}



