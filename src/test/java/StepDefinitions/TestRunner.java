package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
tags = "@Datatransform",
features="src/test/resources/Features/Datatransform.feature",
glue = {"StepDefinitions"},
plugin = {"json:target/cucumber.json"},
monochrome = true)
public class TestRunner {

}
