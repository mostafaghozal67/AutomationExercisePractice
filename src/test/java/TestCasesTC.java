import Utilities.DataUtility;
import io.qameta.allure.Description;
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
public class TestCasesTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test case verifies that on clicking on test cases link the user is navigated to the test cases page successfully")
    @Test
    public void clickOnTestCases() throws IOException {
        new HomePage(getDriver()).
                clickOnTestCases();
        Assert.assertEquals(getDriver().getCurrentUrl(), DataUtility.getPropertiesValue("environment","TestCases_URL"));
    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
