package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletedAccountPage {

    private final WebDriver driver ;

    public DeletedAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By accountDeletedText = By.cssSelector("h2 > b");
    private final By continueButton = By.cssSelector("div[class='pull-right'] > a");

    public String getAccountDeletedText(){
        return Utility.getText(driver,accountDeletedText);
    }

    public HomePage clickOnContinueButton(){
        Utility.clickOnElement(driver,continueButton);
        return new HomePage(driver);
    }
}
