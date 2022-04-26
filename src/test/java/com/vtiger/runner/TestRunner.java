package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/Features/",
		glue = {"com.vtiger.stepdefinitions"},
	//	plugin = {"pretty", "html:target/cucumber-reports.html"},
	    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
		//tags = "@only",
		tags = "@release123",
		//dryRun = true,
		monochrome = true
		)

public class TestRunner {

}
