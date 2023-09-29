package Testinium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    private final WebDriver driver = Driver.get();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void WaitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectByValue(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void KeysEnter(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(Keys.RETURN);
    }

    public void clearElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = '';", element);
    }

    public void disappearElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void sendKeysElement(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }

    public String getType(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getAttribute("type");
    }

    public String getValue(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getAttribute("value");
    }

    public Boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}