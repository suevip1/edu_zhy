package com.edu.zhy.api.api.service.impl.aop;

import com.edu.zhy.api.api.service.impl.context.zhyAopEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ZhyAopLog {

    /**
     * 业务模块
     */
    zhyAopEnum after();

    /**
     * 操作类型
     */
    zhyAopEnum  before();

    /**
     * 操作子类型
     */
    String subOptType() default "";

}
