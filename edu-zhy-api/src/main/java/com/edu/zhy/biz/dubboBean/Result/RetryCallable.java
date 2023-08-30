package com.edu.zhy.biz.dubboBean.Result;

import com.edu.zhy.biz.dubboBean.retryStrategy.RetryStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class RetryCallable<T> implements Callable<T> {

    private static final Logger log = LoggerFactory.getLogger(RetryCallable.class);
    private final Callable<T> task;
    private final RetryStrategy strategy;

    public RetryCallable(Callable<T> task, RetryStrategy strategy) {
        this.task = task;
        this.strategy = strategy;
    }

    public T call() throws Exception {
        try {
            return this.task.call();
        } catch (Exception var4) {
            Exception e = var4;

            while(this.strategy.allowRetry()) {
                try {
                    return this.task.call();
                } catch (Exception var3) {
                    log.warn("Run [{}] failed of [{}], retrying...", this.task, e.getMessage());
                }
            }

            throw e;
        }
    }
}
