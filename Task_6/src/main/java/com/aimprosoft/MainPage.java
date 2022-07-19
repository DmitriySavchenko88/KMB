package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {

    public static final String TITLE = "Electronics Site | Homepage";

    public static final By WELCOME_MESSAGE_BY = By.xpath("//*[contains(text(), 'Welcome Savchenko')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToMainPage(){
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en");
    }

    public By signInButton = By.xpath("//a[contains(text(),'Register')]");


    public SignInSignUpPage goToSignIn() {
        WebElement ele = driver.findElement(signInButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
        return new SignInSignUpPage(driver);
    }

    public WebElement getWelcomeMassageElement() {
        return driver.findElement(WELCOME_MESSAGE_BY);
    }

}