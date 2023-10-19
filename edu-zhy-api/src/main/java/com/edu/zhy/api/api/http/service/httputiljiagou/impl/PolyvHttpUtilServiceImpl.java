package com.edu.zhy.api.api.http.service.httputiljiagou.impl;

import com.edu.zhy.api.api.http.enums.RequestType;
import com.edu.zhy.api.api.http.service.httputiljiagou.AbstractHttpService;
import com.edu.zhy.api.api.http.service.httputiljiagou.Context.PolyvContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.back.PolyvResponse;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.PolyvParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PolyvHttpUtilServiceImpl extends AbstractHttpService<PolyvContext, PolyvParam, PolyvResponse> {
    @Override
    public Integer getHttpType() {
        return RequestType.PAOLIVAY_TYPE.getType();
    }

    @Override
    public void preCheck(PolyvContext polyvContext, PolyvParam polyvParam) {

    }

    @Override
    public void Execute(PolyvContext polyvContext, PolyvParam polyvParam) {

    }

    @Override
    public PolyvResponse backExecute(PolyvContext polyvContext, PolyvParam polyvParam) {
        return null;
    }

    @Override
    public void afterExecute(PolyvContext polyvContext, PolyvParam polyvParam) {

    }


}
