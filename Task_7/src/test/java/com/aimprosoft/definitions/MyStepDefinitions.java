package com.aimprosoft.definitions;


import com.aimprosoft.pages.AbstractPage;
import com.aimprosoft.pages.ProductListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyStepDefinitions {

    public WebDriver driver;
    public ProductListPage productListPage;


    @Given("product list page is opened")
    public void gpToProductListPageIsOpened() {


    }

    @When("customer enters a product name into the input field end press ENTER")
    public void verifyThatCustomerIsAbleToEnterAProductNameIntoTheInputFieldEndPressENTER() {
        this.productListPage.enterProductName("DSC-H20 Blue");
    }



    @Then("the entered product appears in the product list on the site page")
    public void verifyThatTheEnteredProductAppearsInTheProductListOnTheSitePage() {
        Assert.assertEquals(this.productListPage.getProductNameFromSearchList(), "DSC-H20 Blue");
    }

    @Given("Product list page is opened")
    public void productListPageIsOpened() {
        driver.get(AbstractPage.BASIC_URL);
        productListPage = new ProductListPage(driver);
    }
}
