package com.automation.test.login;

import com.automation.factory.LoginFactory;
import com.automation.model.LoginRequest;
import com.automation.model.LoginResponse;
import com.automation.service.LoginService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginStepDefinitions {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginFactory loginFactory;

    private LoginRequest loginRequest;

    private LoginResponse loginResponse;

    @Given("I have a valid credential")
    public void i_have_a_valid_credential() {

        loginRequest = loginFactory.buildLogin();
    }

    @When("I call the login API")
    public void i_call_the_login_api() {

        loginResponse = loginService.post(loginRequest);
    }

    @Then("should return the token successfully")
    public void should_return_the_token_successfully() {

        Assert.assertNotNull(loginResponse.getToken());
    }
}