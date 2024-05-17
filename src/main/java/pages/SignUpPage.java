package pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver ;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signUpText = By.cssSelector("div[class='login-form'] > h2 > b");
    private final By genderRadioButtonLocator(String gender){
        return By.xpath("//input[@value='"+gender+"']");
    }
    private final By passwordInput = By.id("password");
    private final By dayDropDown = By.id("days");
    private final By monthDropDown = By.id("months");
    private final By yearDropDown = By.id("years");
    private final By signUpNewsLetterCheckBox = By.xpath("//input[@name='newsletter']");
    private final By receiveSpecialOffersCheckBox = By.xpath("//input[@name='optin']");
    private final By firstNameInput= By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By addressInput = By.id("address1");
    private final By countryDropDown = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipCodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("div[class='login-form'] >form > button");


    public String getSignUpText(){
        return Utility.getText(driver,signUpText);
    }

    public SignUpPage selectGender(String gender){
        Utility.clickOnElement(driver,genderRadioButtonLocator(gender));
        return this;
    }

    public SignUpPage enterPassword( String password ){
        Utility.sendData(driver,passwordInput,password);
        return this;
    }

    public SignUpPage selectDay(String day ){
        Utility.SelectFromDropDownMenu(driver,dayDropDown,day);
        return this;
    }

    public SignUpPage selectMonth(String month){
        Utility.SelectFromDropDownMenu(driver,monthDropDown,month);
        return this;
    }

    public SignUpPage selectYear(String year){
        Utility.SelectFromDropDownMenu(driver,yearDropDown,year);
        return this;
    }

    public SignUpPage clickOnSignUpNewsLetterCheckBox(){
        Utility.clickOnElement(driver,signUpNewsLetterCheckBox);
        return this;
    }

    public SignUpPage clickOnReceiveSpecialOffersCheckBox(){
        Utility.clickOnElement(driver,receiveSpecialOffersCheckBox);
        return this;
    }

    public SignUpPage enterFirstName( String firstName ){
        Utility.sendData(driver,firstNameInput,firstName);
        return this;
    }

    public SignUpPage enterLastName( String lastName ){
        Utility.sendData(driver,lastNameInput,lastName);
        return this;
    }

    public SignUpPage enterAddress( String address ){
        Utility.sendData(driver,addressInput,address);
        return this;
    }

    public SignUpPage selectCountry(String country){
        Utility.SelectFromDropDownMenu(driver,countryDropDown,country);
        return this;
    }

    public SignUpPage enterState( String state ){
        Utility.sendData(driver,stateInput,state);
        return this;
    }

    public SignUpPage enterCity( String city ){
        Utility.sendData(driver,cityInput,city);
        return this;
    }

    public SignUpPage enterZipCode( String zipCode ){
        Utility.sendData(driver,zipCodeInput,zipCode);
        return this;
    }

    public SignUpPage enterMobileNumber( String mobileNumber ){
        Utility.sendData(driver,mobileNumberInput,mobileNumber);
        return this;
    }

    public AccountCreatedPage clickOnCreateAccountButton(){
        Utility.clickOnElement(driver,createAccountButton);
        return new AccountCreatedPage(driver);
    }





}
