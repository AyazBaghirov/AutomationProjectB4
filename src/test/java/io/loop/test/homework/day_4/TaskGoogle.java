package io.loop.test.homework.day_4;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Task 1
================
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Validate title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Validate title equals:
Expected: Google
 */
public class TaskGoogle {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        //Go to: https://google.com
        driver.get("https://google.com");

        //Click to Gmail from top right.
        WebElement gmailButton = driver.findElement(By.xpath("//a[contains(.,'Gmail')]"));
        gmailButton.click();
        // 4- Validate title contains:
        //Expected: Gmail

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title equals ExpectedTitle. TEST PASS");
        }else {
            System.err.println("Title does not equal ExpectedTitle. TEST FAIL");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();


        //6- Validate title equals:
        //Expected: Google

        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.contains(expectedTitle2)) {
            System.out.println("Title equals ExpectedTitle. TEST PASS");
        }else {
            System.err.println("Title does not equal ExpectedTitle. TEST FAIL");
        }

    }
}
