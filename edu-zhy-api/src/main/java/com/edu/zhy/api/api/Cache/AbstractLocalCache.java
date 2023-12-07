package com.edu.zhy.api.api.Cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin.
 * Time 2023/12/4 15:56
 * Desc 文件描述
 */
@Slf4j
public  class AbstractLocalCache<T> implements LocalCache<T> {


    private Cache<String, T> cache;

    private long maximumSize = 5000L;

    private long expireAfterWrite = 60L;

    public AbstractLocalCache(){
        init();
    }

    public AbstractLocalCache(long maximumSize, long expireAfterWrite){
        this.maximumSize = maximumSize;
        this.expireAfterWrite = expireAfterWrite;
    }

    public void init(){
        cache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS)
                .build();
    }



    @Override
    public void add(String key, T value) {
        if (StringUtils.isNotBlank(key) && value != null) {
            cache.put(key, value);
        }

    }

    @Override
    public T get(String key) {
        if (StringUtils.isNotBlank(key)) {

            T value = cache.getIfPresent(key);
            if (value != null) {
                log.info("缓存命中，key:{}", key);
            }
            return value;
        }
        return null;
    }





}
