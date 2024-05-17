package pages;

import Utilities.Utility;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpLoginPage {
    private final WebDriver driver ;

    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    private final By newUserSignUpText = By.xpath("//h2[text()=('New User Signup!')]");
    private final By logInToYourAccountText = By.cssSelector("div[class='login-form'] > h2");
    private final By signUpNameInput = By.cssSelector("div[class='signup-form'] > form > input:nth-child(2)");
    private final By signUpEmailInput = By.cssSelector("div[class='signup-form'] > form > input:nth-child(3)");
    private final By signUpButton = By.cssSelector("div[class='signup-form'] > form > button");
    private final By signUpErrorMessage = By.xpath("//p[text()='Email Address already exist!']");
    private final By loginEmailInput = By.cssSelector("div[class='login-form'] > form > input:nth-child(2)");
    private final By loginPasswordInput = By.cssSelector("div[class='login-form'] > form > input:nth-child(3)");
    private final By loginButton = By.cssSelector("div[class='login-form'] > form > button");
    private final By loginErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");


    public String getNewUserSignUpText(){
        return Utility.getText(driver,newUserSignUpText);
    }

    public String getLogInToYourAccountText(){return Utility.getText(driver,logInToYourAccountText);}


    @Description("Enter the name in the SignUp Section")
    public SignUpLoginPage enterName_SignUp(String name){
        Utility.sendData(driver,signUpNameInput,name);
        return this;
    }

    @Description("Enter the email address in the SignUp Section")
    public SignUpLoginPage enterEmailAddress_SignUp(String email){
        Utility.sendData(driver,signUpEmailInput,email);
        return this;
    }

    @Description("Click on SignUp Button")
    public SignUpPage clickOnSignUpButton(){
        Utility.clickOnElement(driver,signUpButton);
        return new SignUpPage(driver);
    }

    public String getRegisterErrorMessage(){
        return Utility.getText(driver,signUpErrorMessage);
    }

    @Description("Enter the email address in the Login Section")
    public SignUpLoginPage enterEmailAddress_Login(String email){
        Utility.sendData(driver,loginEmailInput,email);
        return this;
    }

    @Description("Enter the password in the Login Section")
    public SignUpLoginPage enterPassword_Login(String password){
        Utility.sendData(driver,loginPasswordInput,password);
        return this;
    }

    @Description("Click on Login Button")
    public HomePage clickOnLoginButton(){
        Utility.clickOnElement(driver,loginButton);
        return new HomePage(driver);
    }

    public String getLoginErrorMessage(){
        return Utility.getText(driver,loginErrorMessage);
    }
}
