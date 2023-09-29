package Testinium.pages;

import Testinium.utils.Driver;
import Testinium.utils.Helper;
import Testinium.utils.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends Helper {
    public SearchResultPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".m-productCard__desc")
    public List<WebElement> productList;
    @FindBy(id = "productListTitle")
    public WebElement productSearchTitle;

    public void clickRandomProduct() {
        WaitForElement(productSearchTitle);
        Random random = new Random();
        clickElement(productList.get(random.nextInt(productList.size())));
        Log4j.step("Clicked on the Accept Cookie Policy Button.");
    }
}
