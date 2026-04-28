package com.AceOnlineShoePortal.Stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactNewsletterTest {
    private static final Logger log = LogManager.getLogger(ContactNewsletterTest .class);

    @Given("I open the site {string}")
    public void i_open_the_site(String string) {

    }

    @Given("I navigate to the {string} page")
    public void i_navigate_to_the_page(String string) {

    }

    @When("I fill the contact form:")
    public void i_fill_the_contact_form(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @When("I submit the contact form")
    public void i_submit_the_contact_form() {

    }

    @Then("I should see a success message {string} or similar")
    public void i_should_see_a_success_message_or_similar(String string) {

    }

    @Then("I should see a validation error {string}")
    public void i_should_see_a_validation_error(String string) {

    }

    @Given("I am on the {string} page")
    public void i_am_on_the_page(String string) {

    }

    @When("I enter {string} into the newsletter field")
    public void i_enter_into_the_newsletter_field(String string) {

    }

    @When("I click {string}")
    public void i_click(String string) {

    }

    @Then("I should see {string}")
    public void i_should_see(String string) {

    }

}
