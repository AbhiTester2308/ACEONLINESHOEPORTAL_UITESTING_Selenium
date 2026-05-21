package com.AceOnlineShoePortal.Stepdefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import com.AceOnlineShoePortal.Hooks.hook;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps() {
        this.driver = hook.getDriver();
    }

    @Given("I open the site {string}")
    public void i_open_the_site(String url) {
        driver.get(url);
    }
}