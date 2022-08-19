package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends AbstractPage {

    private static final By THREE_DOTS_BUTTON = By.xpath("//span[@class='glyphicon glyphicon-option-vertical']");
    private static final By REMOVE_BUTTON = By.xpath("//a[@class='__web-inspector-hide-shortcut__']");
    private static final By SHOPPING_CART_IS_EMPTY_MASSAGE = By.xpath("//div[@class='content']/h2");

    public Cart(WebDriver driver) {
        super(driver);
    }
    public void clickOnThreeDotsButton(){
        driver.findElement(THREE_DOTS_BUTTON).click();
    }
    public void clickOnRemoveButton(){
        driver.findElement(REMOVE_BUTTON).click();
    }
}
