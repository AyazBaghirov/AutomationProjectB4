package io.loop.test.day3;
/*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"

    the rest is home work
    locate:
    username
    password
    login
    with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */

import io.loop.test.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;

public class T3_getAttribute_css {
    public static void main(String[] args) throws InterruptedException {


        //go to the url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);

        driver.manage().window().maximize();

        driver.navigate().to(DocuportConstants.DOCUPORT_TEST);

        // Locate the element with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        // get the value of the attribute
        //String docuport = logo.getAttribute("alt")
        String docuport = logo.getDomAttribute("alt");
        System.out.println("docuport = " + docuport);

        if (DocuportConstants.LOGO_DOCUPORT.equals(docuport)){
            System.out.println("Expected result matches with actual ");
            System.out.println("TEST PASS");
        }else {
            System.out.println("Expected result does not match with actual ");
            System.err.println("TEST FAIL");
        }


WebElement username = driver.findElement(By.cssSelector("input[id='input-14']"));
WebElement password = driver.findElement(By.cssSelector("input[id='input-15']"));
Thread.sleep(5000);
username.sendKeys(DocuportConstants.USERNAME_CLIENT);
password.sendKeys(DocuportConstants.PASSWORD);

WebElement loginButton = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
loginButton.click();

Thread.sleep(5000);
WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
continueButton.click();

WebElement Batch1Group1 = driver.findElement(By.cssSelector("div[class='v-avatar primary']>span"));

if (Batch1Group1.isDisplayed()){
    System.out.println("Expected result matches with actual. TEST PASSED");
}else {
    System.err.println("Expected result does not match with actual. TEST FAILED");
}
    }
}
