import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.visibility.SwitchCacheKey;
import com.edu.zhy.api.api.visibility.VisibilityConfigDTO;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public class TestV1 {
    private LoadingCache<String, VisibilityConfigDTO> loadingCache;

    @Test
    private void zhyV1(){


    }




    @PostConstruct
    public void initCache(){
        loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(60L, TimeUnit.SECONDS)
                .maximumSize(1000L)
                .build(new CacheLoader<String, VisibilityConfigDTO>() {

                    @Override
                    public VisibilityConfigDTO load(String s) {
                        return new VisibilityConfigDTO();
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
