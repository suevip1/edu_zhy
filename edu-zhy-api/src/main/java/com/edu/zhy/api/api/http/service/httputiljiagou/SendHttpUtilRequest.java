package com.edu.zhy.api.api.http.service.httputiljiagou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendHttpUtilRequest {

    private String url;

    /**
     * *true 为get请求;
     * *false 为post请求
     */
    private Boolean isRequest;

    //POST请求body参数
    private Map<String, Object> bodyMap = new HashMap<>();
    //POST请求header参数
    private Map<String, String> headerMap;






}
