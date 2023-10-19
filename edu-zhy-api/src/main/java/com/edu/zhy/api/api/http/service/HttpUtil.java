package com.edu.zhy.api.api.http.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * *执行前置层
 */

@Slf4j
@Component
public class HttpUtil implements ApplicationContextAware {
    //路由的方法
    private static Map<Integer , HttpUtilService> httpUtilServiceMap= new HashMap<>();



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, HttpUtilService> beansOfType = applicationContext.getBeansOfType(HttpUtilService.class);

        for (Map.Entry<String, HttpUtilService> entry : beansOfType.entrySet()){
            HttpUtilService httpUtilService = entry.getValue();

            Optional.ofNullable(httpUtilService.getHttpType()).ifPresent(type -> {
                //为null不执行
                if (Objects.isNull(type)) return;

                httpUtilServiceMap.put(type,httpUtilService);
            });

        }

    }

    //这里需要用type进行路由:目前先定义个常用类型
    //参数 T:url  R:常用参数 定义两个上级父类
    //需要一个常用的方法用来承载http请求参数组装（用type来进行参数路由）



}
