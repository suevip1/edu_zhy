package com.edu.zhy.biz.dubboBean.retryStrategy;
import com.google.common.base.Preconditions;

public class ExponentialRetryStrategy implements RetryStrategy {
    private volatile int times;
    private volatile long millisecondBetweenSleeps;

    public ExponentialRetryStrategy(int times, long baseMilliseconds) {
        Preconditions.checkArgument(times > 0, "Parameter times must > 0");
        Preconditions.checkArgument(baseMilliseconds > 0L, "Parameter baseMilliseconds must > 0");
        this.times = times;
        this.millisecondBetweenSleeps = baseMilliseconds;
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
            this.millisecondBetweenSleeps *= 2L;
        } catch (InterruptedException var2) {
        }

    }
}
