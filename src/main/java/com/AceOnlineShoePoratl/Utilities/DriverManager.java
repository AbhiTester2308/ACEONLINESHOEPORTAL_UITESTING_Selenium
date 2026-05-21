package com.AceOnlineShoePoratl.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public final class DriverManager {

    private static final Logger log = LogManager.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> WAIT = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized. Ensure @BeforeAll hook ran.");
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = WAIT.get();
        if (wait == null) {
            throw new IllegalStateException("WebDriverWait not initialized. Ensure @BeforeAll hook ran.");
        }
        return wait;
    }

    public static void startBrowser() {
        if (DRIVER.get() != null) {
            CommonUtilis.syncFromDriverManager();
            log.info("Browser already running — reusing existing session");
            return;
        }

        ConfigReader config = new ConfigReader();
        String browser = config.getBrowser();
        String remoteUrl = config.getSeleniumRemoteUrl();
        int timeoutSeconds = config.getExplicitWaitSeconds();

        log.info("Starting browser={} remoteUrl={}", browser, remoteUrl);
        System.out.println("[DriverManager] browser=" + browser + ", selenium.remote.url=" + remoteUrl);

        WebDriver driver = switch (browser.toLowerCase()) {
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--remote-allow-origins=*");
                yield createDriver(remoteUrl, options, () -> {
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver(options);
                });
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                yield createDriver(remoteUrl, options, () -> {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver(options);
                });
            }
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                yield createDriver(remoteUrl, options, () -> {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(options);
                });
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutSeconds));
        driver.get(config.getUrl());

        DRIVER.set(driver);
        WAIT.set(new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)));

        CommonUtilis.syncFromDriverManager();
        log.info("Browser started for thread {}", Thread.currentThread().getName());
    }

    public static void quitBrowser() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                log.warn("Error quitting browser: {}", e.getMessage());
            } finally {
                DRIVER.remove();
                WAIT.remove();
                CommonUtilis.clear();
            }
        }
    }

    private static WebDriver createDriver(
            String remoteUrl,
            MutableCapabilities capabilities,
            DriverFactory localFactory
    ) {
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            try {
                log.info("Starting RemoteWebDriver at {}", remoteUrl);
                return new RemoteWebDriver(new URL(remoteUrl), capabilities);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create RemoteWebDriver for url: " + remoteUrl, e);
            }
        }
        log.info("Starting local WebDriver");
        return localFactory.create();
    }

    @FunctionalInterface
    private interface DriverFactory {
        WebDriver create();
    }
}
