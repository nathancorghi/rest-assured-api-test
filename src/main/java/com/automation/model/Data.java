package com.automation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Data {

    private int id;

    private String email;

    private String first_name;

    private String last_name;

    private String avatar;
}