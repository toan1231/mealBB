package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/apiFeatures",
        glue={"api_automation.stepDefinition"},
        dryRun = true,
        monochrome = true,
        tags = { "@my" },
        plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json" }
)
public class APITestRunner {

}
//"@ApiRegression"