package io.loop.test.homework.day_4;
/*
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

public class DoucportValidateLoginErrorMessages {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        //1. navigate to docuport application

        driver.get(DocuportConstants.DOCUPORT_TEST);

        //2. validate placeholders for user name and password
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='input-14']"));
        if (usernameBox.isDisplayed()) {
            System.out.println("usernameBox.isDisplayed() = " + usernameBox.isDisplayed());
        } else {
            System.err.println("usernameBox.isDisplayed() = false");
        }

        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='input-15']"));
        if (passwordBox.isDisplayed()) {
            System.out.println("passwordBox.isDisplayed() = " + passwordBox.isDisplayed());
        } else {
            System.err.println("passwordBox.isDisplayed() = false");


        }
        //3. without sending username and password click login button

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Log in']"));
        loginButton.click();

        WebElement UsernameErrorMessage = driver.findElement(By.xpath("//*[contains(text(),'Please enter your username or email address')]"));

        String expectedUsernameErrorMessage = "Please enter your username or email address";
        String actualUsernameErrorMessage = UsernameErrorMessage.getText();
        if (actualUsernameErrorMessage.equals(expectedUsernameErrorMessage)) {
            System.out.println("Actual Username Error Message matches Expected Error Message");
        } else {
            System.err.println("Actual Username Error Message DOES NOT matches Expected Error Message");
        }
            WebElement PasswordErrorMessage = driver.findElement(By.xpath("//*[contains(text(),'Please enter your password')]"));

            String expectedPasswordErrorMessage = "Please enter your password";
            String actualPasswordErrorMessage = PasswordErrorMessage.getText();

            if (actualPasswordErrorMessage.equals(expectedPasswordErrorMessage)) {

                System.out.println("Actual Password Error Message matches Expected Error Message");

            } else {
                System.err.println("Actual Password Error Message DOES NOT matches Expected Error Message");
            }

            driver.quit();
        }
    }
