package com.edu.zhy.api.api.util;

import brave.internal.Nullable;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.BufferedSink;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class httpUtil {

    private volatile static httpUtil mInstance;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final MediaType form = MediaType.parse("application/x-www-form-urlencoded");

    private OkHttpClient mOkHttpClient;


    private static final String IMGUR_CLIENT_ID = "...";
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");



    public String proxy ="http://proxy-qa.s.qima-inc.com";


    /**
     * *发送http请求 post
     * @return
     */
    public String sendHttpPost(HttpPost httpPost)throws IOException{
        String string;

        try (CloseableHttpClient httpClient = HttpClients.createDefault();){

            CloseableHttpResponse execute = httpClient.execute(httpPost);
            HttpEntity entity = execute.getEntity();

            string = EntityUtils.toString(entity, "UTF-8");

        }
        return string;
    }


    /**
     * *发送http   get请求
     * @param httpGet
     * @return
     * @throws IOException
     */
    public String sendHttpGet(HttpGet httpGet)throws IOException{
        String string;

        try (CloseableHttpClient httpClient = HttpClients.createDefault();){

            CloseableHttpResponse execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();

            string = EntityUtils.toString(entity, "UTF-8");

        }
        return string;
    }



    //拼接url参数
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


    //构建http请求 可强转
    public HttpRequestBase getProxyMethod(String url, boolean isGet) {

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










    public String sendPost(String content){


        return "";
    }




    /**
     * *异步get请求
     * @return
     */
    public String sendSysnGet(HttpPost httpPost) throws IOException{



        return "";
    }




    /**
     * 示例代码
     * */

    /**
     * *
     * *前面几个步骤和异步方式一样，只是最后一部是通过 Call#execute() 来提交请求，
     * * 注意这种方式会阻塞调用线程，所以在Android中应放在子线程中执行，否则有可能引起ANR异常，Android3.0
     * * 以后已经不允许在主线程访问网络
     * *
     * @return
     */
    public String sendGetV1(){
        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
//                    Log.d(TAG, "run: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        return "";
    }


    /**
     * *-new OkHttpClient;
     * -构造Request对象；
     * -通过前两步中的对象构建Call对象；
     * -通过Call#enqueue(Callback)方法来提交异步请求；
     * *异步发起的请求会被加入到 Dispatcher 中的 runningAsyncCalls双端队列中通过线程池来执行
     * *
     * @return
     */
    public String sendSysnGetV1(){

        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });

        return "";
    }


    /**
     * *
     * @param content
     * @return
     */
    public String sendPostStringV1(String content){
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "I am Jdqm.";
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    Log.d(TAG, headers.name(i) + ":" + headers.value(i));
                }
//                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });

        return "";
    }


    /**
     * *POST方式提交流
     * @param content
     * @return
     */
    public String sendPostStreamV1(String content){

        RequestBody requestBody = new RequestBody() {
            @Nullable
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/x-markdown; charset=utf-8");
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("I am Jdqm.");
            }
        };

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    Log.d(TAG, headers.name(i) + ":" + headers.value(i));
                }
//                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
        return "";
    }


    /**
     * * POST提交文件
     * @param content
     * @return
     */
    public String sendPostFileV1(String content){
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("test.md");
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, file))
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    Log.d(TAG, headers.name(i) + ":" + headers.value(i));
                }
//                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });

        return "";
    }


    /**
     * *POST方式提交表单
     * @param content
     * @return
     */
    public String sendPostHeadersV1(String content){
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .build();
        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    Log.d(TAG, headers.name(i) + ":" + headers.value(i));
                }
//                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
        return "";
    }


    /**
     * *POST方式提交分块请求
     * MultipartBody 可以构建复杂的请求体，与HTML文件上传形式兼容。多块请求体中每块请求都是一个请求体，可以定义自己的请求头。
     * * 这些请求头可以用来描述这块请求，例如它的 Content-Disposition 。如果 Content-Length 和 Content-Type 可用的话，他们会被自动添加到请求头中。
     **
     * *
     * @param content
     * @return
     */
    public String sendPostDocumentedV1(String content){

//        private void postMultipartBody() {
            OkHttpClient client = new OkHttpClient();


            // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
            MultipartBody body = new MultipartBody.Builder("AaB03x")
                    .setType(MultipartBody.FORM)
                    .addPart(
                            Headers.of("Content-Disposition", "form-data; name=\"title\""),
                            RequestBody.create(null, "Square Logo"))
                    .addPart(
                            Headers.of("Content-Disposition", "form-data; name=\"image\""),
                            RequestBody.create(MEDIA_TYPE_PNG, new File("website/static/logo-square.png")))
                    .build();

            Request request = new Request.Builder()
                    .header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
                    .url("https://api.imgur.com/3/image")
                    .post(body)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println(response.body().string());
                }
            });
//        }

        return "";
    }




}
