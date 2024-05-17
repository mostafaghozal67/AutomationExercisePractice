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
public class VerifySubscriptionInCartPageTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test verifies if the 'SUBSCRIPTION' is visible")
    @Test
    public void verifySubscriptionTextIsVisible(){
        boolean isVisible = new HomePage(getDriver()).
                clickOnCartsLink().
                scrollToFooter().
                verifyVisibilityOfSubscriptionText();
        Assert.assertTrue(isVisible);
    }

    @Description("This test case verifies that when the user enters his email address and click on the arrow button a 'You have been successfully subscribed!' is displayed")
    @Test
    public void verifySubscription() throws FileNotFoundException {
        String successMessage = new HomePage(getDriver()).
                clickOnCartsLink().
                scrollToFooter().
                enterEmailAddress(DataUtility.getJsonData("Subscription","email")).
                clickOnArrowButton().
                getSubscriptionSuccessMessage();
        Assert.assertEquals(successMessage,"You have been successfully subscribed!");
    }


    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
