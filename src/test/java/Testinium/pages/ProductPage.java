package Testinium.pages;

import Testinium.utils.Driver;
import Testinium.utils.Helper;
import Testinium.utils.Log4j;
import Testinium.utils.TxtWriter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductPage extends Helper {
    TxtWriter _txtWriter;

    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);
        _txtWriter = new TxtWriter();
    }

    @FindBy(css = ".o-productDetail__description")
    public WebElement productName;
    @FindBy(xpath = "//ins[@id='priceNew']")
    public WebElement productPrice;
    @FindBy(id = "addBasket")
    public WebElement addToBasket;
    @FindBy(xpath = "//div[@id='sizes']//span[contains(@class,'m-variation__item') and not(contains(@class,'disabled'))]")
    public List<WebElement> sizeCount;
    @FindBy(css = ".m-notification__button.btn")
    public WebElement goToBasketPage;
    @FindBy(css = ".m-price__lastPrice")
    public List<WebElement> additionalDiscountNumber ;
    @FindBy(xpath = "(//div[@class='m-price__lastPrice']//text())[last()]")
    public WebElement additionalDiscountPrice;

    public void productInfoAndPriceToTxt() {
        if (additionalDiscountNumber .size() > 0) {
            _txtWriter.Writer(String.format("Product Name: %s | Product Price : %s", getText(productName), getText(additionalDiscountPrice)));
        } else {
            _txtWriter.Writer(String.format("Product Name: %s | Product Price : %s", getText(productName), getText(productPrice)));
        }
        Log4j.info("Product name and product price are written to text file");
    }

    public void clickAddToBasket() {
        Random random = new Random();
        if (sizeCount.size() > 0) {
            clickElement(sizeCount.get(random.nextInt(sizeCount.size())));
        }
        clickElement(addToBasket);
        clickElement(goToBasketPage);
        Log4j.info("Randomly select the product, add the product to the basket and go to the basket");
    }
}
