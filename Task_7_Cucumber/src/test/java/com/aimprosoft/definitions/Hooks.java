package com.aimprosoft.definitions;

import com.aimprosoft.driverManager.DriverManager;
import com.aimprosoft.pages.ProductListPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Hooks {
    WebDriver driver;
    ProductListPage productListPage;

    @Before
    public void homePage() throws Exception {

        WebDriver driver = DriverManager.getWebDriver("chrome");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        driver.close();
    }
}
