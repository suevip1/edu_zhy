package com.edu.zhy.biz.dubboBean.Result;

import com.edu.zhy.biz.dubboBean.Result.resultEnum.CommonResultCode;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用执行结果
 *
 * @author Yu Hui
 */
public class CommonResult<T> extends PlainResult<T> {

    private static final int DEFAULT_ERROR_CODE = -100;
    @Setter
    @Getter
    private String subCode;
    @Setter
    @Getter
    private String subMsg;

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(CommonResultCode.SUCCESS.code);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static CommonResult<Boolean> success() {
        return success(Boolean.TRUE);
    }

    public static <T> CommonResult<T> error(Exception e) {
        int errorCode = DEFAULT_ERROR_CODE;
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return error(be.getErrorCode(), be.getErrorMsg(), be.getSubErrorCode(), be.getSubErrorMsg());
        } else {
            String message = e.getMessage();
            // 这里是为了兼容旧的逻辑，所以将message放在了主层级。实际上应该在子层级里面；
            return error(errorCode, message, e.getClass().getSimpleName(), null);
        }
    }

    public static <T> CommonResult<T> error(int errorCode, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMessage(message);
        return result;
    }

    public static <T> CommonResult<T> error(int errorCode, String message, String subCode, String subMsg) {
        CommonResult<T> result = new CommonResult<>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMessage(message);
        result.setSubCode(subCode);
        result.setSubMsg(subMsg);
        return result;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "success=" + isSuccess() +
                ", code=" + getCode() +
                ", message='" + getMessage() + '\'' +
                ", data=" + getData() +
                '}';
    }
}

