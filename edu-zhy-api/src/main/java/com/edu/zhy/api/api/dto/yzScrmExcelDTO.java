package com.edu.zhy.api.api.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class yzScrmExcelDTO {

    //手机号
    @ExcelProperty("手机号")
    private String phone;

    //姓名
    @ExcelProperty("姓名")
    private String name;

    //性别
    @ExcelProperty("性别")
    private String sex;

    //生日
    @ExcelProperty("生日")
    private String birthDay;

    //微信
    @ExcelProperty("微信")
    private String wx;

    //备注
    @ExcelProperty("备注")
    private String remark;

    //省
    @ExcelProperty("省")
    private String province;

    //市
    @ExcelProperty("市")
    private String theCity;

    //区/县
    @ExcelProperty("区/县")
    private String areaCounty;

    //积分(整数)
    @ExcelProperty("积分")
    private Long points;

    //储值余额（单位：元，精确小数点后两位）
    @ExcelProperty("储值余额")
    private String storedBalance;

    //储值赠送金（单位：元，精确小数点后两位）
    @ExcelProperty("储值赠送金")
    private String storeBonus;

    //标签（注：多个用、隔开，标签不存在则新建标签。如：标签A、标签B）
    @ExcelProperty("标签")
    private String tag;

    //会员等级值（VIP+等级值。如：VIP1）
    @ExcelProperty("会员等级值")
    private String membershipLevel;

    //成长值（限整数）
    @ExcelProperty("成长值")
    private Long growthValue;

    //有效期（注：限付费会员，单位为月）
    @ExcelProperty("有效期")
    private String validity;

    //[分销员]手机号（11位手机号）
    @ExcelProperty("[分销员]手机号")
    private String distributorPhone;

    //[导购员]手机号（11位手机号）
    @ExcelProperty("[导购员]手机号")
    private String shoppingGuidePhone;


    /**
     * 领券时,指定面额, 单位为分
     */
    private Long assignValue;
    /**
     * 随机券面额范围（单位：分）
     */
    private Long valueRandomTo;




}
