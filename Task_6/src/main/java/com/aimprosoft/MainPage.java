package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {

    public WebElement getWelcomeMassageElement() {
        return driver.findElement(By.xpath("//li[@class = 'logged_in js-logged_in']"));
    }

    public static final By signInButton = By.xpath("//a[contains(text(),'Register')]");


    public void goToMainPage() {
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en");
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignIn() {
        WebElement ele = driver.findElement(signInButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
    }


}