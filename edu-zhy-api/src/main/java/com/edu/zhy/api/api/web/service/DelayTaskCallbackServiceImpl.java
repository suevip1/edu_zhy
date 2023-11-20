package com.edu.zhy.api.api.web.service;

import com.edu.zhy.api.api.web.DelayTaskCallbackService;
import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.api.api.web.factory.TspTaskExecutorFactory;

public class DelayTaskCallbackServiceImpl implements DelayTaskCallbackService {
    @Override
    public boolean tspCallBackExecuteCore(DelayTaskMessage message) {

        TspTaskExecutorFactory.getInstance().handler(message).callBackExecute(message);
        return true;
    }
}
