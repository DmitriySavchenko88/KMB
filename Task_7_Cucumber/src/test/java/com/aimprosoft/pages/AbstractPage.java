package com.aimprosoft.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    public static final String BASIC_URL = "https://electronics-2005.aimprosoft.com/electronics/en/Open-Catalogue/c/1";

    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }



}
