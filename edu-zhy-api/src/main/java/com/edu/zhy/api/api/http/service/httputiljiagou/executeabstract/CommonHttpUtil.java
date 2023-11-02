package com.edu.zhy.api.api.http.service.httputiljiagou.executeabstract;


import com.edu.zhy.api.api.http.service.httputiljiagou.Context.CommonContext;
import com.edu.zhy.api.api.http.service.httputiljiagou.HttpUtilService;
import com.edu.zhy.api.api.http.service.httputiljiagou.enums.CommonRequest;
import com.edu.zhy.api.api.http.service.httputiljiagou.impl.CommonHttpUtilServiceImpl;
import com.edu.zhy.api.api.http.service.httputiljiagou.initutil.InitApplicationContextUtil;
import com.edu.zhy.api.api.http.service.httputiljiagou.params.CommonParam;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *执行前置层
 * *这里到时候
 */

@Slf4j
//@Component
public  class CommonHttpUtil
//        implements ApplicationContextAware
extends  AbstractHttpUtil{
    //路由的方法
    public static Map<Integer , HttpUtilService> httpUtilServiceMap= new HashMap<>();

    //一般远程调用参数
    private static CommonContext commonContext;
    private static CommonParam commonParam;
    //接口属性
    private static Map<String, String> paramMap = new HashMap<>();



//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//        Map<String, HttpUtilService> beansOfType = applicationContext.getBeansOfType(HttpUtilService.class);
//
//        for (Map.Entry<String, HttpUtilService> entry : beansOfType.entrySet()){
//            HttpUtilService httpUtilService = entry.getValue();
//
//            Optional.ofNullable(httpUtilService.getHttpType()).ifPresent(type -> {
//                httpUtilServiceMap.put(type,httpUtilService);
//            });
//
//        }
//
//    }



    //这里需要用type进行路由:目前先定义个常用类型
    //参数 T:url  R:常用参数 定义两个上级父类
    //需要一个常用的方法用来承载http请求参数组装（用type来进行参数路由）

    /**
     * *使用规范示例远程本地调用
     * @param args
     */
    public static void main(String[] args) {

        //get请求
        executeGetCommon();

        //post请求
        executePostCommon();


    }

//    这里还可以在抽下进行执行


    /**
     * *远程调用执行一般
     * *get请求
     */
    public static void executeGetCommon(){
        //执行
        //请求参数
        paramMap.put("kdtId","16719442");
        paramMap.put("alias","fig2cvlk");
        paramMap.put("pageNumber","2");
        paramMap.put("pageSize","6");
        //isRequest为true 必传
        List<String> getMapName = Arrays.asList("kdtId","alias","pageNumber","pageSize");

        try {
            CommonHttpUtilServiceImpl instance = InitApplicationContextUtil.getInstance(CommonHttpUtilServiceImpl.class);

            commonContext = buildAbstractHttpRequest(new CommonContext(),CommonRequest.UEL.getName(), true, getMapName, null);

            commonParam = buildAbstractHttpParam(new CommonParam(),paramMap);

            //前置效验
            instance.preCheck(commonContext,commonParam);

            //执行
            instance.Execute(commonContext,commonParam);


            InitApplicationContextUtil.closeClient();

        }catch (Exception e){
            log.error("executeCommon:远程请求失败了 e:{}",e);
            System.err.println(e);
        }


    }


    /**
     * *POST请求(这个还需要测试下)
     */
    public static void executePostCommon(){

        //执行
        //请求参数
        paramMap.put("kdtId","16719442");
        paramMap.put("alias","fig2cvlk");
        paramMap.put("pageNumber","1");
        paramMap.put("pageSize","6");

        try {
            CommonHttpUtilServiceImpl instance = InitApplicationContextUtil.getInstance(CommonHttpUtilServiceImpl.class);

            commonContext = buildAbstractHttpRequest(new CommonContext(),CommonRequest.POST_UEL.getName(),false, null, null);

            commonParam = buildAbstractHttpParam(new CommonParam(),paramMap);

            //前置效验
            instance.preCheck(commonContext,commonParam);

            //执行
            instance.Execute(commonContext,commonParam);


            InitApplicationContextUtil.closeClient();

        }catch (Exception e){
            log.error("executeCommon:远程请求失败了 e:{}",e);
            System.err.println(e);
        }


    }






//
//
//    /**
//     * *编程式快速获取到获取到一个bean 测试
//     */
//    private static void initAnnotationConfigApplicationContextV2(){
//
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//
//        // 注册 Bean
//        applicationContext.registerBean(CommonHttpUtilServiceImpl.class);
//
//        // 启动 Spring 上下文
//        applicationContext.refresh();
//
//        // 获取 Bean 实例
//        HttpUtilService bean = applicationContext.getBean(CommonHttpUtilServiceImpl.class);
//
//
//        System.err.println(bean);
//
//
//        // 关闭 Spring 上下文
//        applicationContext.close();
//
//    }
//
//
//
//
//    /**
//     * * 这里需要一个共同的启动bean得方法
//     * *编程式快速获取到获取到一个bean  并执行逻辑
//     * *需要想想还有没有更加得处理路由方式
//     */
//    private static void initAnnotationConfigApplicationContext(AbstractHttpRequest request,AbstractHttpParam param){
//
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//
//        // 注册 Bean
//        applicationContext.registerBean(CommonHttpUtilServiceImpl.class);
//
//        // 启动 Spring 上下文
//        applicationContext.refresh();
//
//        // 获取 Bean 实例
//        HttpUtilService bean = applicationContext.getBean(CommonHttpUtilServiceImpl.class);
//
//        // 使用 Bean
////        bean.preCheck(request, param);
//
//        bean.Execute(request, param);
//
//        // 关闭 Spring 上下文
//        applicationContext.close();
//
//    }


//    /**
//     * *转换到参数
//     * @param isRequest   是否是get请求
//     * @param getMapName GET请求下的网址格式字段重要参数名称
//     * @param args 参数(可不传)
//     * @return
//     */
//    private static CommonContext buildCommonContext(Boolean isRequest , List<String> getMapName,String args){
//        CommonContext commonContext = new CommonContext();
//        commonContext.setUrl(CommonRequest.UEL.getName());
//        commonContext.setIsRequest(isRequest);
//        commonContext.setExampleUrl(CommonRequest.EXAMPLE_URL.getName());
//        commonContext.setGetMapName(getMapName);
//        commonContext.setContentType(CommonRequest.CONTENT_TYPE.getName());
//        commonContext.setCookie(CookieType.COOKIE_TYPE_V1.getCookies());
//        commonContext.setUserAgent(CommonRequest.USER_AGENT.getName());
//        commonContext.setApp(CommonRequest.APP.getName());
//        commonContext.setEnv(CommonRequest.ENV.getName());
//        commonContext.setService(CommonRequest.SERVICE.getName());
//        commonContext.setMethod(CommonRequest.METHOD.getName());
//        //这个参数可以不用传
//        commonContext.setArgs(args);
//
//        commonContext.setSc(CommonRequest.SC.getName());
//        commonContext.setTimeout(CommonRequest.TIMEOUT.getName());
//        commonContext.setRetries(CommonRequest.RETRIES.getName());
//        commonContext.setCacheControl(CommonRequest.CACHE_CONTROL.getName());
//        return commonContext;
//
//    }
//
//
//    private static CommonParam buildCommonParam(Map<String, String> paramMap){
//        CommonParam commonParam = new CommonParam();
//        commonParam.setParamMap(paramMap);
//        return commonParam;
//    }



//
//    /**
//     * *使用规范示例远程本地调用
//     * @param args
//     */
//    public static void main(String[] args) {
////
////        //测试执行
////        initAnnotationConfigApplicationContextV2();
//
//        //测试执行
////        initAnnotationConfigApplicationContext(buildCommonContext(true,getMapName,null),buildCommonParam(paramMap));
//
//        //执行
//        //请求参数
//        paramMap.put("kdtId","16719442");
//        paramMap.put("alias","fig2cvlk");
//        paramMap.put("pageNumber","2");
//        paramMap.put("pageSize","6");
//        //isRequest为true 必传
//        List<String> getMapName = Arrays.asList("kdtId","alias","pageNumber","pageSize");
//
//        try {
//            CommonHttpUtilServiceImpl instance = InitApplicationContextUtil.getInstance(CommonHttpUtilServiceImpl.class);
//
//            commonContext = buildCommonContext(true, getMapName, null);
//
//            commonParam = buildCommonParam(paramMap);
//
//            //前置效验
//            instance.preCheck(commonContext,commonParam);
//
////            instance.Execute(buildCommonContext(true,getMapName,null),buildCommonParam(paramMap));
//            //执行
//            instance.Execute(commonContext,commonParam);
//
//
//            InitApplicationContextUtil.closeClient();
//
//        }catch (Exception e){
//            log.error("远程请求失败了 e:{}",e);
//            System.err.println(e);
//        }
//
//
//    }

}
