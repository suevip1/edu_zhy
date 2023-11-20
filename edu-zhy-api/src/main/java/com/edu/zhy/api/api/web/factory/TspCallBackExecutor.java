package com.edu.zhy.api.api.web.factory;

import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;

public interface TspCallBackExecutor {

    /**
     * toc回调执行的具体方法
     *
     * @param msg 回调消息体
     */
    void callBackExecute(DelayTaskMessage msg) throws BusinessException;
}
