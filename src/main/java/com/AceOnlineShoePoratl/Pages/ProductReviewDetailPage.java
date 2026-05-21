package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductReviewDetailPage extends BasePage {

    public void navigateToCatalog(String category) {
        click(StoreLocator.navMenuItem(category));
    }

    public void openFirstProduct() {
        click(StoreLocator.FIRST_PRODUCT);
    }

    public void openProductByName(String name) {
        click(StoreLocator.productByName(name));
    }

    public boolean isProductTitleDisplayed() {
        return isDisplayed(StoreLocator.PRODUCT_TITLE);
    }

    public boolean isMainImageDisplayed() {
        return isDisplayed(StoreLocator.MAIN_IMAGE);
    }

    public int getThumbnailCount() {
        return driver().findElements(StoreLocator.THUMBNAILS).size();
    }

    public String getPriceText() {
        return getText(StoreLocator.PRODUCT_PRICE_TEXT);
    }

    public List<WebElement> getSizeElements() {
        return driver().findElements(StoreLocator.SIZE_OPTIONS);
    }

    public boolean isAddToCartEnabled() {
        return explicitWait().until(ExpectedConditions.presenceOfElementLocated(StoreLocator.byText("Add to Cart"))).isEnabled();
    }

    public void selectSize(String size) {
        click(StoreLocator.sizeOption(size));
    }

    public void selectColor(String color) {
        new Select(explicitWait().until(ExpectedConditions.presenceOfElementLocated(StoreLocator.COLOR_DROPDOWN)))
                .selectByVisibleText(color);
    }

    public void scrollToReviews() {
        scrollIntoView(StoreLocator.byText("Reviews"));
    }

    public boolean isRatingAndCountVisible() {
        return isDisplayed(StoreLocator.OVERALL_RATING) && isDisplayed(StoreLocator.REVIEW_COUNT);
    }

    public void sortReviewsBy(String criteria) {
        new Select(driver().findElement(StoreLocator.SORT_DROPDOWN)).selectByVisibleText(criteria);
    }

    public List<WebElement> getReviewDateElements() {
        return driver().findElements(StoreLocator.REVIEW_DATES);
    }

    public void clickWriteReview() {
        click(StoreLocator.byText("Write a review"));
    }

    public boolean isLoginModalDisplayed() {
        return isDisplayed(StoreLocator.LOGIN_MODAL);
    }

    public void clickLabeledButton(String label) {
        click(StoreLocator.byText(label));
    }
}
