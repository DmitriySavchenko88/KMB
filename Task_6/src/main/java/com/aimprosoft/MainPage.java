package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {
    private static final By MY_ACCOUNT_BUTTON = By.xpath("//div[@class= \"myAccountLinksHeader js-myAccount-toggle\" ] ");

    public String getDisplayedMyAccountButtonText() {
        return driver.findElement(MY_ACCOUNT_BUTTON).getText();
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