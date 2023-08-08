package com.edu.zhy.api.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum AddressTypeEnum {

    PROVINCE(1,"省"),
    TEAMCITY(2,"市"),
    ACCOUNT(3,"区/县");


    private Integer type;

    private String content;


    private static final Map<Integer, AddressTypeEnum> VALUE_ENUM_CACHE = new HashMap<>();
    private static final Map<String, AddressTypeEnum> STATUS_ENUM_CACHE = new HashMap<>();

    static {
        for (AddressTypeEnum statusEnum : AddressTypeEnum.values()) {
            VALUE_ENUM_CACHE.put(statusEnum.getType(), statusEnum);
            STATUS_ENUM_CACHE.put(statusEnum.getContent(), statusEnum);
        }
    }


    public static AddressTypeEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        return VALUE_ENUM_CACHE.get(value);
    }
}
