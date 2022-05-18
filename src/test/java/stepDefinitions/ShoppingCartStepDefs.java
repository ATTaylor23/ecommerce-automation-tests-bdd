package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class ShoppingCartStepDefs {

    int expQuantity;
    String expSize;
    String expColor;

    @When("I increase the quantity {int} and choose the size {string} and color {string} and click on add to cart")
    public void iIncreaseTheQuantityAndChooseTheSizeAndColorAndClickOnAddToCart(Integer quantity, String size, String color) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        expQuantity = quantity;
        expSize = size;
        expColor = color;

        productDetailsPage.clickOnPlusButton(quantity - 1);
        productDetailsPage.chooseSize(size);
        productDetailsPage.chooseColor(color);
        productDetailsPage.submitButton.click();
        SeleniumUtils.waitFor(3);


    }
    @Then("The quantity, size and color should be correct")
    public void theQuantitySizeAndColorShouldBeCorrect() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        int actualQuantity = Integer.parseInt(productDetailsPage.popUpQuantity.getText());
        String[] items = productDetailsPage.popUpAttributes.getText().split(",");
        String actualColor = items[0].trim();
        String actualSize = items[1].trim();

        Assert.assertEquals(expQuantity, actualQuantity);
        Assert.assertEquals(expColor, actualColor);
        Assert.assertEquals(expSize, actualSize);

        productDetailsPage.nextButton.click();

    }
    @Then("The shopping cart details should be the follow:")
    public void theShoppingCartDetailsShouldBeTheFollow(List<Map<String,String>> dataTable) {

        Map<String,String> map = dataTable.get(0);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        Assert.assertEquals(map.get("Name"), shoppingCartPage.productName.getText());
        Assert.assertEquals(map.get("Quantity"), shoppingCartPage.quantity.getText().split(" ")[0] );
        Assert.assertEquals(map.get("Unit Price"), shoppingCartPage.unitPrice.getText());
        Assert.assertEquals(map.get("TotalBeforeShipping"), shoppingCartPage.totalBeforeShipping.getText().trim());
        Assert.assertEquals(map.get("Shipping Fee"), shoppingCartPage.shippingFee.getText());


    }

}
