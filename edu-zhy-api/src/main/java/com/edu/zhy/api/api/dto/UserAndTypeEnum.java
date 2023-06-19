package com.edu.zhy.api.api.dto;

@lombok.AllArgsConstructor
@lombok.Getter
public enum UserAndTypeEnum {

    USER_TYPE_TT("user_type_tt","厨师"),
    USER_TYPE_SS("user_type_ss","演员");


    private String name;

    private String desc;







}
