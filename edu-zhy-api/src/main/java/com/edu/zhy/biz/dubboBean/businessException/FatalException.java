package com.edu.zhy.biz.dubboBean.businessException;

/**
 * 致命异常
 *
 * @author Yu Hui
 */
public class FatalException extends BusinessException {

    public FatalException(int errorCode) {
        super(errorCode);
    }

    public FatalException(int errorCode, String message) {
        super(errorCode, message);
    }

    public FatalException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public FatalException(int errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public FatalException(IErrorCode errorCode) {
        super(errorCode);
    }

    public FatalException(IErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
