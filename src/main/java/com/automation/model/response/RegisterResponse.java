package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse extends ResponseError {

    private Integer id;

    private String token;
}