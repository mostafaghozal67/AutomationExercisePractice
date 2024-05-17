package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    private final WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productName = By.cssSelector("div[class='product-information'] > h2");
    private final By productCategory = By.xpath("//div[@class='product-information'] //p[1]");
    private final By productPrice = By.xpath("//div[@class='product-information'] //span//span");
    private final By productAvailability= By.xpath("//div[@class='product-information'] //p[2]//b");
    private final By productQuantity = By.xpath("//input[@name='quantity']");
    private final By addToCartButton = By.cssSelector("button[class*='cart']");
    private final By viewCartLink = By.xpath("//u[text()='View Cart']");


    public boolean verifyVisibilityOfProductName(){
        //WebElement product_Name = Utility.getWebElement(driver,productName);
        return Utility.getWebElement(driver,productName).isDisplayed();
    }

    public boolean verifyVisibilityOfProductCategory(){
        //WebElement product_Category = Utility.getWebElement(driver,productCategory);
        return Utility.getWebElement(driver,productCategory).isDisplayed();
    }

    public boolean verifyVisibilityOfProductPrice(){
        //WebElement product_Price = Utility.getWebElement(driver,productPrice);
        return Utility.getWebElement(driver,productPrice).isDisplayed();
    }

    public boolean verifyVisibilityOfProductAvailability(){
        //WebElement product_Availability = Utility.getWebElement(driver,productAvailability);
        return Utility.getWebElement(driver,productAvailability).isDisplayed();
    }

    public ProductDetailsPage changeProductQuantity(String quantity){
        Utility.clearText(driver,productQuantity);
        Utility.sendData(driver,productQuantity,quantity);
        return this;
    }

    public ProductDetailsPage clickOnAddToCart(){
        Utility.clickOnElement(driver,addToCartButton);
        return this;
    }

    public CartsPage clickOnViewCartLink(){
        Utility.clickOnElement(driver,viewCartLink);
        return new CartsPage(driver);
    }





}
