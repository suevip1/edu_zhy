package com.edu.zhy.biz.dubboBean.Result;

import com.edu.zhy.biz.dubboBean.Result.resultEnum.CommonResultCode;
import com.edu.zhy.biz.dubboBean.businessException.IErrorCode;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * 接口返回的基础类，通过success判断本次调用在服务器端执行是否成功
 *
 * @author: chenhuajiang@youzan.com
 * @date: 15/8/21
 */
@ToString
@EqualsAndHashCode
public class BaseResult implements Serializable{

    private static final long serialVersionUID = 1949910043360896391L;

    /**
     * 标识本次调用是否返回
     */
    private boolean success;

    /**
     * 本次调用返回code，一般为错误代码
     */
    private int code;

    /**
     * 本次调用返回的消息，一般为错误消息
     */
    private String message;

    /**
     * 请求Id
     */
    private String requestId;

    /**
     * 调用失败返回的数据
     */
    private Map<String, Object> errorData;

    public BaseResult() {
        this.code = CommonResultCode.SUCCESS.code;
        this.success = true;
        this.message = CommonResultCode.SUCCESS.message;
    }

    /**
     * 设置错误信息
     *
     * @param code
     * @param message
     */
    public <R extends BaseResult> R setErrorMessage(int code, String message) {
        this.code = code;
        this.success = false;
        this.message = message;
        return (R) this;
    }

    public <R extends BaseResult> R setErrorMessage(IErrorCode code, Object... args) {
        this.code = code.getCode();
        this.success = false;
        this.message = String.format(code.getMessage(), args);
        return (R) this;
    }

    /**
     * 设置错误信息
     *
     * @param rc
     * @param args
     * @return
     * @see CommonResultCode
     */
    public <R extends BaseResult> R setError(CommonResultCode rc, Object... args) {
        this.code = rc.code;
        this.success = false;
        if (args == null || args.length == 0) {
            this.message = rc.message;
        } else {
            this.message = String.format(rc.message, args);
        }
        return (R) this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, Object> getErrorData() {
        return errorData;
    }

    public void setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
    }
}

