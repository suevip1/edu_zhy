package com.edu.zhy.api.api.http.service.httputiljiagou;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * *这里作为生成的公共属性配置区
 */

@Slf4j
@Component
public class AbstractGeneratorApplication implements ApplicationContextAware {
    //路由的方法
    public static Map<Integer , HttpCreateGenerator> generatorHashMap= new HashMap<>();




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, HttpCreateGenerator> beansOfType = applicationContext.getBeansOfType(HttpCreateGenerator.class);

        for (Map.Entry<String ,HttpCreateGenerator> generatorEntry : beansOfType.entrySet()){

            HttpCreateGenerator httpCreateGenerator = generatorEntry.getValue();

            Optional.ofNullable(httpCreateGenerator.generatorType()).ifPresent(generator -> {

                generatorHashMap.put(generator,httpCreateGenerator);

            } );

        }


    }


}
