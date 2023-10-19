package com.edu.zhy.api.api.visibility;

import java.lang.reflect.Field;

/**
 * @Auther: zishan
 * @Date: 2020-02-11
 */
public interface BaseConverter {

    void convert(Field field, Object obj);

}
