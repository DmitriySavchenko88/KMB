package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;


    @BeforeMethod
    void initializeWebDriver() {

        driver = TestUtils.getWebDriver("chrome");
    }

    @AfterMethod
    void closeBrowser() {

        driver.quit();
    }


    @Test
    private void goToSignInPage() {
        System.out.println("Go to Sign In Page");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        SignInSignUpPage signInSignUpPage = new SignInSignUpPage(driver);
        Assert.assertEquals(signInSignUpPage.getReturningCustomerText(), "Returning Customer");
    }

    @Test
    private void logInWithValidData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        SignInSignUpPage signInSignUpPage = new SignInSignUpPage(driver);
        System.out.println("Log In with Valid DATA");

        MainPage loggedInMainPage = new MainPage(driver);
        signInSignUpPage.enterUserEmail("savchenko@mail.ru");
        signInSignUpPage.enterUserPass("471666");
        signInSignUpPage.clickOnLogInButton();
        Assert.assertNotNull(loggedInMainPage.getWelcomeMassageElement());

    }

    @Test
    private void logInWithInValidData() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        SignInSignUpPage signInSignUpPage = new SignInSignUpPage(driver);
        System.out.println("Log In with INVALID DATA");
        signInSignUpPage.enterUserEmail("savchenko@mail.ru");
        signInSignUpPage.enterPassword("132132132132");
        signInSignUpPage.clickOnLogInButton();
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'alert alert-danger alert-dismissable getAccAlert']")));

        Assert.assertNotNull(signInSignUpPage.getErrorText());

    }

    @Test
    private void registrationWithExistsEmail() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        SignInSignUpPage signInSignUpPage = new SignInSignUpPage(driver);
        System.out.println("Registering with a registered email");
        SignInSignUpPage registrationPage = new SignInSignUpPage(driver);
        signInSignUpPage.enterFirstName("Savchenko");
        signInSignUpPage.enterLastName("Dmytro");
        signInSignUpPage.enterExistingEmail("Saveliy.kramarov666@gmail.com");
        signInSignUpPage.enterPassword("paparazi29918");
        signInSignUpPage.confirmPassword("paparazi29918");
        signInSignUpPage.clickOnCheckBoxTerms();
        signInSignUpPage.clickOnRegistrationButton();
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='An account already exists for this email address.']")));
        Assert.assertNotNull(registrationPage.getAccountExistErrorElement());
    }

    @Test
    private void registrationWithValidEmail() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        SignInSignUpPage signInSignUpPage = new SignInSignUpPage(driver);
        System.out.println("Registering with a NEW email");
        MainPage loggedInMainPage = new MainPage(driver);
        signInSignUpPage.enterFirstName("Savchenko");
        signInSignUpPage.enterLastName("Dmytro");
        signInSignUpPage.enterEmail();
        signInSignUpPage.enterPassword("paparazi29918");
        signInSignUpPage.confirmPassword("paparazi29918");
        signInSignUpPage.clickOnCheckBoxTerms();
        signInSignUpPage.clickOnRegistrationButton();

        Assert.assertNotNull(loggedInMainPage.getWelcomeMassageElement());
    }
}
