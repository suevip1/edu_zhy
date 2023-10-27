package com.edu.zhy.api.api.http.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum GeneratorType {
    COMMON_TYPE_GENERATOR(1,"commonTypeGenerator","一般用的http请求"),
    PAOLIVAY_TYPE_GENERATOR(2,"PaoLiVayTypeGenerator","保利威请求")
    ;


    private Integer type;

    private String name;

    private String desc;



    //用type来寻找
    private static GeneratorType valueOfType(Integer type){
        for (GeneratorType generatorType :GeneratorType.values()){
            if (Objects.equals(generatorType.type,type)){
                return generatorType;
            }

        }
        return null;
    }


    //根据名称来查找
    private static GeneratorType valueOfName(String name){
        return Arrays.stream(values())
                .filter(o -> Objects.equals(name,o.getName()))
                .findFirst()
                .orElse(null);
    }
}
