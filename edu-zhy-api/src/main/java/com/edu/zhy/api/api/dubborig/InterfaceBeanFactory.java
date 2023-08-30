//package com.edu.zhy.api.api.dubborig;
//
//import org.apache.commons.math3.util.Pair;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.support.AbstractBeanFactory;
//
//import java.lang.reflect.Field;
//import java.util.*;
//
//public class InterfaceBeanFactory extends AbstractBeanFactory {
//    private static final Logger log = LoggerFactory.getLogger(InterfaceBeanFactory.class);
//
//    public InterfaceBeanFactory() {
//    }
//
//    protected boolean isInterface(Field field) {
//        return field.getType().isInterface() && !field.getType().isArray() && !field.getType().isAssignableFrom(List.class) && !field.getType().isAssignableFrom(Collection.class) && !field.getType().isAssignableFrom(Map.class);
//    }
//
//    protected Pair<Boolean, Object> buildFieldValue(Object currentTarget, Field field) {
//        if (!this.isInterface(field)) {
//            return null;
//        } else {
//            Class fieldClass = field.getType();
//            Reflections reflections = new Reflections(prefixPath(fieldClass), new Scanner[0]);
//            Set<Class> classes = reflections.getSubTypesOf(fieldClass);
//            return !Objects.isNull(classes) && classes.size() <= 1 ? new Pair(true, this.newInstance((Class)classes.stream().findFirst().get())) : null;
//        }
//    }
//}
