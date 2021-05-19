package com.automation.service;

import com.automation.model.response.ResponseData;
import com.automation.model.response.UserConsultResponse;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends AbstractService {

    private static final String URL = "/api/users/{0}";

    public ResponseData<UserConsultResponse> consultSingleUser(Integer id) {

        return requestUtils.get(URL, UserConsultResponse.class, id);
    }
}