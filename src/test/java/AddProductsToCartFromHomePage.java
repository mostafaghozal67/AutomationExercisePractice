import Utilities.DataUtility;
import io.qameta.allure.Description;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Listeners(IInvokedListenerClass.class)

public class AddProductsToCartFromHomePage {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test case verifies that when the user clicks on view product button the user should be navigated to product details page then he changes the quantity he should be navigated to the Carts page with an accurate quantity")
    @Test
    public void addProductsToCartFromHomePage() throws FileNotFoundException {
        String productQuantity = new HomePage(getDriver()).
                clickOnViewProductButton(1).
                changeProductQuantity(DataUtility.getJsonData("ChangeQuantityOfProduct","quantity")).
                clickOnAddToCart().
                clickOnViewCartLink().
                verifyQuantityOfAProduct();
        Assert.assertEquals(productQuantity,DataUtility.getJsonData("ChangeQuantityOfProduct","quantity"));
    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
