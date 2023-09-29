package Testinium.stepdefs;

import Testinium.utils.Driver;
import Testinium.utils.Log4j;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        Log4j.info(String.format("Starting Test: '%s'", scenario.getName()));
        
        String configLocation = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "log4j.properties").toString();
        PropertyConfigurator.configure(configLocation);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed", new ByteArrayInputStream(screenshot));
        }

        Driver.closeDriver();
        Log4j.info(String.format("Test completed.(Status: %s)", scenario.getStatus()));
    }
}
