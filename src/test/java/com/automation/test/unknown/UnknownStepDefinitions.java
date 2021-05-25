package com.automation.test.unknown;

import com.automation.model.response.ResponseData;
import com.automation.model.response.UnknownConsultResponse;
import com.automation.model.response.UnknownListConsultResponse;
import com.automation.service.UnknownService;
import com.automation.utils.IntegerUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnknownStepDefinitions {

    @Autowired
    private UnknownService unknownService;

    private ResponseData<UnknownListConsultResponse> unknownListConsultResponse;

    private Integer page;

    private ResponseData<UnknownConsultResponse> unknownConsultResponse;

    private Integer id;

    @Given("I have the page number {int} to consult resource information")
    public void i_have_the_page_number_to_consult_resource_information(Integer page) {

        this.page = page;
    }

    @Given("I have an existing resource")
    public void i_have_an_existing_resource() throws InterruptedException {

        id = IntegerUtils.random(1, 12);
    }

    @Given("I have a non-existent resource")
    public void i_have_a_nonexistent_resource() throws InterruptedException {

        id = IntegerUtils.random(13, 99);
    }

    @When("I consult the information of resource using page number")
    public void i_consult_the_information_of_resource_using_page_number() {

        unknownListConsultResponse = unknownService.consultListOfResources(page);
    }

    @When("I consult the information of resource using id")
    public void i_consult_the_information_of_resource_using_id() {

        unknownConsultResponse = unknownService.consultSingleResource(id);
    }

    @Then("should return the resources information correctly")
    public void should_return_the_resources_information_correctly() {

        Assert.assertEquals(unknownListConsultResponse.getStatusCode(), 200);
        Assert.assertEquals(unknownListConsultResponse.getData().getPage(), page);
        Assert.assertNotNull(unknownListConsultResponse.getData().getPerPage());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotal());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotalPages());

        unknownListConsultResponse.getData().getData().forEach(
                data -> {
                    Assert.assertNotNull(data.getId());
                    Assert.assertNotNull(data.getName());
                    Assert.assertNotNull(data.getYear());
                    Assert.assertNotNull(data.getColor());
                    Assert.assertNotNull(data.getPantoneValue());
                }
        );

        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getText());
    }

    @Then("should not return resources information")
    public void should_not_return_resources_information() {

        Assert.assertEquals(unknownListConsultResponse.getStatusCode(), 200);
        Assert.assertEquals(unknownListConsultResponse.getData().getPage(), page);
        Assert.assertNotNull(unknownListConsultResponse.getData().getPerPage());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotal());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotalPages());
        Assert.assertTrue(unknownListConsultResponse.getData().getData().isEmpty());
        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getText());
    }

    @Then("should return the resource information correctly")
    public void should_return_the_resource_information_correctly() {

        Assert.assertEquals(unknownConsultResponse.getStatusCode(), 200);
        Assert.assertEquals(unknownConsultResponse.getData().getData().getId(), id);
        Assert.assertNotNull(unknownConsultResponse.getData().getData().getName());
        Assert.assertNotNull(unknownConsultResponse.getData().getData().getYear());
        Assert.assertNotNull(unknownConsultResponse.getData().getData().getColor());
        Assert.assertNotNull(unknownConsultResponse.getData().getData().getPantoneValue());
        Assert.assertNotNull(unknownConsultResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(unknownConsultResponse.getData().getSupport().getText());
    }

    @Then("should not return response data")
    public void should_not_return_response_data() {

        Assert.assertEquals(unknownConsultResponse.getStatusCode(), 404);
    }
}