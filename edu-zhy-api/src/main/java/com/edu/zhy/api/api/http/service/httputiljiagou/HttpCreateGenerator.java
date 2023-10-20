package com.edu.zhy.api.api.http.service.httputiljiagou;

public interface HttpCreateGenerator<K,V> {

    /**
     * *构造参数共同参数
     * @param k
     * @param v
     * @return
     */
    SendHttpContext generator(K k, V v);




}
