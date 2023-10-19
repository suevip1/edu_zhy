package com.edu.zhy.api.api.http.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractHttpResponse<T> implements Serializable {
    private static final long serialVersionUID = -3556058019030712456L;

    /**
     * *请求code
     */
    private Integer code;

    /**
     * *请求描述
     */
    private String message;

    /**
     **数据
     */
    private T date;

    /**
     * *请求是否成功
     */
    private Boolean success;



}
