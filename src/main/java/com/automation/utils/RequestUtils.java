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
import java.text.MessageFormat;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Component
public class RequestUtils {

    @Autowired
    private Gson gson;

    private Response response;

    private RequestSpecification requestSpecification;

    private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    public <T> ResponseData<T> post(String url, Object request, Class<T> clazz) {

        ResponseData<T> responseData = new ResponseData<>();

        requestInitialization();

        response = requestSpecification
                .body(gson.toJson(request))
                .post(url);

        logger.info("REQUEST -> Executing POST on {}", url);
        logger.info("REQUEST -> Body: {}", gson.newBuilder().setPrettyPrinting().create().toJson(request));
        logger.info("STATUS -> Code {}", response.statusCode());
        logger.info("RESPONSE -> Body {}", gson.newBuilder().setPrettyPrinting().create().toJson(response.getBody().as(Object.class)));

        responseData.setData(response.then().extract().response().getBody().as((Type) clazz));
        responseData.setStatusCode(response.then().extract().response().getStatusCode());
        responseData.setError(response.then().extract().response().getBody().jsonPath().get("error"));

        return responseData;
    }

    public <T> ResponseData<T> get(String url, Class<T> clazz, Object... endpointParameters) {

        url = MessageFormat.format(url, endpointParameters);

        ResponseData<T> responseData = new ResponseData<>();

        requestInitialization();

        response = requestSpecification
                .get(url);

        logger.info("REQUEST -> Executing GET on {}", url);
        logger.info("STATUS -> Code {}", response.statusCode());
        logger.info("RESPONSE -> Body {}", gson.newBuilder().setPrettyPrinting().create().toJson(response.getBody().as(Object.class)));

        responseData.setData(response.then().extract().response().getBody().as((Type) clazz));
        responseData.setStatusCode(response.then().extract().response().getStatusCode());

        return responseData;
    }

    public <T> ResponseData<T> put(String url, Object request, Class<T> clazz, Object... endpointParameters) {

        url = MessageFormat.format(url, endpointParameters);

        ResponseData<T> responseData = new ResponseData<>();

        requestInitialization();

        response = requestSpecification
                .body(gson.toJson(request))
                .put(url);

        logger.info("REQUEST -> Executing PUT on {}", url);
        logger.info("REQUEST -> Body: {}", gson.newBuilder().setPrettyPrinting().create().toJson(request));
        logger.info("STATUS -> Code {}", response.statusCode());
        logger.info("RESPONSE -> Body {}", gson.newBuilder().setPrettyPrinting().create().toJson(response.getBody().as(Object.class)));

        responseData.setData(response.then().extract().response().getBody().as((Type) clazz));
        responseData.setStatusCode(response.then().extract().response().getStatusCode());

        return responseData;
    }

    public <T> ResponseData<T> delete(String url, Object... endpointParameters) {

        url = MessageFormat.format(url, endpointParameters);

        ResponseData<T> responseData = new ResponseData<>();

        requestInitialization();

        response = requestSpecification
                .delete(url);

        logger.info("REQUEST -> Executing DELETE on {}", url);
        logger.info("STATUS -> Code {}", response.statusCode());

        responseData.setStatusCode(response.then().extract().response().getStatusCode());

        return responseData;
    }

    private void requestInitialization() {

        RestAssured.baseURI = Constants.BASE_URL;

        requestSpecification = RestAssured.given();

        requestSpecification.contentType(APPLICATION_JSON_VALUE);
    }
}