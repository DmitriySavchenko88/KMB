package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    public static final String BASIC_URL = "https://electronics-2005.aimprosoft.com/electronics/en";

    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }


}
