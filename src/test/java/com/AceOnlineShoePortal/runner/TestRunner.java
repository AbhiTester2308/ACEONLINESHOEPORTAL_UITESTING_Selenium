package com.AceOnlineShoePortal.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Cucumber JUnit runner. Default: all scenarios except @wip.
 * Smoke only: mvn test -Dtest=TestRunner -Dcucumber.filter.tags=@smoke
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.AceOnlineShoePortal.Hooks", "com.AceOnlineShoePortal.Stepdefinition"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@home_navigation"
)
public class TestRunner {
}
