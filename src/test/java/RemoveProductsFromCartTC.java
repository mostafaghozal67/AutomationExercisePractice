import Utilities.DataUtility;
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
public class RemoveProductsFromCartTC {
    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Test
    public void removeProductsFromCart() throws FileNotFoundException {
        boolean IsFirstProductExist =new HomePage(getDriver()).
                hoverOnProduct(1).
                clickOnAddToCartLink(1).
                clickOnContinueShoppingButton().
                hoverOnProduct(2).
                clickOnAddToCartLink(2).
                clickOnContinueShoppingButton().
                clickOnCartsLink().
                clickOnRemoveProductFromCartLink(DataUtility.getJsonData("FirstProductInTheCart","productDescription")).
                verifyThatAProductIsRemoved(DataUtility.getJsonData("FirstProductInTheCart","productDescription"));
        Assert.assertFalse(IsFirstProductExist);
        boolean IsSecondProductExist=new CartsPage(getDriver()).
                clickOnRemoveProductFromCartLink(DataUtility.getJsonData("SecondProductInTheCart","productDescription")).
                verifyThatAProductIsRemoved(DataUtility.getJsonData("SecondProductInTheCart","productDescription"));
        Assert.assertFalse(IsSecondProductExist);

    }

    @AfterMethod
    public void quit(){
        //closeBrowser();
    }
}
