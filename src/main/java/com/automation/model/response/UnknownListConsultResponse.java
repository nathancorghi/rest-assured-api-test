package com.automation.model.response;

import com.automation.model.AbstractPage;
import com.automation.model.Support;
import com.automation.model.UnknownData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnknownListConsultResponse extends AbstractPage {

    private List<UnknownData> data;

    private Support support;
}