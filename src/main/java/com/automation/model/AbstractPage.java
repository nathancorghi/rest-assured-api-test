package com.automation.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractPage {

    private Integer page;

    @SerializedName("per_page")
    private Integer perPage;

    private Integer total;

    @SerializedName("total_pages")
    private Integer totalPages;
}