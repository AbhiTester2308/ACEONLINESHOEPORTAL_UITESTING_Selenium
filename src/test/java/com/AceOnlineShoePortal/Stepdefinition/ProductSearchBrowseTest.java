package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.ProductsSearchBrowserPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductSearchBrowseTest {

    private final ProductsSearchBrowserPage psb = new ProductsSearchBrowserPage();
    private List<String> firstPageProducts;

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        psb.search(keyword);
    }

    @Then("I should see a results header containing {string}")
    public void i_should_see_a_results_header_containing(String keyword) {
        Assert.assertTrue(psb.getResultsHeaderText().toLowerCase().contains(keyword.toLowerCase()));
    }

    @Then("each listed product name or description should contain {string} at least once")
    public void each_listed_product_name_or_description_should_contain(String keyword) {
        List<String> texts = psb.getProductTitlesAndDescriptions();
        boolean allMatch = texts.stream().allMatch(t -> t.toLowerCase().contains(keyword.toLowerCase()));
        Assert.assertTrue("Some products do not match keyword", allMatch);
    }

    @When("I apply filters:")
    public void i_apply_filters(DataTable dataTable) {
        Map<String, String> filters = dataTable.asMap(String.class, String.class);
        psb.applyFilters(
                filters.get("Category"),
                filters.get("PriceMin"),
                filters.get("PriceMax"),
                filters.get("Size"),
                filters.get("Color")
        );
    }

    @Then("the results should only include products in {string}")
    public void the_results_should_only_include_products_in(String category) {
        Assert.assertTrue(psb.getResultsHeaderText().toLowerCase().contains(category.toLowerCase()));
    }

    @Then("every product price should be between {int} and {int} inclusive")
    public void every_product_price_should_be_between_inclusive(Integer min, Integer max) {
        List<Double> prices = psb.getAllPrices();
        prices.forEach(p -> Assert.assertTrue(p >= min && p <= max));
    }

    @Then("every product size should include {string}")
    public void every_product_size_should_include(String size) {
        Assert.assertTrue(psb.getProductTitlesAndDescriptions().stream()
                .anyMatch(t -> t.contains(size)));
    }

    @Then("at least one color chip should be {string}")
    public void at_least_one_color_chip_should_be(String color) {
        Assert.assertTrue(psb.getProductTitlesAndDescriptions().stream()
                .anyMatch(t -> t.toLowerCase().contains(color.toLowerCase())));
    }

    @When("I sort the results by {string}")
    public void i_sort_the_results_by(String sortOption) {
        psb.sortResults(sortOption);
    }

    @Then("the product list should be ordered {string} by {string}")
    public void the_product_list_should_be_ordered_by(String order, String metric) {
        if (metric.equalsIgnoreCase("price")) {
            List<Double> actual = psb.getAllPrices();
            List<Double> sorted = actual.stream().sorted().collect(Collectors.toList());
            if (order.equalsIgnoreCase("desc")) {
                Collections.reverse(sorted);
            }
            Assert.assertEquals(sorted, actual);
        }
    }

    @Given("the results show page {string}")
    public void the_results_show_page(String pageNum) {
        Assert.assertTrue(psb.getCurrentPageText().contains(pageNum));
        firstPageProducts = psb.getProductIdentifiers();
    }

    @Then("I should see page {string}")
    public void i_should_see_page(String pageNum) {
        Assert.assertTrue(psb.getCurrentPageText().contains(pageNum));
    }

    @Then("the product cards should update \\(no duplicates from page 1)")
    public void the_product_cards_should_update_no_duplicates_from_page_1() {
        List<String> secondPageProducts = psb.getProductIdentifiers();
        boolean hasOverlap = secondPageProducts.stream().anyMatch(firstPageProducts::contains);
        Assert.assertFalse("Found duplicates on page 2", hasOverlap);
    }
}
