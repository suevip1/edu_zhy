package com.edu.zhy.api.api.web.factory;

import com.edu.zhy.api.api.web.dto.DelayTaskMessage;

public abstract class AbstractTspTask implements TspCallBackExecutor{


    /**
     * 延时任务体
     */
//    @Getter
//    protected TaskRequest taskRequest;
//
//    private TspServiceClient tspServiceClient;

    protected void init() {
//        tspServiceClient = ApplicationContextHelper.getBean(TspServiceClient.class);
        System.err.println("AbstractTspTask.init 执行方法");
    }

    public AbstractTspTask(String bizId, String bizExtraId, long executeTime) {
        //tsp api: http://paas.qima-inc.com/docs/tsp/user/api_task.html
//        taskRequest = TaskRequest.builder()
//                .optionType(TaskOptionType.TASK_ADD)
//                .taskType(TaskType.DELAYED)
//                .configName(getTaskType())
//                .bizId(bizId)
//                .bizExtraId(bizExtraId)
//                .executeTime(executeTime)
//                .retryCnt(10)
//                //创建任务时 任务已存在，且为 初始状态 or 已结束状态 则重置为 初始状态
//                .optPolicy(OptPolicy.OPT_INIT)
//                .build();
        System.err.println("AbstractTspTask.AbstractTspTask 执行方法");
        init();
    }


    public AbstractTspTask(DelayTaskMessage delayTaskMessage) {
        this(delayTaskMessage.getBizID(), delayTaskMessage.getBizExtraID(), delayTaskMessage.getDelayEndTime());
    }

    /**
     * 提供给定时任务这样无参数的使用
     */
    public AbstractTspTask() {
        init();
    }

    /**
     * 获取任务类型
     *
     * @see TspTaskConstant
     */
    public abstract String getTaskType();

//    /**
//     * 获取任务详情
//     */
//    public TaskDTO getTaskDetail() {
//        return tspServiceClient.getTaskDetail(taskRequest);
//    }
//
//    /**
//     * 新增延时任务
//     */
//    public void create() {
//        tspServiceClient.createTask(taskRequest);
//    }
//
//    /**
//     * 取消延时任务
//     */
//    public boolean cancel() {
//        return tspServiceClient.cancelTask(taskRequest);
//    }

//    /**
//     * 强制添加任务
//     */
//    public void forceAddTask() {
//        // 1 优先取消任务
//        cancelAllTask();
//
//        // 2 添加任务
//        create();
//    }
//
//    /**
//     * 取消所有任务
//     */
//    public void cancelAllTask() {
//        List<TaskDTO> taskDTOList = tspServiceClient.getAllTaskList(getTaskType(), taskRequest.getBizId());
//        if (CollectionUtils.isEmpty(taskDTOList)) {
//            return;
//        }
//        taskDTOList.forEach(each -> {
//            if (Objects.isNull(each)) {
//                return;
//            }
//
//            if (TaskStatus.FIN.code() == each.getStatus()) {
//                return;
//            }
//            tspServiceClient.cancelTask(getTaskType(), each.getBizId(),
//                    Optional.ofNullable(each.getExtra()).map(TaskExtra::getBizExtraID).orElse(null));
//        });
//    }
//
//
//    /**
//     * 强制添加任务
//     */
//    public void forceAddTaskV2() {
//        // 1 优先取消任务
//        cancelAllTaskV2();
//
//        // 2 添加任务
//        create();
//    }
//
//    /**
//     * 取消所有任务
//     */
//    public void cancelAllTaskV2() {
//        List<TaskDTO> taskDTOList = tspServiceClient.getAllTaskListV2(getTaskType(), taskRequest.getBizId());
//        if (CollectionUtils.isEmpty(taskDTOList)) {
//            return;
//        }
//        taskDTOList.forEach(each -> {
//            if (Objects.isNull(each)) {
//                return;
//            }
//
//            if (TaskStatus.FIN.code() == each.getStatus()) {
//                return;
//            }
//            tspServiceClient.cancelTask(getTaskType(), each.getBizId(),
//                    Optional.ofNullable(each.getExtra()).map(TaskExtra::getBizExtraID).orElse(null));
//        });
//    }


}
