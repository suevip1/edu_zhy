package com.edu.zhy.api.api.http.dto;

import com.edu.zhy.api.api.http.polyv.PolyvRequest;
import lombok.Data;

import java.io.Serializable;

/**
 */
@Data
public abstract class AbstractCommonRequest implements Serializable, PolyvRequest {

    /**
     * 从API设置中获取，在直播系统登记的appId
     */
    String appId;

    /**
     * 当前时间的秒级时间戳（13位）
     */
    String timestamp;

    /**
     * 签名， 32 位大写的 MD5 值
     */
    String sign;

}
