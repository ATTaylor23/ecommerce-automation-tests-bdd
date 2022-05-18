package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCartPage {

    public ShoppingCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//p[@class='product-name'])[2]")
    public WebElement productName;

    @FindBy (id = "summary_products_quantity")
    public WebElement quantity;

    @FindBy (xpath = "//td[@data-title='Unit price']")
    public WebElement unitPrice;

    @FindBy (xpath = "//td[@data-title='Total']")
    public WebElement totalBeforeShipping;

    @FindBy (id = "total_shipping")
    public WebElement shippingFee;

}
