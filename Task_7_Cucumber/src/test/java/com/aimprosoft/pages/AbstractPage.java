package com.aimprosoft.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    public static final String BASIC_URL = "https://electronics-2005.aimprosoft.com/electronics/en/";

    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }



}
