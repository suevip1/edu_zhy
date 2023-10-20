package com.edu.zhy.api.api.http.service.httputiljiagou.impl;

import com.edu.zhy.api.api.http.enums.RequestType;
import com.edu.zhy.api.api.http.service.httputiljiagou.AbstractHttpService;
import com.edu.zhy.api.api.http.service.httputiljiagou.Context.PolyvContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.back.PolyvResponse;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.PolyvParam;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class PolyvHttpUtilServiceImpl extends AbstractHttpService<PolyvContext, PolyvParam, PolyvResponse> {
    @Override
    public Integer getHttpType() {
        return RequestType.PAOLIVAY_TYPE.getType();
    }

    @Override
    public void preCheck(PolyvContext polyvContext, PolyvParam polyvParam) {

        if (Objects.isNull(polyvContext) || Objects.isNull(polyvContext.getUrl())){
            throw new BusinessException(-100,"PolyvHttpUtilServiceImpl url都没有还跑个屁啊");
        }

        if (Objects.isNull(polyvParam) || polyvParam.getParamMap().isEmpty()){
            throw new BusinessException(-100,"PolyvHttpUtilServiceImpl 参数都没有你还想跑接口想屁吃");
        }

    }

    @Override
    public void Execute(PolyvContext polyvContext, PolyvParam polyvParam) {
//
//        List<Object> argList = new ArrayList<>();
//
//        Map<String, String> paramMap = polyvParam.getParamMap();
//
//        if (paramMap.isEmpty()) return;
//
//
//        Map<String, String> headerMap = new HashMap<>();
//        headerMap.put("Content-Type", polyvContext.getContentType());
//        headerMap.put("Cookie", CookieType.COOKIE_TYPE_V1.getCookies());
//        headerMap.put("User-Agent", UserEquipmentType.USER_EQUIPMENT_TYPE_V1.getUserMessage());
//
//
//        Map<String, Object> bodyMap = new HashMap<>();
//        bodyMap.put("app", polyvContext.getApp());
//        bodyMap.put("env", polyvContext.getEnv());
//        bodyMap.put("service", polyvContext.getService());
//        bodyMap.put("method", polyvContext.getMethod());
//        bodyMap.put("args", argList.add(paramMap));
//        bodyMap.put("sc", polyvContext.getSc());
//        bodyMap.put("timeout", polyvContext.getTimeout());
//        bodyMap.put("retries", polyvContext.getRetries());





    }

    @Override
    public PolyvResponse backExecute(PolyvContext polyvContext, PolyvParam polyvParam) {
        return null;
    }

    @Override
    public void afterExecute(PolyvContext polyvContext, PolyvParam polyvParam) {

    }


}
