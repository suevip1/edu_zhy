package com.edu.zhy.api.api.http.polyv;

import com.edu.zhy.api.api.http.dto.AbstractCommonParam;
import com.edu.zhy.api.api.http.dto.AbstractCommonRequest;
import com.edu.zhy.api.api.http.util.MD5Utils;
import com.edu.zhy.api.api.http.util.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

@Slf4j
//@Component
public class PolyvHttpUtil
//        implements ApplicationContextAware
{

//    @Value("${owl.live.outter.proxy}")
    public String proxy;

    private PolyvHttpUtil polyvHttpUtil;



    /**
     * * 查询get请求
     * *直接可以调用
     * @param url
     * @param request
     * @param param
     * @param <T>
     * @return
     */
    public <T extends AbstractCommonRequest,R extends AbstractCommonParam> String sendPolyvHttpGet(String url, T request, R param) {

        String response = sendHttpGet(url, buildParams(request, param));

        logHttp(request, response);

        return response;
    }


    /**
     * * post 请求
     * *直接可以调用
     * @param url
     * @param request
     * @param authCommand
     * @param <T>
     * @return
     */
    public <T extends AbstractCommonRequest,R extends AbstractCommonParam> String sendPolyvHttpPost(String url, T request, R authCommand) {

        String response = sendHttpPost(url, buildParams(request, authCommand));

        logHttp(request, response);

        return response;
    }




    /**
     * 发送 HTTP GET 请求
     *
     * @param httpUrl url
     * @param maps    参数
     * @return 请求结果
     */
    private String sendHttpGet(String httpUrl, Map<String, String> maps) {
//        HttpGet httpGet = new HttpGet(buildGetUrl(httpUrl, maps));

        HttpGet httpGet = (HttpGet) getProxyMethod(buildGetUrl(httpUrl, maps), true);

        //httpGet.setConfig(requestConfig);
        Throwable throwable;
        try {
            return sendHttpGet(httpGet);
        } catch (ConnectTimeoutException e) {
            log.error("HttpClient.sendHttpGet,请求超时,httpUrl={},maps={}", httpUrl, maps, e);
            throwable = e;
        } catch (ClientProtocolException e) {
            log.error("HttpClient.sendHttpGet,请求出错,httpUrl={},maps={}", httpUrl, maps, e);
            throwable = e;
        } catch (Exception e) {
            log.error("HttpClient.sendHttpGet,其他异常， httpUrl={},maps={}", httpUrl, maps, e);
            throwable = e;
        }
        throw new RuntimeException(throwable);
    }



    private String sendHttpPost(String httpUrl, Map<String, String> maps) {
        HttpPost httpPost = (HttpPost) getProxyMethod(httpUrl, false);
//        HttpPost httpPost = new HttpPost(httpUrl);
        //httpPost.setConfig(requestConfig);
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (String key : maps.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
        }
        Throwable throwable;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            return sendHttpPost(httpPost);
        } catch (ConnectTimeoutException e) {
            log.error("HttpClient.sendHttpPost,请求超时,httpUrl={},maps={}", httpUrl, maps, e);
            throwable = e;
        } catch (ClientProtocolException e) {
            log.error("HttpClient.sendHttpPost,请求出错,httpUrl={},maps={}", httpUrl, maps, e);
            throwable = e;
        } catch (Exception e) {
            log.error("HttpClient.sendHttpPost,其他异常， httpUrl={},maps={}", httpUrl, maps, e);
            throwable = e;
        }
        throw new RuntimeException(throwable);
    }




    private HttpRequestBase getProxyMethod(String url, boolean isGet) {

        int protocolEnd = url.indexOf("://");

        String protocol = url.substring(0, protocolEnd);

        String remainUrl = url.substring(protocolEnd + 3);

        int hostEnd = remainUrl.indexOf("/");

        String host = remainUrl.substring(0, hostEnd);

        String proxyUrl = proxy + remainUrl.substring(hostEnd);

        HttpRequestBase method;

        if (isGet) {

            method = new HttpGet(proxyUrl);

        } else {

            method = new HttpPost(proxyUrl);

        }

        method.setHeader("Host", host);

        // 长链接
//        if (keepAlive) {
//            LogUtil.info(log, LogData.desc("设置保利威HTTP请求长链接"));
//            method.addHeader("YZC-Keepalive-Timeout", "60000");
//            method.addHeader("YZC-Keepalive-Poolsize", "15");
//        }

        if ("https".equalsIgnoreCase(protocol)) {

            method.setHeader("Scheme", "https");

        } else {

            method.setHeader("Scheme", "http");

        }

        return method;

    }


    private String sendHttpGet(HttpGet httpGet) throws IOException {
        String responseContent;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        }
        return responseContent;
    }


    private String sendHttpPost(HttpPost httpPost) throws IOException {
        String responseContent;
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        }
        return responseContent;
    }




    private static String buildGetUrl(String httpUrl, Map<String, String> maps) {
        StringBuilder stringBuilder = new StringBuilder(httpUrl);
        stringBuilder.append("?");

        for (Map.Entry<String, String> entry : maps.entrySet()) {
            stringBuilder
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");

        }
        return stringBuilder.toString();
    }



    private static <T extends AbstractCommonRequest,R extends AbstractCommonParam> Map<String, String> buildParams(T request,R param) {

        request.setAppId(param.getAppId());
        request.setTimestamp(String.valueOf(System.currentTimeMillis()));

        Map<String, String> params = MapUtil.toStringMap(request);

        request.setSign(generateSign(params,param.getAppSecret()));

        params = MapUtil.toStringMap(request);
        return params;
    }


    /**
     * 创建签名工具函数
     * <p>
     * {@link <a herf="http://dev.polyv.net/2018/liveproduct/l-api/rule/sign/"/>}
     *
     * @param parray    所有参数
     * @param secretKey 应用密匙
     * @return 签名内容
     */
    private static String generateSign(Map<String, String> parray, String secretKey) {
        Map<String, String> params = paramFilter(parray);
        String concatedStr = concatParams(params);
        String plain = secretKey + concatedStr + secretKey;
        String encrypted = MD5Utils.getMD5String(plain);
        return encrypted.toUpperCase();
    }


    private static Map<String, String> paramFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<>();
        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }



    private static String concatParams(Map<String, String> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(params.get(key));
        }
        return sb.toString();
    }


    private static <T extends AbstractCommonRequest> void logHttp(T request, String response) {

        log.info("method:{} in sendPolyvHttpPost, request:{} , response:{}, cast time:{}",
                request.method(),
                request,
                response,
                System.currentTimeMillis() - Long.parseLong(request.getTimestamp()));

    }


//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        Map<String, PolyvHttpUtil> beansOfType = applicationContext.getBeansOfType(PolyvHttpUtil.class);
//
//        for (Map.Entry<String , PolyvHttpUtil> stringPolyvHttpUtilEntry : beansOfType.entrySet()){
//
//            polyvHttpUtil = stringPolyvHttpUtilEntry.getValue();
//
//        }
//    }



}
