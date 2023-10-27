package com.edu.zhy.api.api.http.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractHttpRequest implements Serializable {
    private static final long serialVersionUID = 1107522469901752984L;

    /**
     * *请求网址
     */
    private String url;

    /**
     * *true 为get请求;
     * *false 为post请求
     */
    private Boolean isRequest;

    /**
     * *GET请求下的网址格式
     * *get请求需要的（这个暂时可以先不用;目前没想到验证方式）
     * *目前格式:/参数/参数?   (这样拼接)
     */
    private String exampleUrl;

    /**
     * *GET请求下的网址格式字段重要参数名称
     * *get请求需要的    &  前面的参数(需要拼接到链接上的前置字段)
     * *需要自己排好序哈
     */
    private List<String> getMapName;



    /**
     * * 请求内部接口*
     */

    //属于请求头
    /**
     * * 格式: application/json
     */
    private String contentType;
    /**
     * * cookie信息 电脑抓
     */
    private String cookie;
    /**
     * * 电脑信息
     */
    private String userAgent;

    //属于请求实体内容
    /**
     * * 内部访问应用  owl-live
     */
    private String app;
    /**
     * * 内部访问应用环境 pre
     */
    private String env;
    /**
     * *  接口路径： com.youzan.owl.live.api.live.video.EduPolyvRemakesPlayBackFacade
     */
    private String service;
    /**
     * * 方法名称
     */
    private String method;
    /**
     * *参数
     */
    private String args;
    /**
     * * 内部sc环境
     */
    private String sc;
    /**
     * *10000L
     */
    private String timeout;
    /**
     * *0L
     */
    private String retries;







    /**
     * * 请求外部接口(请求头)
     * *Cache-Control: no-cache
     */
    private String cacheControl;











}
