package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By navigationBar = By.cssSelector("ul[class*='navbar-nav']");
    private final By featuresItemsBlock = By.className("features_items");
    private final By recommendedItemsBlock = By.className("recommended_items");
    private final By signup_Login_Link = By.cssSelector("ul[class*='navbar-nav'] :nth-child(4) > a");
    private final By loggedInUserName = By.cssSelector("ul[class*='nav'] :nth-child(10) > a > b");
    private final By logoutLink = By.cssSelector("ul[class*='navbar-nav'] :nth-child(4) > a");
    private final By deleteAccountLink = By.cssSelector("ul[class*='navbar-nav'] :nth-child(5) > a");
    private final By contactUsLink = By.cssSelector("ul[class*='navbar-nav'] :nth-child(8) > a");
    private final By testCasesLink = By.cssSelector("ul[class*='navbar-nav'] :nth-child(5) > a");
    private final By productsLink = By.cssSelector("ul[class*='navbar-nav'] :nth-child(2) > a");
    private final By cartsLink = By.cssSelector("ul[class*='navbar-nav'] :nth-child(3) > a");
    private final By footer = By.id("footer");
    private final By subscriptionText = By.cssSelector("div[class='single-widget'] > h2");
    private final By emailInput = By.id("susbscribe_email");
    private final By arrowButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.cssSelector("div[class*='alert-success']");
    private final By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private By viewProductButton(int productIndex){
        return By.xpath("(//a[text()='View Product'])["+productIndex+"]");
    }
    private By hoverOnAProduct(int productIndex){
        return By.xpath("//div[@class='features_items']//div[@class='col-sm-4']["+productIndex+"]");
    }
    private By addAProductToCartOnHovering(int productIndex){
        return By.xpath("(//div[@class='overlay-content'])["+productIndex+"]//a");
    }




    public boolean verifyVisibilityOfNavigationBar(){
        WebElement navBar = Utility.getWebElement(driver,navigationBar);
        return navBar.isDisplayed();
    }

    public boolean verifyVisibilityOfFeaturesItems(){
        WebElement featuresItems = Utility.getWebElement(driver,featuresItemsBlock);
        return featuresItems.isDisplayed();
    }

    public boolean verifyVisibilityOfRecommendedItems(){
        WebElement recommendedItems = Utility.getWebElement(driver,recommendedItemsBlock);
        return recommendedItems.isDisplayed();
    }

    public SignUpLoginPage clickOnSignUpLoginLink(){
        Utility.clickOnElement(driver,signup_Login_Link);
        return new SignUpLoginPage(driver);
    }

    public String getLoggedInUserName(){
       return Utility.getText(driver,loggedInUserName);
    }

    public DeletedAccountPage clickOnDeleteAccount(){
        Utility.clickOnElement(driver,deleteAccountLink);
        return new DeletedAccountPage(driver);
    }

    public SignUpLoginPage clickOnLogoutLink(){
        Utility.clickOnElement(driver,logoutLink);
        return new SignUpLoginPage(driver);
    }

    public ContactUsPage clickOnContactUs(){
        Utility.clickOnElement(driver,contactUsLink);
        return new ContactUsPage(driver);
    }

    public void clickOnTestCases(){
        Utility.clickOnElement(driver,testCasesLink);
    }

    public ProductsPage clickOnProducts(){
        Utility.clickOnElement(driver,productsLink);
        return new ProductsPage(driver);
    }

    public HomePage scrollToFooter(){
        Utility.Scroll(driver,footer);
        return this;
    }

    public boolean verifyVisibilityOfSubscriptionText(){
        WebElement SubscriptionText = Utility.getWebElement(driver,subscriptionText);
        return SubscriptionText.isDisplayed();
    }

    public HomePage enterEmailAddress(String email){
        Utility.sendData(driver,emailInput,email);
        return this;
    }

    public HomePage clickOnArrowButton(){
        Utility.clickOnElement(driver,arrowButton);
        return this;
    }

    public String getSubscriptionSuccessMessage(){
        return Utility.getText(driver,subscriptionSuccessMessage);
    }

    public CartsPage clickOnCartsLink(){
        Utility.clickOnElement(driver,cartsLink);
        return new CartsPage(driver);
    }

    public ProductDetailsPage clickOnViewProductButton(int product_Index){
        Utility.clickOnElement(driver,viewProductButton(product_Index));
        return new ProductDetailsPage(driver);
    }

    public HomePage hoverOnProduct(int index){
        Utility.moveToElement(driver,hoverOnAProduct(index));
        return this;
    }

    public HomePage clickOnAddToCartLink(int index){
        Utility.clickOnElement(driver,addAProductToCartOnHovering(index));
        return this;
    }

    public HomePage clickOnContinueShoppingButton(){
        Utility.clickOnElement(driver,continueShoppingButton);
        return this;
    }











}
