package com.edu.zhy.api.api.threadpool;

import com.alibaba.dubbo.common.threadpool.support.cached.CachedThreadPool;
import com.alibaba.dubbo.common.threadpool.support.fixed.FixedThreadPool;
import com.edu.zhy.api.api.spring.FrameworkThreadPoolExecutor;
import com.edu.zhy.api.api.threadpool.runnableUtil.FrameworkRunnable;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureExecutorPool {

    private static final Integer CORE_SIZE = 100;

    private static final Integer MAX_SIZE = 200;

    private static final Long KEEP_TIME = 200L;

//    private static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_TIME,
//            TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000), new ThreadFactoryBuilder().setNameFormat("").build(),
//            new RejectedExecutionHandler() {
//        @Override
//        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//
//
//        }
//
//    }
//    );



    //一个由链表结构组成的有界阻塞队列，大小默认为Integer的MAX。
    private static ThreadPoolExecutor  linkedBlockingExecutor = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_TIME,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),new ThreadFactoryBuilder().setNameFormat("").build() ,
            new ThreadPoolExecutor.CallerRunsPolicy());



    private static ThreadPoolExecutor linkedBlockingExecutorV2 = new FrameworkThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_TIME,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),new ThreadFactoryBuilder().setNameFormat("").build() ,
            new ThreadPoolExecutor.CallerRunsPolicy());

    //一个由数组结构组成的有界阻塞队列。
    private static ThreadPoolExecutor arrayBlockingExecutor = new FrameworkThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_TIME,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),new ThreadFactoryBuilder().setNameFormat("").build() ,
            new ThreadPoolExecutor.CallerRunsPolicy());



    //SynchronousQueue
    //不存储元素的阻塞队列单列
    private static ThreadPoolExecutor synchronousExecutor = new FrameworkThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_TIME,
            TimeUnit.SECONDS, new SynchronousQueue<>(),new ThreadFactoryBuilder().setNameFormat("").build() ,
            new ThreadPoolExecutor.CallerRunsPolicy());



    //SingleThreadExecutor：
    //单线程线程池，如果当前线程出现异常会开启一个新的线程来执行，保证任务的执行顺序和提交顺序一致，初始化参数如下：
    //
    //• corePoolSize:1
    //• maximumPoolSize: 1
    //• keepAliveTime: 0L
    //• workQueue:new LinkedBlockingQueue<Runnable>()






    //CachedThreadPool：
    //是一个无界的、可以扩容的线程池,线程数量的上限取决于服务器性能，每当有任务时立马线程来执行，当有空闲线程时，默认60秒才会停止，主要初始化参数如下：
    //
    //•  corePoolSize: 0
    //•  maximumPoolSize: Integer.MAX_VALUE
    //•  keepAliveTime: 60L // TimeUnit.SECONDS
    //•  workQueue:new SynchronousQueue<Runnable>()
    private static CachedThreadPool cachedThreadPool = new CachedThreadPool();


    //FixedThreadPool：
    //固定大小的线程池，最大线程数与核心线程数一致，每提交一个任务就创建一个线程，直到达到最大线程数，当某一个线程出现异常后会创建一个新的线程，适用于固定并发，初始化参数如下：
    //
    //• corePoolSize: nThreads
    //• maximumPoolSize: nThreads
    //• keepAliveTime: 0L
    //• workQueue:new LinkedBlockingQueue<Runnable>()
    private static FixedThreadPool fixedThreadPool = new FixedThreadPool();






    //ScheduledThreadPool：
    //是一个固定线程核心数，无界的线程池，支持定时执行任务，如果存在空闲线程，会被立刻停止，初始化参数如下：
    //
    //•  corePoolSize: corePoolSize
    //•  maximumPoolSize: Integer.MAX_VALUE
    //•  keepAliveTime: 0
    //•  workQueue:new DelayedWorkQueue()



    public static <T> CompletableFuture<T> execute(ThreadPoolExecutor executor, Supplier<T> supplier){
        return CompletableFuture.supplyAsync(supplier,executor);
    }


    public static <T> CompletableFuture<T> future(Supplier<T> supplier){

        return CompletableFuture.supplyAsync(supplier,linkedBlockingExecutor);
    }

    public static CompletableFuture<Void> frameWorkRunnableFuture(ThreadPoolExecutor executor,Runnable runnable){
        return CompletableFuture.runAsync(new FrameworkRunnable(runnable),executor);
    }


    public static <T> CompletableFuture<T> frameWorkCallableFuture(ThreadPoolExecutor executor,Supplier<T> supplier){

        return CompletableFuture.supplyAsync(supplier,executor);
    }


    public static String m2(){

        System.err.println(System.currentTimeMillis());

        return "HAHAHHAAHHA";

    }



    public static String m1(){

        System.err.println(System.currentTimeMillis());

        return "111111";
    }


    public static void main(String[] args) {
//        frameWorkRunnableFuture(linkedBlockingExecutor,() -> m2());

        frameWorkRunnableFuture(linkedBlockingExecutor, () -> {
            m2();

            m1();

        } );

//        frameWorkRunnableFuture(linkedBlockingExecutor, () -> m1());



//        CompletableFuture<String> stringCompletableFuture = frameWorkCallableFuture(linkedBlockingExecutorV2, () -> m2());
//
//        CompletableFuture<String> stringCompletableFuture1 = frameWorkCallableFuture(linkedBlockingExecutorV2, () -> m1());
//
//        CompletableFuture.allOf(stringCompletableFuture,stringCompletableFuture1);
//
//        System.err.println(stringCompletableFuture.join()+ ":"+stringCompletableFuture1.join());


    }



}
