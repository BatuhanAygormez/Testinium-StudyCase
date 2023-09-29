package Testinium.stepdefs;

import Testinium.pages.BasketPage;
import Testinium.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BasketSteps {
    BasketPage _basketPage;

    public BasketSteps() {
        _basketPage = new BasketPage();
    }

    @And("I compare the price on the product page with the price in the cart")
    public void ıCompareThePriceOnTheProductPageWithThePriceInTheCart() {
        _basketPage.CompareProductPriceForBasketPrice();
    }

    @And("I increase the quantity to {int} and verify it")
    public void ıIncreaseTheQuantityToAndVerifyIt(int quantity) {
        _basketPage.QuantityNumberSelection(String.valueOf(quantity));
    }

    @And("I remove the product from the cart")
    public void ıRemoveTheProductFromTheCart() {
        _basketPage.removeProductFromBasket();
    }

    @Then("I verify that the cart is empty")
    public void ıVerifyThatTheCartIsEmpty() {
        _basketPage.verifyEmptyBasket();
    }
}
