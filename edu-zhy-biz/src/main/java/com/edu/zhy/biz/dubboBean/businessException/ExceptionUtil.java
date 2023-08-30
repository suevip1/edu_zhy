package com.edu.zhy.biz.dubboBean.businessException;


public final class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static BusinessException businessException(int errorCode, String message, Throwable cause) {
        throw new BusinessException(ErrorCode.assembleErrorCode(errorCode), message, cause);
    }

    public static BusinessException businessException(int errorCode, String message) {
        throw new BusinessException(ErrorCode.assembleErrorCode(errorCode), message);
    }

    public static BusinessException businessException(int errorCode) {
        throw new BusinessException(ErrorCode.assembleErrorCode(errorCode));
    }

    public static BusinessException businessException(IErrorCode errorCode) {
        throw new BusinessException(ErrorCode.assembleErrorCode(errorCode.getCode()), errorCode.getMessage());
    }

    public static FatalException fatalException(int errorCode, String message, Throwable cause) {
        return new FatalException(ErrorCode.assembleErrorCode(errorCode), message, cause);
    }

    public static FatalException fatalException(int errorCode, String message) {
        return new FatalException(ErrorCode.assembleErrorCode(errorCode), message);
    }

    public static FatalException fatalException(int errorCode) {
        return new FatalException(ErrorCode.assembleErrorCode(errorCode));
    }

    public static FatalException fatalException(IErrorCode errorCode) {
        throw new FatalException(ErrorCode.assembleErrorCode(errorCode.getCode()), errorCode.getMessage());
    }
}
