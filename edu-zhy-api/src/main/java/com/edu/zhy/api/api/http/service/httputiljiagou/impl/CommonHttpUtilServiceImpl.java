package com.edu.zhy.api.api.http.service.httputiljiagou.impl;

import com.edu.zhy.api.api.http.enums.RequestType;
import com.edu.zhy.api.api.http.service.httputiljiagou.AbstractHttpService;
import com.edu.zhy.api.api.http.service.httputiljiagou.Context.CommonContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.back.CommonResponse;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.CommonParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * *
 */

@Slf4j
@Service
public class CommonHttpUtilServiceImpl extends AbstractHttpService<CommonContext, CommonParam, CommonResponse> {


    @Override
    public Integer getHttpType() {
        return RequestType.COMMON_TYPE.getType();
    }

    @Override
    public void preCheck(CommonContext commonContext, CommonParam commonParam) {

    }

    @Override
    public void Execute(CommonContext commonContext, CommonParam commonParam) {

    }

    @Override
    public CommonResponse backExecute(CommonContext commonContext, CommonParam commonParam) {
        return null;
    }

    @Override
    public void afterExecute(CommonContext commonContext, CommonParam commonParam) {

    }


}
