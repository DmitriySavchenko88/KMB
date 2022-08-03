package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private SignInSignUpPage signInSignUpPage;

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    @BeforeClass
    public void initPages() {
        driver = new ReusableWebDriver(() -> TestUtils.getWebDriver("chrome"));
        mainPage = new MainPage(driver);
        signInSignUpPage = new SignInSignUpPage(driver);
    }


    @Test
    private void goToSignInPage() {
        System.out.println("Go to Sign In Page");
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        Assert.assertEquals(signInSignUpPage.getReturningCustomerText(), "Returning Customer");
    }

    @Test
    private void logInWithValidData() {
        mainPage.goToMainPage();
        mainPage.goToSignIn();
        System.out.println("Log In with Valid DATA");
        signInSignUpPage.enterUserEmail("savchenko@mail.ru");
        signInSignUpPage.enterUserPass("471666");
        signInSignUpPage.clickOnLogInButton();
        Assert.assertNotNull(mainPage.getWelcomeMassageElement());

    }

    @Test
    private void logInWithInValidData() {

        mainPage.goToMainPage();
        mainPage.goToSignIn();
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

        mainPage.goToMainPage();
        mainPage.goToSignIn();
        System.out.println("Registering with a registered email");
        signInSignUpPage.enterFirstName("Savchenko");
        signInSignUpPage.enterLastName("Dmytro");
        signInSignUpPage.enterExistingEmail("Saveliy.kramarov666@gmail.com");
        signInSignUpPage.enterPassword("paparazi29918");
        signInSignUpPage.confirmPassword("paparazi29918");
        signInSignUpPage.clickOnCheckBoxTerms();
        signInSignUpPage.clickOnRegistrationButton();
        WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='An account already exists for this email address.']")));
        Assert.assertNotNull(signInSignUpPage.getAccountExistErrorElement());
    }

    @Test
    private void registrationWithValidEmail() {

        mainPage.goToMainPage();
        mainPage.goToSignIn();
        System.out.println("Registering with a NEW email");
        signInSignUpPage.enterFirstName("Savchenko");
        signInSignUpPage.enterLastName("Dmytro");
        signInSignUpPage.enterEmail();
        signInSignUpPage.enterPassword("paparazi29918");
        signInSignUpPage.confirmPassword("paparazi29918");
        signInSignUpPage.clickOnCheckBoxTerms();
        signInSignUpPage.clickOnRegistrationButton();

        Assert.assertNotNull(mainPage.getWelcomeMassageElement());
    }
}
