package stepDefinitions.duoBank;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class duoBankStepDefs {

    String email;
    String password;
    RequestSpecification requestSpecification;
    Response response;

    @Given("The base URI is set to {string}")
    public void theBaseURIIsSetTo(String uri) {

        baseURI = uri;

    }
    @Given("The valid body is added to the request")
    public void theValidBodyIsAddedToTheRequest() {

        email = new Faker().internet().emailAddress();
        password = new Faker().internet().password();

        requestSpecification = given().
                                       body("{\n" +
                                            "        \"first_name\" : \"Jack\",\n" +
                                            "        \"last_name\" : \"Sparrow\", \n" +
                                            "        \"email\" : \""+email+"\",\n" +
                                            "        \"password\" : \""+password+"\"\n" +
                                            "}");

    }
    @When("I send a POST request to endpoint {string}")
    public void iSendAPOSTRequestToEndpoint(String endpoint) {

        response = requestSpecification.when().log().all().
                                                                post(endpoint);

    }
    @Then("The status code should be {int} and response payload should contain a message {string}")
    public void theStatusCodeShouldBeAndResponsePayloadShouldContainAMessage(Integer status, String message) {

        response.then().log().all().
                assertThat().
                statusCode(status).
                body("message", equalTo(message));

    }
    @Then("I navigate to the homepage")
    public void iNavigateToTheHomepage() {

        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");

    }
    @Then("I enter the same credentials sent by API request")
    public void iEnterTheSameCredentialsSentByAPIRequest() {

        Driver.getDriver().findElement(By.id("exampleInputEmail1")).sendKeys(email, Keys.TAB, password, Keys.ENTER);

    }
    @Then("I should be able to login")
    public void iShouldBeAbleToLogin() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loan Application"));

        Driver.getDriver().close();

    }


}
