package com.edu.zhy.api.api.dto;

import lombok.Data;

@Data
public class ExcelKttOrderDTO {

    //跟团号
    private Long packageNumber;

    //下单人
    private String payOrderName;

    //支付时间
    private String payDate;

    //商品
    private String product;
    //订单金额
    private Integer payPrice;

    //订单退款
    private String refundPrice;
    //订单状态
    private String status;

    //收货人
    private String consignee;

    //联系电话
    private String phone;

    //详细地址
    private String  detailedAddress;









}
