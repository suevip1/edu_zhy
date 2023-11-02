import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.visibility.SwitchCacheKey;
import com.edu.zhy.api.api.visibility.VisibilityConfigDTO;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestV1 {
    private LoadingCache<String, VisibilityConfigDTO> loadingCache;

    private static final String TIME_HMS_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void zhyV1(){
        Long start =1698832800000L ;
        Long end = 1701360000000L;

        boolean b = checkActEndAt(start, end);
        System.err.println(b);
//
//        boolean b1 = checkActEndAt(end);
//        System.err.println(b1);
    }


    //ebiz.spotlight   的效验时间

    private boolean checkActEndAt(long endAt) {

        Date endTime = timeStringToDate(timeStamp2DateTimeV2(endAt));
        System.err.println(endTime);
        Date currentTime = getCurrentDateTime();
        System.err.println(currentTime);
        if (currentTime.before(endTime)) {
            return true;
        }

        return false;
    }



    /**
     * 获取当前时间(Date格式)
     */
    public static Date getCurrentDateTime() throws BusinessException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_HMS_PATTERN);

        return timeStringToDate(simpleDateFormat.format(new Date()));
    }

    /**
     * 时间戳转为标准时间
     *
     * @param unixTimeStamp 时间戳
     * @return 日期值
     */
    public static String timeStamp2DateTimeV2(Long unixTimeStamp) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_HMS_PATTERN);

        if (String.valueOf(unixTimeStamp).length() < 13)
            return simpleDateFormat.format(new Date(unixTimeStamp * 1000));
        else
            return simpleDateFormat.format(new Date(unixTimeStamp));
    }

    /**
     * 时间字符串转为dateTime格式
     */
    public static Date timeStringToDate(String time) throws BusinessException {

        try {
            return DateUtils.parseDate(time, TIME_HMS_PATTERN);
        } catch (ParseException e) {

            throw new BusinessException(-100,"传入的时间格式不对，无法完成转换");
        }
    }




    //ebiz.spotlight.basic 时间效验


    private boolean checkActEndAt(long beginAt, long endAt) {

        String beginTime = timeStamp2DateTime(beginAt);
        System.err.println(beginTime);
        String endTime = timeStamp2DateTime(endAt);
        System.err.println(endTime);
        String currentTime = getCurrentTime();
        System.err.println(currentTime);

        return currentTime.compareTo(beginTime) > 0 && currentTime.compareTo(endTime) < 0;
    }

    /**
     * 时间戳转为标准时间
     * @param unixTimeStamp 时间戳
     * @return  日期值
     */
    public static String timeStamp2DateTime(Long unixTimeStamp) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (String.valueOf(unixTimeStamp).length() < 13)
            return simpleDateFormat.format(new Date(unixTimeStamp * 1000));
        else
            return simpleDateFormat.format(new Date(unixTimeStamp));
    }



    /**
     * 获取当前标准时间(String格式)
     */
    public static String getCurrentTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(new Date());
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
