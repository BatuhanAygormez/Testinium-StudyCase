package Testinium.pages;

import Testinium.utils.ConfigReader;
import Testinium.utils.Driver;
import Testinium.utils.Helper;
import Testinium.utils.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Helper {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void openTheUrl(String url) {
        navigateToUrl(url);
        Log4j.step("Opened the Home Page with URL: " + url);
    }
}
