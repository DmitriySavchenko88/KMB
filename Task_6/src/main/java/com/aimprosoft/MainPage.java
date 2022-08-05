package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {
    private static final By WELCOME_MASSAGE = By.xpath("//li[@class = 'logged_in js-logged_in']");

    public WebElement getWelcomeMassageElement() {
        return driver.findElement(WELCOME_MASSAGE);
    }


    public void goToMainPage() {
        driver.get(BASIC_URL);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignIn() {
        driver.get(BASIC_URL + "/login");

    }
}