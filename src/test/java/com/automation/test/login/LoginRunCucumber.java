package com.automation.test.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features/login",
        glue = {"com.automation.test.login"},
        plugin = {"pretty", "json:target/cucumber/login/login.json"}
)
public class LoginRunCucumber {

}