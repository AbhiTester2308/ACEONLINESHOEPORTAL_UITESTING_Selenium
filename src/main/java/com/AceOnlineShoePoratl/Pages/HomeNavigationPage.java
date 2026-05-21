package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomeNavigationPage extends BasePage {

    public void openSite(String url) {
        driver().get(url);
    }

    public boolean isLogoVisible() {
        return isDisplayed(StoreLocator.SITE_LOGO) || isDisplayed(StoreLocator.HOME_HEADING);
    }

    public boolean isSearchBoxVisible() {
        try {
            if (!driver().findElements(StoreLocator.SEARCH_BOX).isEmpty()) {
                return true;
            }
            return !driver().findElements(StoreLocator.SEARCH_BOX_FALLBACK).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean navItemsVisible(List<String> items) {
        for (String item : items) {
            if (driver().findElements(StoreLocator.navMenuItem(item)).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCartIconVisible() {
        return !driver().findElements(StoreLocator.CART_ICON).isEmpty();
    }

    public void clickMenuItem(String menuItem) {
        click(StoreLocator.navMenuItem(menuItem));
    }

    public boolean urlContains(String fragment) {
        return driver().getCurrentUrl().toLowerCase().contains(fragment.toLowerCase());
    }

    public String getTitle() {
        return driver().getTitle();
    }

    public boolean footerLinksVisible(List<String> links) {
        for (String link : links) {
            if (driver().findElements(StoreLocator.footerLink(link)).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void clickFooterLink(String link) {
        click(StoreLocator.footerLink(link));
    }

    public boolean headingContains(String text) {
        return !driver().findElements(StoreLocator.byText(text)).isEmpty();
    }

    public void setViewport(int width, int height) {
        driver().manage().window().setSize(new Dimension(width, height));
    }

    public boolean isBurgerMenuVisible() {
        try {
            WebElement menu = explicitWait().until(ExpectedConditions.presenceOfElementLocated(StoreLocator.HAMBURGER_MENU));
            return menu.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openHamburgerIfPresent() {
        if (isBurgerMenuVisible()) {
            click(StoreLocator.HAMBURGER_MENU);
        }
    }
}
