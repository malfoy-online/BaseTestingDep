package org.basetest.browsermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.basetest.constants.BaseBrowserConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    public static WebDriver driver;
    private static String browserChoice;
    private static String[] browserArguments;

    private DriverManager(){
        if(browserChoice.equalsIgnoreCase(BaseBrowserConstants.CHROME_BROWSER)){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(browserArguments);
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browserChoice.equalsIgnoreCase(BaseBrowserConstants.FIREFOX_BROWSER)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(browserArguments);
            driver = new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browserChoice.equalsIgnoreCase(BaseBrowserConstants.EDGE_BROWSER)) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments(browserArguments);
            driver = new EdgeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver(String browserType){
         browserChoice = browserType;
         new DriverManager();
         return driver;
    }

    public static WebDriver getDriver(String browserType, String... arguments){
        browserChoice = browserType;
        browserArguments = arguments;
        new DriverManager();
        return driver;
    }
}
