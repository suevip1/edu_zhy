package com.edu.zhy.biz.dubboBean.retryStrategy;

public class NeverRetryStrategy implements RetryStrategy {
    public static final NeverRetryStrategy INSTANCE = new NeverRetryStrategy();

    public NeverRetryStrategy() {
    }

    public boolean allowRetry() {
        return false;
    }
}