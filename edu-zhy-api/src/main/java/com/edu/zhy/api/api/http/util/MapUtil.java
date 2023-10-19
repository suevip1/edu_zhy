package com.edu.zhy.api.api.http.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * Map 工具类
 *
 */
public class MapUtil {

    public static Map<String, String> toStringMap(Object param) {
        return JSONObject.parseObject(JSON.toJSONString(param), new TypeReference<Map<String, String>>() {
        });
    }
}
