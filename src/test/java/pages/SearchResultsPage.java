package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchResultsPage {

    public SearchResultsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@class='product-name'][@title='Blouse']")
    public WebElement blouseProduct;

    @FindBy (xpath = "(//a[@class='product-name'][@title='Printed Dress'])[2]")
    public WebElement DressProduct;

    @FindBy (xpath = "(//a[@class='product-name'][@title='Printed Summer Dress'])[2]")
    public WebElement SummerDressProduct;





}
