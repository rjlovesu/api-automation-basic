package testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "json:target/cucumber-reports/jsonReport.json",
                "junit:target/cucumber-reports/xmlReport.xml"},
        tags = {"not @WIP"}
)

public class TestRunner {
}
