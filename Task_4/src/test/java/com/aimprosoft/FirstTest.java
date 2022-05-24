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
        WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
        input.sendKeys(originalText);
        input.submit();
        String titleText = driver.getTitle();
        Assert.assertTrue(titleText.startsWith(originalText));

    }

}