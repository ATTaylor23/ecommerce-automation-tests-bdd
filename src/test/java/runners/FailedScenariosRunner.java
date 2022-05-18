package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(


        features = "@target/failed.txt",

        glue = "stepDefinitions",

        stepNotifications = true

)


public class FailedScenariosRunner {




}
