package Testinium.pages;

import Testinium.utils.Driver;
import Testinium.utils.Helper;
import Testinium.utils.Log4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiePolicyButton;
    @FindBy(css = ".o-modal__closeButton.bwi-close")
    public WebElement genderPopupCloseBtn;
    @FindBy(css = ".o-header__logo--img")
    public WebElement websiteLogo;
    @FindBy(css = ".default-input.o-header__search--input")
    public WebElement searchBox;

    public void clickAcceptCookiePolicyButton() {
        clickElement(acceptCookiePolicyButton);
        Log4j.step("Clicked on the Accept Cookie Policy Button.");
    }
    public void clickGenderPopupCloseBtn() {
        clickElement(genderPopupCloseBtn);
        Log4j.step("Clicked the close button on the gender selection screen");
    }
    public void homePageIsOpened() {
        Assert.assertTrue(isDisplayed(websiteLogo));
        Log4j.step("Login to the home page is verifie");
    }
    public void typeSearchBox(String value) {
        sendKeysElement(searchBox,value);
        Log4j.step("Data is typed into the search button");
    }
    public void clearSearchBox() {
        clearElement(searchBox);
        Log4j.step("Search input is cleared");
    }
    public void EnterToSearchBox() {
        KeysEnter(searchBox);
        Log4j.step("Click the enter button on the keyboard.");
    }
}
