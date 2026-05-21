package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;
import com.AceOnlineShoePoratl.Utilities.ConfigReader;

import java.util.Map;

public class ContactNewsLetterPage extends BasePage {

    public void navigateToPage(String page) {
        click(StoreLocator.navMenuItem(page));
    }

    public void goToHome() {
        driver().get(new ConfigReader().getUrl());
    }

    public boolean messageVisible(String expected) {
        return pageShowsText(expected);
    }

    public void fillContactForm(Map<String, String> data) {
        type(StoreLocator.CONTACT_NAME, data.getOrDefault("Name", ""));
        type(StoreLocator.CONTACT_EMAIL, data.getOrDefault("Email", ""));
        type(StoreLocator.CONTACT_SUBJECT, data.getOrDefault("Subject", ""));
        type(StoreLocator.CONTACT_MESSAGE, data.getOrDefault("Message", ""));
    }

    public void submitContactForm() {
        click(StoreLocator.CONTACT_SUBMIT);
    }

    public String getSuccessMessage() {
        return getText(StoreLocator.byText("Thank you"));
    }

    public String getValidationError() {
        return getText(StoreLocator.AUTH_ERROR);
    }

    public void enterNewsletterEmail(String email) {
        type(StoreLocator.NEWSLETTER_EMAIL, email);
    }

    public void clickSubscribe() {
        click(StoreLocator.byText("Subscribe"));
    }

    public boolean pageShowsText(String expected) {
        return isDisplayed(StoreLocator.byText(expected));
    }
}
