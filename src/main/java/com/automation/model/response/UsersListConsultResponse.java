package com.automation.model.response;

import com.automation.model.Data;
import com.automation.model.Support;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersListConsultResponse extends ResponseError {

    private Integer page;

    private Integer per_page;

    private Integer total;

    private Integer total_pages;

    private List<Data> data;

    private Support support;
}