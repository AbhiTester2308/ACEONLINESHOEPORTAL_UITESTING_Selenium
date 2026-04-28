package com.AceOnlineShoePortal.Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductSearchBrowseTest {
    private static final Logger log = LogManager.getLogger( ProductSearchBrowseTest.class);

    @Given("I open the site {string}")
    public void i_open_the_site(String string) {

    }

    @Given("I am on the {string} catalog page")
    public void i_am_on_the_catalog_page(String string) {

    }

    @When("I search for {string}")
    public void i_search_for(String string) {

    }

    @Then("I should see a results header containing {string}")
    public void i_should_see_a_results_header_containing(String string) {

    }

    @Then("each listed product name or description should contain {string} at least once")
    public void each_listed_product_name_or_description_should_contain_at_least_once(String string) {

    }

    @When("I apply filters:")
    public void i_apply_filters(io.cucumber.datatable.DataTable dataTable) {// Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @Then("the results should only include products in {string}")
    public void the_results_should_only_include_products_in(String string) {

    }

    @Then("every product price should be between {int} and {int} inclusive")
    public void every_product_price_should_be_between_and_inclusive(Integer int1, Integer int2) {

    }

    @Then("every product size should include {string}")
    public void every_product_size_should_include(String string) {

    }

    @Then("at least one color chip should be {string}")
    public void at_least_one_color_chip_should_be(String string) {

    }

    @When("I sort the results by {string}")
    public void i_sort_the_results_by(String string) {

    }

    @Then("the product list should be ordered {string} by {string}")
    public void the_product_list_should_be_ordered_by(String string, String string2) {

    }

    @Given("the results show page {string}")
    public void the_results_show_page(String string) {

    }

    @When("I click {string} page")
    public void i_click_page(String string) {

    }

    @Then("I should see page {string}")
    public void i_should_see_page(String string) {

    }

    @Then("the product cards should update \\(no duplicates from page {int})")
    public void the_product_cards_should_update_no_duplicates_from_page(Integer int1) {

    }

}
