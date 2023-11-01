package com.edu.zhy.api.api.http.okhttp;

import okhttp3.*;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yajun
 * @version 1.0.0
 * @ClassName OKHttpUtils
 * @description
 * @date created in 14:16 2021/1/13
 */
public class OKHttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(OKHttpUtils.class);

    private volatile static OKHttpUtils mInstance;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final MediaType form = MediaType.parse("application/x-www-form-urlencoded");

    private OkHttpClient mOkHttpClient;


    public OKHttpUtils(OkHttpClient okHttpClient) {
        if (okHttpClient == null) {

            X509TrustManager xtm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    X509Certificate[] x509Certificates = new X509Certificate[0];
                    return x509Certificates;
                }
            };

            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("SSL");

                sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            /** 拦截器压缩http请求体，许多服务器无法解析 */
            Interceptor gzipRequestInterceptor = new Interceptor() {

                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();

                    String contentEncode = originalRequest.header("Content-Encoding");
                    if (originalRequest.body() == null
                            || !StringUtils.contains(contentEncode, "gzip")) {
                        return chain.proceed(originalRequest);
                    }
                    Request compressedRequest = originalRequest.newBuilder()
                            .header("Content-Encoding", "gzip")
                            .method(originalRequest.method(), gzip(originalRequest.body()))
                            .build();
                    return chain.proceed(compressedRequest);
                }
            };
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            mOkHttpClient = builder
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
//                    .sslSocketFactory(sslContext.getSocketFactory())
                    .sslSocketFactory(getSSLSocketFactory(), getX509TrustManager())
                    .hostnameVerifier(getHostnameVerifier())
//                    .hostnameVerifier(DO_NOT_VERIFY)
                    .addInterceptor(gzipRequestInterceptor)
//                    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-qa.s.qima-inc.com", 80)))
                    .build();
        } else {
            mOkHttpClient = okHttpClient;
        }
    }

    public static OKHttpUtils initClient(OkHttpClient okHttpClient) {
        if (mInstance == null) {
            synchronized (OKHttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new OKHttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static OKHttpUtils getInstance() {
        return initClient(null);
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    /**
     * 请求的body gzip压缩
     * @param body
     * @return
     */
    private RequestBody gzip(final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public long contentLength() {
                return -1; // 无法知道压缩后的数据大小
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(gzipSink);
                gzipSink.close();
            }
        };
    }

    public String sendGet(String url, Map<String, String> headers) {
        Request.Builder requestBuilder = new Request.Builder()
                .get()
                .url(url);

        if (headers != null && !headers.isEmpty()) {
            headers.forEach((key, value) -> {
                requestBuilder.addHeader(key, value);
            });
        }

        long startTime = System.currentTimeMillis();
        Response response = null;
        try {
            response = mOkHttpClient.newCall(requestBuilder.build()).execute();
        } catch (IOException e) {
            LOGGER.error("action=sendGet, send get http request occur exception", e);
        }
//        LOGGER.info("cost: {} ms", System.currentTimeMillis() - startTime);
        return okResp2String(response);

    }

    public void downFile(String url, Map<String, String> headers, File file) throws Exception{
        Request.Builder requestBuilder = new Request.Builder()
                .get()
                .url(url);

        if (headers != null && !headers.isEmpty()) {
            headers.forEach((key, value) -> {
                requestBuilder.addHeader(key, value);
            });
        }

        long startTime = System.currentTimeMillis();
        Response response = null;
        try {
            response = mOkHttpClient.newCall(requestBuilder.build()).execute();
        } catch (IOException e) {
            LOGGER.error("action=sendGet, send get http request occur exception", e);
        }
//        LOGGER.info("cost: {} ms", System.currentTimeMillis() - startTime);
        FileUtils.writeByteArrayToFile(file, response.body().bytes());

    }

    public String sendJsonPost(String url, Map<String, String> headers, String body) {
        RequestBody requestBody = RequestBody.create(JSON, body);
        Request.Builder requestBuilder = new Request.Builder()
                .post(requestBody)
                .url(url);
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((key, value) -> {
                requestBuilder.addHeader(key, value);
            });
        }
        Response response = null;
        try {
            response = mOkHttpClient.newCall(requestBuilder.build()).execute();
        } catch (IOException e) {
            LOGGER.error("action=sendPost, send post http request occur exception", e);
        }
        return okResp2String(response);

    }

    public String sendFormPost(String url, Map<String, String> headers, String body) {
        RequestBody requestBody = RequestBody.create(form, body);
        Request.Builder requestBuilder = new Request.Builder()
                .post(requestBody)
                .url(url);
        if (headers != null && !headers.isEmpty()) {
            headers.forEach((key, value) -> {
                requestBuilder.addHeader(key, value);
            });
        }
        Response response = null;
        try {
            response = mOkHttpClient.newCall(requestBuilder.build()).execute();
        } catch (IOException e) {
            LOGGER.error("action=sendFormPost, send post http request occur exception", e);
        }
        return okResp2String(response);
    }

    private String okResp2String(Response response) {
        String result = null;
        if (response == null) {
            return result;
        }
        try {
            result = response.body().string();
        } catch (IOException e) {
            LOGGER.error("action=okResp2String, send get http request but parse response body occur exception", e);
        }
        return result;
    }

    /**
     * * 下面用于注册
     * @return
     */



    //获取这个SSLSocketFactory
    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取TrustManager
    private static TrustManager[] getTrustManager() {
        return new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
    }

    //获取HostnameVerifier
    public static HostnameVerifier getHostnameVerifier() {
        return (s, sslSession) -> true;
    }

    public static X509TrustManager getX509TrustManager() {
        X509TrustManager trustManager = null;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            trustManager = (X509TrustManager) trustManagers[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trustManager;
    }

}
