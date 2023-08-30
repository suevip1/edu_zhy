package com.edu.zhy.biz.dubboBean.retryStrategy;

public class OneTimeRetryStrategy implements RetryStrategy {
    private volatile boolean retried = false;
    private final long waitMillisecond;

    public OneTimeRetryStrategy(long waitMillisecond) {
        this.waitMillisecond = waitMillisecond;
    }

    public boolean allowRetry() {
        if (Thread.currentThread().isInterrupted()) {
            return false;
        } else {
            this.await();
            boolean retried = this.retried;
            this.retried = true;
            return !retried;
        }
    }

    private synchronized void await() {
        try {
            this.wait(this.waitMillisecond);
        } catch (InterruptedException var2) {
        }

    }
}
