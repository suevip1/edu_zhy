package com.edu.zhy.biz.dubboBean.businessException;


/**
 * TODO 类实现描述
 *
 * @author: chenhuajiang@youzan.com
 * @date: 15/8/21
 */
public interface IErrorCode {
    /**
     * 错误码
     *
     * @return
     */
    public int getCode();

    /**
     * 错误消息
     *
     * @return
     */
    public String getMessage();
}
