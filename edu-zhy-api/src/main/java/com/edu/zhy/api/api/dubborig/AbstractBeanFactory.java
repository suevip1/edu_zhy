//package com.edu.zhy.api.api.dubborig;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.reflect.FieldUtils;
//import org.apache.commons.math3.util.Pair;
//import org.mockito.Mockito;
//import org.springframework.util.ReflectionUtils;
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public abstract class AbstractBeanFactory implements IBeanFactory{
//    protected static ThreadLocal<List<Object>> targetContext = new ThreadLocal();
//
//    public AbstractBeanFactory() {
//    }
//
//    public void doInjection(Object target) {
//        boolean var6 = false;
//
//        List list;
//        try {
//            var6 = true;
//            list = (List) ObjectUtils.defaultIfNull(targetContext.get(), new ArrayList());
//            list.add(target);
//            targetContext.set(list);
//            this.doInjectionInternal(target);
//            var6 = false;
//        } finally {
//            if (var6) {
//                List list = (List)targetContext.get();
//                if (CollectionUtils.isNotEmpty(list)) {
//                    list.remove(list.size() - 1);
//                    targetContext.set(list);
//                }
//
//            }
//        }
//
//        list = (List)targetContext.get();
//        if (CollectionUtils.isNotEmpty(list)) {
//            list.remove(list.size() - 1);
//            targetContext.set(list);
//        }
//
//    }
//
//    private void doInjectionInternal(Object target) {
//        List<Object> fieldList = new ArrayList();
//        ReflectionUtils.doWithFields(target.getClass(), (field) -> {
//            Pair valueWrap = null;
//
//            try {
//                valueWrap = this.buildFieldValue(target, field);
//            } catch (Exception var6) {
//                var6.printStackTrace();
//            }
//
//            if (valueWrap != null) {
//                FieldUtils.writeField(field, target, valueWrap.getValue(), true);
//                if (Objects.nonNull(valueWrap.getValue()) && Boolean.TRUE.equals(valueWrap.getKey())) {
//                    fieldList.add(valueWrap.getValue());
//                }
//
//            }
//        }, (field) -> {
//            return this.filterField(target, field);
//        });
//        fieldList.forEach(DubboBeanFactory::autoInjection);
//    }
//
//    protected boolean filterField(Object currentTarget, Field field) {
//        return BeanFactoryUtils.isNull(currentTarget, field) && !BeanFactoryUtils.isBasicType(field);
//    }
//
//    protected abstract Pair<Boolean, Object> buildFieldValue(Object currentTarget, Field field);
//
//    protected Object newInstance(Class fieldClass) {
//        try {
//            return fieldClass.newInstance();
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            return Mockito.mock(fieldClass);
//        }
//    }
//
//    protected static String prefixPath(Class fieldClass) {
//        String path = fieldClass.getPackage().getName();
//        System.out.println(path);
//        int index = -1;
//
//        for(int i = 0; i < 4; ++i) {
//            index = path.indexOf(".", index + 1);
//        }
//
//        return index == -1 ? path : path.substring(0, index);
//    }
//
//}
