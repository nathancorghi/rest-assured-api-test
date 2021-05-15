package com.automation.utils;

import com.automation.Constants;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestUtils {

    @Autowired
    protected Gson gson;

    private RequestSpecification requestSpecification;

    private Response response;

    public <T> Object post(Object request, String url, Class<T> clazz) {

        RestAssured.baseURI = Constants.BASE_URL;

        requestSpecification = RestAssured.given();

        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.body(gson.toJson(request))
                .post(url);

        return response.then().extract().response().body().as(clazz);
    }
}