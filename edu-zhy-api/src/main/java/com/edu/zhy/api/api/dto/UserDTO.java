package com.edu.zhy.api.api.dto;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

@lombok.Data
public class UserDTO {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("生日")
    private Date birthday;

    @ExcelProperty("薪资")
    private Double salary;



}
