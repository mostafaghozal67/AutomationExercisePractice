package pages;

import Utilities.DataUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class PaymentDetailsPage {
    private final WebDriver driver ;

    public PaymentDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameOfTheCardInput = By.xpath("//input[@name='name_on_card']");
    private final By cardNumberInput = By.xpath("//input[@name='card_number']");
    private final By cvcInput = By.xpath("//input[@name='cvc']");
    private final By monthExpirationInput = By.xpath("//input[@name='expiry_month']") ;
    private final By yearExpirationInput = By.xpath("//input[@name='expiry_year']");
    private final By payAndConfirmOrderButton = By.id("submit") ;

    public PaymentDetailsPage enterNameOfTheCard(String name){
        Utility.sendData(driver,nameOfTheCardInput,name);
        return this;
    }

    public PaymentDetailsPage enterCardNumber(String cardNumber){
        Utility.sendData(driver,cardNumberInput,cardNumber);
        return this;
    }

    public PaymentDetailsPage enterCvc(String cvc){
        Utility.sendData(driver,cvcInput,cvc);
        return this;
    }

    public PaymentDetailsPage enterExpiryMonth(String expiryMonth){
        Utility.sendData(driver,monthExpirationInput,expiryMonth);
        return this;
    }

    public PaymentDetailsPage enterExpiryYear(String expiryYear){
        Utility.sendData(driver,yearExpirationInput,expiryYear);
        return this;
    }

    public PaymentDetailsPage clickOnPayAndConfirmOrderButton(){
        Utility.clickOnElement(driver,payAndConfirmOrderButton);
        return this;
    }





}
