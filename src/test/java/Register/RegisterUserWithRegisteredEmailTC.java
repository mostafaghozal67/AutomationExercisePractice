package Register;

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
public class RegisterUserWithRegisteredEmailTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }


    @Description("This test case verifies that when registering with existing email the error message 'Email Address already exist!' appears")
    @Test
    public void SignUpWithRegisteredEmail() throws FileNotFoundException {
        new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterName_SignUp(DataUtility.getJsonData("InValidSignUp","name")).
                enterEmailAddress_SignUp(DataUtility.getJsonData("InValidSignUp","email")).
                clickOnSignUpButton();
        Assert.assertEquals(new SignUpLoginPage(getDriver()).getRegisterErrorMessage(),"Email Address already exist!");
    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
