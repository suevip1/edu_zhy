package com.edu.zhy.api.api.visibility;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @Auther: zishan
 * @Date: 2020-02-20
 */
@Slf4j
public class QuantityConverter implements BaseConverter {

    @Override
    public void convert(Field field, Object obj) {
        try {
            Object preVal = FieldUtils.readField(field, obj, Boolean.TRUE.booleanValue());

            if (preVal instanceof Integer) {
                FieldUtils.writeField(field, obj, 0, Boolean.TRUE.booleanValue());
            } else if (preVal instanceof Long) {
                FieldUtils.writeField(field, obj, 0L, Boolean.TRUE.booleanValue());

            } else if (preVal instanceof Float) {
                FieldUtils.writeField(field, obj, 0F, Boolean.TRUE.booleanValue());
            } else if (preVal instanceof Double) {
                FieldUtils.writeField(field, obj, 0D, Boolean.TRUE.booleanValue());
            } else if (preVal instanceof String) {
                FieldUtils.writeField(field, obj, "", Boolean.TRUE.booleanValue());
            }
        } catch (IllegalAccessException e) {
            log.error("QuanityConvertor.convert faild! field:{}, Object:{}, preVal:{}", field.getName(), obj.getClass().getName(), JSON.toJSONString(obj), e);
        }
    }
}
