package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends BasePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    public boolean isHomePageDisplayed() {
        boolean displayed = isDisplayed(StoreLocator.HOME_HEADING);
        if (displayed) {
            log.info("Application home page displayed");
        } else {
            log.warn("Application home page heading not displayed");
        }
        return displayed;
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(StoreLocator.SITE_LOGO);
    }
}
