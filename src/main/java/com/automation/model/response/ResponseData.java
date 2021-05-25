package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {

    private T data;

    private int statusCode;

    private String error;
}