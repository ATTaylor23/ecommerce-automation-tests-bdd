package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DatatableDemoStepDefs {


    @Given("I set up something")
    public void iSetUpSomething() {

    }
    @When("I pass this data as List")
    public void iPassThisData(List<String> dataTable) {
        System.out.println(dataTable);

    }
    @Then("I should see the expected result")
    public void iShouldSeeTheExpectedResult() {

    }
    @When("I pass this data as List of Lists")
    public void iPassThisDataAsListOfLists(List<List<String>> dataTable) {
        System.out.println(dataTable);

        Assert.assertEquals(dataTable.get(1).get(1), "Dahle");

    }
    @When("I pass this data as List of Maps")
    public void iPassThisDataAsListOfMaps(List<Map<String,String>> dataTable) {
        System.out.println(dataTable);
        Assert.assertEquals(dataTable.get(1).get("lastName"), "Dahle");

    }
    @When("I pass this data as Map")
    public void iPassThisDataAsMap(Map<String,String> dataTable) {
        System.out.println(dataTable);
        System.out.println(dataTable.get("KSEA"));

    }
    @When("I pass this data as Map<String, List<String>>")
    public void iPassThisDataAsMapStringListString(Map<String, List<String>> dataTable) {
        System.out.println(dataTable);

    }
    @Given("I am connected to database")
    public void iAmConnectedToDatabase() {

    }
    @When("I send the following query")
    public void iSendTheFollowingQuery(String docString) {
        System.out.println(docString);
    }
    @Then("The result should be correct")
    public void theResultShouldBeCorrect() {

    }
}
