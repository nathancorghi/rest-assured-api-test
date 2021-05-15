package com.automation.service;

import com.automation.model.LoginRequest;
import com.automation.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService {

    private static final String URL = "/api/login";

    public LoginResponse login(LoginRequest loginRequest) {

        return (LoginResponse) requestUtils.post(loginRequest, URL, LoginResponse.class);
    }
}