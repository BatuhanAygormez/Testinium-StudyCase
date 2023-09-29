package Testinium.stepdefs;

import Testinium.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BaseSteps {
    BasePage _basePage;

    public BaseSteps() {
        _basePage = new BasePage();
    }

    @Given("I open the {string} website")
    public void iOpenTheHttpsBeymenComWebsite(String url) {
        _basePage.openTheUrl(url);
    }
}
