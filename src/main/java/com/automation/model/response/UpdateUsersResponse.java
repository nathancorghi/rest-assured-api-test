package com.automation.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateUsersResponse extends ResponseError {

    private String name;

    private String job;

    private Date updatedAt;
}