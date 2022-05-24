package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void checkGoogleStartPage() {
        String originalText = "Как научить голубя убивать русню?";

        driver.get("https://www.google.com");
        WebElement input = driver.findElement(By.xpath("//form[contains(@action, \"/search\")]//input[not(contains(@type, \"submit\"))]"));
        input.sendKeys(originalText);
        input.sendKeys("\n");
        String titleText = driver.findElement(By.xpath("//title")).getAttribute("innerText");
        String text = titleText.substring(0, titleText.length() - 15);
        Assert.assertEquals(originalText, text);

    }

}