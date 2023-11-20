package com.edu.zhy.api.api.web.factory;

public interface TspTaskConstant {
    /**
     * 直播开始前提醒任务
     */
    String LIVE_BEGIN_REMINDER_TASK = "owl_live_begin_reminder";

    /**
     * 直播活动结束任务
     */
    String LIVE_FLOE_END_TASK = "owl_live_flow_end";

    /**
     * 保利威删除直播任务
     */
    String POLYV_DELETE_FAIL_RETRY = "owl_live_polyv_delete";

    /**
     * 教育视频直播自动结束
     */
    String EDU_POLYV_AUTO_FINISH = "owl_live_edu_auto_finish";

    /**
     * 定时拉去保利威数据
     */
    String LIVE_PULL_POLYV_WATCH = "owl_live_pull_polyv_watch_record";

    /**
     * 全量数据
     */
    String LIVE_PULL_ALL_POLYV_WATCH = "owl_live_pull_all_polyv_watch_record";

    /**
     * 打烊店铺
     */
    String LIVE_PULL_CLOSED_WATCH = "owl_live_pull_closed_kdtid";

    /**
     * 直播视频结束后拉去数据
     */
    String LIVE_FINISH_PULL_DATA = "owl_live_finish_pull_watch";


    /**
     * 结束后六小时自动比较录制的视频
     */
    String LIVE_PLAY_BACK_COMPARE = "owl_live_play_back_compare";

    /**
     * 加入流量补贴白名单商家
     */
    String LIVE_AVOID_ALLOWANCE_KDT = "owl_live_avoid_allowance_kdt";

    /**
     * 直播开始任务回调
     */
    String LIVE_START_TASK = "owl-live-start";

    /**
     * 直播开始任务回调的分隔符
     */
    String LIVE_START_TASK_SEPARATOR = "_";


    /**
     * 直播开始任务回调
     */
    String EDU_LIVE_START_TASK = "edu_live_start";

    /**
     * 直播活动结束任务
     */

    String EDU_LIVE_END_TASK = "edu_live_end";




    /**
     * 直播开始前提醒任务
     */
    String EDU_LIVE_START_REMINDER_TASK = "edu_live_start_reminder";


    /**
     * 白板任务
     */
    String EDU_LIVE_WHITEBOARD_TASK = "edu_live_whiteboard";
    /**
     * 白板任务
     */
    String EDU_LIVE_WHITEBOARD_CONVERSION_TASK = "edu_live_whiteboard_conversion";


}
