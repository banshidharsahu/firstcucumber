package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/logindemo.feature", glue = {
		"StepDefinations" }, monochrome = true, plugin = { "pretty", "html:target/HtmlReport",
				"json:target/JsonReports/reports.json", "junit:target/JUnitReports/reports.xml" })

public class Test_runner

{

}
