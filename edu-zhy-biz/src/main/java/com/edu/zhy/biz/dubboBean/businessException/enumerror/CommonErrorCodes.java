package com.edu.zhy.biz.dubboBean.businessException.enumerror;


import com.edu.zhy.biz.dubboBean.businessException.IErrorCode;

public enum CommonErrorCodes implements IErrorCode {
    COMMON_ERROR(100, "执行错误"),
    ILLEGAL_PARAM(101, "参数错误"),
    ENTITY_NOT_FOUND(102, "实体不存在"),
    LOCK_EXCEPTION(103, "锁定错误"),
    AUTH_FAIL(110, "越权校验失败"),
    CHAIN_AUTH_FAIL(111, "连锁越权校验失败"),
    SHOP_CAPACITY_AUTH_FAIL(112, "店铺能力校验失败");

    private final int code;
    private final String message;

    private CommonErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
