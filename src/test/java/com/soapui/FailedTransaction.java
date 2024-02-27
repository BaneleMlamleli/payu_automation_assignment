package com.soapui;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FailedTransaction extends BaseClass {
    // https://staging.payu.co.za/rpp.do?PayUReference=34467249044840
    static final String payUReference = "34467249044840";

    @Test
    public void testFailedTransactionUserJourney() {
        BaseClass.launchBrowserWithWebsiteHomePage(payUReference);

        // Cart:  //input[@name='pay_meth']

        webDriver.findElement(By.xpath("//input[@id='0_cardNumber']")).sendKeys("5100051617508008"); // Entering Card  number
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
        assertTrue(webDriver.findElement(By.xpath("//p[@class='txt-center centerpage']")).getText().equalsIgnoreCase("Your transaction was unsuccessful."));
        // continue button: //button[@id='validLink']
        assertTrue(webDriver.findElement(By.xpath("//button[@id='validLink']")).isDisplayed());
    }
}
