package com.AceOnlineShoePoratl.ElementsLocator;

import org.openqa.selenium.By;

/**
 * Single repository for all UI locators (XPath only).
 * Page classes must not define By.xpath — add or update locators here only.
 */
public final class StoreLocator {

    private StoreLocator() {
    }

    // ==================== HOME ====================
    public static final By HOME_HEADING = By.xpath("/html/body/div/h1/font");
    public static final By SITE_LOGO = By.xpath("//*[@id='ShoePortalImage']");

    // ==================== GLOBAL NAVIGATION ====================
    public static final By HAMBURGER_MENU = By.xpath("/html/body/div/nav/div");
    public static final By SEARCH_BOX = By.xpath("//input[@type='search' or contains(@placeholder,'Search') or contains(@id,'search')]");
    public static final By SEARCH_BOX_FALLBACK = By.xpath("//input[contains(@type,'text') or @type='search']");
    public static final By CART_ICON = By.xpath("//a[contains(@href,'cart') or contains(.,'Cart')]");
    public static final By SEARCH_BUTTON = By.xpath("//button[contains(.,'Search') or @type='submit']");
    public static final By MEN_CATALOG_LINK = By.xpath("//nav//a[contains(normalize-space(),'Men')]");

    // ==================== AUTH ====================
    public static final By SIGN_IN_LINK = By.xpath("/html/body/div/nav/div/ul/a[2]/li");
    public static final By REGISTER_LINK = By.xpath("/html/body/center[1]/div/form/button | //button[contains(.,'Register') or contains(.,'Sign up')]");
    public static final By FIRST_NAME = By.xpath("/html/body/center/div/form/div/input[1]");
    public static final By LAST_NAME = By.xpath("/html/body/center/div/form/div/input[2]");
    public static final By EMAIL = By.xpath("/html/body/center/div/form/div/input[3]");
    public static final By USERNAME = By.xpath("/html/body/center/div/form/div/input[5]");
    public static final By PASSWORD = By.xpath("/html/body/center/div/form/div/input[6]");
    public static final By CONFIRM_PASSWORD = By.xpath("/html/body/center/div/form/div/input[7]");
    public static final By REGISTER_SUBMIT = By.xpath("/html/body/center/div/form/div/div[2]/center/input | //input[@type='submit']");
    public static final By LOGIN_EMAIL = By.xpath("//input[@type='email' or contains(@name,'email') or contains(@placeholder,'mail')]");
    public static final By LOGIN_PASSWORD = By.xpath("//input[@type='password']");
    public static final By LOGIN_SUBMIT = By.xpath("//input[@type='submit' or @type='button'][contains(@value,'Login') or contains(@value,'Sign')] | //button[contains(.,'Login')]");
    public static final By LOGOUT_BUTTON = By.xpath("//*[contains(.,'Logout') or contains(.,'Log out')]");
    public static final By WELCOME_MESSAGE = By.xpath("//*[contains(@class,'welcome') or contains(.,'Welcome')]");
    public static final By AUTH_ERROR = By.xpath("//*[contains(@class,'error') or contains(@class,'alert')]");

    // ==================== CATALOG / SEARCH / FILTER ====================
    public static final By RESULTS_HEADER = By.xpath("//*[contains(@class,'results') or contains(@class,'heading') or self::h1 or self::h2]");
    public static final By PRODUCT_CARD = By.xpath("//*[contains(@class,'product') or contains(@class,'card')]");
    public static final By PRICE_MIN_INPUT = By.xpath("//input[contains(@placeholder,'Min') or contains(@name,'min')]");
    public static final By PRICE_MAX_INPUT = By.xpath("//input[contains(@placeholder,'Max') or contains(@name,'max')]");
    public static final By PRODUCT_PRICE_TEXT = By.xpath("//*[contains(text(),'$') or contains(text(),'₹') or contains(text(),'€')]");
    public static final By SORT_DROPDOWN = By.xpath("//select");

    // ==================== PRODUCT DETAIL (PDP) ====================
    public static final By FIRST_PRODUCT = By.xpath("(//a[contains(@href,'product') or contains(@class,'product')])[1]");
    public static final By PRODUCT_TITLE = By.xpath("//h1 | //h2[contains(@class,'title')]");
    public static final By MAIN_IMAGE = By.xpath("//img[contains(@class,'main') or contains(@id,'main')] | (//img)[1]");
    public static final By THUMBNAILS = By.xpath("//img[contains(@class,'thumb')]");
    public static final By SIZE_OPTIONS = By.xpath("//button[contains(@class,'size')] | //select[contains(@name,'size')]//option");
    public static final By COLOR_DROPDOWN = By.xpath("//select");
    public static final By OVERALL_RATING = By.xpath("//*[contains(@class,'rating') or contains(.,'★')]");
    public static final By REVIEW_COUNT = By.xpath("//*[contains(.,'review')]");
    public static final By REVIEW_DATES = By.xpath("//*[contains(@class,'review-date') or self::time]");
    public static final By LOGIN_MODAL = By.xpath("//*[contains(@class,'modal') and (contains(.,'Login') or contains(.,'Register'))]");

    // ==================== CONTACT / NEWSLETTER ====================
    public static final By CONTACT_NAME = By.xpath("//input[contains(@name,'name') or contains(@placeholder,'Name')]");
    public static final By CONTACT_EMAIL = By.xpath("//input[@type='email' or contains(@name,'email')]");
    public static final By CONTACT_SUBJECT = By.xpath("//input[contains(@name,'subject') or contains(@placeholder,'Subject')]");
    public static final By CONTACT_MESSAGE = By.xpath("//textarea");
    public static final By CONTACT_SUBMIT = By.xpath("//input[@type='submit'] | //button[@type='submit']");
    public static final By NEWSLETTER_EMAIL = By.xpath("//footer//input[@type='email'] | //input[contains(@placeholder,'newsletter') or contains(@id,'newsletter')]");

    // ==================== CART / CHECKOUT ====================
    public static final By QUANTITY_INPUT = By.xpath("//input[@type='number' or contains(@name,'quantity')]");
    public static final By CARD_NUMBER = By.xpath("//input[contains(@name,'card') or contains(@placeholder,'Card')]");
    public static final By CARD_EXPIRY = By.xpath("//input[contains(@name,'exp') or contains(@placeholder,'Expiry')]");
    public static final By CARD_CVV = By.xpath("//input[contains(@name,'cvv') or contains(@placeholder,'CVV')]");
    public static final By PROMO_CODE_INPUT = By.xpath("//input[contains(@placeholder,'promo') or contains(@name,'promo')]");

    // ==================== DYNAMIC XPATH HELPERS ====================

    /** Nav menu link by visible label (Home, Men, Women, Contact, etc.). */
    public static By navMenuItem(String item) {
        return By.xpath(String.format("//nav//a[contains(normalize-space(),'%s')]", item));
    }

    /** Footer link by visible label. */
    public static By footerLink(String link) {
        return By.xpath(String.format("//footer//a[contains(normalize-space(),'%s')]", link));
    }

    /** Any element containing visible text. */
    public static By byText(String text) {
        return By.xpath(String.format("//*[contains(normalize-space(),'%s')]", text));
    }

    /** Filter chip / label by text (category, color, size). */
    public static By filterByText(String value) {
        return byText(value);
    }

    /** Product link or card by product name. */
    public static By productByName(String name) {
        return byText(name);
    }

    /** Size button or option by value. */
    public static By sizeOption(String size) {
        return By.xpath(String.format("//button[normalize-space()='%s'] | //option[normalize-space()='%s']", size, size));
    }

    /** Shipping / checkout input by field label (Full Name, Address, City, etc.). */
    public static By shippingField(String fieldLabel) {
        return By.xpath(String.format(
                "//input[contains(@placeholder,'%s') or contains(@name,'%s')]",
                fieldLabel, fieldLabel
        ));
    }
}
