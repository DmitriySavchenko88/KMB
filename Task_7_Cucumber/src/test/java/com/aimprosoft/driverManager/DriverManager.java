package com.aimprosoft.driverManager;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    @Contract("_ -> new")
    public static @NotNull WebDriver getWebDriver(@NotNull String browserName) {

        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");

                return new ChromeDriver();
            case "mozilla firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/java/resources/geckodriver");

                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException("Incorrect BrowserName");


        }


    }
}








