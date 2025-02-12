package io.loop.test.homework.day_7;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.DocuportWebTableUtils;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.testng.Assert.assertEquals;

/*
 1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza - we did in class
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
 */
public class Task2 {

    String actual;
    String expected;

    @Test
    public void testAdvisor() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportBETA"));
        DocuportUtils.login(Driver.getDriver(), "advisor");

        WebElement users = Driver.getDriver().findElement(By.xpath("//span[.='Users']"));
        users.click();

        expected = "alexdesouze";
        actual = DocuportWebTableUtils.returnAnyField(Driver.getDriver(),"alex.de.souza@gmail.com","username");
        assertEquals(actual, expected,"Actual does NOT match expected");

        expected ="+994512060042";
        actual = DocuportWebTableUtils.returnAnyField(Driver.getDriver(),"alex.de.souza@gmail.com","phone number");

        assertEquals(actual, expected,"Actual does NOT match expected");

        expected ="Client";
        actual = DocuportWebTableUtils.returnAnyField(Driver.getDriver(),"alex.de.souza@gmail.com","role");

        assertEquals(actual, expected,"Actual does NOT match expected");

        expected ="Batch1 Group1";
        actual = DocuportWebTableUtils.returnAnyField(Driver.getDriver(),"alex.de.souza@gmail.com","advisor");

        assertEquals(actual, expected,"Actual does NOT match expected");


    }

}
