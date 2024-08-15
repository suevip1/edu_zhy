package com.edu.zhy.api.api.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("生日")
    private Date birthday;

    @ExcelProperty("薪资")
    private Double salary;


    /**
     * 领券时,指定面额, 单位为分
     */
    private Long assignValue;
    /**
     * 随机券面额范围（单位：分）
     */
    private Long valueRandomTo;

}
