package com.edu.zhy.api.api.visibility;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Auther: zishan
 * @Date: 2020-02-19
 *
 * 基于内存的缓存策略  在 Guava 缓存库中，可以使用 CacheBuilder 类来创建和配置缓存
 * * * *
 */
public class FieldReferenceCache {

    private LoadingCache<String, Map<String, HidingConfigDTO>> loadingCache;

    /**
     * 最大缓存数量
     */
    private static final Long MAX_SIZE = 10000L;

    /**
     * 缓存时间
     */
    private static final Long EXPIRE_TIME = 60L;

    @Resource
    private VisibilityClient visibilityClient;

    @PostConstruct
    public void initCache() {
        loadingCache = CacheBuilder.newBuilder()
                .maximumSize(MAX_SIZE)
                .expireAfterWrite(EXPIRE_TIME, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Map<String, HidingConfigDTO>>() {
                    @Override
                    public Map<String, HidingConfigDTO> load(@NotNull String key) {
                        if (StringUtils.isBlank(key)) {
                            return Maps.newHashMap();
                        }
                        List<HidingConfigDTO> configs = visibilityClient.getReferenceConfig(key);
                        if (CollectionUtils.isNotEmpty(configs)) {
                            return configs.stream().filter(Objects::nonNull).collect(Collectors.toMap(HidingConfigDTO::getHideFieldName, v -> v, (k1, k2) -> k1));
                        }
                        return Maps.newHashMap();
                    }
                });
    }

    public Map<String, HidingConfigDTO> get(String key) {
        return loadingCache.getUnchecked(key);
    }

    public void put(String key, Map<String, HidingConfigDTO> value) {
        loadingCache.put(key, value);
    }

    public void resetLoadingCache(LoadingCache loadingCache) {
        this.loadingCache = loadingCache;
    }

}
