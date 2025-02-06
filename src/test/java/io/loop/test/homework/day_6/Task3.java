package io.loop.test.homework.day_6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
go to https://demoqa.com/alerts
click - click button to see alert
handle alert
click - On button click, alert will appear after 5 seconds
handle alert
click - On button click, confirm box will appear
click ok and validate - You selected Ok
after that do it again this time cancel and validate - You selected Cancel
click - On button click, prompt box will appear
enter "Loop Academy" and validate You entered Loop Academy
 */
public class Task3 extends TestBase {

    Alert alert;
    String expectedMessage;
    String actualMessage;

    @Test
    public void informationAlert () throws InterruptedException {

        driver.get ("https://demoqa.com/alerts");


        WebElement informationAlert1 = driver.findElement (By.xpath("//*[@id='alertButton']"));
        informationAlert1.click ();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        alert = driver.switchTo().alert();
        alert.accept();



        WebElement informationAlert2 = driver.findElement (By.xpath("//*[@id='timerAlertButton']"));
        informationAlert2.click ();


        Thread.sleep(5000);

        alert.accept();

    }

    @Test
    public void confirmationAlert () throws InterruptedException {

        driver.get ("https://demoqa.com/alerts");

        WebElement confirmButton = driver.findElement (By.xpath("//*[@id='confirmButton']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Thread.sleep(10000);

        confirmButton.click ();

        alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessage = driver.findElement (By.xpath("//span[contains (., 'You selected ')]"));

        expectedMessage = "You selected Ok";
        actualMessage = successMessage.getText ();

        Assert.assertEquals(actualMessage, expectedMessage, "Expected does not match actual");

        confirmButton.click ();

        alert.dismiss();

        expectedMessage = "You selected Cancel";
        actualMessage = successMessage.getText ();
        Assert.assertEquals(actualMessage, expectedMessage, "Expected does not match actual");

    }


    @Test
    public void promptAlert () throws InterruptedException {
        driver.get ("https://demoqa.com/alerts");

        WebElement promptButton = driver.findElement (By.xpath("//button[@id='promtButton']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        promptButton.click ();


        String text = "Loop Academy";
        alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();


        WebElement promptResult = driver.findElement (By.xpath("//span[@id = 'promptResult']"));

        expectedMessage = "You entered Loop Academy";
        actualMessage = promptResult.getText ();

        Assert.assertEquals(actualMessage, expectedMessage, "Expected does not match actual");









    }






}
