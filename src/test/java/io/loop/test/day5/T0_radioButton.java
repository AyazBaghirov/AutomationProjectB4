package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/*

        https://loopcamp.vercel.app/radio-buttons.html
        wait implicitly 10 seconds
        is selected
        is enabled
         */


public class T0_radioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement red = driver.findElement(By.xpath("//input[@id = 'red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id = 'green']"));

        // isSelected()
        System.out.println("red.isSelected() Before Clicking " + red.isSelected());
        red.click();
        System.out.println("red.isSelected() After Clicking " + red.isSelected());

        green.click();
        System.out.println("green.isSelected() = " + green.isSelected());

        //isEnabled
        System.out.println("red.isEnabled() = " + red.isEnabled());
        System.out.println("green.isEnabled() = " + green.isEnabled());

    }
}
