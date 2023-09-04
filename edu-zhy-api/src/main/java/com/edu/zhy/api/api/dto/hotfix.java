package com.edu.zhy.api.api.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class hotfix implements Serializable {
    /**
     * 订单号
     */
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("手机号")
    private String phone;

    /**
     * 预支付单号
     */
    @ExcelProperty("地址")
    private String adress;

    /**
     * 支付二维码的 url
     */
    @ExcelProperty("爱心捐赠")
    private String pay;

}
