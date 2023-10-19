package com.edu.zhy.api.api.visibility;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: zishan
 * @Date: 2020-02-19
 */
@Data
public class HidingConfigDTO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 所在类reference
     */
    private String reference;

    /**
     * 隐藏字端名称
     */
    private String hideFieldName;

    /**
     * 开关来源 1:visbility_config 2:配置中心
     */
    private Integer switchSource;

    /**
     * 开关读取用到id字端名称，如：kdtId，alias
     */
    private String switchIndicatorName;

    /**
     * 开关类型：当switch_source为1时：1订阅数开关 2:更新期数开关；当switch_source为2时：配置中心的key
     */
    private String switchIndicatorType;

    /**
     * 默认是否隐藏 0:不隐藏
     */
    private Integer defaultDisplay;

    /**
     * 转化器类型：0:数字转化器，1:手机号转化器
     */
    private Integer converter;
}
