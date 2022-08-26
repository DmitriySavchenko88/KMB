package com.aimprosoft.driverManager;

import com.aimprosoft.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
    private static WebDriver driver;


    public static WebDriver getWebDriver() throws Exception {
        if (driver != null) return driver;
        String driverName = ConfigProperties.getProperty("browser");

        switch (driverName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                return new ChromeDriver();
            }
            case "mozilla firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Incorrect BrowserName");

        }
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}








