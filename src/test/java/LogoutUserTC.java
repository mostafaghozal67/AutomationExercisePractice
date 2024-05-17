import Utilities.DataUtility;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Listeners(IInvokedListenerClass.class)
public class LogoutUserTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Test
    public void clickOnLogout() throws IOException {
        new HomePage(getDriver()).
                clickOnSignUpLoginLink().
                enterEmailAddress_Login(DataUtility.getJsonData("ValidLogin","email")).
                enterPassword_Login(DataUtility.getJsonData("ValidLogin","password")).
                clickOnLoginButton().
                clickOnLogoutLink();
        Assert.assertEquals(getDriver().getCurrentUrl(),DataUtility.getPropertiesValue("environment","Base_URL")+"login");
    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
