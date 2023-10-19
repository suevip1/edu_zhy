package com.edu.zhy.api.api.http.service.impl;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.dto.AbstractHttpResponse;
import com.edu.zhy.api.api.http.service.HttpUtilService;

public class PolyvHttpUtilServiceImpl implements HttpUtilService {
    @Override
    public Integer getHttpType() {
        return null;
    }

    @Override
    public void preCheck(AbstractHttpRequest abstractHttpRequest, AbstractHttpParam abstractHttpParam) {

    }

    @Override
    public void Execute(AbstractHttpRequest abstractHttpRequest, AbstractHttpParam abstractHttpParam) {

    }

    @Override
    public AbstractHttpResponse backExecute(AbstractHttpRequest abstractHttpRequest, AbstractHttpParam abstractHttpParam) {
        return null;
    }

    @Override
    public void afterExecute(AbstractHttpRequest abstractHttpRequest, AbstractHttpParam abstractHttpParam) {

    }
}
