package com.edu.zhy.api.api.windows;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.edu.zhy.api.api.windows.util.SecureUtils;
import com.edu.zhy.api.api.windows.util.UserAgentUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.HttpCookie;
import java.util.List;

@Slf4j
public abstract class CasComponent {

    /**
     * cookie字符串转换
     */
    protected static String convertHttpCookieString(List<HttpCookie> cookies) {
        if (CollectionUtils.isEmpty(cookies)) {
            return "";
        }

        StringBuilder cookieWrap = new StringBuilder();
        for (HttpCookie cookie : cookies) {
            cookieWrap.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
        }
        return cookieWrap.toString();
    }


    /**
     * cookie列表转换
     */
    protected static HttpCookie[] convertHttpCookies(List<HttpCookie> cookies) {
        HttpCookie[] result = new HttpCookie[cookies.size()];
        for (int i = 0; i < cookies.size(); i++) {
            result[i] = cookies.get(i);
        }
        return result;
    }
    protected static HttpCookie[] convertHttpCookies2(List<HttpCookie> cookies) {
        HttpCookie[] result = new HttpCookie[cookies.size()+1];
        for (int i = 0; i < cookies.size(); i++) {
            result[i] = cookies.get(i);
        }
        result[result.length - 1] = HttpCookie.parse("TSID=7b0005be38914583820761866313a5df").get(0);
        return result;
    }


    /**
     * 解析认证结果code
     */
    protected static String parseLocationCode(HttpResponse authResponse) {
        String location = authResponse.header("Location");
        return StringUtils.substringBetween(location, "?code=", "&qs=");
    }

    /**
     * 1. 登录
     */
    protected static HttpResponse login(String username, String password) {
        log.info("开始cas登录");
        return HttpUtil.createPost("https://cas.qima-inc.com/public/users/login")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", UserAgentUtils.userAgent)
                .header("Referer", "https://cas.qima-inc.com/public/oauth?name=skynet&qs=&redirect_uri=")
                .header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .body(JSON.toJSONString(MapUtil.builder("username", username).put("password", SecureUtils.decryptStr(password)).build()))
                .execute();

    }
    protected static HttpResponse login2(String username, String password) {
        log.info("开始cas登录");
        return HttpUtil.createPost("https://cas.qima-inc.com/public/users/login")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", UserAgentUtils.userAgent)
                .header("Referer", "https://cas.qima-inc.com/public/oauth?name=hufu-prod-bak&qs=https%3A%2F%2Ffuneng.qima-inc.com%2F%3A%3A2EE1D4F3BDD500DA18642FE1DD662330&redirect_uri=")
                .header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .body(JSON.toJSONString(MapUtil.builder("username", username).put("password", SecureUtils.decryptStr(password)).build()))
                .execute();

    }

}
