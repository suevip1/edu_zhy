package com.edu.zhy.biz.dubboBean.exceptionHandler;

import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.edu.zhy.biz.dubboBean.businessException.ExceptionUtil;
import com.edu.zhy.biz.dubboBean.businessException.enumerror.CommonErrorCodes;

public class DirectThrowExceptionHandler implements ExceptionHandler {
    public DirectThrowExceptionHandler() {
    }

    public void handle(Throwable throwable) {
        if (throwable instanceof BusinessException) {
            throw (BusinessException)throwable;
        } else {
            throw ExceptionUtil.fatalException(CommonErrorCodes.COMMON_ERROR.getCode(), CommonErrorCodes.COMMON_ERROR.getMessage(), throwable);
        }
    }
}
