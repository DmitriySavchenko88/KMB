package com.aimprosoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    private static WebDriver chromeDriver;

    static {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        chromeDriver = new ChromeDriver();
    }

    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                return chromeDriver;

            default:
                throw new IllegalArgumentException("Incorrect BrowserName");

        }

    }


}
