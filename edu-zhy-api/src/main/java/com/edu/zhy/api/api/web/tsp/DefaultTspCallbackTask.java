package com.edu.zhy.api.api.web.tsp;

import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.api.api.web.factory.AbstractTspTask;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;

public class DefaultTspCallbackTask extends AbstractTspTask {


    public DefaultTspCallbackTask(DelayTaskMessage delayTaskMessage) {
        super(delayTaskMessage);
    }

    @Override
    public void callBackExecute(DelayTaskMessage msg) throws BusinessException {
        System.err.println("DefaultTspCallbackTask.callBackExecute 执行逻辑");
    }

    @Override
    public String getTaskType() {
        return null;
    }
}
