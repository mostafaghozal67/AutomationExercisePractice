package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private final WebDriver driver ;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountCreatedText = By.cssSelector("h2 > b");
    private final By continueButton = By.cssSelector("div[class='pull-right'] > a");

    public String getAccountCreatedText(){
        return Utility.getText(driver,accountCreatedText);
    }


    public HomePage clickOnContinueButton(){
        Utility.clickOnElement(driver,continueButton);
        return new HomePage(driver);
    }
}
