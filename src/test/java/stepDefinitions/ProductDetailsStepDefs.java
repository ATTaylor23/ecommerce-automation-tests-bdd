package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultsPage;
import utilities.Driver;
import utilities.PropertyReader;

public class ProductDetailsStepDefs {


    @When("I click on a product {string}")
    public void i_click_on_a_product(String productName) {
        HomePage homePage = new HomePage();
        homePage.clickOnProduct(productName);

    }
    @When("I land on a product details page with title containing {string}")
    public void i_land_on_a_product_details_page_with_title_containing(String productName) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(productName));

    }
    @Then("The title of the product should be {string}")
    public void the_title_of_the_product_should_be(String productName) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assert.assertEquals(productName, productDetailsPage.productTitle.getText());

    }

    @Then("The price of the product should be {double}")
    public void the_price_of_the_product_should_be(Double price) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assert.assertEquals(price, Double.valueOf(productDetailsPage.productPrice.getText().replace("$", "")));

    }

    @When("I click on a product with {string}")
    public void i_click_on_a_product_with(String string) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.chiffonDress.click();

    }

    @Then("The default quantity should be {int}")
    public void the_default_quantity_should_be(Integer defQuantity) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Assert.assertEquals(defQuantity, Integer.valueOf(productDetailsPage.quantity.getAttribute("value")));

    }
    Integer sharedTimes;

    @When("I click on a plus button {int} times")
    public void i_click_on_a_plus_button_times(Integer times) {
        sharedTimes = times;
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickOnPlusButton(times);

    }

    @Then("The quantity should be correct")
    public void the_quantity_should_be_correct() {
        Integer actualQuantity = Integer.valueOf(new ProductDetailsPage().quantity.getAttribute("value"));
        Integer expectedQuantity = sharedTimes + 1;

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }





//    @When("I click on a product Faded Short Sleeve T-shirts")
//    public void i_click_on_a_product_faded_short_sleeve_t_shirts() {
//        HomePage homePage = new HomePage();
//        homePage.product1.click();
//
//    }
//    @And("I land on a product details page with title containing Faded Short Sleeve T-shirts")
//    public void someMethod(){
//        Assert.assertTrue(Driver.getDriver().getTitle().contains("Faded Short Sleeve T-shirts"));
//
//    }
//    @Then("The title of the product should be Faded Short Sleeve T-shirts")
//    public void the_title_of_the_product_should_be_the_same() {
//        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
//        Assert.assertEquals("Faded Short Sleeve T-shirts", productDetailsPage.productTitle.getText());
//
//    }
//    @When("I click on a product Blouse")
//    public void i_click_on_a_product_blouse() {
//        HomePage homePage = new HomePage();
//        homePage.product2.click();
//
//    }
//    @When("I land on a product details page with title containing Blouse")
//    public void i_land_on_a_product_details_page_with_title_containing_blouse() {
//        Assert.assertTrue(Driver.getDriver().getTitle().contains("Blouse"));
//
//    }
//    @Then("The title of the product should be Blouse")
//    public void the_title_of_the_product_should_be_blouse() {
//        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
//        Assert.assertEquals("Blouse", productDetailsPage.productTitle.getText());
//
//
//    }


    // DEMO OF THE DIFFERENT TYPES PARAMETERS


//    @Given("I have {int} {string}")
//    public void i_have(Integer amount, String fruit) {
//
//        System.out.println("The amount: " + amount);
//        System.out.println("The fruit: " + fruit);
//
//    }
//    @When("I take {int} away")
//    public void i_take_away(Integer amount) {
//
//        System.out.println("The taken amount: " + amount);
//
//    }
//    @Then("I should have {int} left and price should be {double}")
//    public void i_should_have_left_and_price_should_be(Integer amount, Double price) {
//
//        System.out.println("The amount left: " + amount);
//        System.out.println("The price: " + price);
//
//    }


}
