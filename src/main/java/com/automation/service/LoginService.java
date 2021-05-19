package com.automation.service;

import com.automation.model.request.LoginRequest;
import com.automation.model.response.LoginResponse;
import com.automation.model.response.ResponseData;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService {

    private static final String URL = "/api/login";

    public ResponseData<LoginResponse> login(LoginRequest loginRequest) {

        return requestUtils.post(URL, loginRequest, LoginResponse.class);
    }
}