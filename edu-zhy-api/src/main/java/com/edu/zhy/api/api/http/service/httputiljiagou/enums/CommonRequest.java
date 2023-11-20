package com.edu.zhy.api.api.http.service.httputiljiagou.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CommonRequest {

    //https://shop16911610.youzan.com/wscshop/edu/course/group/findItemGroupPageForWym.json
    UEL(1,"https://api.netless.link/v5/services/conversion/tasks/%s","URL:请求的接口地址:GET请求地址"),
    EXAMPLE_URL(2,"","exampleUrl:格式请求地址"),
    CONTENT_TYPE(3,"application/json","contentType:格式: application/json"),
    COOKIE(4,"","cookie:cookie信息 电脑抓"),
    USER_AGENT(5,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36","userAgent:电脑信息"),
    APP(6,"ebiz-owl","app:内部访问应用  owl-live"),
    ENV(7,"qa","env:内部访问应用环境 pre"),
    SERVICE(8,"com.youzan.owl.live.api.live.video.LiveFlowMaxViewerWhiteFacade","service : 接口路径:com.youzan.owl.live.api.live.video.EduPolyvRemakesPlayBackFacade"),
    METHOD(9,"addViewerWhite","method:请求得方法"),

    SC(10,"prj0057992","sc:内部sc环境"),

    TIMEOUT(11,"10000","timeout:接口请求秒数"),

    RETRIES(12,"O","retries:注册ol"),


    CACHE_CONTROL(13,"no-cache","Cache-Control:请求外部接口(请求头)"),

    POST_UEL(14,"com.youzan.owl.live.api.live.video.LiveFlowMaxViewerWhiteFacade.addViewerWhite","URL:请求的接口地址:POST请求地址")


    ;


    private Integer type;

    private String name;

    private String desc;



    //用type来寻找
    private static CommonRequest valueOfType(Integer type){
        for (CommonRequest requestType :CommonRequest.values()){
            if (Objects.equals(requestType.type,type)){
                return requestType;
            }

        }
        return null;
    }


    //根据名称来查找
    private static CommonRequest valueOfName(String name){
        return Arrays.stream(values())
                .filter(o -> Objects.equals(name,o.getName()))
                .findFirst()
                .orElse(null);
    }





}
