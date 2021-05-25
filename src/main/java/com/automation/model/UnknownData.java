package com.automation.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnknownData {

    private Integer id;

    private String name;

    private Long year;

    private String color;

    @SerializedName("pantone_value")
    private String pantoneValue;
}