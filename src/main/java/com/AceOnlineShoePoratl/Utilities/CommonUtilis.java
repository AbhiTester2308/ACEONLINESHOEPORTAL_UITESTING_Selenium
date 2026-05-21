package com.AceOnlineShoePoratl.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Backward-compatible access to driver/wait. Prefer {@link DriverManager} in new code.
 */
public class CommonUtilis {

    public static WebDriver driver;
    public static WebDriverWait wait;

    private CommonUtilis() {
    }

    static void syncFromDriverManager() {
        driver = DriverManager.getDriver();
        wait = DriverManager.getWait();
    }

    static void clear() {
        driver = null;
        wait = null;
    }
}
