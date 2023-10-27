package com.edu.zhy.api.api.http.service.httputiljiagou.initutil;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * *通过  AnnotationConfigApplicationContext 快速得到一个bean
 * *可以用
 */
public class InitApplicationContextUtil {

    private static volatile AnnotationConfigApplicationContext applicationContext;

    /**
     * *初始化对外接口
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getInstance(Class<T> tClass){
        return initClient(tClass);
    }


    /**
     * *注册
     * @param tClass
     * @return
     */
    private static <T> T initClient(Class<T> tClass){
        applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Bean
        applicationContext.registerBean(tClass);

        // 启动 Spring 上下文
        applicationContext.refresh();

        // 获取 Bean 实例
        T bean = applicationContext.getBean(tClass);

        return bean;
    }

//    /**
//     * *关闭
//     * @param annotationConfigApplicationContext
//     */
//    public static void closeClient(AnnotationConfigApplicationContext annotationConfigApplicationContext){
//        ((AnnotationConfigApplicationContext) annotationConfigApplicationContext).close();
//        return ;
//    }
//

    /**
     * *对外关闭接口
     * *关闭资源 进行销毁
     */
    public static void closeClient(){
        ((AnnotationConfigApplicationContext) applicationContext).close();
        return ;
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        context = applicationContext;
//    }


//    /**
//     * *编程式快速获取到获取到一个bean 测试
//     */
//    private static void initAnnotationConfigApplicationContextV2(){
//
//        applicationContext = new AnnotationConfigApplicationContext();
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



}
