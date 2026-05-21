package com.AceOnlineShoePoratl.Pages;

import com.AceOnlineShoePoratl.ElementsLocator.StoreLocator;

import java.util.Map;

public class CartCheckoutPage extends BasePage {

    private final ProductReviewDetailPage productPage = new ProductReviewDetailPage();

    public void navigateToCatalog(String category) {
        productPage.navigateToCatalog(category);
    }

    public void openFirstProduct() {
        productPage.openFirstProduct();
    }

    public void selectFirstAvailableSize() {
        if (!productPage.getSizeElements().isEmpty()) {
            productPage.getSizeElements().get(0).click();
        }
    }

    public void clickAddToCart() {
        productPage.clickLabeledButton("Add to Cart");
    }

    public int getCartCount() {
        String text = driver().findElement(StoreLocator.CART_ICON).getText().replaceAll("\\D", "");
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }

    public boolean isAddToCartConfirmationVisible() {
        return isDisplayed(StoreLocator.byText("added")) || isDisplayed(StoreLocator.byText("cart"));
    }

    public void openCartPage() {
        click(StoreLocator.CART_ICON);
    }

    public void increaseQuantity(String qty) {
        type(StoreLocator.QUANTITY_INPUT, qty);
    }

    public boolean isCartEmptyMessageVisible() {
        return isDisplayed(StoreLocator.byText("Your cart is empty"));
    }

    public void proceedToCheckout() {
        click(StoreLocator.byText("Checkout"));
    }

    public void fillShippingDetails(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            type(StoreLocator.shippingField(entry.getKey()), entry.getValue());
        }
    }

    public void selectPaymentMethod(String method) {
        click(StoreLocator.byText(method));
    }

    public void enterCardDetails(Map<String, String> data) {
        type(StoreLocator.CARD_NUMBER, data.get("Number"));
        type(StoreLocator.CARD_EXPIRY, data.get("Expiry"));
        type(StoreLocator.CARD_CVV, data.get("CVV"));
    }

    public void placeOrder() {
        click(StoreLocator.byText("Place order"));
    }

    public boolean isOrderConfirmationVisible() {
        return isDisplayed(StoreLocator.byText("order")) && isDisplayed(StoreLocator.byText("confirmation"));
    }

    public void applyPromoCode(String code) {
        type(StoreLocator.PROMO_CODE_INPUT, code);
        click(StoreLocator.byText("Apply"));
    }
}
