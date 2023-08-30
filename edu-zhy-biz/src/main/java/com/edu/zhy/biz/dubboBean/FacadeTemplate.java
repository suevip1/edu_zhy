package com.edu.zhy.biz.dubboBean;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.edu.zhy.biz.dubboBean.Result.RetryCallable;
import com.edu.zhy.biz.dubboBean.businessException.RpcException;
import com.edu.zhy.biz.dubboBean.context.ApplicationContextHolder;
import com.edu.zhy.biz.dubboBean.exceptionHandler.CurrentInvoker;
import com.edu.zhy.biz.dubboBean.retryStrategy.RetryStrategy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class FacadeTemplate {
    private static volatile TransactionTemplate transactionTemplate;
    private static volatile com.youzan.ebiz.domain.template.FacadeTemplateOptions facadeTemplateOptions;

    public FacadeTemplate() {
    }

    public static <T> CommonResult<T> run(Callable<T> task, com.youzan.ebiz.domain.template.FacadeTemplateOptions options) {
        return doExecute(task, options);
    }

    public static <T> CommonResult<T> run(Callable<T> task) {
        return doExecute(task, facadeTemplateOptions());
    }

    public static <T> CommonResult<T> run(Callable<T> task, boolean withTransaction) {
        com.youzan.ebiz.domain.template.FacadeTemplateOptions options = com.youzan.ebiz.domain.template.FacadeTemplateOptions.builder().withTransaction(withTransaction).build();
        return doExecute(task, options);
    }

    public static <T> CommonResult<T> run(Callable<T> task, boolean withTransaction, RetryStrategy retryStrategy) {
        com.youzan.ebiz.domain.template.FacadeTemplateOptions options = com.youzan.ebiz.domain.template.FacadeTemplateOptions.builder().withTransaction(withTransaction).retryStrategy(retryStrategy).build();
        return doExecute(task, options);
    }

    private static <T> CommonResult<T> doExecute(Callable<T> task, com.youzan.ebiz.domain.template.FacadeTemplateOptions options) {
        CommonResult var3;
        try {
            CurrentInvoker.set(getInvokerClassName());
            RetryCallable<T> retryTask = new RetryCallable(task, options.getRetryStrategy());
            if (!options.isWithTransaction()) {
                var3 = doExecute(retryTask, (ExceptionHandler)options.getExceptionHandler());
                return var3;
            }

            var3 = (CommonResult)transactionTemplate().execute((status) -> {
                CommonResult<T> result = doExecute(retryTask, (ExceptionHandler)options.getExceptionHandler());
                if (!result.isSuccess()) {
                    status.setRollbackOnly();
                }

                return result;
            });
        } finally {
            CurrentInvoker.clear();
        }

        return var3;
    }

    private static <T> CommonResult<T> doExecute(Callable<T> task, ExceptionHandler exceptionHandler) {
        try {
            return CommonResult.success(task.call());
        } catch (Exception var4) {
            exceptionHandler.handle(var4);
            if (var4 instanceof RpcException) {
                RpcException exception = (RpcException)var4;
                if (exception.isTimeout()) {
                    CommonResult.error(-123, "time_out", String.format("rpc_%s", exception.getCode()), (String)Arrays.stream(ExceptionUtils.getStackFrames(exception)).limit(8L).collect(Collectors.joining("\n")));
                } else {
                    CommonResult.error(var4);
                }
            }

            return CommonResult.error(var4);
        }
    }

    private static TransactionTemplate transactionTemplate() {
        if (transactionTemplate == null) {
            transactionTemplate = (TransactionTemplate) ApplicationContextHolder.getContext().getBean(TransactionTemplate.class);
        }

        return transactionTemplate;
    }

    private static com.youzan.ebiz.domain.template.FacadeTemplateOptions facadeTemplateOptions() {
        if (facadeTemplateOptions == null) {
            facadeTemplateOptions = (com.youzan.ebiz.domain.template.FacadeTemplateOptions)ApplicationContextHolder.getContext().getBean(com.youzan.ebiz.domain.template.FacadeTemplateOptions.class);
        }

        return facadeTemplateOptions;
    }

    private static String getInvokerClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[4];
        return stackTraceElement.getClassName();
    }
}
