import Utilities.DataUtility;
import Utilities.Utility;
import io.qameta.allure.Step;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.SignUpPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.Utility.getTimeStamp;

@Listeners(IInvokedListenerClass.class)
public class AccountCreatedTC {
    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }


    @Step("This test case verifies that 'ACCOUNT CREATED!' is visible")
    @Test
    public void verifyVisibilityOfAccountCreatedText() throws FileNotFoundException {
        String accountCreatedText =new HomePage(getDriver()).
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
                clickOnCreateAccountButton().getAccountCreatedText();
        Assert.assertEquals(accountCreatedText,"ACCOUNT CREATED!");
    }

    @Step("This test case verifies that when clicking on the continue button the user will be directed to the home page and the user should be logged in ")
    @Test
    public void clickOnContinueButton() throws IOException {
        new HomePage(getDriver()).
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
                clickOnContinueButton();
        Assert.assertEquals(getDriver().getCurrentUrl(),DataUtility.getPropertiesValue("environment","Base_URL"));
    }
    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
