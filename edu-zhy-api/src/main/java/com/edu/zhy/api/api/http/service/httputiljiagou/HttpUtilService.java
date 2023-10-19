package com.edu.zhy.api.api.http.service.httputiljiagou;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import com.edu.zhy.api.api.http.dto.AbstractHttpResponse;

/**
 * *
 * @param <K> 执行固定重要参数
 * @param <V> 执行可变参数
 * @param <T> 执行需要返回参数
 */
public interface HttpUtilService<K extends AbstractHttpRequest,V extends AbstractHttpParam,T extends AbstractHttpResponse> {

    /**
     * * 路由的类型
     * @return
     */
    Integer getHttpType();

    /**
     * *前置参数效验
     * @param k
     * @param v
     */
    void preCheck(K k,V v);

    /**
     * 执行(主要不返参)
     * * @param k
     * @param v
     */
    void Execute(K k,V v);


    /**
     * *执行(带返参)
     * @param k
     * @param v
     * @return
     */
    T backExecute(K k,V v);



    /**
     * 后置执行动作
     * * @param k
     * @param v
     */
    void afterExecute(K k,V v);











}
