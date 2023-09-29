package Testinium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = (System.getProperty("browserName") != null) ? System.getProperty("browserName") : ConfigReader.get("browserName");

            switch (browser.toLowerCase()) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().browserVersionDetectionCommand("google-chrome --version | cut -d ' ' -f 3");
                    driver = new ChromeDriver();
                }
                case "firefox" -> driver = new FirefoxDriver();
                case "firefox-headless" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless=new");
                    driver = new FirefoxDriver(options);
                }
                case "ie" -> {
                    if (!System.getProperty("os.names.txt").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    driver = new InternetExplorerDriver();
                }
                case "edge" -> {
                    if (!System.getProperty("os.names.txt").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    driver = new EdgeDriver();
                }
                case "safari" -> {
                    if (!System.getProperty("os.names.txt").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    driver = new SafariDriver();
                }
                default -> driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
