package com.edu.zhy.biz.dubboBean.retryStrategy;

import java.util.function.Function;

public class NullExceptionResultMapper implements Function<Throwable, Object> {

    @Override
    public Object apply(Throwable throwable) {
        return null;
    }
}
