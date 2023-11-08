package com.edu.zhy.api.api.threadpool.runnableUtil;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by heweilong on 2017/7/25.
 */
public class ServiceChainContext {

    private static Logger logger = LoggerFactory.getLogger(ServiceChainContext.class);

    private static Map currentServiceChain;

    static {
        currentServiceChain = new HashMap<String, Object>();
        if (null != System.getenv().get(Constants.CURRENT_SERVICE_CHAIN_NAME_PROPERTY)) {
            currentServiceChain.put(Constants.SERVICE_CHAIN_NAME, System.getenv().get(Constants.CURRENT_SERVICE_CHAIN_NAME_PROPERTY));
            logger.debug("currentServiceChain {} {}", Constants.SERVICE_CHAIN_NAME, System.getenv().get(Constants.CURRENT_SERVICE_CHAIN_NAME_PROPERTY));
        }
        if (null != System.getenv().get(Constants.CURRENT_SERVICE_CHAIN_ZAN_TEST_PROPERTY)) {
            currentServiceChain.put(Constants.SERVICE_CHAIN_ZAN_TEST, Boolean.valueOf(String.valueOf(System.getenv().get(Constants.CURRENT_SERVICE_CHAIN_ZAN_TEST_PROPERTY))));
            logger.debug("currentServiceChain {} {}", Constants.SERVICE_CHAIN_ZAN_TEST, System.getenv().get(Constants.CURRENT_SERVICE_CHAIN_ZAN_TEST_PROPERTY));
        }
    }

    public static void init() {
        //do nothing，只是为了触发static代码块，保证初始化只执行一次
    }

    private static ServiceChainContextHolder serviceChainContextHolder = new InternalServiceChainContextHolder();

    static {
        ServiceLoader<ServiceChainContextHolder> loaders = ServiceLoader.load(ServiceChainContextHolder.class);
        Iterator<ServiceChainContextHolder> iterator = loaders.iterator();
        while (iterator.hasNext()) {
            try {
                ServiceChainContext.serviceChainContextHolder = iterator.next();
            } catch (ServiceConfigurationError e) {
                //TODO 阿拉丁容器加载SPI会先使用SystemClassLoader加载，导致获取到非指定Dubbo版本里面的SPI实现
                logger.warn(e.getMessage(), e);
            }
        }
    }

    public static void removeServiceChainContext() {
        serviceChainContextHolder.getHolder().remove();
    }

    public static void setInvocationServiceChainContext(Map serviceChain) {
        serviceChainContextHolder.getHolder().get().setServiceChainContext(serviceChain);
    }

    public static Map getInvocationServiceChainContext() {
        Map serviceChain = serviceChainContextHolder.getHolder().get().getServiceChainContext();
        if (null != serviceChain && serviceChain.keySet().size() > 0) {
            return serviceChain;
        }
        if (null != currentServiceChain && currentServiceChain.keySet().size() > 0) {
            //不能把currentServiceChain直接暴露出去
            serviceChain = new HashMap();
            serviceChain.putAll(currentServiceChain);
            return serviceChain;
        }
        return null;
    }

    public static Optional<Boolean> isInvocationZanTest() {
        Map serviceChain = getInvocationServiceChainContext();
        if (null != serviceChain && serviceChain.containsKey(Constants.SERVICE_CHAIN_ZAN_TEST)) {
            if (Boolean.TRUE.equals(Boolean.valueOf(String.valueOf(serviceChain.get(Constants.SERVICE_CHAIN_ZAN_TEST))))) {
                return Optional.of(Boolean.TRUE);
            } else if (Boolean.FALSE.equals(Boolean.valueOf(String.valueOf(serviceChain.get(Constants.SERVICE_CHAIN_ZAN_TEST))))) {
                return Optional.of(Boolean.FALSE);
            }
        }
        return Optional.ofNullable(null);
    }

    /**
     * 获取当前实例所属的sc
     * @return
     */
    public static String getCurrentServiceChainName() {
        if (null != currentServiceChain && currentServiceChain.get(Constants.SERVICE_CHAIN_NAME) instanceof String) {
            return (String) currentServiceChain.get(Constants.SERVICE_CHAIN_NAME);
        }
        return null;
    }

    /**
     * 获取上游传递过来的sc标识
     * @return
     */
    public static String getUpstreamServiceChainName() {
        Map serviceChain = serviceChainContextHolder.getHolder().get().getServiceChainContext();
        if (null != serviceChain && serviceChain.get(Constants.SERVICE_CHAIN_NAME) instanceof String) {
            return (String) serviceChain.get(Constants.SERVICE_CHAIN_NAME);
        }
        return null;
    }

    /**
     * 获取当前上下文中的sc标识，先获取上游传递过来的sc标识，如果没有则获取当前实例所属的sc
     * @return
     */
    public static String getInvocationServiceChainName() {
        Map serviceChain = getInvocationServiceChainContext();
        if (null != serviceChain && serviceChain.get(Constants.SERVICE_CHAIN_NAME) instanceof String) {
            return (String) serviceChain.get(Constants.SERVICE_CHAIN_NAME);
        }
        return null;
    }

    public static String getInvocationServiceChainWithJsonFormat() {
        Map serviceChain = getInvocationServiceChainContext();
        if (null != serviceChain) {
            try {
                return JSON.toJSONString(serviceChain);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
