package com.edu.zhy.api.api.Cache;

import com.edu.zhy.api.api.http.service.httputiljiagou.initutil.InitApplicationContextUtil;

/**
 * Created by Admin.
 * Time 2023/12/11 17:28
 * Desc 文件描述
 */
public class TestCache {


    public static void main(String[] args) {


        LocalCache instance = InitApplicationContextUtil.getInstance(AbstractLocalCache.class);

//        UserDTO userDTO = new UserDTO();
//        userDTO.setName("sososo");
//
//        instance.add("sg",userDTO);


        System.err.println(instance.get("sg"));


        InitApplicationContextUtil.closeClient();


    }


}
