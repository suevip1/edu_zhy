package com.edu.zhy.api.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 通用工具类
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

  private static ApplicationContext appCtx;

  /**
   * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
   *
   * @param applicationContext ApplicationContext 对象.
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    appCtx = applicationContext;
  }

  /**
   * 获取ApplicationContext
   */
  public static ApplicationContext getApplicationContext() {
    return appCtx;
  }

  /**
   * 这是一个便利的方法，帮助我们快速得到一个BEAN
   *
   * @param beanName bean的名字
   * @return 返回一个bean对象
   */
  public static Object getBean(String beanName) {
    return appCtx.getBean(beanName);
  }

  public static <T> T getBean(Class<T> clazz) {
    return appCtx.getBean(clazz);
  }

  public static <T> T getBean(String beanName, Class<T> clazz) {
    return appCtx.getBean(beanName, clazz);
  }

  public static <T> Map<String, T> getBeansOfType(Class<T> claz) {
    return appCtx.getBeansOfType(claz);
  }

}
