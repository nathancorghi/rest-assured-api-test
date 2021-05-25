package com.automation.model.response;

import com.automation.model.Support;
import com.automation.model.UnknownData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnknownConsultResponse {

    private UnknownData data;

    private Support support;
}