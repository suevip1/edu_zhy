package com.edu.zhy.api.api.http.service.httputiljiagou.exception;


import java.util.Objects;


/**
 * @author zhangcheng
 */
public class ReflectInvokeException extends RuntimeException {

    private String clazzName;

//    public ReflectInvokeException(Object bean, ShopMetaInfo shopMetaInfo) {
//        this(bean, "");
//    }

    public ReflectInvokeException(Object bean, String cause) {

        super(createMessage(bean, cause));
        if (Objects.nonNull(bean)) {
            this.clazzName = bean.getClass().getName();
        }
    }

    private static String createMessage(Object bean, String cause) {

        if (Objects.isNull(bean)) {
            return cause;
        }

        return "fail to invoke using reflection,bean=[" + bean.getClass().getName() + "],error:" + cause;

    }

    public String getClazzName() {
        return clazzName;
    }
}
