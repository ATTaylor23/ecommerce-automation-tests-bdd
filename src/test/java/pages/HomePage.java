package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class HomePage {

    @FindBy (xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
    public WebElement product1;

    @FindBy (xpath = "(//a[@title='Blouse'])[2]")
    public WebElement product2;

    @FindBy (xpath = "//ul[@id='homefeatured']//a[@class='product-name']")
    public List<WebElement> products;



    public void clickOnProduct(String name){
        String xpath = "(//a[@title='" + name + "'])[2]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }


    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "search_query_top")
    public WebElement searchBar;



}
