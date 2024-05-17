import Utilities.DataUtility;
import io.qameta.allure.Description;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartsPage;
import pages.HomePage;
import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Listeners(IInvokedListenerClass.class)
public class ProductsPageTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This Test case verifies that on clicking on products link the user is navigated to the products page and the products list are visible")
    @Test
    public void verifyVisibilityOfAllProducts() throws IOException {
        int numberOfProducts = new HomePage(getDriver()).
                clickOnProducts().
                getAllProducts();
        Assert.assertEquals(getDriver().getCurrentUrl(),DataUtility.getPropertiesValue("environment","Products_URL"));
        Assert.assertTrue(numberOfProducts>0);
    }


    @Description("This test case verifies that when the user add products to the cart then click on the view cart button the products should be add to the cart successfully with their accurate name, price and quantity")
    @Test
    public void AddProductsToCart() throws FileNotFoundException {
        new HomePage(getDriver()).
                clickOnProducts().
                hoverOnProduct(1).
                clickOnAddToCartLink(1).
                clickOnContinueShoppingButton().
                hoverOnProduct(2).
                clickOnAddToCartLink(2).
                clickOnViewCartButton();
        boolean isFirstProductNameMatch = new CartsPage(getDriver()).
                verifyProductsNamesAddedToCartAreMatch("FirstProductInTheCart",DataUtility.getJsonData("FirstProductInTheCart","productDescription"));
        Assert.assertTrue(isFirstProductNameMatch);
        boolean isSecondProductNameMatch = new CartsPage(getDriver()).
                verifyProductsNamesAddedToCartAreMatch("SecondProductInTheCart",DataUtility.getJsonData("SecondProductInTheCart","productDescription"));
        Assert.assertTrue(isSecondProductNameMatch);
        boolean isFirstProductPriceMatch = new CartsPage(getDriver()).
                verifyProductsPricesAddedToCartAreMatch("FirstProductInTheCart",DataUtility.getJsonData("FirstProductInTheCart","productPrice"));
        Assert.assertTrue(isFirstProductPriceMatch);
        boolean isSecondProductPriceMatch = new CartsPage(getDriver()).
                verifyProductsPricesAddedToCartAreMatch("SecondProductInTheCart",DataUtility.getJsonData("SecondProductInTheCart","productPrice"));
        Assert.assertTrue(isSecondProductPriceMatch);
        boolean isFirstProductQuantityMatch = new CartsPage(getDriver()).
                verifyProductsQuantityAddedToCartAreMatch("FirstProductInTheCart",DataUtility.getJsonData("FirstProductInTheCart","productQuantity"));
        Assert.assertTrue(isFirstProductQuantityMatch);
        boolean isSecondProductQuantityMatch = new CartsPage(getDriver()).
                verifyProductsQuantityAddedToCartAreMatch("SecondProductInTheCart",DataUtility.getJsonData("SecondProductInTheCart","productQuantity"));
        Assert.assertTrue(isSecondProductQuantityMatch);

    }


    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
