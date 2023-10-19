package com.edu.zhy.api.api.visibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VisibilityConfigDTO implements Serializable {


    /**
     * alias
     */
    private String targetAlias;

    /**
     * 是否可见 true 可见
     */
    private Boolean display;

    /**
     *
     */
    private String config;
}
