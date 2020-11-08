package com.bonsaiui.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\resources\\Features", glue = "com.bonsaiui.stepdefinitions", 
		dryRun = false, plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", 
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports/Cucumber.html" }, monochrome = true, tags = { "@wip1" })




public class BonsaiRegressionRunner {

}
