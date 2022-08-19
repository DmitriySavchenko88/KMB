package definitions;

import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.ProductListPage;

public class Hooks {
    WebDriver driver;
   ProductListPage productListPage;

    @Before
    public void homePage() throws Exception {

        WebDriver driver = DriverManager.getWebDriver("chrome");
        productListPage = new ProductListPage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver(){
        driver.close();
    }
}
