import Utilities.DataUtility;
import listners.IInvokedListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CategoriesBarPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static DriverFactory.DriverFactory.*;

@Listeners(IInvokedListenerClass.class)
public class ViewCategoryProductsTC {

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(DataUtility.getPropertiesValue("environment","Browser"));
        getDriver().get(DataUtility.getPropertiesValue("environment","Base_URL"));
    }


    @Test
    public void viewCategoryProducts() throws IOException {
        boolean IsCategoryTitleVisible = new CategoriesBarPage(getDriver()).
                verifyVisibilityOfCategoryTitle();
        Assert.assertTrue(IsCategoryTitleVisible);
        boolean IsCategoryTextVisible = new CategoriesBarPage(getDriver()).
                clickOnCategoryLink(DataUtility.getJsonData("CategoryProducts","menCategory")).
                clickOnSubCategoryLink(DataUtility.getJsonData("CategoryProducts","menSubCategory")).
                verifyVisibilityOfCategoryText();
        Assert.assertTrue(IsCategoryTextVisible);
        new CategoriesBarPage(getDriver()).
                clickOnCategoryLink(DataUtility.getJsonData("CategoryProducts","womenCategory")).
                clickOnSubCategoryLink(DataUtility.getJsonData("CategoryProducts","womenSubCategory"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains(DataUtility.getPropertiesValue("environment","Category_URL")));
    }


    @AfterMethod
    public void quit(){
        closeBrowser();
    }
}
