package com.edu.zhy.biz.dubboBean.retryStrategy;

public class ForeverRetryStrategy implements RetryStrategy {
    private final long millisecondBetweenSleeps;

    public ForeverRetryStrategy(long millisecondBetweenSleeps) {
        this.millisecondBetweenSleeps = millisecondBetweenSleeps;
    }

    public boolean allowRetry() {
        this.await();
        return !Thread.currentThread().isInterrupted();
    }

    private synchronized void await() {
        try {
            this.wait(this.millisecondBetweenSleeps);
        } catch (InterruptedException var2) {
        }

    }
}
