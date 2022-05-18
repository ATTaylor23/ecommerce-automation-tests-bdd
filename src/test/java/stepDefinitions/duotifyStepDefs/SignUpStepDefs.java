package stepDefinitions.duotifyStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import pages.duotifyPages.HomePageDuo;
import pages.duotifyPages.SignUpPage;
import utilities.DButility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SignUpStepDefs {

    String username;
    String password;

    @Given("I am on the duotify homepage")
    public void iAmOnTheDuotifyHomepage() {
        Driver.getDriver().get("http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?");

    }

    String expectedFirst;
    String expectedLast;
    String expectedEmail;

    @When("I sign up using valid credentials")
    public void iSignUpUsingValidCredentials() {
        Faker fake = new Faker();
        SignUpPage signUpPage = new SignUpPage();

        signUpPage.signUpLink.click();

        username = fake.name().username();
        signUpPage.username.sendKeys(username);

        expectedFirst = fake.name().firstName();
        signUpPage.firstName.sendKeys(expectedFirst);
        expectedLast = fake.name().lastName();
        signUpPage.lastName.sendKeys(expectedLast);

        expectedEmail = fake.internet().emailAddress();

        signUpPage.email.sendKeys(expectedEmail);
        signUpPage.email2.sendKeys(expectedEmail);

        password = fake.internet().password();

        signUpPage.password.sendKeys(password);
        signUpPage.password2.sendKeys(password);

        signUpPage.registerBtn.click();

    }
    @When("I sign up using the following credentials")
    public void iSignUpUsingTheFollowingCredentials(List<Map<String,String>> dataTable) {

        Map<String,String> map = dataTable.get(0);

        SignUpPage signUpPage = new SignUpPage();

        signUpPage.signUpLink.click();

        username = map.get("username");
        signUpPage.username.sendKeys(username);

        expectedFirst = map.get("first");
        signUpPage.firstName.sendKeys(expectedFirst);
        expectedLast = map.get("last");
        signUpPage.lastName.sendKeys(expectedLast);

        expectedEmail = map.get("email");

        signUpPage.email.sendKeys(expectedEmail);
        signUpPage.email2.sendKeys(expectedEmail);

        password = map.get("password");

        signUpPage.password.sendKeys(password);
        signUpPage.password2.sendKeys(password);

        signUpPage.registerBtn.click();

    }
    @Then("I should be able to land on the homepage")
    public void iShouldBeAbleToLandOnTheHomepage() {

        Assert.assertEquals("http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }
    @Then("I should be able to verify the user details in the database")
    public void iShouldBeAbleToVerifyTheUserDetailsInTheDatabase() throws SQLException {

        String query = "Select * from users where username='" + username + "'";
        System.out.println(query);
        List<Map<String, Object>> listOfMaps = DButility.getQueryResultListOfMaps(query);
        Map<String, Object> map = listOfMaps.get(0);


        Assert.assertEquals(username, map.get("username"));
        Assert.assertEquals(expectedFirst, map.get("firstName"));
        Assert.assertEquals(expectedLast, map.get("lastName"));
        Assert.assertEquals(expectedEmail, map.get("email").toString().toLowerCase());
        Assert.assertEquals(DigestUtils.md5Hex(password), map.get("password"));

        String updateQueryNow = "delete from users where username='"+username+"'";
        DButility.updateQuery(updateQueryNow);     //clean the database by removing the user we just created from the ui

    }
    String expectedUsername;
    String expectedFirstName;
    String expectedLastName;
    String expectedEmailNow;
    String expectedPassword;


    @Given("I create a new user in the Database with the following details")
    public void iCreateANewUserInTheDatabaseWithTheFollowingDetails(List<Map<String, String>> dataTable) throws SQLException {

        Map<String, String> map = dataTable.get(0);
        expectedUsername = map.get("username");
        expectedFirstName = map.get("first");
        expectedLastName = map.get("last");
        expectedEmailNow = map.get("email");
        expectedPassword = map.get("password");

        String query = "insert into users(username, firstName, lastName, email, password)\n" +
                "values('"+expectedUsername+"', '"+expectedFirstName+"', '"+expectedLastName+"', '"+expectedEmailNow+"', '"+DigestUtils.md5Hex(expectedPassword)+"')";
        DButility.updateQuery(query);

    }
    @When("I login with the same credentials on the UI")
    public void iLoginWithTheSameCredentialsOnTheUI() throws InterruptedException {
        Driver.getDriver().get("http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?");

        SignUpPage signUpPage = new SignUpPage();

        signUpPage.loginUsername.sendKeys(expectedUsername);
        signUpPage.loginPassword.sendKeys(expectedPassword);
        signUpPage.loginButton.click();


    }
    @Then("firstname, lastname and email should be correct")
    public void firstnameLastnameAndEmailShouldBeCorrect() throws SQLException {

        HomePageDuo homePageDuo = new HomePageDuo();

        String[] arr = homePageDuo.nameFirstAndLast.getText().split(" ");

        homePageDuo.nameFirstAndLast.click();
        homePageDuo.userDetails.click();

        String actualEmail = homePageDuo.emailInput.getAttribute("value");

        Assert.assertEquals(expectedFirstName, arr[0]);
        Assert.assertEquals(expectedLastName, arr[1]);
        Assert.assertEquals(expectedEmailNow, actualEmail);

        String updateQueryAgain = "delete from users where username='"+expectedUsername+"'";
        DButility.updateQuery(updateQueryAgain);

    }



}
