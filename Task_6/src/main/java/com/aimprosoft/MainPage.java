package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {
    public static final By SIGN_IN_BUTTON = By.xpath("//a[contains(text(),'Register')]");

    public WebElement getWelcomeMassageElement() {
        return driver.findElement(By.xpath("//li[@class = 'logged_in js-logged_in']"));
    }


    public void goToMainPage() {
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en");
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignIn() {
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en/login");

    }
}