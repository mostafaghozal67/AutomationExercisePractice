package pages;

import Utilities.DataUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;

public class CartsPage {
    private final WebDriver driver;

    public CartsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By footer = By.id("footer");
    private final By subscriptionText = By.cssSelector("div[class='single-widget'] > h2");
    private final By emailInput = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.cssSelector("div[class*='alert-success']");
    private final By productQuantity = By.xpath("//tr[@id='product-1']//td[4]//button");
    private final By proceedToCheckoutButton = By.xpath("//a[@class='btn btn-default check_out']");
    private final By registerLoginLink = By.xpath("//div[@class='modal-body']//p[2]//a");
    private final By removeProductFromCartLink = By.className("cart_quantity_delete");
    private By getProductDescription(String productDescription){
        return By.xpath("//a[text()='"+productDescription+"']");
    }
    private By getProductsPrice(String productPrice){
        return By.xpath("//td[@class='cart_price'] //p[text()='"+productPrice+"']");
    }
    private By getProductsQuantity(String productIndex){
        return By.xpath("//tr[@id='product-"+productIndex+"']//td[4]//button");
    }
    private By removeProductButton(String productName){
        return By.xpath("//h4[.='"+productName+"']//parent::td//parent::tr//a[@class='cart_quantity_delete']");
    }
    private By getProduct(String productName){
        return By.xpath("//*[text()='"+productName+"']");
    }


    public CartsPage scrollToFooter(){
        Utility.Scroll(driver,footer);
        return this;
    }

    public boolean verifyVisibilityOfSubscriptionText(){
        WebElement SubscriptionText = Utility.getWebElement(driver,subscriptionText);
        if(SubscriptionText.isDisplayed())
            return true;
        else return false;
    }

    public CartsPage enterEmailAddress(String email){
        Utility.sendData(driver,emailInput,email);
        return this;
    }

    public CartsPage clickOnArrowButton(){
        Utility.clickOnElement(driver,arrowButton);
        return this;
    }

    public String getSubscriptionSuccessMessage(){
        return Utility.getText(driver,subscriptionSuccessMessage);
    }

    public boolean verifyProductsNamesAddedToCartAreMatch(String JsonFileName,String product_Description) throws FileNotFoundException {
        return Utility.getText(driver,getProductDescription(product_Description)).equals(DataUtility.getJsonData(JsonFileName,"productDescription"));
    }

    public boolean verifyProductsPricesAddedToCartAreMatch(String JsonFileName,String product_Price) throws FileNotFoundException {
        return Utility.getText(driver,getProductsPrice(product_Price)).equals(DataUtility.getJsonData(JsonFileName,"productPrice"));
    }

    public boolean verifyProductsQuantityAddedToCartAreMatch(String JsonFileName,String productQuantity) throws FileNotFoundException {
        return Utility.getText(driver,getProductsQuantity(productQuantity)).equals(DataUtility.getJsonData(JsonFileName,"productQuantity"));
    }

    public String verifyQuantityOfAProduct(){
        return Utility.getText(driver,productQuantity);
    }

    public CartsPage clickOnProceedToCheckoutButton(){
        Utility.clickOnElement(driver,proceedToCheckoutButton);
        return this;
    }

    public SignUpLoginPage clickOnRegisterLoginLink(){
        Utility.clickOnElement(driver,registerLoginLink);
        return new SignUpLoginPage(driver);
    }

    public CartsPage clickOnRemoveProductFromCartLink(String product_name){
        Utility.clickOnElement(driver,removeProductButton(product_name));
        return this;
    }

    public boolean verifyThatAProductIsRemoved(String product_name){
        return !Utility.getWebElement(driver,getProduct(product_name)).isDisplayed();
    }



}
