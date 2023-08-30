package com.edu.zhy.biz.dubboBean.exceptionHandler;


import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.edu.zhy.biz.dubboBean.businessException.FatalException;
import com.edu.zhy.biz.dubboBean.businessException.RpcException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleLogExceptionHandler implements ExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(SimpleLogExceptionHandler.class);

    public SimpleLogExceptionHandler() {
    }

    public void handle(Throwable throwable) {
        Logger logger = this.getLogger();
        if (throwable instanceof BusinessException) {
            BusinessException exception = (BusinessException)throwable;
            if (exception instanceof FatalException) {
                logger.error("Code: " + exception.getErrorCode(), exception);
            } else {
                logger.warn("Code: " + exception.getErrorCode(), exception);
            }
        } else if (throwable instanceof RpcException) {
            RpcException exception = (RpcException)throwable;
            if (exception.isTimeout()) {
                logger.warn("Code: time_out", Arrays.stream(ExceptionUtils.getStackFrames(exception)).limit(4L).collect(Collectors.joining("\n")));
            } else {
                logger.warn("Code: rpc_" + exception.getCode(), Arrays.stream(ExceptionUtils.getStackFrames(exception)).limit(4L).collect(Collectors.joining("\n")));
            }
        } else {
            logger.error("", throwable);
        }

    }

    private Logger getLogger() {
        String className = CurrentInvoker.get();
        return className != null ? LoggerFactory.getLogger(className) : log;
    }
}
