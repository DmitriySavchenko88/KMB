package com.aimprosoft.definitions;


import com.aimprosoft.driverManager.DriverManager;
import com.aimprosoft.pages.MainPage;
import com.aimprosoft.pages.ProductListPage;
import com.aimprosoft.pages.SignInForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    public ProductListPage productListPage;
    public SignInForm signInForm;
    public MainPage mainPage;
    public WebDriver driver;

    @Before
    public void initPage() throws Exception {

        driver = DriverManager.getWebDriver();
        productListPage = new ProductListPage(driver);
        signInForm = new SignInForm(driver);
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("Product list page is opened")
    public void openProductListPage() {
       productListPage.goToProductListPage();


    }

    @When("Customer searches for 'DSC-H20 Blue'")
    public void customerEntersAProductNameIntoTheInputFieldEndPressEnter() {
        productListPage.enterProductName();

    }

    @Then("Product with name 'DSC-H20 Blue' is appeared in the product list on the site page")
    public void theEnteredProductAppearsInTheProductListOnTheSitePage() {
        Assert.assertEquals(productListPage.getProductNameFromSearchList(), "BLUE");
    }

    @When("the user clicks on Film Cameras")
    public void theUserClicksOnFilmCameras() {
        productListPage.clickOnProductHeadersButton("Film Cameras");

    }

    @Then("the page displays Film Cameras")
    public void thePageDisplaysFilmCameras() {
        Assert.assertEquals(productListPage.getProductTextFromTitleOfProductListPage("Film cameras"), "FILM CAMERAS");

    }

    @When("the user clicks on Webcams")
    public void theUserClicksWebcams() {
        productListPage.clickOnProductHeadersButton("Webcams");

    }

    @Then("the page displays Webcams")
    public void thePageDisplaysWebcams() {
        Assert.assertEquals(productListPage.getProductTextFromTitleOfProductListPage("Webcams"), "WEBCAMS");

    }

    @Given("Sign in form is opened")
    public void signInFormIsOpened() {
        driver.get(MainPage.BASIC_URL+"login");
    }

    @When("Users enters the information in Email and Password fields")
    public void usersEntersTheInformationAsFollows(List<Map<String, String>> dataTable) {
        for (Map<String, String> form : dataTable) {
            String email = form.get("Email");
            signInForm.enterUserEmail(email);
            String pass = form.get("Pass");
            signInForm.enterUserPass(pass);
        }
    }

    @And("Click on the LogIn button")
    public void clickOnTheLogInButton() {
        signInForm.clickOnLogInButton();
    }

    @Then("My Account button is displayed on the Main page")
    public void welcomeMassageIsDisplayInTheHOMEPage() {
        Assert.assertEquals(mainPage.getMyAccountButtonTex(), "MY ACCOUNT", "Main Page doesn't has My Account text on button");
    }


}