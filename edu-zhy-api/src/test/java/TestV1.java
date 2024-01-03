import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.http.okhttp.OKHttpUtils;
import com.edu.zhy.api.api.visibility.SwitchCacheKey;
import com.edu.zhy.api.api.visibility.VisibilityConfigDTO;
import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestV1 {
    private LoadingCache<String, VisibilityConfigDTO> loadingCache;

    private static final String TIME_HMS_PATTERN = "yyyy-MM-dd HH:mm:ss";


    private static long ONE_MINUTES = 1 * 60 * 1000L;



    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);


    static final String[] PATTERNS = new String[]{
            DEFAULT_DATE_FORMAT
    };


    private static MediaType multiPartType = MediaType.parse("application/octet-stream");

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

    @Test
    public void m3(){
        long startTime = System.currentTimeMillis();
        long timeout = 10000; // 设置轮询超时时间为10秒

        while (true) {
            long currentTime = System.currentTimeMillis();

            // 执行代码块
            // ...
            System.err.println(System.currentTimeMillis());

            // 检查结束条件
            if (currentTime - startTime >= timeout) {
                break;
            }

            // 等待一段时间再进行下一次轮询
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void zhym2(){
//
//        long executeTime = getExecuteTime();
//
//        System.err.println(executeTime);


//        Integer min = null;
//
//        if (Objects.isNull(min)){
//            System.err.println(min);
//        }

//
//        Date date = new Date();
//
//        System.err.println(date);

        String extraInfo = null;


        if (StringUtils.isBlank(extraInfo)){
            System.err.println(extraInfo);

        }


//        Integer tig = 55;
//        Integer hh = null;
//
//
//        try {
//            if (Objects.equals(tig,hh)){
//                System.err.println(true);
//            }
//
//            System.err.println(false);
//        }catch (Exception e){
//            System.err.println("11:"+ e);
//        }


//
//        long time = tig * 60L * 1000;
//
//        System.err.println(time);

//
//        String string = "1";
//
//        if (Objects.equals(string,1)){
//
//            System.err.println("相等不相等");
//        }


    }


    @Test
    public void  mm1(){
        DelayTaskMessage delayTaskMessage = new DelayTaskMessage();

        if (Objects.isNull(delayTaskMessage)){
            System.err.println(delayTaskMessage);
        }

        String taskType = delayTaskMessage.getTaskType();
        if (taskType == null){
            System.err.println(taskType);

        }


    }

    private static String getIp() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return "127.0.0.1";
    }



    public static void main(String[] args) {

//        byte[] fileContent = new byte[6];
//        String fileName = "hahaha";
//        String token = "pNRZT0KqE-4QuBa6MxYRg-Uc-FTJ8vw_TDVMOYK0:ClRy7HP-O23oWqSJPg5X3C1gp9o=:eyJzYXZlS2V5IjoidXBsb2FkX2ZpbGVzLyQoYnVja2V0KS8kKHllYXIpLyQobW9uKS8kKGRheSkvJChldGFnKSQoZXh0KSIsInNjb3BlIjoieXotdGVzdC1maWxlIiwiY2FsbGJhY2tVcmwiOiJodHRwczovL21hdGVyaWFscy1xYS55b3V6YW4uY29tL2NhbGxiYWNrL3N0b3JhZ2VxaW5pdWZpbGUuanNvbiIsImZzaXplTGltaXQiOjUyNDI4ODAwLCJmc2l6ZU1pbiI6MSwiZGVhZGxpbmUiOjE3MDQyMDQyNTQsImNhbGxiYWNrQm9keSI6ImF2SW5mb1x1MDAzZCQoYXZpbmZvKVx1MDAyNmtkdElkXHUwMDNkMFx1MDAyNmJ1Y2tldElkXHUwMDNkM1x1MDAyNm1lZGlhVHlwZVx1MDAzZDVcdTAwMjZpbWFnZUluZm9cdTAwM2QkKGltYWdlSW5mbylcdTAwMjZtaW1lVHlwZVx1MDAzZCQobWltZVR5cGUpXHUwMDI2c2l6ZVx1MDAzZCQoZnNpemUpXHUwMDI2c291cmNlVHlwZVx1MDAzZDBcdTAwMjZ1cGxvYWRDaGFubmVsXHUwMDNkb3dsX3NjaGVkdWxlX2pvYlx1MDAyNm5hbWVcdTAwM2QkKGZuYW1lKVx1MDAyNmlzUHVibGljXHUwMDNkMVx1MDAyNmNvbW1vbi1vcGVyYXRvclx1MDAzZDB8M1x1MDAyNmF0dGFjaG1lbnRQYXRoXHUwMDNkJChrZXkpIn0=";
//
//        uploadFile(fileName,token,fileContent);

        String ip = getIp();

        System.err.println(ip);


    }

    @Test
    public void m29(){
//      byte[] fileContent = new byte[6];
//      String fileName = "hahaha";
//      String token = "pNRZT0KqE-4QuBa6MxYRg-Uc-FTJ8vw_TDVMOYK0:ClRy7HP-O23oWqSJPg5X3C1gp9o=:eyJzYXZlS2V5IjoidXBsb2FkX2ZpbGVzLyQoYnVja2V0KS8kKHllYXIpLyQobW9uKS8kKGRheSkvJChldGFnKSQoZXh0KSIsInNjb3BlIjoieXotdGVzdC1maWxlIiwiY2FsbGJhY2tVcmwiOiJodHRwczovL21hdGVyaWFscy1xYS55b3V6YW4uY29tL2NhbGxiYWNrL3N0b3JhZ2VxaW5pdWZpbGUuanNvbiIsImZzaXplTGltaXQiOjUyNDI4ODAwLCJmc2l6ZU1pbiI6MSwiZGVhZGxpbmUiOjE3MDQyMDQyNTQsImNhbGxiYWNrQm9keSI6ImF2SW5mb1x1MDAzZCQoYXZpbmZvKVx1MDAyNmtkdElkXHUwMDNkMFx1MDAyNmJ1Y2tldElkXHUwMDNkM1x1MDAyNm1lZGlhVHlwZVx1MDAzZDVcdTAwMjZpbWFnZUluZm9cdTAwM2QkKGltYWdlSW5mbylcdTAwMjZtaW1lVHlwZVx1MDAzZCQobWltZVR5cGUpXHUwMDI2c2l6ZVx1MDAzZCQoZnNpemUpXHUwMDI2c291cmNlVHlwZVx1MDAzZDBcdTAwMjZ1cGxvYWRDaGFubmVsXHUwMDNkb3dsX3NjaGVkdWxlX2pvYlx1MDAyNm5hbWVcdTAwM2QkKGZuYW1lKVx1MDAyNmlzUHVibGljXHUwMDNkMVx1MDAyNmNvbW1vbi1vcGVyYXRvclx1MDAzZDB8M1x1MDAyNmF0dGFjaG1lbnRQYXRoXHUwMDNkJChrZXkpIn0=";
//
//      uploadFile(fileName,token,fileContent);


        Long gg = 0L;

        if (Objects.equals(gg,0)){
            System.err.println(gg);
        }


    }

    public static void uploadFile(String fileName, String token, byte[] bytes) {

        String fileUrl = "";
        try {
            MultipartBody.Builder builder = new MultipartBody.Builder();

            RequestBody fileBody = RequestBody.create(multiPartType, bytes);

            RequestBody requestBody = builder.setType(MultipartBody.FORM)
                    .addFormDataPart("token", token)
                    .addFormDataPart("file", fileName, fileBody)
                    .build();

            Request request = new Request.Builder()
                    .post(requestBody)
                    .url("http://proxy-qa.s.qima-inc.com")
                    .header("Scheme", "https")
                    .header("Host", "upload.qbox.me")
                    .build();


//
            OkHttpClient okHttpClient = OKHttpUtils.getOkHttpClient();

            Response execute = okHttpClient.newCall(request).execute();
            System.err.println(execute);



        } catch (Exception e) {
        }

    }





    private long getExecuteTime() {
        return System.currentTimeMillis() + ONE_MINUTES;
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
