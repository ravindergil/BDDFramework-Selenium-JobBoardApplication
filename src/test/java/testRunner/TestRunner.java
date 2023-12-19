package testRunner;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
        monochrome = false,
        plugin={"pretty","html:target/cucumber/report.html","json:target/cucumber/report.json"},
        //publish = true,
        tags = ""
)
public class TestRunner {
    //Empty

}
