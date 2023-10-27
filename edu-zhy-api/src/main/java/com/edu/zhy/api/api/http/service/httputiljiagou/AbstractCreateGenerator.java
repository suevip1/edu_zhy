package com.edu.zhy.api.api.http.service.httputiljiagou;

import com.edu.zhy.api.api.http.dto.AbstractHttpParam;
import com.edu.zhy.api.api.http.dto.AbstractHttpRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class AbstractCreateGenerator<K extends AbstractHttpRequest,V extends AbstractHttpParam> implements HttpCreateGenerator<K,V> {

    //这里处理一些转换的共同参数;也可以不处理下放到业务里面在处理
    @Override
    public SendHttpContext generator(K k, V v) {
        throw new UnsupportedOperationException();
    }


    @Override
    public Integer generatorType() {
        return null;
    }

}
