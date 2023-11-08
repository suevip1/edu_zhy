package com.edu.zhy.api.api.threadpool.runnableUtil;

import java.util.Map;

/**
 * 框架Runnable，所有在业务线程里发起的异步任务都应该使用FrameworkRunnable或者FrameworkCallable
 */
public class FrameworkRunnable implements Runnable {
    private Runnable runnable;

    private Map serivceChain;

    public FrameworkRunnable(Runnable runnable) {
        this.runnable = runnable;
        this.serivceChain = ServiceChainContext.getInvocationServiceChainContext();
    }

    public void run() {
        try {
            ServiceChainContext.setInvocationServiceChainContext(serivceChain);
            if (null != runnable) {
                runnable.run();
            }
        } finally {
            ServiceChainContext.removeServiceChainContext();
        }
    }
}
