package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private SignInSignUpPage signInSignUpPage;

    @BeforeMethod
    public void goToSignIn(){
            mainPage.goToMainPage();
            mainPage.goToSignIn();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.manage().deleteAllCookies();
    }


    @BeforeClass
    @Parameters({"browser"})

    public void initPages() {
        driver = WebDriverUtils.getWebDriver("chrome");
        mainPage = new MainPage(driver);
        signInSignUpPage = new SignInSignUpPage(driver);

    }


    @Test
    private void goToSignInPage() {
        System.out.println("Go to Sign In Page");

        Assert.assertEquals(signInSignUpPage.getReturningCustomerText(), "Returning Customer");
    }

    @Test
    private void logInWithValidData() {

        System.out.println("Log In with Valid DATA");
        signInSignUpPage.enterUserEmail("savchenko@mail.ru");
        signInSignUpPage.enterUserPass("471666");
        signInSignUpPage.clickOnLogInButton();
        Assert.assertNotNull(mainPage.getWelcomeMassageElement());

    }

    @Test
    private void logInWithInValidData() {


        System.out.println("Log In with INVALID DATA");
        signInSignUpPage.enterUserEmail("savchenko@mail.ru");
        signInSignUpPage.enterPassword("132132132132");
        signInSignUpPage.clickOnLogInButton();


        Assert.assertNotNull(signInSignUpPage.getErrorText());

    }

    @Test
    private void registrationWithExistsEmail() {


        System.out.println("Registering with a registered email");
        signInSignUpPage.enterFirstName("Savchenko");
        signInSignUpPage.enterLastName("Dmytro");
        signInSignUpPage.enterExistingEmail("Saveliy.kramarov666@gmail.com");
        signInSignUpPage.enterPassword("paparazi29918");
        signInSignUpPage.confirmPassword("paparazi29918");
        signInSignUpPage.clickOnCheckBoxTerms();
        signInSignUpPage.clickOnRegistrationButton();

        Assert.assertNotNull(signInSignUpPage.getAccountExistError());
    }

    @Test
    private void registrationWithValidEmail() {

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
