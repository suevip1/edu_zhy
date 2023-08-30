package com.edu.zhy.biz.dubboBean.retryStrategy;

import java.util.function.Function;

public class DirectReturnResultMapper implements Function<Object, Object> {

    @Override
    public Object apply(Object o) {
        return o;
    }
}