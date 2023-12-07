package com.edu.zhy.api.api.Cache;

/**
 * Created by Admin.
 * Time 2023/12/4 16:14
 * Desc 文件描述
 */
public interface LocalCache<T> {

    void add(String key, T value);

    T get(String key);


}
