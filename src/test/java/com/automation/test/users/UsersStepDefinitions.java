package com.automation.test.users;

import com.automation.factory.RegisterFactory;
import com.automation.model.request.RegisterRequest;
import com.automation.model.response.RegisterResponse;
import com.automation.model.response.ResponseData;
import com.automation.model.response.UserConsultResponse;
import com.automation.service.RegisterService;
import com.automation.service.UsersService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersStepDefinitions {

    @Autowired
    private RegisterFactory registerFactory;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UsersService usersService;

    private RegisterRequest registerRequest;

    private ResponseData<RegisterResponse> registerResponse;

    private ResponseData<UserConsultResponse> usersResponse;

    @Given("I have an user already registered")
    public void i_have_an_user_already_registered() {

        registerRequest = registerFactory.buildRegister();
        registerResponse = registerService.register(registerRequest);
    }

    @Given("I have an unregistered user")
    public void i_have_an_unregistered_user() {

        registerRequest = registerFactory.buildRegister();
        registerRequest.setEmail("eve.holt@reqres.ini");
        registerResponse = registerService.register(registerRequest);
    }

    @When("I consult the information of user using id")
    public void i_consult_the_information_of_user_using_id() {

        usersResponse = usersService.consultSingleUser(registerResponse.getData().getId());
    }

    @Then("should return the user information correctly")
    public void should_return_the_user_information_correctly() {

        Assert.assertEquals(usersResponse.getStatusCode(), 200);
        Assert.assertEquals(usersResponse.getData().getData().getId(), registerResponse.getData().getId());
        Assert.assertEquals(usersResponse.getData().getData().getEmail(), registerRequest.getEmail());
        Assert.assertNotNull(usersResponse.getData().getData().getLast_name());
        Assert.assertNotNull(usersResponse.getData().getData().getAvatar());
        Assert.assertNotNull(usersResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(usersResponse.getData().getSupport().getText());
    }

    @Then("should not return any information of user")
    public void should_not_return_any_information_of_user() {

        Assert.assertEquals(usersResponse.getStatusCode(), 404);
    }
}