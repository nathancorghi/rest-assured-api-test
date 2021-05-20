package com.automation.factory;

import com.automation.model.request.UsersRequest;
import org.springframework.stereotype.Component;

@Component
public class UsersFactory {

    public UsersRequest buildUser() {

        return UsersRequest.builder()
                .name("morpheus")
                .job("leader")
                .build();
    }
}