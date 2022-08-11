package com.aimprosoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");

                return new ChromeDriver();

            default:
                throw new IllegalArgumentException("Incorrect BrowserName");

        }

    }




}
