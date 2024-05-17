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
import pages.SignUpLoginPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Listeners(IInvokedListenerClass.class)
public class LoginWithInCorrectEmailOrPasswordTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test case verifies that when logging in with incorrect email address or password the error message 'Your email or password is incorrect!' appears")
    @Test
    public void InValidLoginTC() throws FileNotFoundException {
        new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterEmailAddress_Login(DataUtility.getJsonData("InValidLogin","email")).
                enterPassword_Login(DataUtility.getJsonData("InValidLogin","password")).
                clickOnLoginButton();
        Assert.assertEquals(new SignUpLoginPage(getDriver()).getLoginErrorMessage(),"Your email or password is incorrect!");

    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
