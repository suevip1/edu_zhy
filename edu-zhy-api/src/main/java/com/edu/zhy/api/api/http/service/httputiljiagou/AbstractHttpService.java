package com.edu.zhy.api.api.http.service.httputiljiagou;

import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.dto.AbstractHttpResponse;
import com.edu.zhy.api.api.http.enums.CookieType;
import com.edu.zhy.api.api.http.enums.UserEquipmentType;
import com.edu.zhy.api.api.http.okhttp.OKHttpUtils;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * *这点抽象出来
 */
@Slf4j
@Component
public abstract class
AbstractHttpService<K extends AbstractHttpRequest,V extends AbstractHttpParam,T extends AbstractHttpResponse>
        extends AbstractGeneratorApplication
        implements HttpUtilService<K , V , T > {



    @Override
    public Integer getHttpType() {
        throw new BusinessException(-100);
    }


    /**
     * *发送请求接口
     * @param httpUtilRequest
     * *String url, Boolean isRequest, Map<String, Object> bodyMap, Map<String, String> headerMap
     */
    public void sendGetOrPost(SendHttpUtilRequest httpUtilRequest) {

        String result;

        if (httpUtilRequest.getIsRequest()){
            //get请求一般直接拼参数到url上面
            result = OKHttpUtils.getInstance().sendGet(httpUtilRequest.getUrl(),null);
        }else {
            //post 请求需要body 和请求头
            result = OKHttpUtils.getInstance()
                    .sendJsonPost(httpUtilRequest.getUrl(), httpUtilRequest.getHeaderMap(),
                            JSON.toJSONString(httpUtilRequest.getBodyMap()));
        }


        Map<String, Object> resultMap = JSON.parseObject(result, Map.class);
        if (0 != MapUtils.getInteger(resultMap, "code")) {
            System.out.println(result);
            throw new IllegalStateException("请求失败，返回code!=0");
        }

        Map<String, Object> dataMap = (Map<String, Object>) resultMap.get("data");
        if (200 != MapUtils.getInteger(dataMap, "code")) {
            System.out.println(result);
            throw new IllegalStateException("请求失败，返回code!=200");
        }

    }

    /**
     * *根据类型获取bean
     * @param type
     * @return
     */
    public static HttpCreateGenerator getGeneratorTypeBean(Integer type){
        return generatorHashMap.get(type);
    }





//    public AbstractHttpResponse sendGetOrPostV2(SendHttpUtilRequest httpUtilRequest) {
//
//        String result;
//
//        if (httpUtilRequest.getIsRequest()){
//            //get请求一般直接拼参数到url上面
//            result = OKHttpUtils.getInstance().sendGet(httpUtilRequest.getUrl(),null);
//        }else {
//            //post 请求需要body 和请求头
//            result = OKHttpUtils.getInstance()
//                    .sendJsonPost(httpUtilRequest.getUrl(), httpUtilRequest.getHeaderMap(),
//                            JSON.toJSONString(httpUtilRequest.getBodyMap()));
//        }
//
//
//        Map<String, Object> resultMap = JSON.parseObject(result, Map.class);
//
////        if (0 != MapUtils.getInteger(resultMap, "code")) {
////            System.out.println(result);
////            throw new IllegalStateException("请求失败，返回code!=0");
////        }
////
////        Map<String, Object> dataMap = (Map<String, Object>) resultMap.get("data");
////        if (200 != MapUtils.getInteger(dataMap, "code")) {
////            System.out.println(result);
////            throw new IllegalStateException("请求失败，返回code!=200");
////        }
//        if (!resultMap.isEmpty()){
//
//
//        }
//
//
//        return null;
//    }




    /**
     * *构建请求参数
     * * /这里需要在抽象出来一个共同的方法来决定抽象的参数  get请求和post请求的 参数
     * @param sendHttpContext
     * @return
     */
    public SendHttpUtilRequest buildGetOrPost(SendHttpContext sendHttpContext){
        SendHttpUtilRequest request = new SendHttpUtilRequest();
        if (Objects.isNull(sendHttpContext)
                || Objects.isNull(sendHttpContext.getAbstractHttpRequest())
        || Objects.isNull(sendHttpContext.getAbstractHttpParam())) {
            log.info("buildGetOrPost 失败参数有为空的 sendHttpContext:{}",sendHttpContext);
            return request;
        }

        if (sendHttpContext.getAbstractHttpRequest().getIsRequest()){
            //这里get请求转换
            request = buildGet(sendHttpContext.getAbstractHttpRequest(),sendHttpContext.getAbstractHttpParam(),request);
        }else {
            //这里post请求转换
            request = buildPost(sendHttpContext.getAbstractHttpRequest(),sendHttpContext.getAbstractHttpParam(),request);
        }

        return request;
    }


    /**
     * *get参数转换
     * @param abstractHttpRequest
     * @param abstractHttpParam
     * @param request
     * @return
     */
    public SendHttpUtilRequest buildGet(AbstractHttpRequest abstractHttpRequest,AbstractHttpParam abstractHttpParam,
                                        SendHttpUtilRequest request){
        Map<String, String> paramMap = abstractHttpParam.getParamMap();
        String url = abstractHttpRequest.getUrl();
        //这里面最智能的就是把格式进行检验;不然每次都要手动弄下
        //这里面还要加参数  1:存请求的网址格式 2:存请求的字段,到时候可以在map里面取值
        url = buildPreGetUrl(url, abstractHttpRequest.getExampleUrl(),abstractHttpRequest.getGetMapName(), paramMap);

        String body = Joiner.on("&").withKeyValueSeparator("=").join(paramMap);

        url = Joiner.on("?").join(url, body);

        request.setIsRequest(abstractHttpRequest.getIsRequest());
        request.setUrl(url);


        return request;
    }


    /**
     * 前置拼接url参数
     * * @return
     */
    private String buildPreGetUrl(String url,String exampleUrl,List<String> getMapName,Map<String, String> paramMap){
        //这里面最智能的就是把格式进行检验;不然每次都要手动弄下
        //这里面还要加参数  1:存请求的网址格式 2:存请求的字段,到时候可以在map里面取值

        if (CollectionUtils.isEmpty(getMapName)) return url;

        if (getMapName.size() == 1){

            for(String name :getMapName){
                url = String.format(url, Optional.ofNullable(paramMap.get(name)).orElse(null));
            }

        }else {

            for(String name :getMapName){
                url = String.format(url, Optional.ofNullable(paramMap.get(name)).orElse(null));
                url = String.format(url,"/");
            }

        }

        return url;
    }




    /**
     * *post参数转换
     * @param abstractHttpRequest
     * @param abstractHttpParam
     * @param request
     * @return
     */
    public SendHttpUtilRequest buildPost(AbstractHttpRequest abstractHttpRequest,AbstractHttpParam abstractHttpParam,
                                        SendHttpUtilRequest request){

        List<Object> argList = new ArrayList<>();

        Map<String, String> paramMap = abstractHttpParam.getParamMap();

        if (paramMap.isEmpty()) return null;


        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", abstractHttpRequest.getContentType());
        headerMap.put("Cookie", CookieType.COOKIE_TYPE_V1.getCookies());
        headerMap.put("User-Agent", UserEquipmentType.USER_EQUIPMENT_TYPE_V1.getUserMessage());

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("app", abstractHttpRequest.getApp());
        bodyMap.put("env", abstractHttpRequest.getEnv());
        bodyMap.put("service", abstractHttpRequest.getService());
        bodyMap.put("method", abstractHttpRequest.getMethod());
        bodyMap.put("args", argList.add(paramMap));
        bodyMap.put("sc", abstractHttpRequest.getSc());
        bodyMap.put("timeout", abstractHttpRequest.getTimeout());
        bodyMap.put("retries", abstractHttpRequest.getRetries());

        request.setHeaderMap(headerMap);
        request.setBodyMap(bodyMap);
        request.setUrl(abstractHttpRequest.getUrl());
        request.setIsRequest(abstractHttpRequest.getIsRequest());


        return request;
    }


}
