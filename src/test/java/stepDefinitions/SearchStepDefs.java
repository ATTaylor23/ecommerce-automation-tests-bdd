package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.Driver;
import utilities.PropertyReader;

public class SearchStepDefs {

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        Driver.getDriver().get(PropertyReader.getTheProperties("url"));
    }
    @When("I search for a Blouse")
    public void i_search_for_a_blouse() {
        HomePage homePage = new HomePage();
        homePage.searchBar.sendKeys("Blouse", Keys.ENTER);

    }
    @Then("I should see the Blouse in the search results")
    public void i_should_see_the_blouse_in_the_search_results() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.blouseProduct.getText().contains("Blouse"));

        Driver.quitDriver();

    }
    @When("I search for a Printed Dress")
    public void i_search_for_a_printed_dress() {
        HomePage homePage = new HomePage();
        homePage.searchBar.sendKeys("Printed Dress", Keys.ENTER);

    }
    @Then("I should see the Printed Dress in the search results")
    public void i_should_see_the_printed_dress_in_the_search_results() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.DressProduct.getText().contains("Printed Dress"));

    }
    @When("I search for a Printed Summer Dress")
    public void i_search_for_a_printed_summer_dress() {
        HomePage homePage = new HomePage();
        homePage.searchBar.sendKeys("Printed Summer Dress", Keys.ENTER);

    }
    @Then("I should see the Printed Summer Dress in the search results")
    public void i_should_see_the_printed_summer_dress_in_the_search_results() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.SummerDressProduct.getText().contains("Printed Summer Dress"));

    }



}
