package com.aimprosoft.driverManager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class DriverManager {

    private static DriverManager instance = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        if (driverThreadLocal.get() == null) {
            String remoteUrl = "http://localhost:4444";
            if (browser.equals("firefox")) {
                Capabilities capabilities = new FirefoxOptions();
                final WebDriver driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
                driverThreadLocal.set(driver);
            }
        }
        return driverThreadLocal.get();
    }

    public static void closeDriver() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}