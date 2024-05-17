package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility {

    private static final String ScreenshotPath = "TestOutputs/Screenshots";

    public static WebElement getWebElement(WebDriver driver,By locator){
        return  driver.findElement(locator);
    }

    public static void clickOnElement(WebDriver driver,By locator){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(locator));
        getWebElement(driver,locator).click();
    }

    public static void sendData(WebDriver driver, By locator, String data){
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        getWebElement(driver,locator).sendKeys(data);
    }

    public static void clearText(WebDriver driver , By locator){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(locator));
         getWebElement(driver,locator).clear();
    }

    public static String getText(WebDriver driver , By locator){
        new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getWebElement(driver,locator).getText();
    }

    public static void SelectFromDropDownMenu(WebDriver driver , By locator, String dropDownValue){
        Select Dropdown = new Select(getWebElement(driver,locator));
        Dropdown.selectByVisibleText(dropDownValue);
    }

    public static void moveToElement(WebDriver driver , By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement(driver,locator)).perform();
    }

    public static WebDriverWait Wait(WebDriver driver){
        return new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public static String getTimeStamp(){
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        try {
            File screenshotSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(ScreenshotPath + screenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(screenshotSrc,screenshotFile);
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));
        }
        catch (Exception e){}

    }

    public static void Scroll(WebDriver driver , By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",getWebElement(driver,locator));
    }



}
