package com.edu.zhy.api.api.dto;

/**
 * @author heyixin
 **/
@lombok.Data
public class OfflineOrderHandleContext {
    private Long kdtId;
    private Long hqKdtId;

    /**
     * 合同号
     */
    private String contractNo;
    /**
     * 订单创建后的 orderNo
     */
    private String orderNo;

    private String orderId;
    /**
     * 创建的合同场景
     */
    private Integer contractScene;

    /**
     * 合同录入来源
     */
    private Integer contractSource;
    /**
     * 合同名称
     */
    private String contractName;
}
