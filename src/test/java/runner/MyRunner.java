package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions",
		"hooks" }, stepNotifications = true, dryRun = false, plugin = { "pretty","html:target/cucumberreport.html",
				"json:target/cucumber.json", "junit:target/cucumber.xml" })
public class MyRunner {

}