package Testinium.stepdefs;

import Testinium.pages.HomePage;
import Testinium.utils.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
    HomePage _homePage;
    ExcelReader _excelReader;

    public HomeSteps() {
        _homePage = new HomePage();
        _excelReader = new ExcelReader();
    }

    @When("I verify that the homepage is loaded")
    public void ıVerifyThatTheHomepageIsLoaded() {
        _homePage.homePageIsOpened();
    }

    @And("I enter the keyword into the search box from Excel \\(Column {int}, Row {int})")
    public void ıEnterTheKeywordIntoTheSearchBoxFromExcelColumnRow(int column, int row) {
        _homePage.typeSearchBox(_excelReader.cellValue(row,column));
    }

    @And("I clear the search box")
    public void ıClearTheSearchBox() {
        _homePage.clearSearchBox();
    }

    @And("I accept cookie policy button")
    public void ıAcceptCookiePolicyButton() {
        _homePage.clickAcceptCookiePolicyButton();
    }

    @And("I closed to gender popup")
    public void ıClosedToGenderPopup() {
        _homePage.clickGenderPopupCloseBtn();
    }

    @And("I press the Enter key to search box")
    public void ıPressTheEnterKeyToSearchBox() {
        _homePage.EnterToSearchBox();
    }
}
