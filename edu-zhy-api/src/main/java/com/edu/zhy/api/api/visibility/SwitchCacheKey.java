package com.edu.zhy.api.api.visibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: zishan
 * @Date: 2020-02-27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwitchCacheKey {

    private Long kdtId;

    private Integer switchSource;

    private String switchIndicatorType;

    private String indicatorId;

    private boolean defaultDisplay;

}
