package com.automation.test.register;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features/register",
        glue = {"com.automation.test.register"},
        plugin = {"pretty", "json:target/cucumber/register/register.json"}
)
public class RegisterRunCucumber {

}