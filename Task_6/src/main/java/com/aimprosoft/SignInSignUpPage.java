package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInSignUpPage extends AbstractPage {


    //Registration
    private static final By firstNameField = By.xpath("//input[@id = 'register.firstName']");
    private static final By lastNameField = By.xpath("//input[@id = 'register.lastName']");
    private static final By emailField = By.xpath("//input[@id = 'register.email']");
    private static final By passwordField = By.xpath("//input[@id = 'password']");
    private static final By confirmPasswordField = By.xpath("//input[@id = 'register.checkPwd']");
    private static final By errorTextLogIn = By.xpath("//div[@class = 'alert alert-danger alert-dismissable getAccAlert']");

    private static final By checkboxTermsConditions = By.xpath(" //input[@id = 'registerChkTermsConditions']");
    private final By registrationButton = By.xpath("//div/button[@type='submit']");
    private static final By textReturningCustomer = By.xpath("//*[contains(text(), 'Returning Customer')] ");
    private static final By accountAlreadyExist = By.xpath("//span[text()='An account already exists for this email address.']");


    //Log in
    private static final By userEmail = By.xpath("//input[@id = 'j_username']");
    private static final By userPass = By.xpath("//input[@id = 'j_password']");
    private static final By logInButton = By.xpath("//form/button[@type='submit']");


    public SignInSignUpPage(WebDriver driver) {

        super(driver);
    }

    public SignInSignUpPage goToSignInSignUpPage(WebDriver driver) {
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en/login");
        return new SignInSignUpPage(driver);
    }

    //Registration
    public SignInSignUpPage enterFirstName(String firstName) {

        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public SignInSignUpPage enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;

    }

    public SignInSignUpPage enterExistingEmail(String existingEmail) {
        driver.findElement(emailField).sendKeys(existingEmail);
        return this;
    }

    public SignInSignUpPage enterEmail() {
        String email = Math.random() + "Qwerty@gmail.com";
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInSignUpPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }


    public SignInSignUpPage confirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        return this;
    }

    public SignInSignUpPage clickOnCheckBoxTerms() {
        driver.findElement(checkboxTermsConditions).click();
        return this;
    }


    //Log In
    public MainPage enterUserEmail(String usersEmail) {
        driver.findElement(userEmail).sendKeys(usersEmail);
        return new MainPage(driver);
    }

    public MainPage enterUserPass(String userPassword) {
        driver.findElement(userPass).sendKeys(userPassword);
        return new MainPage(driver);
    }


    public void clickOnLogInButton() {
        driver.findElement(logInButton).click();
    }

    public SignInSignUpPage clickOnRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new SignInSignUpPage(driver);
    }




    public String getErrorText() {
        return driver.findElement(errorTextLogIn).getText();
    }

    public String getReturningCustomerText() {
        return driver.findElement(textReturningCustomer).getText();
    }

    public String getAccountExistErrorElement() {
        return driver.findElement(accountAlreadyExist).getText();
    }
}