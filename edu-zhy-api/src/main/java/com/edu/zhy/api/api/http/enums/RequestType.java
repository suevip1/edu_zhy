package com.edu.zhy.api.api.http.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RequestType {

    COMMON_TYPE(1,"commonType","一般用的http请求"),
    PAOLIVAY_TYPE(2,"PaoLiVayType","保利威请求")
    ;


    private Integer type;

    private String name;

    private String desc;



    //用type来寻找
    private static RequestType valueOfType(Integer type){
        for (RequestType requestType :RequestType.values()){
            if (Objects.equals(requestType.type,type)){
                return requestType;
            }

        }
        return null;
    }


    //根据名称来查找
    private static RequestType valueOfName(String name){
       return Arrays.stream(values())
               .filter(o -> Objects.equals(name,o.getName()))
               .findFirst()
               .orElse(null);
    }



}
