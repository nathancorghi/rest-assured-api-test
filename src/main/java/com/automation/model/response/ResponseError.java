package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError<T> {

    public T error;
}