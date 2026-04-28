package com.AceOnlineShoePortal.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/Features/ApplicationHome.feature",
  glue = {"com.AceOnlineShoePortal.Hooks","com.AceOnlineShoePortal.Stepdefinition"},
  plugin = {"pretty","html:target/cucumber-html-report","json:cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
  monochrome = true,
  tags = "@home"
)
public class TestRunner {}
