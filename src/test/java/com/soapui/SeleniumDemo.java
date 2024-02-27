package com.soapui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDemo {
    static WebDriver webDriver;

    @BeforeClass
    public static void initDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://the-internet.kineticskunk.co.za/dropdown");
    }

    @Test
    public void searchBar() {
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='dropdown']")));
        select.selectByVisibleText("Option 1");
        
    }

}
