package com.edu.zhy.biz.dubboBean.retryStrategy;

public class NTimesRetryStrategy implements RetryStrategy {
    private volatile int times;
    private final long millisecondBetweenSleeps;

    public NTimesRetryStrategy(int times, long millisecondBetweenSleeps) {
        this.times = times;
        this.millisecondBetweenSleeps = millisecondBetweenSleeps;
    }

    public boolean allowRetry() {
        if (!Thread.currentThread().isInterrupted() && this.times > 0) {
            this.await();
            --this.times;
            return true;
        } else {
            return false;
        }
    }

    private synchronized void await() {
        try {
            this.wait(this.millisecondBetweenSleeps);
        } catch (InterruptedException var2) {
        }

    }
}
