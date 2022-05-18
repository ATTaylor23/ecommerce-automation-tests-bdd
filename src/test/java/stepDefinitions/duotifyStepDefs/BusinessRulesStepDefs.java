package stepDefinitions.duotifyStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DButility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessRulesStepDefs {

    List<String> actualColumnNames;

    @When("I send a query to retrieve column names for songs table")
    public void iSendAQueryToRetrieveColumnNamesForSongsTable() {

        actualColumnNames = DButility.getColumnNames("Select * from songs");

    }
    @Then("The column names should be the following")
    public void theColumnNamesShouldBeTheFollowing(List<String> expectedColumnNames) {

        Assert.assertEquals(expectedColumnNames, actualColumnNames);

    }
    String shareUsername;
    String sharedLastName;

    @When("I update the last name of the user with the username {string} with {string}")
    public void iUpdateTheLastNameOfTheUserWithTheUsernameWith(String username, String expectedLastName) throws SQLException {

        shareUsername = username;
        sharedLastName = expectedLastName;
        String query = "update users set lastName='"+expectedLastName+"' where username='"+username+"'";
        DButility.updateQuery(query);

    }
    @Then("The value should be updated correctly")
    public void theValueShouldBeUpdatedCorrectly() {

        String query = "Select lastName from users where username='"+shareUsername+"'";
        List<List<Object>> listOfLists = DButility.getQueryResultAsListOfLists(query);

        Assert.assertEquals(sharedLastName, (String)(listOfLists.get(0).get(0)));

    }
    List<String> list2;

    @When("I send a query to retrieve all usernames")
    public void iSendAQueryToRetrieveAllUsernames() {

        List<List<Object>> list = DButility.getQueryResultAsListOfLists("Select username from users");

        list2 = new ArrayList<>();
        for (List<Object> each : list) {
            list2.add((String)(each.get(0)));
        }
        Collections.sort(list2);

    }
    @Then("the usernames should not contain duplicates")
    public void theUsernamesShouldNotContainDuplicates() {

        boolean hasNoDuplicate = true;

        for (int i = 0; i < list2.size(); i++) {
            if(list2.get(i).equals(list2.get(i+1))){

                System.out.println(list2.get(i) + " " + list2.get(i + 1));

                hasNoDuplicate = false;
                break;
            }
        }
        Assert.assertTrue(hasNoDuplicate);

    }

}
