package com.edu.zhy.api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeOrderEvent implements Serializable {
    /**
     * 订单消息类型 see
     */
    private Integer type;
    /**
     * 交易订单来源
     * 1: 线上交易
     * 2: 线下交易
     *
     *
     */
    private Integer origin;
    /**
     * 交易订单实体数据
     */
    private String data;

    /**
     * 订单类型 see
     */
    private Integer orderType;

    /**
     * 消息版本
     * 1：目前线上走的消息逻辑
     * 2：教育统一消息后走的逻辑
     */
    private Integer version;
    /**
     * 扩展信息
     * key: TradeEventExtEnum.key
     * value: JSONObject.toJSONString
     */
    private Map<String, String> extMap;

    /**
     * 唯一标识
     */
    private String uniqueKey;



    //////

    private Integer min;

    private Integer max;
}
