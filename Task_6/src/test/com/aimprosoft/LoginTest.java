package com.aimprosoft;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
;

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private SignUpForm signUpForm;
    private SignInForm signInForm;

    @BeforeMethod
    public void goToSignIn() {
        mainPage.goToMainPage();
        mainPage.goToSignIn();
    }

    @AfterMethod
    public void cleanCookies() {
        driver.manage().deleteAllCookies();
    }

    @Parameters({"browser"})
    @BeforeClass
    public void initPages(@Optional("chrome") String browser) {

        driver = WebDriverUtils.getWebDriver(browser);

        mainPage = new MainPage(driver);

        signUpForm = new SignUpForm(driver);
        signInForm = new SignInForm(driver);
        driver.manage().window().maximize();
    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }
    @Test
    private void verifyThatReturningCustomerTextIsDisplayed() {
        System.out.println("Go to Sign In Page");
        Assert.assertEquals(signUpForm.getReturningCustomerText(), "Returning Customer", "Sign in page doesn't has 'Returning Customer' text");
    }

    @Test
    private void verifyThatMyAccountTextIsDisplayedOnTheButton() {

        System.out.println("Log In with Valid DATA");
        signInForm.enterUserEmail("azabraza@mail.com");
        signInForm.enterUserPass("471666");
        signInForm.clickOnLogInButton();
        Assert.assertEquals(mainPage.getMyAccountButtonTex(), "MY ACCOUNT", "Main Page doesn't has My Account text on button");

    }

    @Test
    private void verifyThatErrorMassageIsDisplayedInSignInForm() {


        System.out.println("Log In with INVALID DATA");
        signInForm.enterUserEmail("savchenko@mail.ru");
        signUpForm.enterPassword("132132132132");
        signInForm.clickOnLogInButton();


        Assert.assertEquals(signUpForm.getErrorText(), "×\n" + "Your username or password was incorrect.", "Sign In Form doesn't has ERROR MASSAGE");

    }

    @Test
    private void verifyThatExistsEmailTextIsDisplayedInSignUpForm() {


        System.out.println("Registering with a registered email");
        signUpForm.enterFirstName("Savchenko");
        signUpForm.enterLastName("Dmytro");
        signUpForm.enterEmail("Saveliy.kramarov666@gmail.com");
        signUpForm.enterPassword("paparazi29918");
        signUpForm.confirmPassword("paparazi29918");
        signUpForm.clickOnTermsCheckbox();
        signUpForm.clickOnRegistrationButton();

        Assert.assertEquals(signUpForm.getAccountExistError(), "×\n" + "Please correct the errors below.", "Sign Up form doesn't has massage about Existing Email");
    }

    @Test
    private void verifyThatMyAccountTextIsDisplayedOnTheButtonAfterRegistration() {

        System.out.println("Registering with a NEW email");
        signUpForm.enterFirstName("Savchenko");
        signUpForm.enterLastName("Dmytro");
        signUpForm.enterEmail(Math.random() + "Qwerty@gmail.com");
        signUpForm.enterPassword("paparazi29918");
        signUpForm.confirmPassword("paparazi29918");
        signUpForm.clickOnTermsCheckbox();
        signUpForm.clickOnRegistrationButton();

        Assert.assertEquals(mainPage.getMyAccountButtonTex(), "MY ACCOUNT", "Main Page doesn't has My Account text on button");
    }
}
