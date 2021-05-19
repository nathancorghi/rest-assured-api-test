package com.automation.service;

import com.automation.model.request.RegisterRequest;
import com.automation.model.response.RegisterResponse;
import com.automation.model.response.ResponseData;
import org.springframework.stereotype.Service;

@Service
public class RegisterService extends AbstractService {

    private static final String URL = "/api/register";

    public ResponseData<RegisterResponse> register(RegisterRequest registerRequest) {

        return requestUtils.post(URL, registerRequest, RegisterResponse.class);
    }
}