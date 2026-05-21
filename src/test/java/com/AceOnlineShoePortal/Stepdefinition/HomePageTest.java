package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageTest {

    private final HomePage homePage = new HomePage();

    @When("Application is on the HomePage")
    public void application_is_on_the_home_page() {
        Assert.assertTrue("Home page was not displayed", homePage.isHomePageDisplayed());
    }

    @Then("user verify application Logo")
    public void user_verify_application_logo() {
        Assert.assertTrue("Application logo was not displayed", homePage.isLogoDisplayed());
    }
}
