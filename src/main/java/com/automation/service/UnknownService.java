package com.automation.service;

import com.automation.model.response.ResponseData;
import com.automation.model.response.UnknownListConsultResponse;
import org.springframework.stereotype.Service;

@Service
public class UnknownService extends AbstractService {

    private static final String URL_CONSULT_LIST_RESOURCES = "/api/unknown?page={0}";

    public ResponseData<UnknownListConsultResponse> consultListOfResources(Integer page) {

        return requestUtils.get(URL_CONSULT_LIST_RESOURCES, UnknownListConsultResponse.class, page);
    }
}