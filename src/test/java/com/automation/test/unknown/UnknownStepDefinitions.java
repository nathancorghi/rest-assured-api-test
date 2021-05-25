package com.automation.test.unknown;

import com.automation.model.response.ResponseData;
import com.automation.model.response.UnknownListConsultResponse;
import com.automation.service.UnknownService;
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

    @Given("I have the page number {int} to consult resource information")
    public void i_have_the_page_number_to_consult_resource_information(Integer page) {

        this.page = page;
    }

    @When("I consult the information of resource using page number")
    public void i_consult_the_information_of_resource_using_page_number() {

        unknownListConsultResponse = unknownService.consultListOfResources(page);
    }

    @Then("should return the resource information correctly")
    public void should_return_the_resource_information_correctly() {

        Assert.assertEquals(unknownListConsultResponse.getStatusCode(), 200);
        Assert.assertEquals(unknownListConsultResponse.getData().getPage(), page);
        Assert.assertNotNull(unknownListConsultResponse.getData().getPer_page());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotal());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotal_pages());

        unknownListConsultResponse.getData().getData().forEach(
                data -> {
                    Assert.assertNotNull(data.getId());
                    Assert.assertNotNull(data.getName());
                    Assert.assertNotNull(data.getYear());
                    Assert.assertNotNull(data.getColor());
                    Assert.assertNotNull(data.getPantone_value());
                }
        );

        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getText());
    }

    @Then("should not return resource information")
    public void should_not_return_resource_information() {

        Assert.assertEquals(unknownListConsultResponse.getStatusCode(), 200);
        Assert.assertEquals(unknownListConsultResponse.getData().getPage(), page);
        Assert.assertNotNull(unknownListConsultResponse.getData().getPer_page());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotal());
        Assert.assertNotNull(unknownListConsultResponse.getData().getTotal_pages());
        Assert.assertTrue(unknownListConsultResponse.getData().getData().isEmpty());
        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getUrl());
        Assert.assertNotNull(unknownListConsultResponse.getData().getSupport().getText());
    }
}