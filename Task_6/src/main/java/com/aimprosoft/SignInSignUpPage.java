package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInSignUpPage extends AbstractPage {

    public static final String LOGIN_HEADLINE = "Returning Customer";

    public SignInSignUpPage(WebDriver driver) {

        super(driver);
    }

    public SignInSignUpPage goTosignInSignUpPage (WebDriver driver) {
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en/login");
        return new SignInSignUpPage(driver);
    }

    //Registration
    private By firstNameField = By.xpath("//input[@id = 'register.firstName']");
    private By lastNameField = By.xpath("//input[@id = 'register.lastName']");
    private By emailField = By.xpath("//input[@id = 'register.email']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By confirmPasswordField = By.xpath("//input[@id = 'register.checkPwd']");
    private By errorTextLogIn = By.xpath("//div[@class = 'alert alert-danger alert-dismissable getAccAlert']");

    private By checkboxTermsConditions = By.xpath(" //input[@id = 'registerChkTermsConditions']");
    private final By registrationButton = By.xpath("//div/button[@type='submit']");
    private By textReturningCustomer = By.xpath("//*[contains(text(), 'Returning Customer')] ");
    private By accountAlreadyExist = By.xpath("//span[text()='An account already exists for this email address.']");


    //Log in
    private By userEmail = By.xpath("//input[@id = 'j_username']");
    private By userPass = By.xpath("//input[@id = 'j_password']");
    private final By logInButton = By.xpath("//form/button[@type='submit']");


    //Registration
    public SignInSignUpPage enterFirstName() {

        driver.findElement(firstNameField).sendKeys("Savchenko");
        return this;
    }

    public SignInSignUpPage enterLastName() {
        driver.findElement(lastNameField).sendKeys("Dmytro");
        return this;

    }

    public SignInSignUpPage enterExistingEmail() {
        driver.findElement(emailField).sendKeys("Saveliy.kramarov666@gmail.com");
        return this;
    }
    public SignInSignUpPage enterEmail() {
        String email = Math.random() + "Qwerty@gmail.com";
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInSignUpPage enterPassword() {
        driver.findElement(passwordField).sendKeys("paparazi29918");
        return this;
    }


    public SignInSignUpPage confirmPassword() {
        driver.findElement(confirmPasswordField).sendKeys("paparazi29918");
        return this;
    }

    public SignInSignUpPage clickOnCheckBoxTerms() {
        driver.findElement(checkboxTermsConditions).click();
        return this;
    }


    //Log In
    public MainPage enterUserEmail() {
        driver.findElement(userEmail).sendKeys("savchenko@mail.ru");
        return new MainPage(driver);
    }

    public MainPage enterUserPass() {
        driver.findElement(userPass).sendKeys("471666");
        return new MainPage(driver);
    }

    public SignInSignUpPage enterIncorrectUserPass() {
        driver.findElement(userPass).sendKeys("132132132132");
        return this;
    }


    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }

    public SignInSignUpPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new SignInSignUpPage(driver);
    }


    public SignInSignUpPage registerWithExistingEmail() {

        enterFirstName();
        enterLastName();
        enterExistingEmail();
        enterPassword();
        confirmPassword();
        clickOnCheckBoxTerms();
        clickRegistrationButton();
        return this;
    }
    public MainPage registerWithValidData() {

        enterFirstName();
        enterLastName();
        enterEmail();
        enterPassword();
        confirmPassword();
        clickOnCheckBoxTerms();
        clickRegistrationButton();
        return new MainPage(driver);
    }

    public MainPage logIn() {
        enterUserEmail();
        enterUserPass();
        clickLogInButton();
        return new MainPage(driver);
    }


    public SignInSignUpPage logInWithIncorrectData() {

        this.enterUserEmail();
        this.enterIncorrectUserPass();
        this.clickLogInButton();
        return this;
    }


    public WebElement getErrorText() {
        return driver.findElement(errorTextLogIn);
    }

    public String getReturningCustomerText() {
        return driver.findElement(textReturningCustomer).getText();
    }

    public WebElement getAccountExistErrorElement() {
        return driver.findElement(accountAlreadyExist);
    }
}