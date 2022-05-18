package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class HomepageStepDefs {

    @Then("The promoted products should be the following")
    public void thePromotedProductsShouldBeTheFollowing(List<String> expectedProductNames) {
        List<String> actualProductNames = SeleniumUtils.getElementsText(new HomePage().products);

        Assert.assertEquals(expectedProductNames, actualProductNames);

    }
    @Then("The product details should be the following as list of lists")
    public void theProductDetailsShouldBeTheFollowing(List<List<String>> dataTable) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        String actualName = productDetailsPage.productTitle.getText();
        String actualPrice = productDetailsPage.productPrice.getText();
        String actualModel = productDetailsPage.productModel.getText();
        String actualCondition = productDetailsPage.productCondition.getText();
        String actualComposition = productDetailsPage.productComposition.getText();
        String actualStyle = productDetailsPage.productStyle.getText();
        String actualProperty = productDetailsPage.productProperty.getText();

        // Cucumber does not have soft assertions since it uses junit natively
        // If you want to implement it, you can use AssertJ library

        List<String> expectedRow = dataTable.get(1);
        Assert.assertEquals(expectedRow.get(0), actualName);
        Assert.assertEquals(expectedRow.get(1), actualPrice);
        Assert.assertEquals(expectedRow.get(2), actualModel);
        Assert.assertEquals(expectedRow.get(3), actualCondition);
        Assert.assertEquals(expectedRow.get(4), actualComposition);
        Assert.assertEquals(expectedRow.get(5), actualStyle);
        Assert.assertEquals(expectedRow.get(6), actualProperty);

    }
    @Then("The product details should be the following as list of Maps")
    public void theProductDetailsShouldBeTheFollowingAsListOfMaps(List<Map<String, String>> dataTable) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        String actualName = productDetailsPage.productTitle.getText();
        String actualPrice = productDetailsPage.productPrice.getText();
        String actualModel = productDetailsPage.productModel.getText();
        String actualCondition = productDetailsPage.productCondition.getText();
        String actualComposition = productDetailsPage.productComposition.getText();
        String actualStyle = productDetailsPage.productStyle.getText();
        String actualProperty = productDetailsPage.productProperty.getText();


        Map<String, String> firstRow = dataTable.get(0);
        Assert.assertEquals(firstRow.get("Name"), actualName);
        Assert.assertEquals(firstRow.get("Price"), actualPrice);
        Assert.assertEquals(firstRow.get("Model"), actualModel);
        Assert.assertEquals(firstRow.get("Condition"), actualCondition);
        Assert.assertEquals(firstRow.get("Compositions"), actualComposition);
        Assert.assertEquals(firstRow.get("Styles"), actualStyle);
        Assert.assertEquals(firstRow.get("Properties"), actualProperty);

    }




}
