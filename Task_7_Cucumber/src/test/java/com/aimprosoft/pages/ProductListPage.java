package com.aimprosoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ProductListPage extends AbstractPage {

    private static final By SEARCH_FIELD = By.id("js-site-search-input");

    private static final By FILM_CAMERAS_BUTTON = By.xpath("//a[@title='Film Cameras']");
    private static final By FILM_CAMERAS_TITLE = By.xpath("//li[contains(@class, 'active') and text() = 'Film cameras']");
    private static final By WEB_CAMERAS_BUTTON = By.xpath("//a[@title='Webcams']");
    private static final By WEB_CAMERAS_TITLE = By.xpath("//li[contains(@class, 'active') and text() = 'Webcams']");
    private static final By OPEN_CATALOGUE_CAPTION = By.xpath("//li[@class='active' and contains(text(),'Open Catalogue')] ");
    private static final By POP_UP_WINDOW_WITH_PRODUCT_ADDED_TO_CART = By.id("cboxLoadedContent");
    private static final By PRODUCT_NAME = By.xpath("//em[contains(@class, 'search-results-highlight') and text() = 'Blue']");
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//a[@class='btn btn-default btn-block js-mini-cart-close-button']");
    private static final By CHECK_OUT_BUTTON = By.xpath("//a[@class='btn btn-primary btn-block add-to-cart-button']");
    private static final By PRODUCT_PHOTO = By.xpath("//img[@alt='Camileo H20 EU']");
    private static final By PRISE_CHECK_BOX = By.xpath("(//span[@class='facet__list__mark'])[1]");

    //private static final By SHOP_BY_BRAND_BUTTON = By.xpath("//span[@class='facet__text'])[10]");


    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);


    }

    public void clickOnFilmCamerasHeadersButton() {
        driver.findElement(FILM_CAMERAS_BUTTON).click();
    }

    public void clickOnWebCamerasHeaderButton() {
        driver.findElement(WEB_CAMERAS_BUTTON).click();
    }

    public void enterProductName(String productName) {

        driver.findElement(SEARCH_FIELD).sendKeys(productName + Keys.ENTER);
    }

    public void enterContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void enterCheckOutButton() {
        driver.findElement(CHECK_OUT_BUTTON).click();
    }

    public void clickOnProductPhoto() {
        driver.findElement(PRODUCT_PHOTO).click();
    }

    public void clickOnPriceCheckBox() {
        driver.findElement(PRISE_CHECK_BOX).click();
    }

/*    public void clickOnAddToShoppingCartButton() {
        driver.findElement(ADD_TO_SHOPPING_CART_BUTTON).click();
    }

    public void clickOnShopByBrandButton() {
        driver.findElement(SHOP_BY_BRAND_BUTTON).click();
    }*/

    public String getOpenCatalogueText() {
        return driver.findElement(OPEN_CATALOGUE_CAPTION).getText();

    }

    public String getProductNameFromSearchList() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getFilmCamerasTextFromTitleOfProductListPage() {
        return driver.findElement(FILM_CAMERAS_TITLE).getText();
    }

    public String getWebCamerasTextFromTitleOfProductListPage() {
        return driver.findElement(WEB_CAMERAS_TITLE).getText();
    }
}