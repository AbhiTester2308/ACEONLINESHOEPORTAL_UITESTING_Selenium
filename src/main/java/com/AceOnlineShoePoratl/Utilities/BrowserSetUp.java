package com.AceOnlineShoePoratl.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class BrowserSetUp extends CommonUtilis {

    private static final Logger log = LogManager.getLogger(BrowserSetUp.class);

    public static void application_Launch() {
        ConfigReader config = new ConfigReader();
        String browser = config.getBrowser();
        String remoteUrl = config.getSeleniumRemoteUrl();

        // Show in Jenkins console whether we are using Grid or local browser.
        System.out.println("[BrowserSetUp] browser=" + browser + ", selenium.remote.url=" + remoteUrl);

        switch(browser.toLowerCase()){
             case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = createDriver(remoteUrl, edgeOptions, () -> {
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver(edgeOptions);
                });
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = createDriver(remoteUrl, chromeOptions, () -> {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(chromeOptions);
                });
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = createDriver(remoteUrl, firefoxOptions, () -> {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(firefoxOptions);
                });
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(config.getUrl());
        log.info("Browser setup started");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));



    }
    public static  void application_Quit(){

        //driver.quit();
    }

    private static org.openqa.selenium.WebDriver createDriver(
            String remoteUrl,
            MutableCapabilities capabilities,
            DriverFactory localFactory
    ) {
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            try {
                log.info("Starting RemoteWebDriver at {}", remoteUrl);
                System.out.println("[BrowserSetUp] Starting RemoteWebDriver at " + remoteUrl);
                return new RemoteWebDriver(new URL(remoteUrl), capabilities);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create RemoteWebDriver for url: " + remoteUrl, e);
            }
        }

        log.info("Starting local WebDriver");
        System.out.println("[BrowserSetUp] Starting local WebDriver");
        return localFactory.create();
    }

    @FunctionalInterface
    private interface DriverFactory {
        org.openqa.selenium.WebDriver create();
    }
}
