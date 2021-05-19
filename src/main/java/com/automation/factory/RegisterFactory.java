package com.automation.factory;

import com.automation.model.request.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterFactory {

    public RegisterRequest buildRegister() {

        return RegisterRequest.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
    }
}