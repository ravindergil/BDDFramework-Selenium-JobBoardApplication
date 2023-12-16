package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.sql.Date;
import java.time.LocalDate;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/",
        glue = {"stepDefinitions"},
        //dryRun = true,
        //plugin = {"html:reports/cucumber-html-reports/report.html"},
        //monochrome = true,
        //publish = true,
        tags = ""
)
public class TestRunner {
    //Empty
}
