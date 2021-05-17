package com.automation.service;

import com.automation.model.LoginRequest;
import com.automation.model.LoginResponse;
import com.automation.utils.ResponseUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService {

    private static final String URL = "/api/login";

    public ResponseUtils<LoginResponse> login(LoginRequest loginRequest) {

        return requestUtils.post(URL, loginRequest, LoginResponse.class);
    }
}