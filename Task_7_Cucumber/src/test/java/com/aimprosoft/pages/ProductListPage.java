package com.aimprosoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ProductListPage extends AbstractPage {

    private static final By SEARCH_FIELD = By.id("js-site-search-input");
    private static final By PRODUCT_NAME = By.xpath("(//em[@class = 'search-results-highlight'])[2]");

    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static By getButtonXpath(String nameButton) {
        return By.xpath("//a[@title='" + nameButton + "']");
    }

    public static By gerTitleXpath(String title) {
        return By.xpath("//li[contains(@class, 'active') and text() = '" + title + "']");
    }

    public void clickOnProductHeadersButton(String productName) {
        driver.findElement(getButtonXpath(productName)).click();
    }

    public void enterProductName() {

        driver.findElement(SEARCH_FIELD).sendKeys("DSC-H20 Blue" + Keys.ENTER);
    }


    public String getProductNameFromSearchList() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getProductTextFromTitleOfProductListPage(String productName) {
        return driver.findElement(gerTitleXpath(productName)).getText();
    }


    public void goToProductListPage() {
        driver.get(MainPage.BASIC_URL + "Open-Catalogue/c/1");
    }
}