package com.automation.test.register;

import com.automation.factory.RegisterFactory;
import com.automation.model.request.RegisterRequest;
import com.automation.model.response.RegisterResponse;
import com.automation.model.response.ResponseData;
import com.automation.service.RegisterService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegisterStepDefinitions {

    @Autowired
    private RegisterFactory registerFactory;

    @Autowired
    private RegisterService registerService;

    private RegisterRequest registerRequest;

    private ResponseData<RegisterResponse> registerResponse;

    @Given("I have a valid credential")
    public void i_have_a_valid_credential() {

        registerRequest = registerFactory.buildRegister();
    }

    @Given("I have a invalid credential")
    public void i_have_a_invalid_credential() {

        registerRequest = registerFactory.buildRegister();
        registerRequest.setEmail("eve.holt@reqres.ini");
    }

    @Given("I have a credential without fill field email")
    public void i_have_a_credential_without_fill_field_email() {

        registerRequest = registerFactory.buildRegister();
        registerRequest.setEmail(null);
    }

    @Given("I have a credential without fill field password")
    public void i_have_a_credential_without_fill_field_password() {

        registerRequest = registerFactory.buildRegister();
        registerRequest.setPassword(null);
    }

    @When("I call the register API")
    public void i_call_the_register_api() {

        registerResponse = registerService.register(registerRequest);
    }

    @Then("should register successfully")
    public void should_register_successfully() {

        Assert.assertEquals(registerResponse.getStatusCode(), 200);
        Assert.assertTrue(registerResponse.getData().getId() > 0);
        Assert.assertNotNull(registerResponse.getData().getToken());
    }

    @Then("should return the message of {string}")
    public void should_return_the_message_of(String message) {

        Assert.assertEquals(registerResponse.getStatusCode(), 400);
        Assert.assertEquals(registerResponse.getError(), message);
    }
}