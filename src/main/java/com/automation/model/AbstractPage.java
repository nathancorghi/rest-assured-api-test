package com.automation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractPage {

    private Integer page;

    private Integer per_page;

    private Integer total;

    private Integer total_pages;
}