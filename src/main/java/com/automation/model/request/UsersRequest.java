package com.automation.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsersRequest {

    private String name;

    private String job;
}