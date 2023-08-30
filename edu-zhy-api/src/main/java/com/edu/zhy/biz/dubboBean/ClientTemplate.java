package com.edu.zhy.biz.dubboBean;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import com.edu.zhy.biz.dubboBean.businessException.ExceptionUtil;
import com.edu.zhy.biz.dubboBean.businessException.enumerror.CommonErrorCodes;
import com.edu.zhy.biz.dubboBean.context.ApplicationContextHolder;
import com.edu.zhy.biz.dubboBean.exceptionHandler.CurrentInvoker;
import com.edu.zhy.biz.dubboBean.Result.*;

import java.util.concurrent.Callable;

public class ClientTemplate {
    private static volatile ClientTemplateOptions clientTemplateOptions;

//    public ClientTemplate() {
//    }
//

    @SuppressWarnings("unchecked")
    public static <T> T run(Callable<BaseResult> task) {
        ClientTemplateOptions options = clientTemplateOptions();

        try {
            Object result = (new RetryCallable(() -> {
                return doRun(task);
            }, options.getRetryStrategy())).call();
            return (T) options.getResultMapper().apply(result);
        } catch (Exception var3) {
            options.getExceptionHandler().handle(var3);
            return (T) options.getExceptionResultMapper().apply(var3);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T run(Callable<BaseResult> task, ClientTemplateOptions options) {
        try {
            Object result = (new RetryCallable(() -> {
                return doRun(task);
            }, options.getRetryStrategy())).call();
            return (T) options.getResultMapper().apply(result);
        } catch (Exception var3) {
            options.getExceptionHandler().handle(var3);
            return (T) options.getExceptionResultMapper().apply(var3);
        }
    }

    private static Object doRun(Callable<BaseResult> task) throws Exception {
        Object var2;
        try {
            CurrentInvoker.set(getInvokerClassName());
            BaseResult result = (BaseResult)task.call();
            if (result == null) {
                throw ExceptionUtil.businessException(CommonErrorCodes.ENTITY_NOT_FOUND.getCode(), "返回结果为空");
            }

            if (!result.isSuccess()) {
                throw ExceptionUtil.businessException(result.getCode(), result.getMessage());
            }

            var2 = extractData(result);
        } finally {
            CurrentInvoker.clear();
        }

        return var2;
    }

    private static Object extractData(BaseResult result) {
        if (result instanceof PlainResult) {
            return ((PlainResult)result).getData();
        } else if (result instanceof ListResult) {
            return ((ListResult)result).getData();
        } else if (result instanceof MapResult) {
            return ((MapResult)result).getData();
        } else if (result instanceof PaginatorResult) {
            return ((PaginatorResult)result).getData();
        } else if (result instanceof PlainBoolResult) {
            PlainBoolResult plainBoolResult = (PlainBoolResult)result;
            return plainBoolResult.getData().get("isSuccess");
        } else {
            throw ExceptionUtil.businessException(CommonErrorCodes.COMMON_ERROR.getCode(), "Unsupported class type: " + result.getClass());
        }
    }

    private static ClientTemplateOptions clientTemplateOptions() {
        if (clientTemplateOptions == null) {
            clientTemplateOptions = ApplicationContextHolder.getContext()
                    .getBean(ClientTemplateOptions.class);
        }

        return clientTemplateOptions;
    }

    private static String getInvokerClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[6];
        return stackTraceElement.getClassName();
    }
}
