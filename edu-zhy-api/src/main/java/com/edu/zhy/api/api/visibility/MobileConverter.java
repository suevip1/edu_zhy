package com.edu.zhy.api.api.visibility;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @Auther: zishan
 * @Date: 2020-02-11
 */
@Slf4j
public class MobileConverter implements BaseConverter {


    @Override
    public void convert(Field field, Object obj) {
        try {
            Object preVal = FieldUtils.readField(field, obj, Boolean.TRUE.booleanValue());
            if (preVal instanceof String) {
                String val = (String) preVal;
                if (val.length() < 5) {
                    return;
                }
                String hidenPhone = val.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1 **** $2");

                FieldUtils.writeField(field, obj, hidenPhone, Boolean.TRUE.booleanValue());

            }
        } catch (IllegalAccessException e) {
            log.error("MobileConvertor.convert faild! field:{}, Object:{}, preVal:{}", field.getName(), obj.getClass().getName(), JSON.toJSONString(obj), e);
        }
    }
}

