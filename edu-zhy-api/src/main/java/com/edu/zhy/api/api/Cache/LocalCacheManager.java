package com.edu.zhy.api.api.Cache;

import com.edu.zhy.api.api.Cache.DTO.AbstractLocalCacheDTO;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin.
 * Time 2023/12/4 16:19
 * Desc 文件描述
 */
public class LocalCacheManager {
    private LocalCache<Object> notFoundCache = new LocalCache<Object>() {
        @Override
        public void add(String key, Object value) {

        }

        @Override
        public Object get(String key) {
            return null;
        }
    };

    private Map<Class, LocalCache> cacheMap = new HashMap<>();

    @PostConstruct
    public void init(){
        register(AbstractLocalCacheDTO.class, new AbstractLocalCache<List<AbstractLocalCacheDTO>>() {});
    }

    public <T> void register(Class<T> clazz, LocalCache<?> localCache){
        cacheMap.put(clazz, localCache);
    }

    public <T> LocalCache<T> getLocalCache(Class<T> clazz) {
        //noinspection unchecked
        return (LocalCache<T>) cacheMap.getOrDefault(clazz, notFoundCache);
    }

    public <T> LocalCache<List<T>> getGenericLocalCache(Class<T> clazz){
        //noinspection unchecked
        return (LocalCache<List<T>>) cacheMap.getOrDefault(clazz, notFoundCache);
    }


}
