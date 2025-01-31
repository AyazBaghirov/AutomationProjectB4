package io.loop.test.homework.day_6;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.DocuportConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.print.Doc;
/*
=============
login as an advisor
go to received document
click search
click status dropdown
choose in progress

 */

public class LoopcampLogin extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(LoopcampLogin.class);

    @Test
    public void LoginAsAdvisor() throws InterruptedException {

        driver.get(ConfigurationReader.getProperties("docuportBETA"));

        WebElement loginUsername = driver.findElement(By.xpath("//input[@id='input-14']"));
        loginUsername.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='input-15']"));

        loginPassword.sendKeys(DocuportConstants.PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));

        loginButton.click();

        Thread.sleep(3000);

        WebElement receivedDoc =driver.findElement(By.xpath("//h2[contains(.,'Received')]"));
        receivedDoc.click();

        WebElement searchButton = driver.findElement(By.xpath("(//span[.='Search'])[2]"));
        searchButton.click();

        WebElement clickStatus = driver.findElement(By.xpath("//label[.='Status']"));
        clickStatus.click();

        WebElement inProgress = driver.findElement(By.xpath("(//div[.='In progress'])[3]"));
        inProgress.click();




    }
}
