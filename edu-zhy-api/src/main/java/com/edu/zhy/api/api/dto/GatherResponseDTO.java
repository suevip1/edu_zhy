package com.edu.zhy.api.api.dto;

/**
 * @Author: xiaopeng
 * @Date: 2019-06-21
 */
@lombok.Data
public class GatherResponseDTO implements java.io.Serializable {
    /**
     * 是否有业务异常
     * true 业务执行成功
     * false 存在异常信息
     */
    private boolean bizSuccess;

    /**
     * 订单号
     */
    private String orderNo;

    private String orderId;

    /**
     * 预支付单号
     */
    private String prepayId;

    /**
     * 支付二维码的 url
     */
    private String payUrl;

}
