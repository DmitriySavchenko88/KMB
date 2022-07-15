package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainTestClass {

    private WebDriver driver;


    WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/home/dima/IdeaProjects/newFolder/chromedriver");
                return new ChromeDriver();

            default:
                throw new RuntimeException("Incorrect BrowserName");

        }

    }

    @BeforeMethod
    void initializeWebDriver() {

        driver = getWebDriver("chrome");
    }

    @AfterMethod
    void closeBrowser() {

        driver.quit();
    }


    @Test
    void goToSignInPage() {
        System.out.println("Go to Sign In Page");

        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getTitle(), MainPage.TITLE);

        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        Assert.assertEquals(signInSignUpPage.getReturningCustomerText(), SignInSignUpPage.LOGIN_HEADLINE);


    }

    @Test
    void logInWithValidData() {
        MainPage mainPage = new MainPage(driver);
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Log In with Valid DATA");

        MainPage loggedInMainPage = signInSignUpPage.logIn();
        Assert.assertNotNull(loggedInMainPage.getWelcomeMassageElement());

    }
    @Test
    void logInWithInValidData() {
        MainPage mainPage = new MainPage(driver);
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Log In with Valid DATA");
        SignInSignUpPage loggedInMainPage = signInSignUpPage.logInWithIncorrectData();
        Assert.assertNotNull(signInSignUpPage.getErrorText());

    }

    @Test
    void registrationWithExistsEmail() {
        MainPage mainPage = new MainPage(driver);
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Registering with a registered email");
        SignInSignUpPage registrationPage = signInSignUpPage.registerWithExistingEmail();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(registrationPage.getAccountExistErrorElement());
    }

    @Test
    void registrationWithValidEmail() {
        MainPage mainPage = new MainPage(driver);
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Registering with a NEW email");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        MainPage loggedInMainPage = signInSignUpPage.registerWithValidData();

        Assert.assertNotNull(loggedInMainPage.getWelcomeMassageElement());
    }
}
