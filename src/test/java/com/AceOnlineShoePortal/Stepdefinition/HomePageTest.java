package com.AceOnlineShoePortal.Stepdefinition;


import com.AceOnlineShoePoratl.Pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageTest extends HomePage {


    @When("Application is on the HomePage")
    public void application_is_on_the_home_page() {
        application_HomePage_display();
    }

    @Then("user verify application Logo")
    public void user_verify_application_Logo() {
        application_home_logo();
    }


}
