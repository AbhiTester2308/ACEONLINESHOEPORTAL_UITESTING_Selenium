package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.HomeNavigationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class HomeNavigationTest {

    private final HomeNavigationPage homeNav = new HomeNavigationPage();

    @Then("I should see the site logo")
    public void i_should_see_the_site_logo() {
        Assert.assertTrue(homeNav.isLogoVisible());
    }

    @Then("I should see a search box")
    public void i_should_see_a_search_box() {
        Assert.assertTrue(homeNav.isSearchBoxVisible());
    }

    @Then("I should see the top navigation menu with items:")
    public void i_should_see_the_top_navigation_menu_with_items(DataTable dataTable) {
        List<String> items = dataTable.row(0);
        Assert.assertTrue(homeNav.navItemsVisible(items));
    }

    @Then("I should see the cart icon with count {string}")
    public void i_should_see_the_cart_icon_with_count(String count) {
        Assert.assertTrue(homeNav.isCartIconVisible());
    }

    @When("I click the {string} menu item")
    public void i_click_the_menu_item(String menuItem) {
        homeNav.clickMenuItem(menuItem);
    }

    @Then("I should land on the {string} page")
    public void i_should_land_on_the_page(String expectedUrlFragment) {
        Assert.assertTrue(homeNav.urlContains(expectedUrlFragment));
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        Assert.assertTrue(homeNav.getTitle().contains(expectedTitle));
    }

    @Then("I should see footer links:")
    public void i_should_see_footer_links(DataTable dataTable) {
        List<String> links = dataTable.row(0);
        Assert.assertTrue(homeNav.footerLinksVisible(links));
    }

    @When("I click the {string} footer link")
    public void i_click_the_footer_link(String link) {
        homeNav.clickFooterLink(link);
    }

    @Then("I should land on a page containing {string} in heading")
    public void i_should_land_on_a_page_containing_in_heading(String text) {
        Assert.assertTrue(homeNav.headingContains(text));
    }

    @Given("I set viewport to width {string} and height {string}")
    public void i_set_viewport_to_width_and_height(String width, String height) {
        homeNav.setViewport(Integer.parseInt(width), Integer.parseInt(height));
    }

    @Then("the burger menu {string} be visible")
    public void the_burger_menu_be_visible(String shouldBeVisible) {
        boolean expected = shouldBeVisible.equalsIgnoreCase("should");
        Assert.assertEquals(expected, homeNav.isBurgerMenuVisible());
    }

    @When("the viewport is narrow the menu collapses")
    public void the_viewport_is_narrow_the_menu_collapses() {
        homeNav.openHamburgerIfPresent();
    }
}
