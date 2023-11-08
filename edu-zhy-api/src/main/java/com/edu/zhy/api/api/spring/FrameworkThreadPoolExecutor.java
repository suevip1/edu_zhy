package com.edu.zhy.api.api.spring;

import java.util.concurrent.ThreadPoolExecutor;

public class FrameworkThreadPoolExecutor extends ThreadPoolExecutor {
    public FrameworkThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit, @org.jetbrains.annotations.NotNull java.util.concurrent.BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public FrameworkThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit, @org.jetbrains.annotations.NotNull java.util.concurrent.BlockingQueue<Runnable> workQueue, @org.jetbrains.annotations.NotNull java.util.concurrent.ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public FrameworkThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit, @org.jetbrains.annotations.NotNull java.util.concurrent.BlockingQueue<Runnable> workQueue, @org.jetbrains.annotations.NotNull java.util.concurrent.RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public FrameworkThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit unit, @org.jetbrains.annotations.NotNull java.util.concurrent.BlockingQueue<Runnable> workQueue, @org.jetbrains.annotations.NotNull java.util.concurrent.ThreadFactory threadFactory, @org.jetbrains.annotations.NotNull java.util.concurrent.RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

}
