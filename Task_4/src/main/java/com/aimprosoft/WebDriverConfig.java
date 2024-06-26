package com.aimprosoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverConfig {
    public static ChromeOptions configChrome(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME.browserName());
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return options;
    }

}
