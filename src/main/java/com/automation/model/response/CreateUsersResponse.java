package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUsersResponse {

    private String name;

    private String job;

    private Integer id;

    private Date createdAt;
}