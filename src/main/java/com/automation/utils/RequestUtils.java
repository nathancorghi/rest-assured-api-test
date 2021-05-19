package com.automation.utils;

import com.automation.Constants;
import com.automation.model.response.ResponseData;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class RequestUtils {

    @Autowired
    private Gson gson;

    private RequestSpecification requestSpecification;

    private Response response;

    private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    public <T> ResponseData<T> post(String url, Object request, Class<T> clazz) {

        ResponseData<T> responseData = new ResponseData<>();

        RestAssured.baseURI = Constants.BASE_URL;

        requestSpecification = RestAssured.given();

        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.body(gson.toJson(request))
                .post(url);

        logger.info("REQUEST -> Executing POST on {}", url);
        logger.info("REQUEST -> Body: {}", gson.newBuilder().setPrettyPrinting().create().toJson(request));
        logger.info("STATUS -> Code {}", response.statusCode());
        logger.info("RESPONSE -> Body {}", gson.newBuilder().setPrettyPrinting().create().toJson(response.getBody().as(Object.class)));

        responseData.setData(response.then().extract().response().getBody().as((Type) clazz));
        responseData.setStatusCode(response.then().extract().response().getStatusCode());
        responseData.setError(response.then().extract().response().getBody().as((Type) clazz));

        return responseData;
    }

    public <T> ResponseData<T> get(String url, Class<T> clazz, Object... endpointParameters) {

        ResponseData<T> responseData = new ResponseData<>();

        RestAssured.baseURI = Constants.BASE_URL;

        requestSpecification = RestAssured.given();

        requestSpecification.header("Content-Type", "application/json");

        response = requestSpecification.get(url, endpointParameters);

        logger.info("REQUEST -> Executing POST on {}", url);
        logger.info("STATUS -> Code {}", response.statusCode());
        logger.info("RESPONSE -> Body {}", gson.newBuilder().setPrettyPrinting().create().toJson(response.getBody().as(Object.class)));

        responseData.setData(response.then().extract().response().getBody().as((Type) clazz));
        responseData.setStatusCode(response.then().extract().response().getStatusCode());
        responseData.setError(response.then().extract().response().getBody().as((Type) clazz));

        return responseData;
    }
}