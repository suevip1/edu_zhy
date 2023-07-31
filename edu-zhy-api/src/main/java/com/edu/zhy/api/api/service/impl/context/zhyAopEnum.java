package com.edu.zhy.api.api.service.impl.context;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum zhyAopEnum {
    COLLECT_INFO_SET("SET", "collect_info_set", "资源信息收集-配置"),
    ;

    /**
     * 业务模块
     */
    private String module;

    /**
     * 模块
     */
    private String code;
    /**
     * 模块desc
     */
    private String desc;



    zhyAopEnum(String module, String code, String desc) {
        this.module = module;
        this.code = code;
        this.desc = desc;
    }


//    public static zhyAopEnum parseByCode(String code) {
//
//        if (StringUtils.isEmpty(code)) {
//            return null;
//        }
//
//        for (zhyAopEnum bizModuleEnum : zhyAopEnum.values()) {
//            if (bizModuleEnum.getCode().equals(code)) {
//                return bizModuleEnum;
//            }
//        }
//
//        return null;
//    }



}
