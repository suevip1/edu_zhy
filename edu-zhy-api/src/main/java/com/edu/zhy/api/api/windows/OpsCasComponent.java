package com.edu.zhy.api.api.windows;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.zhy.api.api.windows.util.UserAgentUtils;
import lombok.extern.slf4j.Slf4j;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class OpsCasComponent extends CasComponent{



    /**
     * cas=d44a37368703a19cfb8a97da13c10d6085ee4ddbc4f95c54af732eaaae3c1885585
     * cors_token -> ZTM4NWRjOWNkOGU5Yjc0YTE0ZjQyMTY4OTQzODQ3ZTFhNjJmNWEwMzY2MzZiNDRmY2E1YjQ5Mzk0NTc0NjBmYzpsYW9saWFuZ2xpYW5n
     * 0ffd467a-b3c5-4827-821f-2d36d613ee88
     * cookie -> a43a106492033b6c6ccbeb322ac3c496475c1757ea670f860d6a623eaa573ca7a2a27659fb4dccf74f54cbfbe3d2446f3635fec3fb280b5dafeb00ff871c2de3d153e23d9c51f49acc25c67bb93c187382a103e34191a9de096a7636fe78d696fb8fed9e03b837aa93f03bdb33e4b5100d4ff3d7524a58275606f13039f43265655c2a620dbe4f5a508b8c1917d1706bf248d81372d3dfa74c925cbd67adb3b3e4e8b3510999b360ff71f75eabbe75ee9f450423f00f1dbde43a79ef15658e9272b6c5372321df5cf61ffcaa316053b312f8c5984db262ecc7694a51db2b1196cbb057beb1f6479b4108539d6c9b8de0cd93a9efa35ca834d662df3f79a84ca1aa21db7211d27c96c6ab3bf856792e49623adc93888be914
     * 刷新cookie
     */
    public static Map<String, String> refreshCookie(String username, String password) {
        log.info("开始刷新cookie");
        HttpResponse loginResponse = login(username, password);
        HttpResponse authResponse = authorize(loginResponse.getCookies());
        HttpResponse response = callback(authResponse.getCookies(), parseLocationCode(authResponse));
        JSONObject object = JSON.parseObject(response.body()).getJSONObject("data");
        Map<String, String> map = new HashMap(2);
        map.put("cookie", object.getString("cookie"));
        map.put("jwt_token", object.getString("jwt_token"));
        log.info("cas认证成功 map:{}", map);
        return map;
    }
    public static Map<String, String> refreshDubboCookie(String username, String password) {
        log.info("开始刷新cookie");
        HttpResponse loginResponse = login(username, password);
        HttpResponse authResponse = authorize3(loginResponse.getCookies());
        String location = authResponse.header("Location");

        HttpResponse response = callback3(authResponse.getCookies(), location);
        HttpCookie httpCookie = response.getCookies().get(0);
        String accessToken = httpCookie.getValue();
        List<HttpCookie> cookies = loginResponse.getCookies();
        cookies.addAll(HttpCookie.parse("accessToken="+accessToken));
        List<HttpCookie> cookies1 = loginResponse.getCookies();
        String cas = cookies1.stream().filter(e -> Objects.equals("cas", e.getName())).findAny().get().getValue();

        HttpResponse response6 = base(cookies1);
        String location6 = response6.header("Location");

        HttpResponse response7 = callback4(cas, accessToken, cookies, location6);
        String tigerUrl = response7.header("Location");
        List<HttpCookie> cookies2 = loginResponse.getCookies();
        cookies2.addAll(HttpCookie.parse("TSID="+accessToken));
        HttpResponse httpResponse9 = authorize5(accessToken, cas, cookies2, tigerUrl);
        HttpResponse httpResponse10 = callback5(accessToken, cas, cookies2, httpResponse9.header("Location"));
        HttpResponse httpResponse11 = callback5(accessToken, cas, cookies2, httpResponse10.header("Location"));

        List<HttpCookie> cookies11 = httpResponse11.getCookies();
        String kdtSessionId = cookies11.stream().filter(e -> Objects.equals("KDTSESSIONID", e.getName())).findAny().get().getValue();
        cookies2.addAll(HttpCookie.parse("KDTSESSIONID="+kdtSessionId));
        // 必须调，否则拿不到sessionId
        callback6(kdtSessionId, accessToken, cas, cookies2, httpResponse11.header("Location"));
        System.out.println(accessToken);
        System.out.println(kdtSessionId);
        Map<String, String> map = new HashMap(2);
        map.put("KDTSESSIONID", kdtSessionId);
        map.put("TSID", accessToken);
        log.info("cas认证成功 map:{}", map);
        return map;
    }

    public String getTSID() {
        HttpResponse loginResponse = login("laoliangliang", "wnG6r1rmyT2Rw63fVb0qoQ==");
        HttpResponse authResponse = authorize3(loginResponse.getCookies());
        System.out.println(authResponse);
        String location = authResponse.header("Location");
        HttpResponse response = callback3(authResponse.getCookies(), location);
        HttpCookie httpCookie = response.getCookies().get(0);
        return httpCookie.getValue();
    }
    public static void main(String[] args) {
        HttpResponse loginResponse = login("laoliangliang", "wnG6r1rmyT2Rw63fVb0qoQ==");
        HttpResponse authResponse = authorize3(loginResponse.getCookies());
//        HttpResponse authResponse2 = authorize2(loginResponse.getCookies());
        System.out.println(authResponse);
        String location = authResponse.header("Location");

        HttpResponse response = callback3(authResponse.getCookies(), location);
        HttpCookie httpCookie = response.getCookies().get(0);
        String accessToken = httpCookie.getValue();
        List<HttpCookie> cookies = loginResponse.getCookies();
        cookies.addAll(HttpCookie.parse("cas_username=laoliangliang"));
        cookies.addAll(HttpCookie.parse("access_user=12312_1"));
        cookies.addAll(HttpCookie.parse("accessToken="+accessToken));
//        cookies.add(HttpCookie.parse("cas=" + accessToken).get(0));

//        loginResponse = login("laoliangliang", "wnG6r1rmyT2Rw63fVb0qoQ==");
//        HttpResponse authResponse4 = authorize4(loginResponse.getCookies());
        List<HttpCookie> cookies1 = loginResponse.getCookies();
        String cas = cookies1.stream().filter(e -> Objects.equals("cas", e.getName())).findAny().get().getValue();

        HttpResponse response6 = base(cookies1);
//        String location4 = authResponse4.header("Location");
//        HttpResponse response4 = callback4(authResponse.getCookies().get(0).getValue(), accessToken, cookies, location4);
//        List<HttpCookie> cookies1 = response4.getCookies();
        String location6 = response6.header("Location");

        HttpResponse response7 = callback4(cas, accessToken, cookies, location6);
        String tigerUrl = response7.header("Location");
        List<HttpCookie> cookies2 = loginResponse.getCookies();
        cookies2.addAll(HttpCookie.parse("cas_username=laoliangliang"));
        cookies2.addAll(HttpCookie.parse("access_user=12312_1"));
        cookies2.addAll(HttpCookie.parse("TSID="+accessToken));
        HttpResponse httpResponse9 = authorize5(accessToken, cas, cookies2, tigerUrl);
        HttpResponse httpResponse10 = callback5(accessToken, cas, cookies2, httpResponse9.header("Location"));
        HttpResponse httpResponse11 = callback5(accessToken, cas, cookies2, httpResponse10.header("Location"));

        List<HttpCookie> cookies11 = httpResponse11.getCookies();
        String kdtSessionId = cookies11.stream().filter(e -> Objects.equals("KDTSESSIONID", e.getName())).findAny().get().getValue();
        cookies2.addAll(HttpCookie.parse("KDTSESSIONID="+kdtSessionId));
        HttpResponse httpResponse12 = callback6(kdtSessionId, accessToken, cas, cookies2, httpResponse11.header("Location"));
        List<HttpCookie> cookies12 = httpResponse12.getCookies();
        System.out.println(accessToken);
        System.out.println(kdtSessionId);
//        HttpResponse httpResponse7 = endUserRedirect(authResponse.getCookies().get(0).getValue(), accessToken, cookies, location7);
//        HttpResponse httpResponse8 = rigerToken(authResponse.getCookies().get(0).getValue(), loginResponse.getCookies(), tigerUrl);
    }



    /**
     * 2. 认证
     */
    private static HttpResponse authorize(List<HttpCookie> loginCookies) {
        log.info("开始cas认证");
        return HttpUtil.createGet("https://cas.qima-inc.com/public/oauth/authorize?name=ops-pro&qs=from_ops_pro&qs=https%3A%2F%2Fops.qima-inc.com%2F%23%2Fworkspace").header("Content-Type",
                "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://cas.qima-inc.com/public/oauth?name=ops-pro&qs=from_ops_pro&qs=https%3A%2F%2Fops" +
                ".qima-inc.com%2F%23%2Fworkspace").header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse authorize2(List<HttpCookie> loginCookies) {
        log.info("开始cas认证");
        return HttpUtil.createGet("https://cas.qima-inc.com/public/oauth/authorize?name=funeng&qs=https%25:%25/%25/funeng.qima-inc.com%25/%25%23%25/permission%25/application").header("Content-Type",
                "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://funeng.qima-inc.com/").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse authorize3(List<HttpCookie> loginCookies) {
        log.info("开始cas认证");
        return HttpUtil.createGet("https://cas.qima-inc.com/public/oauth/authorize?name=hufu-prod-bak&qs=https://funeng.qima-inc.com/::2EE1D4F3BDD500DA18642FE1DD662330").header("Content-Type",
                "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://cas.qima-inc.com/public/oauth?name=hufu-prod-bak&qs=https%3A%2F%2Ffuneng.qima-inc.com%2F%3A%3A2EE1D4F3BDD500DA18642FE1DD662330&redirect_uri=").header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse authorize4(List<HttpCookie> loginCookies) {
        log.info("开始cas认证");
        return HttpUtil.createGet("https://cas.qima-inc.com/public/oauth/authorize?name=funeng&qs=https%3A%2F%2Ffuneng.qima-inc.com%2F&redirect_uri=")
                .header("Host","cas.qima-inc.com")
                .header("Content-Type",
                        "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://cas.qima-inc.com/public/oauth?name=funeng&qs=https%3A%2F%2Ffuneng.qima-inc.com%2F&redirect_uri=")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse authorize5(String token, String cas, List<HttpCookie> loginCookies, String tirgerToken) {
        log.info("开始cas认证");
        return HttpUtil.createGet("https://cas.qima-inc.com/public/oauth/authorize?name=funeng&qs="+tirgerToken)
                .header("Cookie", "TSID="+token+";cas="+cas)
                .header("Host","cas.qima-inc.com")
                .header("Content-Type",
                        "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://funeng.qima-inc.com/")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse base(List<HttpCookie> loginCookies) {
        return HttpUtil.createGet("https://funeng.qima-inc.com/")
                .header("Host","funeng.qima-inc.com")
                .header("Content-Type",
                        "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://safelogin-update.qima-inc.com/")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse endUserRedirect(String cas, String token, List<HttpCookie> loginCookies, String url) {
        return HttpUtil.createGet(url)
                .header("Cookie", "accessToken="+token+";cas="+cas)
                .header("Host","safelogin-update.qima-inc.com")
                .header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Content-Type",
                        "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://safelogin-update.qima-inc.com//")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-site").cookie(convertHttpCookies(loginCookies)).execute();
    }
    private static HttpResponse rigerToken(String cas, List<HttpCookie> loginCookies, String url) {
        return HttpUtil.createGet(url)
                .header("Cookie", "cas="+cas)
                .header("Host","funeng.qima-inc.com")
                .header("Content-Type",
                        "application/json").header("User-Agent", UserAgentUtils.userAgent).header("Referer", "https://safelogin-update.qima-inc.com/")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-origin").cookie(convertHttpCookies(loginCookies)).execute();
    }


    /**
     * 3. 回调
     */
    private static HttpResponse callback(List<HttpCookie> authCookies, String code) {
        log.info("开始cas回调");
        String url = String.format("https://ops.qima-inc.com/api/v1.0/oauth/callback?code=%s&qs=from_ops_pro,https://ops.qima-inc.com/", code);
        return HttpUtil.createGet(url).header("authority", "ops.qima-inc.com").header("accept", "application/json").header("x-requested-with", "XMLHttpRequest").header("User-Agent",
                UserAgentUtils.userAgent).header("Referer", "https://cas.qima-inc.com/public/oauth?name=ops-pro&qs=from_ops_pro&qs=https%3A%2F%2Fops.qima-inc.com%2F%23%2Fworkspace").header("Sec" +
                "-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "same-origin").header("referer", "https://ops.qima-inc.com/").cookie(convertHttpCookies(authCookies)).execute();
    }
    private static HttpResponse callback2(List<HttpCookie> authCookies, String code) {
        log.info("开始cas回调");
        String url = String.format("https://funeng.qima-inc.com/auth/login/callback?code=%s&qs=https://funeng.qima-inc.com/", code);
        return HttpUtil.createGet(url).header("Host", "funeng.qima-inc.com").header("accept", "application/json").header("x-requested-with", "XMLHttpRequest").header("User-Agent",
                        UserAgentUtils.userAgent)
//                .header("Referer", "https://cas.qima-inc.com/public/oauth?name=funeng&qs=from_ops_pro&qs=https://funeng.qima-inc.com/")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "cross-site")
//                .header("referer", "https://funeng.qima-inc.com")
                .cookie(convertHttpCookies2(authCookies)).execute();
    }
    private static HttpResponse callback3(List<HttpCookie> authCookies, String url) {
        log.info("开始cas回调");
        return HttpUtil.createGet(url).header("Host", "safelogin-update.qima-inc.com").header("accept", "application/json").header("x-requested-with", "XMLHttpRequest").header("User-Agent",
                        UserAgentUtils.userAgent)
                .header("Referer", "https://cas.qima-inc.com//")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-site")
//                .header("referer", "https://funeng.qima-inc.com")
                .cookie(convertHttpCookies2(authCookies)).execute();
    }
    private static HttpResponse callback4(String cas, String token, List<HttpCookie> authCookies, String url) {
        log.info("开始cas回调");
//        String url = "https://safelogin-update.qima-inc.com/api/endUser/redirect?enterpriseCode=0f2c2121a277ee9ac666f5c4d72c34b8&redirect=https%3A%2F%2Ffuneng.qima-inc.com%2F";
        return HttpUtil.createGet(url).header("Host", "safelogin-update.qima-inc.com").header("accept", "application/json").header("User-Agent",
                        UserAgentUtils.userAgent)
                .header("Cookie", "accessToken="+token+";cas="+cas)
                .header("Referer", "https://safelogin-update.qima-inc.com/")
                .header("Sec-Fetch-Dest", "document").header("Sec-Fetch-Mode", "navigate").header("Sec-Fetch-Site", "same-site")
//                .header("referer", "https://funeng.qima-inc.com")
                .cookie(convertHttpCookies2(authCookies)).execute();
    }
    private static HttpResponse callback5(String token, String cas, List<HttpCookie> authCookies, String url) {
        log.info("开始cas回调");
        return HttpUtil.createGet(url).header("Host", "funeng.qima-inc.com").header("User-Agent",
                        UserAgentUtils.userAgent)
                .header("Cookie", "TSID="+token+";cas="+cas+";loc_dfp=f3ecb765e14dab3985d4a2724ece72d2; dfp=b7458870b13d2380ad66ee6e2276adb4; ")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Sec-Fetch-Site", "cross-site")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Dest", "document")
                .cookie(convertHttpCookies(authCookies)).execute();
    }
    private static HttpResponse callback6(String sessionId, String token, String cas, List<HttpCookie> authCookies, String url) {
        log.info("开始cas回调");
        return HttpUtil.createGet("https://funeng.qima-inc.com/").header("Host", "funeng.qima-inc.com")
                .header("User-Agent", UserAgentUtils.userAgent)
                .header("Cookie", "KDTSESSIONID="+sessionId+";TSID="+token+";cas="+cas+";loc_dfp=f3ecb765e14dab3985d4a2724ece72d2; dfp=b7458870b13d2380ad66ee6e2276adb4; ")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Sec-Fetch-Site", "cross-site")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Dest", "document")
                .cookie(convertHttpCookies(authCookies)).execute();
    }


}
