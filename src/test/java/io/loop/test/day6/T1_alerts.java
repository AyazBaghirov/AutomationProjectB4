package io.loop.test.day6;

import io.loop.test.base.TestBase;
import io.loop.test.day3.AllLocatorsPractice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_alerts extends TestBase {

        /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
     */

    @Test
    public void informationAlert() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");
    }

    @Test
    public void confirmationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJSConfirm.click();

        driver.switchTo().alert().accept(); // will lick op and accept the alert
        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match expected");
    }

}
