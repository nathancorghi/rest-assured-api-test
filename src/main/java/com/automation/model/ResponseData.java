package com.automation.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ResponseData<T> {

    public T data;

    public int statusCode;
}