package com.automation.model.response;

import com.automation.model.Data;
import com.automation.model.Support;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserConsultSingleResponse extends ResponseError {

    private Data data;

    private Support support;
}