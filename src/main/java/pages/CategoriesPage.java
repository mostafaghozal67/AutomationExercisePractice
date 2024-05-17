package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesPage {

    private final WebDriver driver;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By categoryText = By.xpath("//h2[@class='title text-center']");

    public boolean verifyVisibilityOfCategoryText(){
        return Utility.getWebElement(driver,categoryText).isDisplayed();
    }



}
