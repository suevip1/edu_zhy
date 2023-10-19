package com.edu.zhy.api.api.visibility;

import lombok.Getter;

/**
 * @Auther: zishan
 * @Date: 2020-02-20
 */
public enum ConverterTypeEnum {

    QUANTITY_CONVERTER(0),
    MOBILE_CONVERTER(1);


    ConverterTypeEnum(int type) {
        this.type = type;
    }

    @Getter
    private int type;

    public static ConverterTypeEnum getByType(int type) {
        for (ConverterTypeEnum converterTypeEnum : ConverterTypeEnum.values()) {
            if (converterTypeEnum.getType() == type) {
                return converterTypeEnum;
            }
        }
        return null;
    }

}
