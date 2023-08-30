//package com.edu.zhy.api.api.dubborig;
//
//import lombok.NonNull;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.reflect.Field;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class DubboBeanFactory {
//    private static final Logger log = LoggerFactory.getLogger(DubboBeanFactory.class);
//    private static Map<Field, Object> fieldBeanMap = new ConcurrentHashMap();
//    private static Map<Class, Object> classBeanMap = new ConcurrentHashMap();
//    private static List<IBeanFactory> beanFactoryList;
//
//    public DubboBeanFactory() {
//    }
//
//    public static <T> T autoInjection(@NonNull T target) {
//        if (target == null) {
//            throw new NullPointerException("target");
//        } else {
//            beanFactoryList.forEach((o) -> {
//                o.doInjection(target);
//            });
//            return target;
//        }
//    }
//
//    public static void registerBeans(Object... beans) {
//        Object[] var1 = beans;
//        int var2 = beans.length;
//
//        for(int var3 = 0; var3 < var2; ++var3) {
//            Object bean = var1[var3];
//            classBeanMap.put(bean.getClass(), bean);
//        }
//
//    }
//
//    public static void registerBean(Field field, Object bean) {
//        fieldBeanMap.put(field, bean);
//    }
//
//    static {
//        beanFactoryList = Arrays.asList(new CustomizeFieldBeanFactory(fieldBeanMap), new CustomizeClassBeanFactory(classBeanMap), new DubboTetherBeanFactory(), new InterfaceDaoBeanFactory(), new InterfaceBeanFactory(), new ListBeanFactory(), new ObjectBeanFactory());
//    }
//
//}
