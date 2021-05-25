package com.automation.test.login;

import com.automation.factory.LoginFactory;
import com.automation.model.request.LoginRequest;
import com.automation.model.response.LoginResponse;
import com.automation.service.LoginService;
import com.automation.model.response.ResponseData;
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

    private ResponseData<LoginResponse> loginResponse;

    @Given("I have a valid credential")
    public void i_have_a_valid_credential() {

        loginRequest = loginFactory.buildLogin();
    }

    @Given("I have a invalid credential")
    public void i_have_a_invalid_credential() {

        loginRequest = loginFactory.buildLogin();
        loginRequest.setEmail("michael.lawson@reqres.ini");
    }

    @Given("I have a credential without fill field email")
    public void i_have_a_credential_without_fill_field_email() {

        loginRequest = loginFactory.buildLogin();
        loginRequest.setEmail(null);
    }

    @Given("I have a credential without fill field password")
    public void i_have_a_credential_without_fill_field_password() {

        loginRequest = loginFactory.buildLogin();
        loginRequest.setPassword(null);
    }

    @When("I call the login API")
    public void i_call_the_login_api() {

        loginResponse = loginService.login(loginRequest);
    }

    @Then("should return the token successfully")
    public void should_return_the_token_successfully() {

        Assert.assertEquals(loginResponse.getStatusCode(), 200);
        Assert.assertNotNull(loginResponse.getData().getToken());
    }

    @Then("should return the message of {string}")
    public void should_return_the_message_of(String message) {

        Assert.assertEquals(loginResponse.getStatusCode(), 400);
        Assert.assertEquals(loginResponse.getError(), message);
    }
}