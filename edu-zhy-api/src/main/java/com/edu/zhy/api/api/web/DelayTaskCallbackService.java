package com.edu.zhy.api.api.web;

import com.edu.zhy.api.api.web.dto.DelayTaskMessage;

public interface DelayTaskCallbackService {

    /**
     * tsp 延时任务统一回调入口
     * @return
     */
    boolean tspCallBackExecuteCore(DelayTaskMessage message);

}
