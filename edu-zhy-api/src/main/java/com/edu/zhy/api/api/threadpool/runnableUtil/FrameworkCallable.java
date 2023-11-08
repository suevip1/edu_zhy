package com.edu.zhy.api.api.threadpool.runnableUtil;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 框架Callable，所有在业务线程里发起的异步任务都应该使用FrameworkRunnable或者FrameworkCallable
 */
public class FrameworkCallable<V> implements Callable<V> {

    private Callable<V> callable;
    private Map serivceChain;

    public FrameworkCallable(Callable<V> callable) {
        this.callable = callable;
        this.serivceChain = ServiceChainContext.getInvocationServiceChainContext();
    }

    public V call() throws Exception {
        try {
            ServiceChainContext.setInvocationServiceChainContext(this.serivceChain);
            if (null != this.callable) {
                return this.callable.call();
            }
        } finally {
            ServiceChainContext.removeServiceChainContext();
        }
        return null;
    }
}
