package com.edu.zhy.api.api.windows.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;


/**
 * @author luoxiangnan
 * @date 2020-05-21
 */
public class SecureUtils {

    private static String key = "CuGj8tf2eg4KOmN5";

    private static AES aes = SecureUtil.aes(key.getBytes());


    /**
     * 解密
     */
    public static String decryptStr(String encrypt) {
        return aes.decryptStr(encrypt);
    }


    /**
     * 加密
     */
    public static String encryptStr(String key, String password) {
        return aes.encryptBase64(password);
    }


    /**
     * 这里输入自己的密码加下密后在如下变量使用 cas的密码
     * @see /edu-script/quick/src/main/resources/application.properties
     * @param args
     */
    public static void main(String[] args) {
        // 自己密码拿出来，放配置文件
        String password = SecureUtils.encryptStr(key, "");
        System.out.println(password);

    }
}
