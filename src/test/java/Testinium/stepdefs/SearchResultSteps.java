package Testinium.stepdefs;

import Testinium.pages.HomePage;
import Testinium.pages.SearchResultPage;
import io.cucumber.java.en.And;

public class SearchResultSteps {

    SearchResultPage _searchResultPage;

    public SearchResultSteps() {
        _searchResultPage = new SearchResultPage();
    }


    @And("I select a random product from the search results")
    public void ıSelectARandomProductFromTheSearchResults() {
        _searchResultPage.clickRandomProduct();
    }
}
