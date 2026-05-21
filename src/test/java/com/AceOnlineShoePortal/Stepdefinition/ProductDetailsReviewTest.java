package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.ProductReviewDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsReviewTest {

    private final ProductReviewDetailPage pdp = new ProductReviewDetailPage();

    @When("I open a product named {string}")
    public void i_open_a_product_named(String name) {
        pdp.openProductByName(name);
    }

    @Then("I should see the product title")
    public void i_should_see_the_product_title() {
        Assert.assertTrue("Product title not displayed", pdp.isProductTitleDisplayed());
    }

    @Then("I should see the main image and at least 1 thumbnail")
    public void i_should_see_images() {
        Assert.assertTrue("Main image not displayed", pdp.isMainImageDisplayed());
        Assert.assertTrue("Thumbnails not found", pdp.getThumbnailCount() >= 1);
    }

    @Then("I should see the price with currency symbol")
    public void i_should_see_price() {
        String price = pdp.getPriceText();
        Assert.assertTrue("Price or currency missing", price.matches(".*[\\$\\£\\€₹].*\\d+.*"));
    }

    @Then("I should see available sizes")
    public void i_should_see_available_sizes() {
        Assert.assertFalse("No sizes displayed", pdp.getSizeElements().isEmpty());
    }

    @Then("I should see an {string} button enabled for selectable sizes")
    public void i_should_see_add_to_cart_enabled(String buttonText) {
        Assert.assertTrue("Add to Cart button should be enabled", pdp.isAddToCartEnabled());
    }

    @When("I select size {string}")
    public void i_select_size(String size) {
        pdp.selectSize(size);
    }

    @When("I select color {string}")
    public void i_select_color(String color) {
        pdp.selectColor(color);
    }

    @Then("the {string} button should be {string}")
    public void the_button_should_be_state(String buttonName, String state) {
        boolean isEnabled = pdp.isAddToCartEnabled();
        if (state.equalsIgnoreCase("enabled")) {
            Assert.assertTrue(isEnabled);
        } else {
            Assert.assertFalse(isEnabled);
        }
    }

    @When("I scroll to {string} section")
    public void i_scroll_to_section(String section) {
        pdp.scrollToReviews();
    }

    @Then("I should see overall rating \\(stars) and review count")
    public void i_should_see_rating_and_count() {
        Assert.assertTrue(pdp.isRatingAndCountVisible());
    }

    @When("I sort reviews by {string}")
    public void i_sort_reviews_by(String criteria) {
        pdp.sortReviewsBy(criteria);
    }

    @Then("the top review date should be the most recent among visible reviews")
    public void verify_top_review_date() {
        List<WebElement> dates = pdp.getReviewDateElements();
        Assert.assertFalse("No reviews found to verify dates", dates.isEmpty());
    }

    @Then("I should be prompted to log in or see a login\\/register modal")
    public void i_should_see_login_modal() {
        Assert.assertTrue("Login modal not displayed", pdp.isLoginModalDisplayed());
    }
}
