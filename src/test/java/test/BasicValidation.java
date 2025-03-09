package test;

import static org.testng.Assert.assertTrue;

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
    public void testEnterProduct() {
		Search search = new Search(driver);
		search.enterProduct("iPhone");
		
	}
	@Test(priority = 3)
    public void testClick() {
		Search search = new Search(driver);
		search.clickSearchButton();
	}
	
	@Test(priority = 4)
    public void clickElement() {
		Search search = new Search(driver);
		search.elementClick();
	}
	
	
	


}
