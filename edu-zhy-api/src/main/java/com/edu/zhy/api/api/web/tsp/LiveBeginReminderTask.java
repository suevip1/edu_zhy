package com.edu.zhy.api.api.web.tsp;

import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.api.api.web.factory.AbstractTspTask;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;

import static com.edu.zhy.api.api.web.factory.TspTaskConstant.LIVE_BEGIN_REMINDER_TASK;

public class LiveBeginReminderTask extends AbstractTspTask {
    private String liveGoodsAlias;

    private Long kdtId;

    private Long executeTime;
//
//    private LiveSubscriptionClient liveSubscriptionClient;
//
//    private LiveProductClient liveProductClient;

    /**
     * 分页查询订阅用户数目
     */
    private static final int SUBSCRIPTION_USER_PAGE_QUERY_SIZE = 100;

    /**
     * 消息分批推送hedwig的分片大小
     */
    private static final int HEDWIG_BATCH_PUSH_CHUNK_SIZE = 20;

    /**
     * 提醒任务构造方法
     *
     * @param liveGoodsAlias 直播商品Alias
     * @param kdtId          店铺kdtId
     * @param executeTime    延时时间的执行时间
     */
    public LiveBeginReminderTask(String liveGoodsAlias, Long kdtId, long executeTime) {
        super(liveGoodsAlias, kdtId.toString(), executeTime);
        this.liveGoodsAlias = liveGoodsAlias;
        this.kdtId = kdtId;
        this.executeTime = executeTime;
    }

    public LiveBeginReminderTask(DelayTaskMessage delayTaskMessage) {
        super(delayTaskMessage);
        this.liveGoodsAlias = delayTaskMessage.getBizID();
        this.kdtId = Long.parseLong(delayTaskMessage.getBizExtraID());
        this.executeTime = delayTaskMessage.getDelayEndTime();
    }

    @Override
    protected void init() {
        super.init();

//        liveSubscriptionClient = ApplicationContextHelper.getBean(LiveSubscriptionClient.class);
//        liveProductClient = ApplicationContextHelper.getBean(LiveProductClient.class);
    }

    @Override
    public String getTaskType() {
        return LIVE_BEGIN_REMINDER_TASK;
    }


    @Override
    public void callBackExecute(DelayTaskMessage msg) throws BusinessException {

        System.err.println("LiveBeginReminderTask.callBackExecute 执行逻辑");
    }





}
