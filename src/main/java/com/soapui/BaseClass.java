package com.soapui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    public static WebDriver webDriver = null;
    static final String BASE_URL = "https://staging.payu.co.za/rpp.do?PayUReference=";
    final static String BROWSER = "chrome"; //chrome, firefox, edge

    public static void launchBrowserWithWebsiteHomePage(String payUReference) {
        switch (BROWSER) {
            case "chrome":
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to(BASE_URL + payUReference);
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to(BASE_URL + payUReference);
                break;
            case "edge":
                // System.setProperty("webdriver.edge.driver", DRIVER_PATH + "msedgedriver.exe");
                webDriver = new EdgeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to(BASE_URL + payUReference);
                break;
            default:
                System.out.println("Selected browser is not available. You can use Chrome, Firefox, or Edge");
                break;
        }
    }
    
    // @AfterClass
    // public static void closeBrowser() {
    //     webDriver.close();
    //     webDriver.quit();
    // }
}
