package com.automation.test.unknown;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features/unknown",
        glue = {"com.automation.test.unknown"},
        plugin = {"pretty", "json:target/cucumber/unknown/unknown.json"}
)
public class UnknownRunCucumber {

}
