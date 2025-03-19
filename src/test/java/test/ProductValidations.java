package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.ProductPage;
import utils.ReadYaml;

import static org.testng.Assert.assertTrue;

import java.util.Map;

public class ProductValidations extends BaseTest {
    private ProductPage productPage;
    private Map<String, Object> productData;

    @Test(dependsOnMethods = {"clickIphone16e"})
    public void deviceValidation() {


        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        ReadYaml rf = new ReadYaml();
        String responseFile = "productDetails.yaml";
        //String expectedResult = gson.toJson(rf.readYaml(responseFile));
        Map<String, Object> data = rf.readYaml(responseFile);
        //Read each data from Readfile
        String expectedBrand = (String) data.get("brand");
        String expectedOperating_system = (String) data.get("operating_system");
        String expectedMemory_storage_capacity = (String) data.get("memory_storage_capacity");
        String expectedScreenSize = (String) data.get("screen_size");
        String expectedModelName = (String) data.get("model_name");

        //Read each data from DevicePage POM
        ProductPage deviceModelPage = new ProductPage(driver);
        String actualBrand = deviceModelPage.getBrand();
        String actualOperating_system = deviceModelPage.getOperatingSystem();
        String actualMemory_storage_capacity = deviceModelPage.getMemoryStorage();
        String actualScreenSize = deviceModelPage.getScreenSize();
        String actualModelName = deviceModelPage.getModelName();

        Reporter.log("expected Brand : " + expectedBrand);
        Reporter.log("actual Brand : " + actualBrand);

        Reporter.log("expected Operating_system : " + expectedOperating_system);
        Reporter.log("actual Operating_system : " + actualOperating_system);

        Reporter.log("expected Memory_storage_capacity : " + expectedMemory_storage_capacity);
        Reporter.log("actual Memory_storage_capacity : " + actualMemory_storage_capacity);

        Reporter.log("expected ScreenSize : " + expectedScreenSize);
        Reporter.log("actual ScreenSize : " + actualScreenSize);

        Reporter.log("expected ModelName " + expectedModelName);
        Reporter.log("actual ModelName : " + actualModelName);


        assertTrue(actualBrand.equals(expectedBrand), "Mismatch in the Brand,");
        assertTrue(actualOperating_system.equals(expectedOperating_system), "Mismatch in the OS,");
        assertTrue(actualMemory_storage_capacity.equals(expectedMemory_storage_capacity), "Mismatch in the Memory,");
        assertTrue(actualScreenSize.equals(expectedScreenSize), "Mismatch in the Screensize,");
        assertTrue(actualModelName.equals(expectedModelName), "Mismatch in the ModelName,");


    }
}
