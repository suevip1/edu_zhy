package com.edu.zhy.api.api.visibility;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 可见行配置缓存
 *
 * @Auther: zishan
 * @Date: 2019-08-08
 */
@Slf4j
public class SwitchCache {

    private LoadingCache<String, VisibilityConfigDTO> loadingCache;

    /**
     * 最大缓存数量
     */
    private static final Long MAX_SIZE = 10000L;

    /**
     * 缓存时间
     */
    private static final Long EXPIRE_TIME = 60L;

    private static final String SPLIT_STRING = "::";

    @Resource
    private VisibilityClient visibilityClient;

    @PostConstruct
    public void initCache() {
        loadingCache = CacheBuilder.newBuilder()
                .maximumSize(MAX_SIZE)
                .expireAfterWrite(EXPIRE_TIME, TimeUnit.SECONDS)
                .build(new CacheLoader<String, VisibilityConfigDTO>() {
                    @Override
                    public VisibilityConfigDTO load(@NotNull String key) {
                        SwitchCacheKey switchCacheKey = JSON.parseObject(key, SwitchCacheKey.class);

                        Long kdtId = switchCacheKey.getKdtId();
                        Integer switchSource = switchCacheKey.getSwitchSource();
                        String switchIndicatorType = switchCacheKey.getSwitchIndicatorType();
                        String indicatorId = switchCacheKey.getIndicatorId();
                        Boolean defaultDisplay = switchCacheKey.isDefaultDisplay();

                        SwitchDisplayQuery query = SwitchDisplayQuery.builder()
                                .switchIndicatorType(switchIndicatorType)
                                .switchSource(switchSource)
                                .build();
                        VisibilityConfigDTO config = visibilityClient.queryDisplayByConfig(kdtId, indicatorId, query);
                        if (config == null || config.getDisplay() == null) {
                            return VisibilityConfigDTO.builder().display(defaultDisplay).targetAlias(indicatorId).build();
                        }
                        return config;
                    }
                });
    }

    public VisibilityConfigDTO get(String key) {
        return loadingCache.getUnchecked(key);
    }

    public void put(String key, VisibilityConfigDTO value) {
        loadingCache.put(key, value);
    }

    public void resetLoadingCache(LoadingCache loadingCache) {
        this.loadingCache = loadingCache;
    }

    public static String buildKey(Long kdtId, String indicatorId, Integer switchSource, String switchIndicatorType, boolean defaultDisplay) {
        SwitchCacheKey switchCacheKey = SwitchCacheKey.builder().kdtId(kdtId).indicatorId(indicatorId).switchSource(switchSource).switchIndicatorType(switchIndicatorType).defaultDisplay(defaultDisplay).build();
        return JSON.toJSONString(switchCacheKey);
    }

}
