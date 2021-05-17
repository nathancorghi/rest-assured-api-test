package com.automation.utils;

import com.automation.Constants;
import com.automation.model.ResponseData;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestUtils {

    @Autowired
    private Gson gson;

    @Autowired
    private ResponseData responseData;

    private RequestSpecification requestSpecification;

    private Response response;

    private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    public <T> ResponseData<T> post(String url, Object request, Class<T> clazz) {

        RestAssured.baseURI = Constants.BASE_URL;

        requestSpecification = RestAssured.given();

        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.body(gson.toJson(request))
                .post(url);

        logger.info("REQUEST -> Executing POST on {}", url);
        logger.info("REQUEST -> Body: {}", gson.newBuilder().setPrettyPrinting().create().toJson(request));
        logger.info("STATUS -> Code {}", response.statusCode());
        logger.info("RESPONSE -> Body {}", gson.newBuilder().setPrettyPrinting().create().toJson(response.getBody().as(Object.class)));

        responseData.setData(response.then().extract().response().getBody().as(clazz));
        responseData.setStatusCode(response.then().extract().response().getStatusCode());

        return responseData;
    }
}