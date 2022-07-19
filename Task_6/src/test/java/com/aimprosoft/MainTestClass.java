package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
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
        mainPage.goToMainPage();
        Assert.assertEquals(mainPage.getTitle(), MainPage.TITLE);

        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        Assert.assertEquals(signInSignUpPage.getReturningCustomerText(), SignInSignUpPage.LOGIN_HEADLINE);


    }

    @Test
    void logInWithValidData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Log In with Valid DATA");

        MainPage loggedInMainPage = signInSignUpPage.logIn();
        Assert.assertNotNull(loggedInMainPage.getWelcomeMassageElement());

    }

    @Test
    void logInWithInValidData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Log In with INVALID DATA");
        SignInSignUpPage loggedInMainPage = signInSignUpPage.logInWithIncorrectData();
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'alert alert-danger alert-dismissable getAccAlert']")));

        Assert.assertNotNull(signInSignUpPage.getErrorText());

    }

    @Test
    void registrationWithExistsEmail() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Registering with a registered email");
        SignInSignUpPage registrationPage = signInSignUpPage.registerWithExistingEmail();
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='An account already exists for this email address.']")));
        Assert.assertNotNull(registrationPage.getAccountExistErrorElement());
    }

    @Test
    void registrationWithValidEmail() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        SignInSignUpPage signInSignUpPage = mainPage.goToSignIn();
        System.out.println("Registering with a NEW email");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        MainPage loggedInMainPage = signInSignUpPage.registerWithValidData();

        Assert.assertNotNull(loggedInMainPage.getWelcomeMassageElement());
    }
}
