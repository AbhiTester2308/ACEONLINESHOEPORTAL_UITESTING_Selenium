package com.AceOnlineShoePortal.Hooks;

import com.AceOnlineShoePoratl.Utilities.ConfigReader;
import com.AceOnlineShoePoratl.Utilities.DriverManager;
import com.AceOnlineShoePoratl.Utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Browser opens once for the full test run ({@link BeforeAll}) and closes at the end ({@link AfterAll}).
 * Each scenario reuses the same session — no launch/quit per scenario.
 */
public class hook {

    private static final Logger log = LogManager.getLogger(hook.class);

    @BeforeAll
    public static void beforeAllScenarios() {
        DriverManager.startBrowser();
        log.info("Browser launched once for entire test run");
    }

    @AfterAll
    public static void afterAllScenarios() {
        DriverManager.quitBrowser();
        log.info("Browser closed after all scenarios completed");
    }

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String path = ScreenshotUtil.capture(scenario.getName());
            if (path != null) {
                log.error("Screenshot saved: {}", path);
            }
        }

        if (new ConfigReader().resetUrlAfterScenario()) {
            try {
                DriverManager.getDriver().get(new ConfigReader().getUrl());
                log.debug("Reset browser to home URL after scenario: {}", scenario.getName());
            } catch (Exception e) {
                log.warn("Could not reset URL after scenario: {}", e.getMessage());
            }
        }
    }
}
