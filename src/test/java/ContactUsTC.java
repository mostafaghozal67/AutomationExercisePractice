import Utilities.DataUtility;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.ProductsPage;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Listeners(IInvokedListenerClass.class)
public class ContactUsTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Test
    public void fillContactUsForm() throws IOException {
        String successMessage = new HomePage(getDriver()).
                clickOnContactUs().
                enterName(DataUtility.getJsonData("ContactUs","name")).
                enterEmail(DataUtility.getJsonData("ContactUs","email")).
                enterSubject(DataUtility.getJsonData("ContactUs","subject")).
                enterMessage(DataUtility.getJsonData("ContactUs","message")).
                uploadFile().
                clickOnSubmitButton().
                clickOnAlertOkButton().
                getSuccessMessage();
        Assert.assertEquals(successMessage,"Success! Your details have been submitted successfully.");
        new ContactUsPage(getDriver()).
                clickOnHomeButton();
        Assert.assertEquals(getDriver().getCurrentUrl(),DataUtility.getPropertiesValue("environment","Base_URL"));
    }


    @AfterMethod
    public void quit(){
        closeBrowser();
    }


}
