package io.loop.test.homework.day_7;

import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class Task3 {
    /*
 1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title

 */

    String actual, expected;

    @Test
    public void windowHandleTest(){
        Driver.getDriver().get(ConfigurationReader.getProperties("loop.practice"));
        WebElement multipleWindows = Driver.getDriver().findElement(By.xpath("//a[@href='windows.html']"));
        multipleWindows.click();

        WebElement poweredByLoopcamp = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        expected = "Powered by LOOPCAMP";
        actual = poweredByLoopcamp.getText();
        assertEquals(actual, expected, "Actual DOES NOT MATCH expected");

        expected ="Windows";
        actual =Driver.getDriver().getTitle();
        assertEquals(actual, expected, "Actual DOES NOT MATCH expected");

        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//a[contains(@href, 'windows/new.html')]"));
        clickHere.click();
        String originalWindow = Driver.getDriver().getWindowHandle();

//        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
//        for (String windowHandle : windowHandles) {
//            System.out.println("windowHandle = " + windowHandle);
//            Driver.getDriver().switchTo().window(windowHandle);
//        }
//

        BrowserUtils.switchToWindow(Driver.getDriver(), "New Window");
        System.out.println("Driver.getDriver().getWindowHandle() = " + Driver.getDriver().getWindowHandle());
        System.out.println("Driver.getDriver().getWindowHandles() = " + Driver.getDriver().getWindowHandles());
        expected = "New Window";
        actual = Driver.getDriver().getTitle();
        assertEquals(actual, expected, "Actual DOES NOT MATCH expected");

    }
}
