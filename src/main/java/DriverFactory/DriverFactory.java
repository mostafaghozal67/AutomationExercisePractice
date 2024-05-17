package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverFactory {

    private static WebDriver driver ;

    public static void setupDriver(String browser){
        switch (browser){
            case "Chrome" :
                ChromeOptions options = new ChromeOptions();
                //options.addExtensions(new File("E:\\Automation testing\\AutomationExercise\\src\\main\\java\\DriverFactory\\AdBlock.crx"));
                options.addArguments("--incognito");
                driver= new ChromeDriver(options);

                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
        }

    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static void closeBrowser(){
        getDriver().quit();
    }
}
