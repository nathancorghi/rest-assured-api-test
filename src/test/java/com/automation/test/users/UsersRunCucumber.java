package com.automation.test.users;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features/users",
        glue = {"com.automation.test.users"},
        plugin = {"pretty", "json:target/cucumber/users/users.json"}
)
public class UsersRunCucumber {

}