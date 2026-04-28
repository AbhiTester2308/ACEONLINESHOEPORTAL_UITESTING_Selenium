package com.AceOnlineShoePortal.Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomeNavigationTest {
    private static final Logger log = LogManager.getLogger(HomeNavigationTest .class);

    @Given("I am a guest user")
    public void i_am_a_guest_user() {

    }

    @Given("I open the site {string}")
    public void i_open_the_site(String string) {

    }

    @Then("I should see the site logo")
    public void i_should_see_the_site_logo() {

    }

    @Then("I should see a search box")
    public void i_should_see_a_search_box() {

    }

    @Then("I should see the top navigation menu with items:")
    public void i_should_see_the_top_navigation_menu_with_items(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @Then("I should see the cart icon with count {string}")
    public void i_should_see_the_cart_icon_with_count(String string) {

    }

    @When("I click the {string} menu item")
    public void i_click_the_menu_item(String string) {

    }

    @Then("I should land on the {string} page")
    public void i_should_land_on_the_page(String string) {

    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String string) {

    }

    @Then("I should see footer links:")
    public void i_should_see_footer_links(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @When("I click the {string} footer link")
    public void i_click_the_footer_link(String string) {

    }

    @Then("I should land on a page containing {string} in heading")
    public void i_should_land_on_a_page_containing_in_heading(String string) {

    }

    @Given("I set viewport to width {string} and height {string}")
    public void i_set_viewport_to_width_and_height(String string, String string2) {

    }

    @Then("the burger menu {string} be visible")
    public void the_burger_menu_be_visible(String string) {

    }

    @When("the viewport is narrow the menu collapses")
    public void the_viewport_is_narrow_the_menu_collapses() {

    }

}
