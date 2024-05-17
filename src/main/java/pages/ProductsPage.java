package pages;

import Utilities.DataUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private final WebDriver driver;

    //Variables
    List<WebElement> products ;
    List<WebElement> productsName;
    List<String> productName ;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By allProducts = By.cssSelector("div[class*='productinfo']");
    private final By searchInput = By.xpath("//input[@name='search']");
    private final By searchButton = By.cssSelector("div[class='container'] > button");
    private final By allProductsName = By.cssSelector("div[class*='productinfo'] > p");
    private final By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private final By viewCartButton = By.xpath("//u[text()='View Cart']");
    private By clickOnAProduct(int productIndex){
        return By.xpath("(//a[text()='View Product'])["+productIndex+"]");
    }
    private By hoverOnAProduct(int productIndex){
        return By.xpath("//div[@class='features_items']//div[@class='col-sm-4']["+productIndex+"]");
    }
    private By addAProductToCartOnHovering(int productIndex){
        return By.xpath("(//div[@class='overlay-content'])["+productIndex+"]//a");
    }



    public int getAllProducts(){
        products = driver.findElements(allProducts);
        return products.size();
    }

    public ProductDetailsPage clickOnProduct(int index){
        Utility.clickOnElement(driver,clickOnAProduct(index));
        return new ProductDetailsPage(driver);
    }

    public ProductsPage productSearch(String searchedProduct){
        Utility.sendData(driver,searchInput,searchedProduct);
        return this;
    }

    public ProductsPage clickOnSearchButton(){
        Utility.clickOnElement(driver,searchButton);
        return this;
    }

    public ProductsPage getProductsNamesOfSearchResults(){
        productsName = driver.findElements(allProductsName);
        productName = new ArrayList<>();
        for (WebElement element : productsName){
            productName.add(element.getText());
        }
        return this;
    }

    public boolean verifyRelevantSearchResults() throws FileNotFoundException {
        for (String name : productName){
            if (!name.contains(DataUtility.getJsonData("searchProducts","searchResults")))
                return false ;
        }
        return true ;
    }

    public ProductsPage hoverOnProduct(int index){
        Utility.moveToElement(driver,hoverOnAProduct(index));
        return this;
    }

    public ProductsPage clickOnAddToCartLink(int index){
        Utility.clickOnElement(driver,addAProductToCartOnHovering(index));
        return this;
    }

    public ProductsPage clickOnContinueShoppingButton(){
        Utility.clickOnElement(driver,continueShoppingButton);
        return this;
    }

    public CartsPage clickOnViewCartButton(){
        Utility.clickOnElement(driver,viewCartButton);
        return new CartsPage(driver);
    }








}
