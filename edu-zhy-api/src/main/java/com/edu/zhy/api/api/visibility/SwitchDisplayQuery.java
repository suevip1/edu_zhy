package com.edu.zhy.api.api.visibility;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: zishan
 * @Date: 2020-02-20
 */
@Data
@Builder
public class SwitchDisplayQuery implements Serializable {

    /**
     * 开关来源 1:visbility_config 2:配置中心
     */
    private Integer switchSource;

    /**
     * 开关类型：1：订阅数开关 2:更新期数开关
     */
    private String switchIndicatorType;

}
