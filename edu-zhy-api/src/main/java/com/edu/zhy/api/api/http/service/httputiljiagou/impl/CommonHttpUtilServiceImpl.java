package com.edu.zhy.api.api.http.service.httputiljiagou.impl;

import com.edu.zhy.api.api.http.enums.RequestType;
import com.edu.zhy.api.api.http.service.httputiljiagou.AbstractHttpService;
import com.edu.zhy.api.api.http.service.httputiljiagou.Context.CommonContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.back.CommonResponse;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.CommonParam;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
        if (Objects.isNull(commonContext) || Objects.isNull(commonContext.getUrl())){
            throw new BusinessException(-100,"CommonHttpUtilServiceImpl url都没有还跑个屁啊");
        }

        if (Objects.isNull(commonParam) || commonParam.getParamMap().isEmpty()){
            throw new BusinessException(-100,"CommonHttpUtilServiceImpl 参数都没有你还想跑接口想屁吃");
        }

    }

    @Override
    public void Execute(CommonContext commonContext, CommonParam commonParam) {

//        List<Object> list = new ArrayList<>();
//
//        Map<String, String> paramMap = commonParam.getParamMap();
//
//        if (paramMap.isEmpty()) return;
//
//
//        Map<String, String> headerMap = new HashMap<>();
//        headerMap.put("Content-Type", commonContext.getContentType());
//        headerMap.put("Cookie", CookieType.COOKIE_TYPE_V1.getCookies());
//        headerMap.put("User-Agent", UserEquipmentType.USER_EQUIPMENT_TYPE_V1.getUserMessage());
//
//
//        Map<String, Object> bodyMap = new HashMap<>();
//        bodyMap.put("app", commonContext.getApp());
//        bodyMap.put("env", commonContext.getEnv());
//        bodyMap.put("service", commonContext.getService());
//        bodyMap.put("method", commonContext.getMethod());
//        bodyMap.put("args", list.add(paramMap));
//        bodyMap.put("sc", commonContext.getSc());
//        bodyMap.put("timeout", commonContext.getTimeout());
//        bodyMap.put("retries", commonContext.getRetries());


    }

    @Override
    public CommonResponse backExecute(CommonContext commonContext, CommonParam commonParam) {
        return null;
    }

    @Override
    public void afterExecute(CommonContext commonContext, CommonParam commonParam) {

    }


}
