package com.aimprosoft.definitions;


import com.aimprosoft.pages.ProductListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {

    WebDriver driver;
    ProductListPage productListPage = new ProductListPage(driver);


    @Given("Product list page is opened")
    public void productListPageIsOpened() {

    }

    @When("customer enters a product name into the input field end press ENTER")
    public void customerEntersAProductNameIntoTheInputFieldEndPressENTER() {
        productListPage.enterProductName("DSC-H20 Blue");
    }



    @Then("the entered product appears in the product list on the site page")
    public void theEnteredProductAppearsInTheProductListOnTheSitePage() {
        Assert.assertEquals(productListPage.getProductNameFromSearchList(), "DSC-H20 Blue");
    }

}
