package io.loop.test.homework.day_7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends TestBase {
    /*
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
     */
String expected ;
String actual;

@Test
    public void validateIframes(){
    driver.get("https://loopcamp.vercel.app/nested-frames.html");
    driver.switchTo().frame("frame-top");
    driver.switchTo().frame("frame-left");

    String xpath = "//*[contains(text(), 'LEFT')]";

    WebElement LeftFrame = driver.findElement(By.xpath(xpath));

    expected = "LEFT";
    actual = LeftFrame.getText().trim();

    Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");
    driver.switchTo().parentFrame();
    driver.switchTo().frame(1);
    xpath = "//*[contains(text(), 'MIDDLE')]";

    WebElement MiddleFrame = driver.findElement(By.xpath(xpath));

    expected = "MIDDLE";
    actual = MiddleFrame.getText().trim();

    Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");


    driver.switchTo().parentFrame();
    driver.switchTo().frame(2);
    xpath = "//*[contains(text(), 'RIGHT')]";

    WebElement rightFrame = driver.findElement(By.xpath(xpath));

    expected = "RIGHT";
    actual = rightFrame.getText().trim();

    Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");


    driver.switchTo().defaultContent();
    driver.switchTo().frame("frame-bottom");
    xpath = "//*[contains(text(), 'BOTTOM')]";

    WebElement bottomFrame = driver.findElement(By.xpath(xpath));

    expected = "BOTTOM";
    actual = bottomFrame.getText().trim();

    Assert.assertEquals(actual,expected, "Actual " + actual +  "DOES NOT match the expected " + expected + "=> Test Failed");



}


}
