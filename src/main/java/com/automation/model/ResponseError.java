package com.automation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError<T> {

    public T error;
}