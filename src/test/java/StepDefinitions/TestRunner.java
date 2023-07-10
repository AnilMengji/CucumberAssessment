package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
tags = "@API",
features="src/test/resources/Features/Api.feature",
glue = {"StepDefinitions"},
plugin = {"json:target/cucumber.json"},
monochrome = true)
public class TestRunner {

}
