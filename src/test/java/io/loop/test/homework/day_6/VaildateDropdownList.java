package io.loop.test.homework.day_6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
task1
=============

go to http://the-internet.herokuapp.com/dropdown
                validate "Please select an option" is selected by default
Choose option 1 and validate that it is selected
Choose option 2 and validate that it is selected
Validate dropdown name is "Dropdown List"

task2
=============
login as an advisor
go to received document
click search
click status dropdown
choose in progress

task3
=============
go to https://demoqa.com/alerts
click - click button to see alert
handle alert
click - On button click, alert will appear after 5 seconds
handle alert
click - On button click, confirm box will appear
click ok and validate - You selected Ok
after that do it again this time cancel and validate - You selected Cancel
click - On button click, prompt box will appear
enter "Loop Academy" and validate You entered Loop Academy

task4
=============
go to https://demoqa.com/nestedframes
Validate "Child Iframe" text
Validate "Parent Iframe" text
Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."


 */
public class VaildateDropdownList extends TestBase {

    @Test
            public void dropdownList() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select [@id='dropdown']"));
        Select dropdownSelect = new Select(dropdown);
        String expected = "Please select an option";
        Assert.assertEquals(dropdownSelect.getFirstSelectedOption().getText(), expected, "Actual Does NOT match Expected");

        expected ="Option 1";
        dropdownSelect.selectByIndex(1);
        Assert.assertEquals(dropdownSelect.getFirstSelectedOption().getText(), expected, "Actual Does NOT match Expected");


        expected ="Option 2";
        dropdownSelect.selectByVisibleText("Option 2");
        Assert.assertEquals(dropdownSelect.getFirstSelectedOption().getText(), expected, "Actual Does NOT match Expected");

        WebElement DropdownListName = driver.findElement(By.xpath("//h3"));
        expected = "Dropdown List";
        Assert.assertEquals(DropdownListName.getText(), expected, "Actual Does NOT match Expected");
    }
}
