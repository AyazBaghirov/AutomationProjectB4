package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset-password
    5. validate - Enter the email address associated with yor account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate send button is displayed
    8. validate cancel button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */
public class T000_xpath_getText {
    public static void main(String[] args) throws InterruptedException {

        //1. open chrome
        //    2. go to docuport
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        //3. click on forgot password

        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(DocuportConstants.RESET_PASSWORD_URL)) {
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
        }

        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));

        String actualValidateMessageText = validateMessage.getText();

        if (actualValidateMessageText.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
        }
// 6. enter forgotpasswordg1@gmail.com to email box

        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id, 'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        WebElement cancelButton = driver.findElement(By.xpath("//span[contains(., 'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));;

        if (sendButton.isDisplayed()) {
            System.out.println("Test passed!  Send Button displayed");
        }else {
            System.out.println("Test failed!  Send Button Not displayed");
        }


        if (cancelButton.isDisplayed()) {
            System.out.println("Test passed!  Cancel Button displayed");
        }else {
            System.out.println("Test failed!  Cancel Button Not displayed");
        }

        sendButton.click();
        Thread.sleep(7000);

        // 10. validate - We've sent you an email with a link to reset your password. Please check your email

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        Thread.sleep(5000);
        //System.out.println("successMessage = " + successMessage.getText());
        try{
            System.out.println("successMessage.getText() = " + successMessage.getText());
        }catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }

    }
}
