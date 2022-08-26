package com.aimprosoft.definitions;

import com.aimprosoft.driverManager.DriverManager;
import com.aimprosoft.pages.AbstractPage;
import com.aimprosoft.pages.ProductListPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    ProductListPage productListPage;
    WebDriver driver;
    @Before
    public void initPage() throws Exception {

        driver = DriverManager.getWebDriver();
        productListPage = new ProductListPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Given("Product list page is opened")
    public void product_list_page_is_opened() {
        driver.get(AbstractPage.BASIC_URL);


    }

    @When("customer enters a product name into the input field end press ENTER")
    public void customer_enters_a_product_name_into_the_input_field_end_press_enter() {
        productListPage.enterProductName("DSC-H20 Blue");

    }

    @Then("the entered product appears in the product list on the site page")
    public void the_entered_product_appears_in_the_product_list_on_the_site_page() {
        Assert.assertEquals(productListPage.getProductNameFromSearchList(), "BLUE");
    }

    @When("the user clicks Film Cameras")
    public void the_user_clicks_film_cameras() {
        productListPage.clickOnFilmCamerasHeadersButton();

    }

    @Then("the page displays Film Cameras")
    public void the_page_displays_film_cameras() {
        Assert.assertEquals(productListPage.getFilmCamerasTextFromTitleOfProductListPage(), "FILM CAMERAS");

    }

    @When("the user clicks Webcams")
    public void the_user_clicks_webcams() {
        productListPage.clickOnWebCamerasHeaderButton();

    }

    @Then("the page displays Webcams")
    public void the_page_displays_webcams() {
        Assert.assertEquals(productListPage.getWebCamerasTextFromTitleOfProductListPage(), "WEBCAMS");

    }


}
