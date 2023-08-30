package com.edu.zhy.biz.dubboBean;


import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * dubbo telnet代理类
 *
 * @author luoxiangnan
 * @date 2020-03-04
 */
@Slf4j
@SuppressWarnings("all")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DubboTetherProxy implements MethodInterceptor {

    static {
        try {
            FieldUtils.writeStaticField(FacadeTemplate.class, "facadeTemplateOptions", FacadeTemplateOptions.DEFAULT, true);
            FieldUtils.writeStaticField(ClientTemplate.class, "clientTemplateOptions", ClientTemplateOptions.DEFAULT, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义的 xServiceChain 参数
     */
    public static HashMap<String, Object> xServiceChain = new HashMap<>();
    public static boolean showTetherLogLog = false;

    private static String TETHER_URL = "http://tether-qa.s.qima-inc.com:8680/soa/";

    static {
        switch (System.getProperty("spring.profiles.active", "qa")) {
            case "pre": {
                TETHER_URL = "http://tether-pre.s.qima-inc.com:8680/soa/";
                break;
            }
            default: {
                break;
            }
        }
    }

    protected static String TETHER_URL_FORMAT = TETHER_URL + "%s/%s";

    /**
     * Object类内方法集合
     */
    protected final static Set<String> objectMethods = Arrays.stream(Object.class.getMethods()).map(Method::getName).collect(Collectors.toSet());

    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) {

        // 本地方法一律不代理
        if (objectMethods.contains(method.getName())) {
            return "toString".equals(method.getName()) ? obj.getClass().getName() : null;
        }

        String tetherUrl = String.format(TETHER_URL_FORMAT, method.getDeclaringClass().getTypeName(), method.getName());
        String body = Arrays.stream(params).map(o -> Objects.isNull(o) ? "{}" : JSON.toJSONString(o)).collect(Collectors.toList()).toString();
        if (showTetherLogLog) {
            log.info("DubboTetherProxy intercept: {} {}", tetherUrl, body);
        }
        String result = null;
        xServiceChain.put("name", System.getProperty("mock.dubbo.sc", "qa"));
//        String result = HttpRequest.post(tetherUrl)
//                .header("Content-Type", "application/json")
//                .header("x-request-protocol", "dubbo")
//                .header("X-Service-Chain", JSON.toJSONString(xServiceChain))
//                .body(body)
//                .execute().body();
        if (StringUtils.isBlank(result) || !result.startsWith("{")) {
            log.error("tetherUrl:{} body:{} invoke error result:{}", tetherUrl, body, result);
            return new RuntimeException(result);
        }
        return JSON.parseObject(result, method.getGenericReturnType());
    }

    /**
     * 创建dubbo tether代理
     * 如果需要在property中自定义服务sc环境
     * - System.setProperty("mock.dubbo.sc", "prj001");
     */
    public static class Builder {

        @SuppressWarnings("all")
        public static <T> T enhance(Class<T> object) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(object);
            enhancer.setCallback(new DubboTetherProxy());
            return (T) enhancer.create();
        }
    }
}
