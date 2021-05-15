package com.automation.service;

import com.automation.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    @Autowired
    protected RequestUtils requestUtils;
}