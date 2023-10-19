package com.edu.zhy.api.api.http.service.impl;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.dto.AbstractHttpResponse;
import com.edu.zhy.api.api.http.enums.RequestType;
import com.edu.zhy.api.api.http.service.HttpUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * *
 */

@Slf4j
@Service
public class CommonHttpUtilServiceImpl implements HttpUtilService {


    @Override
    public Integer getHttpType() {
        return RequestType.COMMON_TYPE.getType();
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
