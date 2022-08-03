package com.aimprosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ReusableWebDriver implements WebDriver, JavascriptExecutor {

    private final Supplier<WebDriver> webDriverSupplier;

    private WebDriver instance;

    public ReusableWebDriver(Supplier<WebDriver> webDriverSupplier) {
        this.webDriverSupplier = webDriverSupplier;
    }

    private WebDriver getInstance() {
        if (instance == null) {
            instance = webDriverSupplier.get();
        }
        return instance;
    }

    @Override
    public void get(String url) {
        getInstance().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getInstance().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getInstance().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getInstance().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getInstance().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getInstance().getPageSource();
    }

    @Override
    public void close() {
        getInstance().close();
    }

    @Override
    public void quit() {
        getInstance().quit();
        instance = null;
    }

    @Override
    public Set<String> getWindowHandles() {
        return getInstance().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getInstance().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return getInstance().switchTo();
    }

    @Override
    public Navigation navigate() {
        return getInstance().navigate();
    }

    @Override
    public Options manage() {
        return getInstance().manage();
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) instance).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) instance).executeAsyncScript(script, args);
    }
}
