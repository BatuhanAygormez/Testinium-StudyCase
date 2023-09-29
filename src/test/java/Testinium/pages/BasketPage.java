package Testinium.pages;

import Testinium.utils.Driver;
import Testinium.utils.Helper;
import Testinium.utils.Log4j;
import Testinium.utils.TxtWriter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage extends Helper {
    TxtWriter _txtWriter;

    public BasketPage() {
        PageFactory.initElements(Driver.get(), this);
        _txtWriter = new TxtWriter();
    }

    @FindBy(css = ".-grandTotal .m-orderSummary__value")
    public WebElement grandTotalPrice;
    @FindBy(xpath = "//select[@id='quantitySelect0-key-0']/option")
    public List<WebElement> incrementableNumberofPieces;
    @FindBy(id = "quantitySelect0-key-0")
    public WebElement quantityNumberIncrease;
    @FindBy(xpath = "//select[@id='quantitySelect0-key-0']//option[@value='2']")
    public WebElement quantityNumber;
    @FindBy(id = "removeCartItemBtn0-key-0")
    public WebElement removeProductBtn;
    @FindBy(css = ".m-empty__messageTitle")
    public WebElement emptyBasketResult;

    public void CompareProductPriceForBasketPrice() {
        String productPrice = _txtWriter.ReadProductPrice();
        String basketPagePrice = getText(grandTotalPrice).replace(" TL", "").split(",")[0];


        System.out.println(productPrice);
        System.out.println(basketPagePrice);

        Assert.assertEquals(productPrice, basketPagePrice);
        Log4j.info("The product in the basket and the product in the text file were compared");    }

    public void QuantityNumberSelection(String adet) {
        if (incrementableNumberofPieces.size() > 1) {
            selectByValue(quantityNumberIncrease, adet);
            Assert.assertEquals(getText(quantityNumber).trim().replace(" adet", ""), adet);
        } else {
            Log4j.info("Number of units cannot be increased");
        }
    }

    public void removeProductFromBasket() {
        clickElement(removeProductBtn);
    }

    public void verifyEmptyBasket() {
        Assert.assertTrue(isDisplayed(emptyBasketResult));
    }
}
