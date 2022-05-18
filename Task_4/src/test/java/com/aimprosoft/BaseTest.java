package com.aimprosoft;

import com.aimprosoft.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    protected WebDriver driver = DriverManager.getDriver();

    @AfterTest
    public void kill(){
        driver.close();
        driver.quit();
    }

}
