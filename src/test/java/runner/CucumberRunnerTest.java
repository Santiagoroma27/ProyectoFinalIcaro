package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
