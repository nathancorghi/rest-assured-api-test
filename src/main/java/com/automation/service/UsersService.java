package com.automation.service;

import com.automation.model.request.UsersRequest;
import com.automation.model.response.*;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends AbstractService {

    private static final String URL_USER = "/api/users/{0}";

    private static final String URL_CREATE_USER = "/api/users";

    public ResponseData<UsersConsultResponse> consultSingleUser(Integer id) {

        return requestUtils.get(URL_USER, UsersConsultResponse.class, id);
    }

    public ResponseData<CreateUsersResponse> createUser(UsersRequest usersRequest) {

        return requestUtils.post(URL_CREATE_USER, usersRequest, CreateUsersResponse.class);
    }

    public ResponseData<UpdateUsersResponse> updateUser(Integer id, UsersRequest usersRequest) {

        return requestUtils.put(URL_USER, usersRequest, UpdateUsersResponse.class, id);
    }

    public ResponseData deleteUser(Integer id) {

        return requestUtils.delete(URL_USER, id);
    }
}