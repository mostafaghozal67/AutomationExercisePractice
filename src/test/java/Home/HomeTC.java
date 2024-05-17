package Home;

import Utilities.DataUtility;
import io.qameta.allure.Description;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.Utility.getTimeStamp;

@Listeners(IInvokedListenerClass.class)
public class HomeTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test case verifies the visibility of the home page by checking if the navigation bar, featured items and recommended items are displayed")
    @Test
    public void verifyVisibilityOfHomePage(){
        Assert.assertTrue(new HomePage(getDriver()).verifyVisibilityOfNavigationBar());
        Assert.assertTrue(new HomePage(getDriver()).verifyVisibilityOfFeaturesItems());
        Assert.assertTrue(new HomePage(getDriver()).verifyVisibilityOfRecommendedItems());
    }


    @Description("This test case verifies the visibility of the username when the user is registered and directed to the home page")
    @Test
    public void verifyVisibilityOfUserNameAfterUserRegistration() throws IOException {
        String loggedInUserName =new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterName_SignUp(DataUtility.getJsonData("ValidSignUp","username")).
                enterEmailAddress_SignUp(DataUtility.getJsonData("ValidSignUp","email")+ getTimeStamp()+ "@gmail.com").
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
        Assert.assertEquals(loggedInUserName,DataUtility.getJsonData("ValidSignUp","username"));
    }


    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
