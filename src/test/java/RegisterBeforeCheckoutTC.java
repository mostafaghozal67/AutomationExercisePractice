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
import static Utilities.Utility.getTimeStamp;


@Listeners(IInvokedListenerClass.class)
public class RegisterBeforeCheckoutTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Test
    public void registerBeforeCheckout() throws IOException {
        String username =new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterName_SignUp(DataUtility.getJsonData("ValidSignUp","username")).
                enterEmailAddress_SignUp(DataUtility.getJsonData("ValidSignUp","email")+getTimeStamp()+"@gmail.com").
                clickOnSignUpButton().
                selectGender(DataUtility.getJsonData("ValidSignUp","gender")).
                enterPassword(DataUtility.getJsonData("ValidSignUp","password")).
                selectDay(DataUtility.getJsonData("ValidSignUp","day")).
                selectMonth(DataUtility.getJsonData("ValidSignUp","month")).
                selectYear(DataUtility.getJsonData("ValidSignUp","year")).
                clickOnSignUpNewsLetterCheckBox().
                clickOnReceiveSpecialOffersCheckBox().
                enterFirstName(DataUtility.getJsonData("ValidSignUp","firstName")).
                enterLastName(DataUtility.getJsonData("ValidSignUp","lastName")).
                enterAddress(DataUtility.getJsonData("ValidSignUp","address")).
                selectCountry(DataUtility.getJsonData("ValidSignUp","country")).
                enterState(DataUtility.getJsonData("ValidSignUp","state")).
                enterCity(DataUtility.getJsonData("ValidSignUp","city")).
                enterZipCode(DataUtility.getJsonData("ValidSignUp","zipCode")).
                enterMobileNumber(DataUtility.getJsonData("ValidSignUp","mobileNumber")).
                clickOnCreateAccountButton().
                clickOnContinueButton().
                getLoggedInUserName();
        Assert.assertEquals(username,DataUtility.getJsonData("ValidSignUp","username"));
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
