package com.automation.utils;

import com.automation.Constants;
import com.automation.service.AbstractService;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestUtils extends AbstractService {

    @Autowired
    protected Gson gson;

    @Autowired
    protected ResponseUtils responseUtils;

    private RequestSpecification requestSpecification;

    private Response response;

    public <T> ResponseUtils<T> post(String url, Object request, Class<T> clazz) {

        RestAssured.baseURI = Constants.BASE_URL;

        requestSpecification = RestAssured.given();

        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.body(gson.toJson(request))
                .post(url);

        responseUtils.setData(response.then().extract().response().getBody().as(clazz));
        responseUtils.setStatusCode(response.then().extract().response().getStatusCode());

        return responseUtils;
    }
}