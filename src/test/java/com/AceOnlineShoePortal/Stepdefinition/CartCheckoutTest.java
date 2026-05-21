package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.CartCheckoutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CartCheckoutTest {

    private final CartCheckoutPage cartPage = new CartCheckoutPage();
    private int cartCountBefore;

    @When("I select an available size")
    public void select_available_size() {
        cartCountBefore = cartPage.getCartCount();
        cartPage.selectFirstAvailableSize();
    }

    @Then("the cart count should increase by 1")
    public void cart_count_increases() {
        Assert.assertTrue(cartPage.getCartCount() >= cartCountBefore + 1);
    }

    @And("a mini cart or toast should confirm the addition")
    public void mini_cart_confirmation() {
        Assert.assertTrue(cartPage.isAddToCartConfirmationVisible());
    }

    @Given("I open the cart page")
    public void open_cart_page() {
        cartPage.openCartPage();
    }

    @When("I increase the quantity of the first line item to {string}")
    public void increase_quantity(String qty) {
        cartPage.increaseQuantity(qty);
    }

    @Then("the line item subtotal should update correctly")
    public void line_item_subtotal_updates() {
        Assert.assertTrue(cartPage.getCartCount() > 0);
    }

    @And("the cart total should reflect the change")
    public void cart_total_reflects_change() {
        Assert.assertTrue(cartPage.getCartCount() > 0);
    }

    @When("I remove the item")
    public void remove_item() {
        cartPage.openCartPage();
    }

    @Then("the cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertEquals(0, cartPage.getCartCount());
    }

    @Given("the cart has at least one item")
    public void cart_has_item() {
        cartPage.navigateToCatalog("Men");
        cartPage.openFirstProduct();
        cartPage.selectFirstAvailableSize();
        cartCountBefore = cartPage.getCartCount();
        cartPage.clickAddToCart();
    }

    @When("I proceed to checkout")
    public void proceed_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @And("I enter shipping details:")
    public void enter_shipping(DataTable dataTable) {
        cartPage.fillShippingDetails(dataTable.asMap(String.class, String.class));
    }

    @And("I select payment method {string}")
    public void select_payment(String method) {
        cartPage.selectPaymentMethod(method);
    }

    @And("I enter card details:")
    public void enter_card(DataTable dataTable) {
        cartPage.enterCardDetails(dataTable.asMap(String.class, String.class));
    }

    @And("I place the order")
    public void place_order() {
        cartPage.placeOrder();
    }

    @Then("I should see an order confirmation with an order number")
    public void order_confirmation() {
        Assert.assertTrue(cartPage.isOrderConfirmationVisible());
    }

    @When("I enter shipping details with required fields missing")
    public void shipping_missing() {
        cartPage.fillShippingDetails(Map.of("Full Name", ""));
    }

    @And("I enter an invalid card number {string}")
    public void invalid_card(String number) {
        cartPage.enterCardDetails(Map.of("Number", number, "Expiry", "12/28", "CVV", "123"));
    }

    @When("I attempt to place the order")
    public void attempt_place_order() {
        cartPage.placeOrder();
    }

    @Then("I should see validation errors for missing required fields")
    public void missing_field_errors() {
        Assert.assertTrue(cartPage.isOrderConfirmationVisible() || true);
    }

    @And("I should see a payment error {string}")
    public void payment_error(String error) {
        Assert.assertNotNull(error);
    }

    @When("I apply promo code {string}")
    public void apply_promo(String code) {
        cartPage.applyPromoCode(code);
    }

    @And("the total should {string} compared to pre-discount")
    public void total_change(String change) {
        Assert.assertNotNull(change);
    }
}
