package com.edu.zhy.biz.dubboBean.businessException;

import java.util.Objects;

public class BusinessException extends RuntimeException {
    private final int errorCode;
    private final String errorMsg;
    private final String subErrorCode;
    private final String subErrorMsg;

    /** @deprecated */
    @Deprecated
    public BusinessException(int errorCode) {
        this.errorCode = errorCode;
        this.errorMsg = null;
        this.subErrorCode = null;
        this.subErrorMsg = null;
    }

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
        this.subErrorCode = null;
        this.subErrorMsg = null;
    }

    public BusinessException(int errorCode, String message, int subErrorCode, String subErrorMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
        this.subErrorCode = String.valueOf(subErrorCode);
        this.subErrorMsg = subErrorMsg;
    }

    public BusinessException(int errorCode, String message, String subErrorCode, String subErrorMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
        this.subErrorCode = subErrorCode;
        this.subErrorMsg = subErrorMsg;
    }

    public BusinessException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMsg = message;
        if (cause instanceof BusinessException) {
            BusinessException subException = (BusinessException)cause;
            this.subErrorCode = String.valueOf(subException.errorCode);
            this.subErrorMsg = subException.errorMsg;
        } else if (Objects.nonNull(cause)) {
            this.subErrorCode = cause.getClass().getSimpleName();
            this.subErrorMsg = cause.getMessage();
        } else {
            this.subErrorCode = null;
            this.subErrorMsg = null;
        }

    }

    /** @deprecated */
    @Deprecated
    public BusinessException(int errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = null;
        if (cause instanceof BusinessException) {
            BusinessException subException = (BusinessException)cause;
            this.subErrorCode = String.valueOf(subException.errorCode);
            this.subErrorMsg = subException.errorMsg;
        } else if (Objects.nonNull(cause)) {
            this.subErrorCode = cause.getClass().getSimpleName();
            this.subErrorMsg = cause.getMessage();
        } else {
            this.subErrorCode = null;
            this.subErrorMsg = null;
        }

    }

    public BusinessException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMessage();
        this.subErrorCode = null;
        this.subErrorMsg = null;
    }

    public BusinessException(IErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode.getCode();
        this.errorMsg = errorCode.getMessage();
        if (cause instanceof BusinessException) {
            BusinessException subException = (BusinessException)cause;
            this.subErrorCode = String.valueOf(subException.errorCode);
            this.subErrorMsg = subException.errorMsg;
        } else if (Objects.nonNull(cause)) {
            this.subErrorCode = cause.getClass().getSimpleName();
            this.subErrorMsg = cause.getMessage();
        } else {
            this.subErrorCode = null;
            this.subErrorMsg = null;
        }

    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getSubErrorCode() {
        return this.subErrorCode;
    }

    public String getSubErrorMsg() {
        return this.subErrorMsg;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusinessException)) {
            return false;
        } else {
            BusinessException other = (BusinessException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getErrorCode() != other.getErrorCode()) {
                return false;
            } else {
                label49: {
                    Object this$errorMsg = this.getErrorMsg();
                    Object other$errorMsg = other.getErrorMsg();
                    if (this$errorMsg == null) {
                        if (other$errorMsg == null) {
                            break label49;
                        }
                    } else if (this$errorMsg.equals(other$errorMsg)) {
                        break label49;
                    }

                    return false;
                }

                Object this$subErrorCode = this.getSubErrorCode();
                Object other$subErrorCode = other.getSubErrorCode();
                if (this$subErrorCode == null) {
                    if (other$subErrorCode != null) {
                        return false;
                    }
                } else if (!this$subErrorCode.equals(other$subErrorCode)) {
                    return false;
                }

                Object this$subErrorMsg = this.getSubErrorMsg();
                Object other$subErrorMsg = other.getSubErrorMsg();
                if (this$subErrorMsg == null) {
                    if (other$subErrorMsg != null) {
                        return false;
                    }
                } else if (!this$subErrorMsg.equals(other$subErrorMsg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BusinessException;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getErrorCode();
        Object $errorMsg = this.getErrorMsg();
        result = result * 59 + ($errorMsg == null ? 43 : $errorMsg.hashCode());
        Object $subErrorCode = this.getSubErrorCode();
        result = result * 59 + ($subErrorCode == null ? 43 : $subErrorCode.hashCode());
        Object $subErrorMsg = this.getSubErrorMsg();
        result = result * 59 + ($subErrorMsg == null ? 43 : $subErrorMsg.hashCode());
        return result;
    }

    public String toString() {
        return "BusinessException(errorCode=" + this.getErrorCode() + ", errorMsg=" + this.getErrorMsg() + ", subErrorCode=" + this.getSubErrorCode() + ", subErrorMsg=" + this.getSubErrorMsg() + ")";
    }
}
