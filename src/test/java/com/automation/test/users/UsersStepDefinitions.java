package com.automation.test.users;

import com.automation.factory.UsersFactory;
import com.automation.factory.RegisterFactory;
import com.automation.model.request.UsersRequest;
import com.automation.model.request.RegisterRequest;
import com.automation.model.response.*;
import com.automation.service.RegisterService;
import com.automation.service.UsersService;
import com.automation.utils.DateUtils;
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

    @Autowired
    private UsersFactory usersFactory;

    private RegisterRequest registerRequest;

    private ResponseData<RegisterResponse> registerResponse;

    private ResponseData<UsersConsultResponse> usersConsultResponse;

    private UsersRequest createUsersRequest;

    private ResponseData<CreateUsersResponse> createUsersResponse;

    private UsersRequest updateUsersRequest;

    private ResponseData<UpdateUsersResponse> updateUsersResponse;

    private Integer id;

    private ResponseData<?> deleteUserResponse;

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

    @Given("I'm including a new user")
    public void im_including_a_new_user() {

        createUsersRequest = usersFactory.buildUser();
    }

    @Given("I have a user created")
    public void i_have_a_user_created() {

        createUsersRequest = usersFactory.buildUser();
        createUsersResponse = usersService.createUser(createUsersRequest);
        id = createUsersResponse.getData().getId();
    }

    @When("I consult the information of user using id")
    public void i_consult_the_information_of_user_using_id() {

        usersConsultResponse = usersService.consultSingleUser(registerResponse.getData().getId());
    }

    @When("I call the API for add a new user")
    public void i_call_the_API_for_add_a_new_user() {

        createUsersResponse = usersService.createUser(createUsersRequest);
    }

    @When("I call the API to update the user name")
    public void i_call_the_api_to_update_the_user_name() {

        updateUsersRequest = createUsersRequest;
        updateUsersRequest.setName("morpheus name changed");
        updateUsersResponse = usersService.updateUser(id, updateUsersRequest);
    }

    @When("I call the API to update the user job")
    public void i_call_the_api_to_update_the_user_job() {

        updateUsersRequest = createUsersRequest;
        updateUsersRequest.setJob("major");
        updateUsersResponse = usersService.updateUser(id, updateUsersRequest);
    }

    @When("I call the API to delete the user")
    public void i_call_the_API_to_delete_the_user() {

        deleteUserResponse = usersService.deleteUser(id);
    }

    @Then("should return the user information correctly")
    public void should_return_the_user_information_correctly() {

        Assert.assertEquals(usersConsultResponse.getStatusCode(), 200);
        Assert.assertEquals(usersConsultResponse.getData().getData().getId(), registerResponse.getData().getId());
        Assert.assertEquals(usersConsultResponse.getData().getData().getEmail(), registerRequest.getEmail());
        Assert.assertNotNull(usersConsultResponse.getData().getData().getLast_name());
        Assert.assertNotNull(usersConsultResponse.getData().getData().getAvatar());
        Assert.assertNotNull(usersConsultResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(usersConsultResponse.getData().getSupport().getText());
    }

    @Then("should not return any information of user")
    public void should_not_return_any_information_of_user() {

        Assert.assertEquals(usersConsultResponse.getStatusCode(), 404);
    }

    @Then("should create successful a new user")
    public void should_create_successful_a_new_user() {

        Assert.assertEquals(createUsersResponse.getStatusCode(), 201);
        Assert.assertEquals(createUsersResponse.getData().getName(), createUsersRequest.getName());
        Assert.assertEquals(createUsersResponse.getData().getJob(), createUsersRequest.getJob());
        Assert.assertTrue(createUsersResponse.getData().getId() > 0);
        Assert.assertEquals(DateUtils.formattedDateTimeWithoutSeconds(createUsersResponse.getData().getCreatedAt()),
                DateUtils.getActualDateAndTime());
    }

    @Then("should change the user name successfully")
    public void should_change_the_user_name_successfully() {

        Assert.assertEquals(updateUsersResponse.getStatusCode(), 200);
        Assert.assertEquals(updateUsersResponse.getData().getName(), updateUsersRequest.getName());
        Assert.assertEquals(DateUtils.formattedDateTimeWithoutSeconds(updateUsersResponse.getData().getUpdatedAt()),
                DateUtils.getActualDateAndTime());
    }

    @Then("should change the user job successfully")
    public void should_change_the_user_job_successfully() {

        Assert.assertEquals(updateUsersResponse.getStatusCode(), 200);
        Assert.assertEquals(updateUsersResponse.getData().getJob(), updateUsersRequest.getJob());
        Assert.assertEquals(DateUtils.formattedDateTimeWithoutSeconds(updateUsersResponse.getData().getUpdatedAt()),
                DateUtils.getActualDateAndTime());
    }

    @Then("should remove the user successfully")
    public void should_remove_the_user_successfully() {

        Assert.assertEquals(deleteUserResponse.getStatusCode(), 204);
    }
}