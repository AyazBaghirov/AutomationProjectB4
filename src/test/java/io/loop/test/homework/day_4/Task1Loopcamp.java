package io.loop.test.homework.day_4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
Practice tasks
==============

task 1
=============
1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. Validate those elements are displayed

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
public class Task1Loopcamp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        //1. go to https://loopcamp.vercel.app/forgot-password.html
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        //locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
        WebElement forgotPassword = driver.findElement(By.tagName("h2"));
        System.out.println("forgotPassword.isDisplayed() = " + forgotPassword.isDisplayed());

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println("email.isDisplayed() = " + email.isDisplayed());

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());

        WebElement retreivePassword = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        System.out.println("retreivePassword.isDisplayed() = " + retreivePassword.isDisplayed());

        driver.quit();



    }
}
