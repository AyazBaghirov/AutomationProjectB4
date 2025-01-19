package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T0_forget_password {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        // locate the forget password link
        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgetPasswordLink.click();
        Thread.sleep(3000);

        //locate forget password heading
        WebElement resetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        System.out.println("resetPasswordHeading.getText() = " + resetPasswordHeading.getText());
    }
}
