package com.edu.zhy.api.api.dto;

@lombok.Getter
@lombok.AllArgsConstructor
public enum HandleChainScene {
    /**
     * 责任链场景
     */
    NULL_CHAIN("null_chain", "返回为 null 的 chain"),
    TRADE_OFFLINE_NORMAL("offline_normal", "线下报名普通下单流程链"),
    TRADE_OFFLINE_RENEW("offline_renew", "线下报名续费下单流程链"),
    TRADE_OFFLINE_QUICK("offline_quick", "线下报名快速收款流程链"),
    REFUND("refund", "教育逆向处理流程"),
    REFUND_NEW("refund_new", "教育逆向处理流程,支持续费"),
    REFUND_CALLBACK("refund_callback", "教育退款消息后置流程链"),
    COURSE_LINK_QUERY("offline_quick#course_link_query", "补充课程商品的查询流程链"),
    LINK_COURSE("offline_quick#link_course", "补充报名信息");

    private String name;
    private String desc;
}
