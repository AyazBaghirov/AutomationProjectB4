package io.loop.test.homework.day_4;

/*

task 2
=============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout

task 3
=============
1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages
 */


import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskDocuport {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        //1. login to docuport application
        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='input-14']"));
        usernameBox.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='input-15']"));
        passwordBox.sendKeys(DocuportConstants.PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));
        loginButton.click();

        Thread.sleep(5000);
        WebElement continueButton = driver.findElement(By.xpath("//span[normalize-space()='Continue']"));
        continueButton.click();

        WebElement batch1Group1 =driver.findElement(By.xpath("//span[normalize-space()='Batch1 Group1']"));
        String expectedBatch ="Batch1 Group1";
        String actualBatch = batch1Group1.getText();
        if (actualBatch.equals(expectedBatch)) {
            System.out.println("Test passed.");
        }else {
            System.err.println("Test failed.");
        }

        batch1Group1.click();

        WebElement logOutButton = driver.findElement(By.xpath("//span[normalize-space()='Log out']"));
        logOutButton.click();

        WebElement docuportLogo = driver.findElement(By.xpath("//img[@src='/img/logo.d7557277.svg']"));

        if (docuportLogo.isDisplayed()) {
            System.out.println("Test passed.");
        }else {
            System.err.println("Test failed.");
        }

        driver.quit();
    }
}
