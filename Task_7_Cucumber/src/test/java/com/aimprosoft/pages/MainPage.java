package com.aimprosoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {
    private static final By MY_ACCOUNT_BUTTON = By.xpath("//div[@class='myAccountLinksHeader js-myAccount-toggle']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getMyAccountButtonTex() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.findElement(MY_ACCOUNT_BUTTON).getText();
    }


}