package com.edu.zhy.api.api.http.service.httputiljiagou.executeabstract;

import com.edu.zhy.api.api.http.service.httputiljiagou.Context.PolyvContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.EduLive;
import com.edu.zhy.api.api.http.service.httputiljiagou.enums.CommonRequest;
import com.edu.zhy.api.api.http.service.httputiljiagou.impl.PolyvHttpUtilServiceImpl;
import com.edu.zhy.api.api.http.service.httputiljiagou.initutil.InitApplicationContextUtil;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.PolyvParam;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *这里只是为了以后的拓展目前只用 CommonHttpUtil 就可以了
 */
@Slf4j
public class PaoLiVayHttpUtil extends AbstractHttpUtil{


    private static PolyvContext polyvContext;

    private static PolyvParam polyvParam;

    //接口属性
    private static Map<String, String> map = new HashMap<>();


    public static void main(String[] args) {

    }


    /**
     * *请求保利威get请求
     */
    public static void executeGetPaoLiVay(){

        //执行
        //请求参数
        String uuid = "52767d007c5711ee9c6f8355bc524372";
        Map<String, String> headers = new HashMap<>();
        //执行
        //请求参数
        try {
            headers = EduLive.getHeaders();
        }catch (Exception e){
            System.err.println("失败了 呜呜呜" + e);
        }

        map.put("type","dynamic");

        map.putAll(headers);

        //isRequest为true 必传
        List<String> getMapName = Arrays.asList("type","token","region");
        try {
            PolyvHttpUtilServiceImpl instance = InitApplicationContextUtil.getInstance(PolyvHttpUtilServiceImpl.class);

            polyvContext = buildAbstractHttpRequest(new PolyvContext(),String.format(CommonRequest.UEL.getName(),uuid),true, getMapName, null);

            polyvParam = buildAbstractHttpParam(new PolyvParam(),map);

            //前置效验
            instance.preCheck(polyvContext,polyvParam);

            //执行
            instance.Execute(polyvContext,polyvParam);


            InitApplicationContextUtil.closeClient();

        }catch (Exception e){
            log.error("executeCommon:远程请求失败了 e:{}",e);
            System.err.println(e);
        }



    }


    /**
     * * 请求保利威post请求
     */
    public static void executePostPaoLiVay(){



        //执行
        //请求参数
        map.put("kdtId","16719442");
        map.put("alias","fig2cvlk");
        map.put("pageNumber","2");
        map.put("pageSize","6");

        try {
            PolyvHttpUtilServiceImpl instance = InitApplicationContextUtil.getInstance(PolyvHttpUtilServiceImpl.class);

            polyvContext = buildAbstractHttpRequest (new PolyvContext(),CommonRequest.POST_UEL.getName(),false, null, null);

            polyvParam = buildAbstractHttpParam(new PolyvParam(),map);

            //前置效验
            instance.preCheck(polyvContext,polyvParam);

            //执行
            instance.Execute(polyvContext,polyvParam);


            InitApplicationContextUtil.closeClient();

        }catch (Exception e){
            log.error("executeCommon:远程请求失败了 e:{}",e);
            System.err.println(e);
        }

    }


//
//    //下面的公共属性可以再抽下
//
//    /**
//     * *转换到参数
//     * @param isRequest   是否是get请求
//     * @param getMapName GET请求下的网址格式字段重要参数名称
//     * @param args 参数(可不传)
//     * @return
//     */
//    private static PolyvContext buildPolyvContext(Boolean isRequest , List<String> getMapName, String args){
//        PolyvContext polyvContext = new PolyvContext();
//        polyvContext.setUrl(CommonRequest.POST_UEL.getName());
//        polyvContext.setIsRequest(isRequest);
//        polyvContext.setExampleUrl(CommonRequest.EXAMPLE_URL.getName());
//        polyvContext.setGetMapName(getMapName);
//        polyvContext.setContentType(CommonRequest.CONTENT_TYPE.getName());
//        polyvContext.setCookie(CookieType.COOKIE_TYPE_V1.getCookies());
//        polyvContext.setUserAgent(CommonRequest.USER_AGENT.getName());
//        polyvContext.setApp(CommonRequest.APP.getName());
//        polyvContext.setEnv(CommonRequest.ENV.getName());
//        polyvContext.setService(CommonRequest.SERVICE.getName());
//        polyvContext.setMethod(CommonRequest.METHOD.getName());
//        //这个参数可以不用传
//        polyvContext.setArgs(args);
//
//        polyvContext.setSc(CommonRequest.SC.getName());
//        polyvContext.setTimeout(CommonRequest.TIMEOUT.getName());
//        polyvContext.setRetries(CommonRequest.RETRIES.getName());
//        polyvContext.setCacheControl(CommonRequest.CACHE_CONTROL.getName());
//        return polyvContext;
//
//    }
//
//
//    private static PolyvParam buildPolyvParam(Map<String, String> paramMap){
//        PolyvParam polyvParam = new PolyvParam();
//        polyvParam.setParamMap(paramMap);
//        return polyvParam;
//    }



}
