package definitions;

import driverManager.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AbstractPage;
import pages.ProductListPage;

public class MyStepDefinitions {
    WebDriver driver;
    ProductListPage productListPage = new ProductListPage(driver);

    @Given("product list page is opened")
    public void goToProductListPage() {
        driver.get(AbstractPage.BASIC_CATALOGUE);

    }

    @When("customer customer enters a product name into the input field and presses ENTER")
    public void customerCustomerEntersAProductNameIntoTheInputFieldAndPressesENTER() {
        productListPage.enterProductName("DSC-H20 Blue");

    }


    @Then("the entered product appears in the product list on the site page")
    public void theEnteredProductAppearsInTheProductListOnTheSitePage() {

        Assert.assertEquals(productListPage.getProductNameFromSearchList(), "DSC-H20 Blue");
    }
}
