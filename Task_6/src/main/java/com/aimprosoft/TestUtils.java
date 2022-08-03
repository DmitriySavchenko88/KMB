package com.aimprosoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtils {
    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/home/dima/IdeaProjects/newFolder/chromedriver");
                return new ChromeDriver();

            default:
                throw new IllegalArgumentException("Incorrect BrowserName");

        }

    }

}
