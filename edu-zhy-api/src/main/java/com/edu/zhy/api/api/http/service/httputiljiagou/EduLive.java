package com.edu.zhy.api.api.http.service.httputiljiagou;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

public class EduLive {

    /**
     * Token 服务过期时间。此参数暂不生效。你无需设置此参数。每个 RTM Token 的有效期都是 24 小时。
     */
   private static Integer EXPIRE_TIMESTAMP = 0;
    /**
     * 指定处理该请求的数据中心，取值如下：
     * （默认值）cn-hz：中国杭州，服务区覆盖东亚、东南亚、以及其他数据中心未覆盖的地区。
     * us-sv：美国硅谷，服务区覆盖北美洲、南美洲。
     * 详见数据中心与全球化。
     */
   private static String REGION = "cn-hz";

    /**
     * 声网的  App ID
     */
    private static String appId ="fde18981cd954fd788b73bacb9566fcf";

    /**
     * 声网的 App 证书
     */
    private static String appCertificate = "78fac440663b42cdb95482fbd4b74f46";


    /**
     * 声网白板ak
     */
    private static String whiteboardAk = "cFJ2jW9vFiXWkwhH";

    /**
     * 声网白板SK
     */
    private static String whiteboardSk = "i4Qa_y3yBy4cPBA54NQUfZo6cZuYfWtC";



    /**
     * 获取Headers
     * @return
     * @throws Exception
     */
    public static Map<String, String> getHeaders() throws Exception {
        Map<String, String> map = new HashMap<>(1);
        // Token 的权限，取值包括 TokenRole.Admin，TokenRole.Writer，TokenRole.Reader。
        map.put("role", TokenRole.Admin.getValue());
        String token = sdkToken(whiteboardAk, whiteboardSk, EXPIRE_TIMESTAMP, map);
        Map<String, String> headersMap= new HashMap<>(2);
        headersMap.put("token",token);
        headersMap.put("region", REGION);
        return headersMap;
    }



    public  enum TokenPrefix {
        SDK("NETLESSSDK_"),
        ROOM("NETLESSROOM_"),
        TASK("NETLESSTASK_");

        private String value;
        TokenPrefix(String name) {
            this.value = name;
        }
        public String getValue() {
            return value;
        }
    }

    /**
     * 数字越小，权限越大
     */
    public enum TokenRole {
        Admin("0"),
        Writer("1"),
        Reader("2");

        private String value;
        TokenRole(String name) {
            this.value = name;
        }
        public String getValue() {
            return value;
        }
    }




    public static String sdkToken(String accessKey, String secretAccessKey, long lifespan, Map<String, String> content) throws Exception {
        return createToken(TokenPrefix.SDK.getValue(), accessKey, secretAccessKey, lifespan, content);
    }



    private static String createToken(String prefix, String accessKey, String secretAccessKey, long lifespan, Map<String, String> content) throws Exception {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.putAll(content);
        map.put("ak", accessKey);
        map.put("nonce", UUID.randomUUID().toString());

        if (lifespan > 0) {
            map.put("expireAt", System.currentTimeMillis() + lifespan + "");
        }

        String information = toJson(sortMap(map));
        map.put("sig", createHmac(secretAccessKey, information));

        String query = sortAndStringifyMap(map);


        return prefix + stringToBase64(query);
    }


    private static String stringToBase64(String str) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(str.getBytes("utf-8")).replace("+", "-").replace("/", "_").replaceAll("=+$", "");
    }


    private static LinkedHashMap<String, String> sortMap(Map<String, String> object) {
        List<String> keys = new ArrayList<>(object.keySet());
        keys.sort(null);

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            linkedHashMap.put(keys.get(i), object.get(keys.get(i)));
        }
        return linkedHashMap;
    }


    /**
     * 因程序本身的 map 只有一层，而非嵌套 map，所以此方法没有实现嵌套 map 转 string
     * 可自行替换为其他 json stringify 实现
     */
    private static String toJson(LinkedHashMap<String, String> map) {
        Iterator<Entry<String, String>> iterator= map.entrySet().iterator();

        List<String> result = new ArrayList<>();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String value;
            if (entry.getValue() == null) {
                value = "null";
            } else {
                value = entry.getValue();
            }
            result.add("\"" + entry.getKey() + "\"" + ":" + "\"" + value + "\"");
        }
        return "{" + String.join(",", result) + "}";
    }



    private static String sortAndStringifyMap(Map<String, String> object) {
        List<String> keys = new ArrayList<>(object.keySet());
        keys.sort(null);

        List<String> kvStrings = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            if (object.get(keys.get(i)) == null) {
                continue;
            } else {
                kvStrings.add(encodeURIComponent(keys.get(i)) + "=" + encodeURIComponent(object.get(keys.get(i))));
            }
        }
        return String.join("&", kvStrings);
    }


    /**
     * encodeURIComponent 基于 url 编码对字符串进行编码
     * 最终实现和 JavaScript 中的 encodeURIComponent 一致
     *
     * https://stackoverflow.com/questions/607176/java-equivalent-to-javascripts-encodeuricomponent-that-produces-identical-outpu
     */
    private static String encodeURIComponent(String s) {
        String result = null;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("%21", "!")
                    .replaceAll("%27", "'")
                    .replaceAll("%28", "(")
                    .replaceAll("%29", ")")
                    .replaceAll("%7E", "~");
        }
        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }



    private static String createHmac(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return byteArrayToHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }



}
