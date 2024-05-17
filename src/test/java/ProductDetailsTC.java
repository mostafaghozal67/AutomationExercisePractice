import Utilities.DataUtility;
import io.qameta.allure.Description;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductDetailsPage;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;


@Listeners(IInvokedListenerClass.class)
public class ProductDetailsTC {
    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }


    @Description("This test case that the details of the product are displayed")
    @Test
    public void verifyVisibilityOfProductDetails(){
        new HomePage(getDriver()).
                clickOnProducts().
                clickOnProduct(1);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Assert.assertTrue(new ProductDetailsPage(getDriver()).verifyVisibilityOfProductName());
        Assert.assertTrue(new ProductDetailsPage(getDriver()).verifyVisibilityOfProductCategory());
        Assert.assertTrue(new ProductDetailsPage(getDriver()).verifyVisibilityOfProductAvailability());
        Assert.assertTrue(new ProductDetailsPage(getDriver()).verifyVisibilityOfProductPrice());
    }


    @AfterMethod
    public void quit(){
        //closeBrowser();
    }
}
