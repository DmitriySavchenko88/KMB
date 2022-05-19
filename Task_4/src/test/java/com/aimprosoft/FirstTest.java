package com.aimprosoft;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void checkGoogleStartPage() {
        String text = "Как научить голубя убивать русню?";

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//input[contains(@class,\"gLFyf gsfi\")]")).sendKeys(text);
        driver.findElement(By.xpath("//div[@class=\"iblpc\"]")).click();

        String value = driver.findElement(By.xpath("//input[contains(@class,\"gLFyf gsfi\")]")).getAttribute("value");
        Assert.assertEquals(text, value);
    }

}