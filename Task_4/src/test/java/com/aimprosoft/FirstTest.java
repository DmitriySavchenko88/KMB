package com.aimprosoft;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void checkGoogleStartPage() {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//input[contains(@class,\"gLFyf gsfi\")]")).sendKeys("Как научить голубя убивать русню?");
        driver.findElement(By.xpath("//div[@class=\"iblpc\"]")).click();
    }


}