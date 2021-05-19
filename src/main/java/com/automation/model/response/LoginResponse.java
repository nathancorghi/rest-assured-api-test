package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse extends ResponseError {

    private String token;
}