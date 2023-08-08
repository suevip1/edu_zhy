package com.edu.zhy.api.api.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelKttOrderDTO implements Serializable {
    private static final long serialVersionUID = -3099606540379049208L;

    //跟团号
    @ExcelProperty("跟团号")
    private String packageNumber;

    //下单人
    @ExcelProperty("下单人")
    private String payOrderName;

    //支付时间
    @ExcelProperty("支付时间")
    private String payDate;

    //商品
    @ExcelProperty("商品")
    private String product;

    //订单金额
    @ExcelProperty("订单金额")
    private String payPrice;

    //订单退款
    @ExcelProperty("订单退款")
    private String refundPrice;

    //订单状态
    @ExcelProperty("订单状态")
    private String status;

    //收货人
    @ExcelProperty("收货人")
    private String consignee;

    //联系电话
    @ExcelProperty("联系电话")
    private String phone;

    //详细地址
    @ExcelProperty("详细地址")
    private String  detailedAddress;









}
