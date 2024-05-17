package Login;

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
public class LoginWithCorrectEmailAndPasswordTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test case verifies that 'Login to your account' is visible and when logging in with correct email address and password the user should be logged in and directed to the home page")
    @Test
    public void ValidLoginTC() throws FileNotFoundException {
        Assert.assertEquals(new HomePage(getDriver()).clickOnSignUpLoginLink().getLogInToYourAccountText(),"Login to your account");
        new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterEmailAddress_Login(DataUtility.getJsonData("ValidLogin","email")).
                enterPassword_Login(DataUtility.getJsonData("ValidLogin","password")).
                clickOnLoginButton();
    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
