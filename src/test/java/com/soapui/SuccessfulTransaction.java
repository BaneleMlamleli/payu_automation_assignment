package com.soapui;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulTransaction extends BaseClass{
    // https://staging.payu.co.za/rpp.do?PayUReference=34538036092283
    static final String payUReference = "34538036092283";
    
    @Test
    public void testSuccessfulTransactionUserJourney() {
        BaseClass.launchBrowserWithWebsiteHomePage(payUReference);

        // Cart:  //input[@name='pay_meth']
        
        webDriver.findElement(By.xpath("//input[@id='0_cardNumber']")).sendKeys("4000015372250142"); // Entering Card  number
        webDriver.findElement(By.id("0_nameOnCard")).sendKeys("Banele Shaun Mlamleli"); // Entering Cardholder name

        Select selectExpiryMonth = new Select(webDriver.findElement(By.xpath("//select[@id='0_expMonth']")));
        selectExpiryMonth.selectByVisibleText("9");
        Select selectExpiryYear = new Select(webDriver.findElement(By.xpath("//select[@id='0_expYear']")));
        selectExpiryYear.selectByVisibleText("2024");

        WebDriverWait waitForCvvNumberField = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        waitForCvvNumberField.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='0_cvv']")));
        webDriver.findElement(By.xpath("//input[@id='0_cvv']")).sendKeys("012");

        // remember me: //strong[normalize-space()='Remember me']
        webDriver.findElement(By.xpath("//button[@id='btnPay']")).click();

        // cancel button: //a[@id='cancelBtn']


        // successful txn: //p[@class='txt-center centerpage']
        WebDriverWait waitForConfirmationText = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        waitForConfirmationText.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='txt-center centerpage']")));
        assertTrue(webDriver.findElement(By.xpath("//p[@class='txt-center centerpage']")).isDisplayed());
        // continue button: //button[@id='validLink']
        assertTrue(webDriver.findElement(By.xpath("//button[@id='validLink']")).isDisplayed());

    }
}