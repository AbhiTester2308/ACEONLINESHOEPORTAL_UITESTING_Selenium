package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.ContactNewsLetterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class ContactNewsletterTest {

    private final ContactNewsLetterPage contactPage = new ContactNewsLetterPage();

    @When("I fill the contact form:")
    public void i_fill_the_contact_form(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        contactPage.fillContactForm(data);
    }

    @When("I submit the contact form")
    public void i_submit_the_contact_form() {
        contactPage.submitContactForm();
    }

    @Then("I should see a success message {string} or similar")
    public void i_should_see_a_success_message_or_similar(String message) {
        Assert.assertTrue(contactPage.getSuccessMessage().contains(message));
    }

    @Then("I should see a validation error {string}")
    public void i_should_see_a_validation_error(String error) {
        Assert.assertTrue(contactPage.getValidationError().contains(error));
    }

    @When("I enter {string} into the newsletter field")
    public void i_enter_into_the_newsletter_field(String email) {
        contactPage.enterNewsletterEmail(email);
    }

}
