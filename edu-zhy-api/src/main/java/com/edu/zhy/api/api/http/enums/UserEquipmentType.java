package com.edu.zhy.api.api.http.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UserEquipmentType {
    USER_EQUIPMENT_TYPE_V1("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36"),

    USER_EQUIPMENT_TYPE_V2(""),

    ;
    private String userMessage;
}
