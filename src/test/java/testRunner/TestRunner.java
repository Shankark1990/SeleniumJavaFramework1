package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = {"features"},
//				features = {".//features/LoginDDT.feature"},
				glue = "stepDefination",
				plugin = {"pretty", "html:reports/myReport.html"},
				dryRun = false
				
		)
public class TestRunner {

}
