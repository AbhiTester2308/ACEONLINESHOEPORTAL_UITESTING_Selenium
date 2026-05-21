package com.AceOnlineShoePortal.Stepdefinition;

import com.AceOnlineShoePoratl.Pages.AuthenticationFeaturePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AuthenticationFeatureTest {

    private final AuthenticationFeaturePage authPage = new AuthenticationFeaturePage();

    @And("I register with details:")
    public void i_register_with_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        authPage.fillRegistration(
                data.get("First Name"),
                data.get("Last Name"),
                data.get("Email"),
                data.get("Password"),
                data.get("Confirm")
        );
    }

    @And("I submit the registration form")
    public void i_submit_registration() {
        authPage.submitRegistration();
    }

    @Then("I should see a registration success message {string} or similar")
    public void verify_registration_success(String expectedMsg) {
        Assert.assertTrue(authPage.getRegistrationSuccessText().contains(expectedMsg));
    }

    @And("I should be redirected to {string} page or be logged in")
    public void verify_redirection(String page) {
        String currentUrl = authPage.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.toLowerCase().contains(page.toLowerCase()) || authPage.isLogoutDisplayed()
        );
    }

    @Then("I should see a validation error containing {string}")
    public void verify_validation_error(String error) {
        Assert.assertTrue(authPage.getValidationErrorText().contains(error));
    }

    @When("I login with email {string} and password {string}")
    public void i_login_with(String email, String password) {
        authPage.login(email, password);
    }

    @Then("I should see my user name or a welcome message")
    public void verify_welcome_msg() {
        Assert.assertFalse(authPage.getWelcomeMessage().isEmpty());
    }

    @And("the logout button should be visible")
    public void verify_logout_visible() {
        Assert.assertTrue("Logout button should be visible", authPage.isLogoutDisplayed());
    }

    @And("the logout button should not be visible")
    public void verify_logout_not_visible() {
        Assert.assertFalse("Logout button should not be visible", authPage.isLogoutDisplayed());
    }

    @Then("I should see an authentication error {string}")
    public void verify_login_error(String error) {
        Assert.assertEquals(error, authPage.getLoginError());
    }
}
