package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class ProductDetailsPage {


    @FindBy (xpath = "//h1")
    public WebElement productTitle;

    @FindBy (id = "our_price_display")
    public WebElement productPrice;

    @FindBy (id = "quantity_wanted")
    public WebElement quantity;

    @FindBy (xpath = "//i[@class='icon-plus']")
    public WebElement plusButton;

    @FindBy (xpath = "(//img[@alt='Printed Chiffon Dress'])[1]")
    public WebElement chiffonDress;

    @FindBy (xpath = "//span[@itemprop='sku']")
    public WebElement productModel;

    @FindBy (xpath = "(//span[@class='editable'])[2]")
    public WebElement productCondition;

    @FindBy (xpath = "(//tr[@class='odd']//td)[2]")
    public WebElement productComposition;

    @FindBy (xpath = "(//tr[@class='even']//td)[2]")
    public WebElement productStyle;

    @FindBy (xpath = "(//tr[@class='odd'])[2]//td[2]")
    public WebElement productProperty;

    @FindBy (xpath = "//button[@name='Submit']")
    public WebElement submitButton;

    @FindBy (id = "layer_cart_product_quantity")
    public WebElement popUpQuantity;

    @FindBy (id = "layer_cart_product_attributes")
    public WebElement popUpAttributes;

    @FindBy (xpath = "//a[@class='btn btn-default button button-medium']")
    public WebElement nextButton;



    public void clickOnPlusButton(int times){
        for(int i = 0; i < times; i++){
            plusButton.click();
        }
    }

    public void chooseSize(String size) {
        new Select(Driver.getDriver().findElement(By.id("group_1"))).selectByVisibleText(size);
    }

    public void chooseColor(String color) {
        String xpath = "//a[@title='" + color + "']";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public ProductDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
