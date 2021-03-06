package com.automation.model.response;

import com.automation.model.UsersData;
import com.automation.model.AbstractPage;
import com.automation.model.Support;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersListConsultResponse extends AbstractPage {

    private List<UsersData> data;

    private Support support;
}