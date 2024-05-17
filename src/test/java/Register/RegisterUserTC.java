package Register;

import Utilities.DataUtility;
import io.qameta.allure.Step;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DeletedAccountPage;
import pages.HomePage;
import pages.SignUpPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.Utility.getTimeStamp;

@Listeners(IInvokedListenerClass.class)
public class RegisterUserTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }



    @Step("This test case verify that 'ENTER ACCOUNT INFORMATION' is visible and when the user enter his information the account is created successfully")
    @Test
    public void registerUser() throws FileNotFoundException {
        Assert.assertEquals(new HomePage(getDriver()).clickOnSignUpLoginLink().getNewUserSignUpText(),"New User Signup!");
        String signUpText = new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterName_SignUp(DataUtility.getJsonData("ValidSignUp","username")).
                enterEmailAddress_SignUp(DataUtility.getJsonData("ValidSignUp","email")+ getTimeStamp()+ "@gmail.com").
                clickOnSignUpButton().
                getSignUpText();
        Assert.assertEquals(signUpText,"ENTER ACCOUNT INFORMATION");
        String accountDeletedText = new SignUpPage(getDriver()).
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
                clickOnDeleteAccount().
                getAccountDeletedText();
        Assert.assertEquals(accountDeletedText,"ACCOUNT DELETED!");
        new DeletedAccountPage(getDriver()).
                clickOnContinueButton();
    }

    @AfterMethod
    public void quit(){
        //closeBrowser();
    }
}
