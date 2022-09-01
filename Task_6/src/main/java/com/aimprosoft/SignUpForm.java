package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpForm extends AbstractPage {


    //Registration
    private static final By FIRST_NAME_FIELD = By.id("register.firstName");
    private static final By LAST_NAME_FIELD = By.id("register.lastName");
    private static final By EMAIL_FIELD = By.id("register.email");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By CONFIRM_PASSWORD_FIELD = By.id("register.checkPwd");
    private static final By ERROR_TEXT_LOG_IN = By.xpath("//div[@class = 'global-alerts']");

    private static final By CHECKBOX_TERMS_CONDITIONS = By.id("registerChkTermsConditions");
    private static final By REGISTRATION_BUTTON = By.xpath("//div/button[@type='submit']");
    private static final By TEXT_RETURNING_CUSTOMER = By.cssSelector(".login-page__headline");
    private static final By ACCOUNT_ALREADY_EXIST = By.cssSelector(".global-alerts");

    public SignUpForm(WebDriver driver) {

        super(driver);
    }


    //Registration
    public void enterFirstName(String firstName) {

        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);

    }

    public void enterLastName(String lastName) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);


    }

    public void enterEmail(String existingEmail) {
        driver.findElement(EMAIL_FIELD).sendKeys(existingEmail);

    }




    public void enterPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);

    }


    public void confirmPassword(String confirmPassword) {
        driver.findElement(CONFIRM_PASSWORD_FIELD).sendKeys(confirmPassword);

    }

    public void clickOnTermsCheckbox() {
        driver.findElement(CHECKBOX_TERMS_CONDITIONS).click();

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

    public String getAccountExistError() {
        return driver.findElement(ACCOUNT_ALREADY_EXIST).getText();
    }
}