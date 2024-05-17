package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesBarPage {
    private final WebDriver driver;

    public CategoriesBarPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By categoryTitle = By.xpath("//h2[text()='Category']");
    private By getCategoryLink(String categoryName){
        return By.xpath("//a[@href='#"+categoryName+"']");
    }
    private By getSubCategoryLink(String subCategoryName){
        return By.xpath("//div[@class='panel-collapse in']//a[text()='"+subCategoryName+"']");
    }

    public boolean verifyVisibilityOfCategoryTitle(){
        return Utility.getWebElement(driver,categoryTitle).isDisplayed();
    }

    public CategoriesBarPage clickOnCategoryLink(String categoryName){
        Utility.clickOnElement(driver,getCategoryLink(categoryName));
        return this;
    }

    public CategoriesPage clickOnSubCategoryLink(String subCategoryName){
        Utility.clickOnElement(driver,getSubCategoryLink(subCategoryName));
        return new CategoriesPage(driver);
    }
}
