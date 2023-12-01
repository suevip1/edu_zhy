package com.edu.zhy.api.api.http.service.httputiljiagou;

import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.dto.AbstractHttpResponse;
import com.edu.zhy.api.api.http.okhttp.OKHttpUtils;
import com.edu.zhy.api.api.http.service.httputiljiagou.enums.PostParamFormat;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;

/**
 * *这点抽象出来
 */
@Slf4j
//@Component
public abstract class
AbstractHttpService<K extends AbstractHttpRequest,V extends AbstractHttpParam,T extends AbstractHttpResponse>
        extends AbstractGeneratorApplication
        implements HttpUtilService<K , V , T > {

    private static SendHttpUtilRequest sendHttpUtilRequest = new SendHttpUtilRequest();

    private static Map<String, Object> map = new HashMap<>();

    private static List<Object> argList = new ArrayList<>();

    private static Map<String, String> paramMap = new HashMap<>();


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


        String result = null;

        if (httpUtilRequest.getIsRequest()){

            result = OKHttpUtils.getInstance().sendGet(httpUtilRequest.getUrl(),null);
        }else {

            result = OKHttpUtils.getInstance()
                    .sendJsonPost(httpUtilRequest.getUrl(), httpUtilRequest.getHeaderMap(),
                            Collections.singletonList(JSON.toJSONString(httpUtilRequest.getBodyMap())));

        }


        Map<String, Object> resultMap = JSON.parseObject(result, Map.class);
        if (0 == MapUtils.getInteger(resultMap, "code")
        || 0 >= MapUtils.getInteger(resultMap, "code")) {
            System.out.println(result);
            throw new IllegalStateException("请求失败，返回code == 0或 返回code <= 0");
        }

        if (
//                "ok" != MapUtils.getString(dataMap,"msg") &&
                        200 != MapUtils.getIntValue(resultMap, "code")) {
            System.out.println(result);
            throw new IllegalStateException("请求失败，返回code!=200");
        }

//        Map<String, Object> dataMap = Optional.ofNullable((Map<String, Object>) resultMap.get("data")).orElse(null);
//        if (dataMap.isEmpty()){
//            System.out.println(result);
//            throw new IllegalStateException("请求失败，返回数据为空");
//        }


        System.out.println("请求成功的数据:{"+result+"}");
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
        Boolean checkZanPost = sendHttpContext.getAbstractHttpRequest().getCheckZanPost();

        if (sendHttpContext.getAbstractHttpRequest().getIsRequest()){
            //这里get请求转换
            request = buildGet(sendHttpContext.getAbstractHttpRequest(),sendHttpContext.getAbstractHttpParam(),request);
        }else {
            //这里post请求转换
            if (checkZanPost){
                request = buildPostZan(sendHttpContext.getAbstractHttpRequest(),sendHttpContext.getAbstractHttpParam());
            }else {
                request = buildPost(sendHttpContext.getAbstractHttpRequest(),sendHttpContext.getAbstractHttpParam());
            }
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
     * @return
     */
    public static SendHttpUtilRequest buildPost(AbstractHttpRequest abstractHttpRequest,AbstractHttpParam abstractHttpParam
                                        ){
        paramMap = abstractHttpParam.getParamMap();

        if (paramMap.isEmpty()) return null;

        map = buildMapName(paramMap, abstractHttpRequest.getPostMapName());

        if (map.isEmpty()) return null;

//        argList.add(map);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", abstractHttpRequest.getContentType());
        headerMap.put("Cookie", abstractHttpRequest.getCookie());
        headerMap.put("User-Agent", abstractHttpRequest.getUserAgent());
        headerMap.put("X-Request-Protocol","dubbo");
        headerMap.put("sc", abstractHttpRequest.getSc());


//        Map<String, Object> bodyMap = new HashMap<>();
//        bodyMap.put("app", abstractHttpRequest.getApp());
//        bodyMap.put("env", abstractHttpRequest.getEnv());
//        bodyMap.put("service", abstractHttpRequest.getService());
//        bodyMap.put("method", abstractHttpRequest.getMethod());
//        //增加参数变更
////        bodyMap.put("args",argList);
//
//        bodyMap.put("sc", abstractHttpRequest.getSc());
//        bodyMap.put("timeout", abstractHttpRequest.getTimeout());
//        bodyMap.put("retries", abstractHttpRequest.getRetries());

        sendHttpUtilRequest.setHeaderMap(headerMap);
        sendHttpUtilRequest.setBodyMap(map);
        sendHttpUtilRequest.setUrl(abstractHttpRequest.getUrl());
        sendHttpUtilRequest.setIsRequest(abstractHttpRequest.getIsRequest());

        return sendHttpUtilRequest;
    }

    /**
     * *post参数转换
     *      //有赞公司内部格式需要拿到pre的cook才行目前只能跑线上
     * *   参数不需要放在链接上面
     * *url  直接拿基础平台的
     * @param abstractHttpRequest
     * @param abstractHttpParam
     * @return
     */
    public static SendHttpUtilRequest buildPostZan(AbstractHttpRequest abstractHttpRequest,AbstractHttpParam abstractHttpParam){

        paramMap = abstractHttpParam.getParamMap();

        if (paramMap.isEmpty()) return null;

        map = buildMapName(paramMap, abstractHttpRequest.getPostMapName());

        if (map.isEmpty()) return null;

        argList.add(map);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", abstractHttpRequest.getContentType());
        headerMap.put("Cookie", abstractHttpRequest.getCookie());
        headerMap.put("User-Agent", abstractHttpRequest.getUserAgent());
        headerMap.put("X-Request-Protocol","dubbo");

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("app", abstractHttpRequest.getApp());
        bodyMap.put("env", abstractHttpRequest.getEnv());
        bodyMap.put("service", abstractHttpRequest.getService());
        bodyMap.put("method", abstractHttpRequest.getMethod());
        //增加参数变更
        bodyMap.put("args",argList);

        bodyMap.put("sc", abstractHttpRequest.getSc());
        bodyMap.put("timeout", abstractHttpRequest.getTimeout());
        bodyMap.put("retries", abstractHttpRequest.getRetries());

        sendHttpUtilRequest.setHeaderMap(headerMap);
        sendHttpUtilRequest.setBodyMap(bodyMap);
        sendHttpUtilRequest.setUrl(abstractHttpRequest.getUrl());
        sendHttpUtilRequest.setIsRequest(abstractHttpRequest.getIsRequest());

        return sendHttpUtilRequest;
    }



    private static Map<String,Object> buildMapName(Map<String, String> paramMap,Map<String, Integer> postMapName){

        Map<String,Object> map = new HashMap<>();

        postMapName.entrySet().stream().forEach(entry -> {
            String value = paramMap.get(entry.getKey());
            if (Objects.nonNull(value)){
                map.putAll(buildMap(map,entry.getValue(),value,entry.getKey()));
            }
        });


        return map;
    }


    private static Map<String,Object> buildMap( Map<String,Object> map,Integer type,String value,String key){

        switch (PostParamFormat.valueOfType(type)){

            case STRING_VALUE:
                map.put(key,value);
                break;


            case LONG_VALUE:
                map.put(key,Long.valueOf(value));
                break;


            case ARRAY_VALUE:
                map.put(key,JSON.parseArray(value));
                break;

            case OBJECT_VALUE:
                map.put(key,JSON.parseObject(value,Map.class));
                break;


            default:
                break;
        }

        return map;
    }


}
