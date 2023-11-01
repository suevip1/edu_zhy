//package com.edu.zhy.api.api.http.service.httputiljiagou.initutil;
//
//import com.edu.zhy.api.api.http.service.httputiljiagou.exception.NoMatchBeanFoundException;
//import com.edu.zhy.api.api.http.service.httputiljiagou.exception.ReflectInvokeException;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.NoSuchBeanDefinitionException;
//import org.springframework.context.ApplicationContext;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
///**
// * * ApplicationContext context 为空还不能用
// * *需要一个快速注册的办法本地无法实现  setApplicationContext方法 和Component注解
// */
////@Component
//public class ApplicationContextHelper
////        implements ApplicationContextAware
//{
//
//    private static ApplicationContext context;
//
//
////    @Override
////    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
////        context = applicationContext;
////    }
//
//    /**
//     * 获取ApplicationContext
//     */
//    public static ApplicationContext getApplicationContext() {
//        return context;
//    }
//
//
//    public static <T> T dispatch(Class<T> tClass, String routeTypeName, String methodName) {
//
//        if (Objects.isNull(tClass)) {
//            throw new IllegalArgumentException("tClass cannot be null");
//        }
//
//        List<T> beans = new ArrayList<>(context.getBeansOfType(tClass).values());
//        System.err.println(beans);
//        if (beans.isEmpty()) {
//            throw new NoSuchBeanDefinitionException(tClass.getName());
//        }
//
//        for (T bean : beans) {
//            if (isMatchRouteType(bean, routeTypeName, methodName)) {
//                return bean;
//            }
//        }
//
//        throw new NoMatchBeanFoundException(routeTypeName, tClass.getName());
//    }
//
//    /**
//     * 判断业务类是否和请求的角色是否匹配
//     * <p>
//     */
//    private static <T> Boolean isMatchRouteType(T bean, String routeTypeName, String methodName) {
//
//        if (Objects.isNull(bean) || StringUtils.isEmpty(routeTypeName) || StringUtils.isEmpty(methodName)) {
//            return false;
//        }
//
//        try {
//            Method method = bean.getClass().getDeclaredMethod(methodName);
//            System.err.println("method"+methodName);
//            method.setAccessible(true);
//            String routeType = (String) method.invoke(bean);
//            System.err.println("routeType"+routeType);
//            method.setAccessible(false);
//            return routeTypeName.equals(routeType);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            throw new ReflectInvokeException(bean, e.getMessage());
//        }
//    }
//
//}
