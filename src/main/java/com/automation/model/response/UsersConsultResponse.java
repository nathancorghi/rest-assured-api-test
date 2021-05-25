package com.automation.model.response;

import com.automation.model.UsersData;
import com.automation.model.Support;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersConsultResponse {

    private UsersData data;

    private Support support;
}