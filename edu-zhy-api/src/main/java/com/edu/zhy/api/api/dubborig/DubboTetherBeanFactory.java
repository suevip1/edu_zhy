//package com.edu.zhy.api.api.dubborig;
//
//import org.apache.commons.math3.util.Pair;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.BeanFactoryUtils;
//
//import java.lang.reflect.Field;
//import java.util.List;
//
//public class DubboTetherBeanFactory extends InterfaceBeanFactory{
//
//    private static final Logger log = LoggerFactory.getLogger(DubboTetherBeanFactory.class);
//
//    public DubboTetherBeanFactory() {
//    }
//
//    protected Pair<Boolean, Object> buildFieldValue(Object currentTarget, Field field) {
//        if (!this.isInterface(field)) {
//            return null;
//        } else {
//            Class fieldClass = field.getType();
//            return !BeanFactoryUtils.isSameProjectPath(((List)targetContext.get()).get(0).getClass(), fieldClass) ? new Pair(false, Builder.enhance(fieldClass)) : null;
//        }
//    }
//
//
//}
