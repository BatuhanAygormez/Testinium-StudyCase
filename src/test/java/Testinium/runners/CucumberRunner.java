package Testinium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty"
        },
        glue= {"Testinium.stepdefs"},
        features = "src/test/java/Testinium/features",
        tags = "",
        dryRun = false
)
public class CucumberRunner {

}
