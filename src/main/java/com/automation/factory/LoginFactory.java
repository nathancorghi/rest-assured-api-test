package com.automation.factory;

import com.automation.model.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class LoginFactory {

    public LoginRequest buildLogin() {

        return LoginRequest.builder()
                .email("michael.lawson@reqres.in")
                .password("7")
                .build();
    }
}