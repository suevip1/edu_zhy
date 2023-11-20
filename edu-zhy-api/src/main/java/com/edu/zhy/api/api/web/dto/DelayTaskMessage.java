package com.edu.zhy.api.api.web.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class DelayTaskMessage implements Serializable {
    private static final long serialVersionUID = 2791788839349682623L;

    /**
     * 业务类型
     */
    protected String taskType;

    protected String bizID;

    protected String bizExtraID;

    protected String shardingID;
    /**
     * 操作类型（增加、暂停、恢复、终止、延期）
     */
    protected String taskOption;
    /**
     * 指定延时任务到期时间,只用于增加操作
     */
    protected Long delayEndTime;

    /**
     * 用于暂停
     */
    protected Long delaySuspendTime;

    /**
     * （只用于恢复操作,值为null 则以currentTime填充）
     */
    protected Long delayResumeTime;

    /**
     * 用于 postpone 操作的延迟时间 ms
     */
    protected Long delayPeriod;
    /**
     * 客户端额外信息
     */
    protected String extra;
    /***传递的数据*/
    protected String data;

    protected Map serviceChainTag;

}
