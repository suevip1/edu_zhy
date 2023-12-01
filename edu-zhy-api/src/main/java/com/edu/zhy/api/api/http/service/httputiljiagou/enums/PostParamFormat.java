package com.edu.zhy.api.api.http.service.httputiljiagou.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Created by Admin.
 * Time 2023/11/30 16:05
 * Desc 文件描述
 */
@Getter
@AllArgsConstructor
public enum PostParamFormat {
    STRING_VALUE(1,"string类型"),
    LONG_VALUE(2,"long类型"),
    ARRAY_VALUE(3,"array数组类型"),
    OBJECT_VALUE(4,"对象");





    private Integer value;

    private String name;



    public static PostParamFormat valueOfType(Integer type){
        for (PostParamFormat requestType :PostParamFormat.values()){
            if (Objects.equals(requestType.value,type)){
                return requestType;
            }

        }
        return null;
    }
}
