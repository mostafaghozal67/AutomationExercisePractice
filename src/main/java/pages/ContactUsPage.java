package pages;

import Utilities.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ContactUsPage {
    private final WebDriver driver ;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameInput = By.xpath("//input[@name='name']");
    private final By emailInput = By.xpath("//input[@name='email']");
    private final By subjectInput = By.xpath("//input[@name='subject']");
    private final By messageInput = By.xpath("//textarea[@name='message']");
    private final By uploadButton = By.xpath("//input[@type='file']");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By successMessage = By.cssSelector("div[class='contact-form'] > div[class*='alert']");
    private final By homeButton = By.cssSelector("a[class*=btn] ");

    public ContactUsPage enterName(String name){
        Utility.sendData(driver,nameInput,name);
        return this;
    }

    public ContactUsPage enterEmail(String email){
        Utility.sendData(driver,emailInput,email);
        return this;
    }

    public ContactUsPage enterSubject(String subject){
        Utility.sendData(driver,subjectInput,subject);
        return this;
    }

    public ContactUsPage enterMessage(String message){
        Utility.sendData(driver,messageInput,message);
        return this;
    }

    public ContactUsPage uploadFile(){
        Utility.sendData(driver,uploadButton,"C:\\Users\\User\\Desktop\\Testing\\Selenium WebDriver.pdf");
        return this;
    }

    public ContactUsPage clickOnSubmitButton(){
        Utility.clickOnElement(driver,submitButton);
        return this;
    }

    public ContactUsPage clickOnAlertOkButton(){
        driver.switchTo().alert().accept();
        return this;
    }

    public String getSuccessMessage(){
        return Utility.getText(driver,successMessage);
    }

    public HomePage clickOnHomeButton(){
        Utility.clickOnElement(driver,homeButton);
        return new HomePage(driver);
    }




}
