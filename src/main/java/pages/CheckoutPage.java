package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By commentTextArea = By.className("form-control");
    private final By placeOrderButton= By.xpath("//a[@class='btn btn-default check_out']");

    public CheckoutPage enterComment(String comment){
        Utility.sendData(driver,commentTextArea,comment);
        return this;
    }
    public void clickOnPlaceOrderButton(){
        Utility.clickOnElement(driver,placeOrderButton);
    }
}
