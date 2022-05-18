package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
     //   tags = "@search",

        features = "src/test/resources/parallel",

        glue = "stepDefinitions",

        stepNotifications = true,

        snippets = CucumberOptions.SnippetType.CAMELCASE,

        plugin = {"pretty",
                "html:target/built-in-report/built-in-report.html",
                "json:target/Cucumber.json",
                "rerun:target/failed.txt"
        }

        //,dryRun = true

)


public class ParallelRunner {
}
