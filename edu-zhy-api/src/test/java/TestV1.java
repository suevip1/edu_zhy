import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.zhy.api.api.dto.UserDTO;
import com.edu.zhy.api.api.http.okhttp.OKHttpUtils;
import com.edu.zhy.api.api.http.util.MD5Utils;
import com.edu.zhy.api.api.visibility.SwitchCacheKey;
import com.edu.zhy.api.api.visibility.VisibilityConfigDTO;
import com.edu.zhy.api.api.web.dto.DelayTaskMessage;
import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
import com.google.common.base.Joiner;
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
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestV1 {
    public static final String BLANK = "";
    private static Pattern phone_86 = Pattern.compile("^\\+86-1[3-9]\\d{9}$");

    private static Pattern phone =Pattern.compile("^1[3-9]\\d{9}$");

    public static final int SIZE_TWO = 2;
    private static Pattern phonePattern = Pattern.compile("(?<=^1[0-9]{2})[0-9]{4}(?=[0-9]{4}$)");


    private LoadingCache<String, VisibilityConfigDTO> loadingCache;

    private static final String TIME_HMS_PATTERN = "yyyy-MM-dd HH:mm:ss";


    private static long ONE_MINUTES = 1 * 60 * 1000L;



    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);


    static final String[] PATTERNS = new String[]{
            DEFAULT_DATE_FORMAT
    };

    /**
     * thing类型字符最大长度
     */
    public static final Integer THING_MAX_LEN = 20;


    private static MediaType multiPartType = MediaType.parse("application/octet-stream");


    private static final String callBackUrl = "http://api-z0.qiniuapi.com/sisyphus/fetch";


    private static final String SHOP_CONFIG = "            {\n" +
            "                \"key\": \"activityType\",\n" +
            "                \"kdtId\": \"2282059\",\n" +
            "                \"value\": \"0\"\n" +
            "            }";

    @Test
    public void  m111222(){

        long l = System.currentTimeMillis();
        System.err.println(l);
        Random random = new Random(System.currentTimeMillis());
        long l1 = random.nextLong();
        System.err.println(l1);

        int randomValue = random.nextInt((int) (20));

        System.err.println(randomValue);

    }

    @Test
    public void  m111(){
//        Long businessId = 8226304108L;
//        long l = businessId % 512;
//        System.err.println(l);
//

        URI uri = URI.create(callBackUrl);

        System.err.println(uri.getHost());
//        System.err.println(uri.getScheme());
//        System.err.println(uri.getPath());
//        System.err.println(uri.getQuery());
//        System.err.println(uri.getPort());

//        String encodedUrl = URLEncoder.encode(callBackUrl, StandardCharsets.UTF_8);
//        System.err.println(encodedUrl);
//
//        String http = getHttpProxyUrl(callBackUrl, "rs.qiniu.com", "http");
//
//        System.err.println(http);

//        try {
//            String encode = URLEncoder.encode(callBackUrl, "UTF-8");
//            System.err.println(encode);
//
//
////            String decode = URLDecoder.decode(encode, "UTF-8");
////            System.err.println(decode);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }



//        Date currentTime = new Date(System.currentTimeMillis());
//
//// 创建 SimpleDateFormat 对象，并设置时区为 UTC
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//// 格式化时间为 ISO 8601 格式
//        String iso8601Time = sdf.format(currentTime);
//
//        System.out.println(iso8601Time);
    }

    private String getHttpProxyUrl(String originUrl, String originScheme, String originHost) {
        String proxyHost = "http.proxy.static.host";
        if (proxyHost == null) {
            throw new RuntimeException("apollo config error");
        }

        return org.apache.commons.lang3.StringUtils.replace(originUrl,
                originScheme + "://" + originHost, "http://" + proxyHost);
    }

    @Test
    public void zh20202(){

//        Boolean all = null;
//        List<Boolean> booleanList = Arrays.asList(true, false, true);
//
//        for (Boolean tt : booleanList){
//            all = tt;
//        }
//        System.err.println(all);

        UserDTO userDTO = new UserDTO();
        userDTO.setName("aahahha");

//        System.err.println(JSON.toJSONString(userDTO));

        String s = JSON.toJSONString(userDTO);

        JSONObject object = JSONObject.parseObject(s);
//        System.err.println(object);

        JSONObject object1 = new JSONObject();
        object1.put("name","sksksk");
        object.putAll(object1);

//        System.err.println(object.toJSONString());
        String s1 = object.toJSONString();

        UserDTO userDTO1 = JSON.parseObject(s1, UserDTO.class);

        System.err.println(s1);
        System.err.println(userDTO1);


    }

    @Test
    public void zhysss() {
        //前置过滤
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        int elementToExclude = 3; // 要排除的元素是 3
//
//        List<Integer> filteredNumbers = numbers.stream()
//                .takeWhile(num -> num != elementToExclude)
//                .toList();
//
//        System.out.println("原始列表：" + numbers);
//        System.out.println("过滤掉元素 " + elementToExclude + " 之前的数据：" + filteredNumbers);
//


//        //后置过滤
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        int elementToExclude = 3; // 要排除的元素是 3
//
//        List<Integer> filteredNumbers = numbers.stream()
//                .dropWhile(num -> num != elementToExclude)
//                .skip(1) // 跳过最初那个不满足条件的元素
//                .toList();
//
//        System.out.println("原始列表：" + numbers);
//        System.out.println("过滤掉元素 " + elementToExclude + " 之后的数据：" + filteredNumbers);

//        跳过
//        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
//        int elementToExclude = 3; // 要排除的元素是 3
//
//        List<Integer> filteredNumbers = numbers.subList(numbers.indexOf(elementToExclude), numbers.size());
//
//        System.out.println("原始列表：" + numbers);
//        System.out.println("过滤掉元素 " + elementToExclude + " 之后的数据：" + filteredNumbers);

//        List<String> videoId = Arrays.asList("1","2","3","4");
////        String videoIdList = StringUtils.join(videoId, ",");
////
////        System.err.println(videoIdList);

//        List<Integer> levelList = Arrays.asList(1,2);
//
//        Set<Integer> levelSet = new HashSet<>(levelList);
//
//        System.err.println(levelList.size());
//        System.err.println(levelSet.size());


        String s = customerRowKeyBuilder(109549123L, 17677612003L);
        System.err.println(s);


    }
    private static String customerRowKeyBuilder(Long kdtId, Long userId) {
        return StringUtils.reverse(String.valueOf(userId)) + "_" + kdtId;
    }


    /**
     * 正常字符串转化为thing类型
     * @param str
     * @return
     */
    public static String StringToThing(String str){
        if(str.length() > THING_MAX_LEN){
            return str.substring(0, THING_MAX_LEN);
        }else{
            return str;
        }
    }

    /**
     * 测试
     */
    @Test
    public void zhyThing(){

        String s = StringToThing("研可岸考研英语〖下单后看商品详情使用〗即");

        System.err.println(s.length());

    }


    @Test
    public void zhyVV(){
        List<Long> list = new ArrayList<>();
        Long phone= 13813711501L;

        for (int i =1 ; i< 200; i++){
            list.add(phone + i);
        }

        System.err.println(list);


//        int i = 0 % 5 == 0 ? 0 / 5 : 0 / 5 + 1;
//
//        System.err.println(i);

    }

    @Test
    public void zhyVVV(){
        List<Integer> list = new ArrayList<>();
        Integer ss = 700;

        for (int i =1 ; i< 800 ; i++){
            list.add(ss+i);
        }

        System.err.println(list);

    }


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


    @Test
    public void  mmmm(){
//        String s = buildRowKey(52780L, 18438480299L);
//        System.err.println(s);


        String s1 ="2024-1-28 人与人之间无时无刻不在比大小，比高低——志存高远，雄视天下（下）";

        System.err.println(s1.length());

    }

    private String buildRowKey(Long liveId, Long userId) {
        String originKey = Joiner.on("_")
                .skipNulls()
                .join(userId, liveId);

        // 取md5前4位
        String prefixKey = MD5Utils.getMD5String(originKey).substring(0,4);
        return Joiner.on("_")
                .skipNulls()
                .join(prefixKey, originKey);
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

        String NickNameUse = "+86-13012345678";

        if (checkPhoneFormat(NickNameUse) || checkPhone(NickNameUse)){
            System.err.println(convertPhone(NickNameUse));
        }


//        String phoneNumber = "15012无345678";
//
//        // 去除非数字字符
//        String digitsOnly = phoneNumber.replaceAll("\\D", "");
//
//
//        System.err.println(digitsOnly);


    }

    @Test
    public void n2(){

//        String str = "：15012 345678";
//
//        String encryptedStr = encryptPhoneNumber(str);
//
//        System.out.println(encryptedStr);

        Long kdtId = 78450779L;

        long mod = kdtId % 100;

        System.err.println(mod);


    }

    /**
     * 效验下昵称是否是普通手机号格式
     * @return
     */
    private Boolean checkPhoneFormat(String nickName){
        Matcher matcher = phone.matcher(nickName);
        if (matcher.find()){
            return true;
        }
        return false;
    }

    /**
     * 效验 +86-  格式的手机号
     * @param nickName
     * @return
     */
    private Boolean checkPhone(String nickName){
        Matcher matcher = phone_86.matcher(nickName);
        if (matcher.find()){
            return true;
        }
        return false;
    }


    /**
     * 手机号脱敏，中间四位替换成*
     * 例如：15012345678 -> 150****5678
     * 例如2：+86-15012345678 -> +86-150****5678
     * @param num 手机号
     * @return 脱敏后的手机号
     */
    public static String convertPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return BLANK;
        }
        return num.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }



    private static String hideNickNameIfNessary(String nickname) {
        //如果nickname为手机号码，则隐藏中间4位数字
        Matcher matcher = phonePattern.matcher(nickname);
        if (matcher.find()) {
            nickname = matcher.replaceAll("****");
        } else {
            StringBuilder sb = new StringBuilder();
            int codePointLength = nickname.codePointCount(0, nickname.length());
            String firstStr = fixedSubString(nickname,0, 1);
            String lastStr = fixedSubString(nickname, codePointLength-1, codePointLength);
            sb.append(firstStr).append("*");
            if (codePointLength > SIZE_TWO) {
                nickname = sb.append(lastStr).toString();
            } else {
                nickname = sb.toString();
            }
        }
        return nickname;
    }

    private static String fixedSubString(String source, int start, int end) {
        String result;
        try {
            result = source.substring(source.offsetByCodePoints(0, start), source.offsetByCodePoints(0, end));
        } catch (Exception e) {
            result = "*";
        }
        return result;
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




    ///**********

    /**
     * * 加密后的字符串：请联系我：***********
     * @param str
     * @return
     */
    private static String encryptPhoneNumber1(String str) {
        // 定义手机号的正则表达式
        String regex = "\\d{11}";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 使用正则表达式匹配手机号码
        Matcher matcher = pattern.matcher(str);

        StringBuffer stringBuffer = new StringBuffer();

        // 循环查找并替换手机号为加密形式
        while (matcher.find()) {
            String phoneNumber = matcher.group();
            String encryptedNumber = encrypt1(phoneNumber); // 自定义的加密方法

            matcher.appendReplacement(stringBuffer, encryptedNumber);
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }

    private static String encrypt1(String phoneNumber) {
        // 这里是一个示例，你可以根据自己的需求来实现具体的加密方法
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < phoneNumber.length(); i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }


    /**
     * *可以使用的正则隐藏手机号
     * @param str
     * @return
     */
    private static String encryptPhoneNumber(String str) {
        // 定义手机号的正则表达式
        String regex = "\\d{11}";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 使用正则表达式匹配手机号码
        Matcher matcher = pattern.matcher(str);

        StringBuffer stringBuffer = new StringBuffer();

        // 循环查找并替换手机号为加密形式
        while (matcher.find()) {
            String phoneNumber = matcher.group();
            String encryptedNumber = encrypt(phoneNumber); // 自定义的加密方法

            matcher.appendReplacement(stringBuffer, encryptedNumber);
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }

    private static String encrypt(String phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        if (phoneNumber.length() == 11) {
            stringBuilder.append(phoneNumber.substring(0, 3)); // 取前三位数字
            stringBuilder.append("****"); // 替换中间四位数字
            stringBuilder.append(phoneNumber.substring(7)); // 取后四位数字
        } else {
            // 手机号不符合要求，不加密处理
            stringBuilder.append(phoneNumber);
        }

        return stringBuilder.toString();
    }

}
