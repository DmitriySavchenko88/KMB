package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    public WebDriver driver;
    public static final String BASIC_URL = "https://electronics-2005.aimprosoft.com/electronics/en";
    private static final By SIGN_IN_PAGE = By.linkText(BASIC_URL +"/login");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }


}
