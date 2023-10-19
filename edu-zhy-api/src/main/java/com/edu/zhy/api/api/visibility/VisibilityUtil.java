package com.edu.zhy.api.api.visibility;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Auther: zishan
 * @Date: 2019-08-08
 */
@Slf4j
public class VisibilityUtil {

    /**
     * 信息隐藏处理方法
     *
     * @param obj 需要被处理的对象
     */
    public static void hideInfo(Object obj) {
        hideInfo(obj, 0);
    }

    public static void hideInfo(Object obj, int count) {
        try {
            if (count > 10000) {
                return;
            }
            count++;

            if (Objects.isNull(obj)) {
                return;
            }
            Class clazz = obj.getClass();
            if (clazz == null) {
                return;
            }
            String clazzName = clazz.getName();
            if (StringUtils.isBlank(clazzName)) {
                return;
            }

            Map<String, HidingConfigDTO> hidingConfigMap = HideInfoContext.getContext().getFieldReferenceCache().get(clazzName);
            //根据className查看配置信息是否录入
            if (MapUtils.isNotEmpty(hidingConfigMap)) {
                Field[] fields = FieldUtils.getAllFields(clazz);
                for (HidingConfigDTO fieldConfig : hidingConfigMap.values()) {
                    //处理数据隐藏
                    try {
                        if (!doHideData(obj, fieldConfig)) {
                            continue;
                        }
                    } catch (Exception e) {
                        log.warn("VisibilityUtil.hideInfo hide data error! object:{}", obj.toString(), e);
                    }
                }

                //遍历其余字段
                for (Field field : fields) {
                    Object fieldObj = FieldUtils.readField(field, obj, Boolean.TRUE.booleanValue());
                    hideInfo(fieldObj, count);
                }

            } else {
                //无录入数据循环遍历
                loopFieldWithoutConfig(obj, clazz, count);
                return;
            }
        } catch (Throwable e) {
            log.warn("VisibilityUtil.hideInfo error! object:{}", obj.toString(), e);
        } finally {
            HideInfoContext.clean();
        }
    }

    /**
     * 处理数据转化
     *
     * @param obj
     * @param fieldConfig
     * @return
     */
    private static boolean doHideData(Object obj, HidingConfigDTO fieldConfig) {
        try {
            Boolean display = fieldConfig.getDefaultDisplay() == 1 ? true : false;

            Long kdtId = null;
            String indicatorId = null;
            VisibilityConfigDTO visibilityConfigDTO = null;
            if (StringUtils.isNotBlank(fieldConfig.getSwitchIndicatorName())) {
                Object indicatorIdObj = FieldUtils.readField(obj, fieldConfig.getSwitchIndicatorName(), Boolean.TRUE.booleanValue());
                if (indicatorIdObj != null) {
                    indicatorId = String.valueOf(indicatorIdObj);
                }
            }

            if (FieldUtils.getField(obj.getClass(), "kdtId", true) != null) {
                Object kdtIdObj = FieldUtils.readField(obj, "kdtId", Boolean.TRUE.booleanValue());
                if (kdtIdObj != null && kdtIdObj instanceof Long) {
                    kdtId = (Long) kdtIdObj;
                }
            }
            if (kdtId == null && indicatorId == null) {
                //记日志,方便定位排查问题
                log.warn("com.youzan.owl.oc.visibility.VisibilityUtil.doHideData maybe ERROR! kdtId:{},indicatorId:{},err className:{}", kdtId, indicatorId, obj.getClass().getName());
            }

            //从缓存中获取是否展示数据
            SwitchCache switchCache = HideInfoContext.getContext().getSwitchCache();
            if (switchCache == null) {
                log.warn("com.youzan.owl.oc.visibility.VisibilityUtil.doHideData get switchCache fail!");
            }
            if (switchCache != null) {
                String key = SwitchCache.buildKey(kdtId, indicatorId, fieldConfig.getSwitchSource(), fieldConfig.getSwitchIndicatorType(), fieldConfig.getDefaultDisplay() == 1 ? true : false);
                visibilityConfigDTO = switchCache.get(key);
            }

            if (visibilityConfigDTO != null) {
                display = visibilityConfigDTO.getDisplay();
            } else {
                visibilityConfigDTO = VisibilityConfigDTO.builder().display(display).build();
            }

            //数据隐藏
            if (!display) {
                Field hideField = FieldUtils.getField(obj.getClass(), fieldConfig.getHideFieldName(), Boolean.TRUE.booleanValue());
                if (hideField != null) {
                    //获取转化器
                    BaseConverter converter = ConvertDispatch.getConverter(fieldConfig.getConverter());
                    if (converter != null) {
                        converter.convert(hideField, obj);
                    }
                }
            }

            //配置信息field赋值
            if (obj instanceof ExtensionDataAware) {
                String extensionData = ((ExtensionDataAware) obj).getExtensionData();
                Map<String, Object> configMap = null;
                if (StringUtils.isBlank(extensionData)) {
                    configMap = Maps.newHashMap();
                } else {
                    configMap = JSON.parseObject(extensionData);
                }
                configMap.put(fieldConfig.getHideFieldName(), visibilityConfigDTO);
                MethodUtils.invokeMethod(obj, "setExtensionData", JSON.toJSONString(configMap));
            } else {
                Method method = MethodUtils.getAccessibleMethod(obj.getClass(), "getExtensionData", null);
                if (method != null) {
                    Object extensionData = method.invoke(obj, null);
                    Map<String, Object> configMap = null;
                    if (extensionData == null) {
                        configMap = Maps.newHashMap();
                    } else {
                        configMap = JSON.parseObject((String) extensionData);
                    }
                    configMap.put(fieldConfig.getHideFieldName(), visibilityConfigDTO);
                    MethodUtils.invokeMethod(obj, "setExtensionData", JSON.toJSONString(configMap));
                }

            }
        } catch (Throwable e) {
            log.warn("com.youzan.owl.oc.visibility.VisibilityUtil.doHideData error! object:{}", obj.toString(), e);
        }

        return true;
    }

    /**
     * 循环没有配置的属性， 包含com.youzan开头的属性和集合/Map
     *
     * @param obj
     * @param clazz
     * @param count
     * @throws IllegalAccessException
     */
    private static void loopFieldWithoutConfig(Object obj, Class clazz, int count) throws IllegalAccessException {
        if (allowAccess(clazz)) {
            //循环字段
            Field[] fields = FieldUtils.getAllFields(clazz);
            for (Field field : fields) {
                if (field.isEnumConstant()) {
                    continue;
                }
                Object fieldObj = FieldUtils.readField(field, obj, Boolean.TRUE.booleanValue());
                hideInfo(fieldObj, count);
            }
        } else if (obj instanceof Collection) {
            Collection collectionObj = (Collection) obj;
            if (Objects.nonNull(collectionObj)) {
                Iterator it = collectionObj.iterator();
                while (it.hasNext()) {
                    hideInfo(it.next(), count);
                }
            }

        } else if (obj instanceof Map) {
            Map mapObj = (Map) obj;
            Collection collectionObj = mapObj.values();
            if (Objects.nonNull(collectionObj)) {
                Iterator it = collectionObj.iterator();
                while (it.hasNext()) {
                    hideInfo(it.next(), count);
                }
            }
        }
    }

    private static boolean allowAccess(Class clazz) {
        return Optional.ofNullable(clazz)
                .map(Class::getPackage)
                .map(Package::getName)
                .map(name -> name.indexOf("com.youzan"))
                .map(i -> i > -1)
                .orElse(false);
    }


}
