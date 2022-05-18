package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DButility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.io.File;
import java.time.Duration;

public class Hooks {

    @Before
    public void setup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
    //    Driver.getDriver().manage().deleteAllCookies();

    }

    @Before  ("@db")         // the before logic that runs before all scenarios tagged with @db
    public void setupDB(){

        DButility.createConnection();

    }

    @After  ("@db")
    public void tearDownDB(){
        DButility.close();
    }


    @After
    public void teardown(Scenario scenario){

        if (scenario.isFailed()){

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshotAs, "image/png", "failed");

        }

        Driver.quitDriver();
    }


}
