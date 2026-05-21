package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticationFeaturePage extends BasePage {

    private static final Logger log = LogManager.getLogger(AuthenticationFeaturePage.class);

    public void navigateTo(String page) {
        click(StoreLocator.HAMBURGER_MENU);
        if (page.equalsIgnoreCase("Register")) {
            click(StoreLocator.SIGN_IN_LINK);
            click(StoreLocator.REGISTER_LINK);
        } else {
            click(StoreLocator.SIGN_IN_LINK);
        }
        log.info("Navigated to {} page", page);
    }

    public void fillRegistration(String fn, String ln, String email, String pass, String confirm) {
        type(StoreLocator.FIRST_NAME, fn);
        type(StoreLocator.LAST_NAME, ln);
        type(StoreLocator.EMAIL, email);
        type(StoreLocator.USERNAME, email);
        type(StoreLocator.PASSWORD, pass);
        if (confirm != null && !confirm.isBlank()) {
            try {
                type(StoreLocator.CONFIRM_PASSWORD, confirm);
            } catch (Exception e) {
                log.debug("Confirm password field not found, skipping");
            }
        }
    }

    public void submitRegistration() {
        click(StoreLocator.REGISTER_SUBMIT);
    }

    public String getRegistrationSuccessText() {
        return getText(StoreLocator.byText("Account created"));
    }

    public String getValidationErrorText() {
        return explicitWait().until(ExpectedConditions.visibilityOfElementLocated(StoreLocator.AUTH_ERROR)).getText();
    }

    public void login(String email, String password) {
        type(StoreLocator.LOGIN_EMAIL, email);
        type(StoreLocator.LOGIN_PASSWORD, password);
        click(StoreLocator.LOGIN_SUBMIT);
    }

    public String getWelcomeMessage() {
        return getText(StoreLocator.WELCOME_MESSAGE);
    }

    public boolean isLogoutDisplayed() {
        try {
            return driver().findElement(StoreLocator.LOGOUT_BUTTON).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getLoginError() {
        return getText(StoreLocator.AUTH_ERROR);
    }

    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }
}
