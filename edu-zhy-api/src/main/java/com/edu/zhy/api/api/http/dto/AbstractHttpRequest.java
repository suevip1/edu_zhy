package com.edu.zhy.api.api.http.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractHttpRequest implements Serializable {
    private static final long serialVersionUID = 1107522469901752984L;

    /**
     * *请求网址
     */
    private String url;

}
