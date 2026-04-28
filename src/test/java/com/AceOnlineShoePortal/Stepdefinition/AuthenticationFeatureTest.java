package com.AceOnlineShoePortal.Stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthenticationFeatureTest {
    private static final Logger log = LogManager.getLogger(AuthenticationFeatureTest.class);

    @Given("I open the site {string}")
    public void i_open_the_site(String string) {

    }

    @When("I navigate to the {string} page")
   /*public void i_navigate_to_the_page(String string) {

    }*/

    @When("I register with details:")
    public void i_register_with_details(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }

    @When("I submit the registration form")
    public void i_submit_the_registration_form() {

    }

    @Then("I should see a registration success message {string} or similar")
    public void i_should_see_a_registration_success_message_or_similar(String string) {

    }

    @Then("I should be redirected to {string} page or be logged in")
    public void i_should_be_redirected_to_page_or_be_logged_in(String string) {

    }

    @Then("I should see a validation error containing {string}")
    public void i_should_see_a_validation_error_containing(String string) {

    }

    @Given("I navigate to the {string} page")
    public void i_navigate_to_the_page(String string) {

    }

    @When("I login with email {string} and password {string}")
    public void i_login_with_email_and_password(String string, String string2) {

    }

    @Then("I should see my user name or a welcome message")
    public void i_should_see_my_user_name_or_a_welcome_message() {

    }

    @Then("the logout button should be visible")
    public void the_logout_button_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should see an authentication error {string}")
    public void i_should_see_an_authentication_error(String string) {

    }

    @Then("the logout button should not be visible")
    public void the_logout_button_should_not_be_visible() {

    }
}
