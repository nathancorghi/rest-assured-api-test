package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateUsersResponse extends ResponseError {

    private String name;

    private String job;

    private int id;

    private Date createdAt;
}