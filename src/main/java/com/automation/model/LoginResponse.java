package com.automation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse extends ResponseError {

    private String token;
}