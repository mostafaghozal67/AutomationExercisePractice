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
public class SearchForProductTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }

    @Description("This test case verifies that all the search results are relevant to the searched product")
    @Test
    public void searchForAProduct() throws FileNotFoundException {
        boolean SearchIsRelevant = new HomePage(getDriver()).
                clickOnProducts().
                productSearch(DataUtility.getJsonData("SearchProducts","searchedProduct")).
                clickOnSearchButton().
                getProductsNamesOfSearchResults().
                verifyRelevantSearchResults();
        Assert.assertTrue(SearchIsRelevant);
    }

    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
