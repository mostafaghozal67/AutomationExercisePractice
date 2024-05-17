import Utilities.DataUtility;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartsPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.PaymentDetailsPage;

import java.io.IOException;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;

@Listeners(IInvokedListenerClass.class)
public class LoginBeforeCheckoutTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Test
    public void loginBeforeCheckout() throws IOException {
        String username =new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterEmailAddress_Login(DataUtility.getJsonData("ValidLogin","email")).
                enterPassword_Login(DataUtility.getJsonData("ValidLogin","password")).
                clickOnLoginButton().
                getLoggedInUserName();
        Assert.assertEquals(username,DataUtility.getJsonData("ValidLogin","name"));
        new HomePage(getDriver()).
                hoverOnProduct(3).
                clickOnAddToCartLink(3).
                clickOnContinueShoppingButton().
                hoverOnProduct(5).
                clickOnAddToCartLink(5).
                clickOnContinueShoppingButton().
                clickOnCartsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(),DataUtility.getPropertiesValue("environment","Cart_URL"));
        new CartsPage(getDriver()).
                clickOnProceedToCheckoutButton();
        new CheckoutPage(getDriver()).
                enterComment("hello").
                clickOnPlaceOrderButton();
        new PaymentDetailsPage(getDriver()).
                enterNameOfTheCard(DataUtility.getJsonData("ValidPaymentDetails","cardName")).
                enterCardNumber(DataUtility.getJsonData("ValidPaymentDetails","cardNumber")).
                enterCvc(DataUtility.getJsonData("ValidPaymentDetails","cvc")).
                enterExpiryMonth(DataUtility.getJsonData("ValidPaymentDetails","expireMonth")).
                enterExpiryYear(DataUtility.getJsonData("ValidPaymentDetails","expireYear")).
                clickOnPayAndConfirmOrderButton();
        new HomePage(getDriver()).
                clickOnDeleteAccount();

    }


    @AfterMethod
    public void quit(){
        //closeBrowser();
    }
}
