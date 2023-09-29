package Testinium.stepdefs;

import Testinium.pages.ProductPage;
import Testinium.pages.SearchResultPage;
import io.cucumber.java.en.And;

public class ProductSteps {
    ProductPage _productPage;

    public ProductSteps() {
        _productPage = new ProductPage();
    }

    @And("I write the product information and price to a text file")
    public void ıWriteTheProductInformationAndPriceToATextFile() {
        _productPage.productInfoAndPriceToTxt();
    }

    @And("I add the selected product to the shopping cart")
    public void ıAddTheSelectedProductToTheShoppingCart() {
        _productPage.clickAddToBasket();
    }
}
