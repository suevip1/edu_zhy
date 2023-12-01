package com.edu.zhy.api.api.http.service.httputiljiagou.executeabstract;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.enums.CookieType;
import com.edu.zhy.api.api.http.service.httputiljiagou.enums.CommonRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractHttpUtil {


    /**
     * *共同属性
     * @param request
     * @param isRequest
     * @param getMapName
     * @param args
     * @param <T>
     * @return
     */
    public static  <T extends AbstractHttpRequest> T  buildAbstractHttpRequest(T request ,String url ,Boolean isRequest , List<String> getMapName, String args,Map<String,Integer> postMapName ){

        request.setUrl(url);
        request.setIsRequest(isRequest);
        request.setExampleUrl(CommonRequest.EXAMPLE_URL.getName());
        request.setGetMapName(getMapName);
        request.setContentType(CommonRequest.CONTENT_TYPE.getName());
        request.setCookie(CookieType.COOKIE_TYPE_V2.getCookies());
        request.setUserAgent(CommonRequest.USER_AGENT.getName());
        request.setApp(CommonRequest.APP.getName());
        request.setEnv(CommonRequest.ENV.getName());
        request.setService(CommonRequest.SERVICE.getName());
        request.setMethod(CommonRequest.METHOD.getName());
        //这个参数可以不用传
        request.setArgs(args);

        request.setPostMapName(postMapName);

        request.setSc(CommonRequest.SC.getName());
        request.setTimeout(CommonRequest.TIMEOUT.getName());
        request.setRetries(CommonRequest.RETRIES.getName());
        request.setCacheControl(CommonRequest.CACHE_CONTROL.getName());

        return request;
    }



    //共同属性

    /**
     * * 参数的共同属性
     * @param param
     * @param paramMap
     * @param <V>
     * @return
     */
    public static  <V extends AbstractHttpParam> V buildAbstractHttpParam(V param, Map<String, String> paramMap ){

        param.setParamMap(paramMap);

        return param;
    }




}