package com.edu.zhy.api.api.http.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public abstract class AbstractCommonParam  implements Serializable {
    private static final long serialVersionUID = 8330423349738517178L;

    private Long id;

    private String userId;

    private String appId;

    private String appSecret;

    public AbstractCommonParam(String userId, String appId, String appSecret) {
        this.userId = userId;
        this.appId = appId;
        this.appSecret = appSecret;
    }



}
