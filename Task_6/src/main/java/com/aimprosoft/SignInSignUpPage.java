package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInSignUpPage extends AbstractPage {


    //Registration
    private static final By FIRST_NAME_FIELD = By.xpath("//input[@id = 'register.firstName']");
    private static final By LAST_NAME_FIELD = By.xpath("//input[@id = 'register.lastName']");
    private static final By EMAIL_FIELD = By.xpath("//input[@id = 'register.email']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@id = 'password']");
    private static final By CONFIRM_PASSWORD_FIELD = By.xpath("//input[@id = 'register.checkPwd']");
    private static final By ERROR_TEXT_LOG_IN = By.xpath("//div[@class = 'alert alert-danger alert-dismissable getAccAlert']");

    private static final By CHECKBOX_TERMS_CONDITIONS = By.xpath(" //input[@id = 'registerChkTermsConditions']");
    private static final By REGISTRATION_BUTTON = By.xpath("//div/button[@type='submit']");
    private static final By TEXT_RETURNING_CUSTOMER = By.xpath("//*[contains(text(), 'Returning Customer')] ");
    private static final By ACCOUNT_ALREADY_EXIST = By.xpath("//span[text()='An account already exists for this email address.']");


    //Log in
    private static final By USER_EMAIL = By.xpath("//input[@id = 'j_username']");
    private static final By USER_PASS = By.xpath("//input[@id = 'j_password']");
    private static final By LOG_IN_BUTTON = By.xpath("//form/button[@type='submit']");


    public SignInSignUpPage(WebDriver driver) {

        super(driver);
    }

    public void goToSignInSignUpPage(WebDriver driver) {
        driver.get("https://electronics-2005.aimprosoft.com/electronics/en/login");

    }

    //Registration
    public void enterFirstName(String firstName) {

        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);

    }

    public void enterLastName(String lastName) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);


    }

    public void enterExistingEmail(String existingEmail) {
        driver.findElement(EMAIL_FIELD).sendKeys(existingEmail);

    }

    public void enterEmail() {
        String email = Math.random() + "Qwerty@gmail.com";
        driver.findElement(EMAIL_FIELD).sendKeys(email);

    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);

    }


    public void confirmPassword(String confirmPassword) {
        driver.findElement(CONFIRM_PASSWORD_FIELD).sendKeys(confirmPassword);

    }

    public void clickOnCheckBoxTerms() {
        driver.findElement(CHECKBOX_TERMS_CONDITIONS).click();

    }


    //Log In
    public void enterUserEmail(String usersEmail) {
        driver.findElement(USER_EMAIL).sendKeys(usersEmail);

    }

    public void enterUserPass(String userPassword) {
        driver.findElement(USER_PASS).sendKeys(userPassword);

    }


    public void clickOnLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

    public void clickOnRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();

    }


    public String getErrorText() {
        return driver.findElement(ERROR_TEXT_LOG_IN).getText();
    }

    public String getReturningCustomerText() {
        return driver.findElement(TEXT_RETURNING_CUSTOMER).getText();
    }

    public String getAccountExistErrorElement() {
        return driver.findElement(ACCOUNT_ALREADY_EXIST).getText();
    }
}