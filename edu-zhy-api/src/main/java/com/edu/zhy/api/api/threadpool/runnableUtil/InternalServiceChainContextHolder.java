package com.edu.zhy.api.api.threadpool.runnableUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heweilong on 2017/7/25.
 */
class InternalServiceChainContextHolder implements ServiceChainContextHolder {

    private final Map attachments = new HashMap<String, Object>();

    private static final ThreadLocal<InternalServiceChainContextHolder> LOCAL = new ThreadLocal<InternalServiceChainContextHolder>() {
        @Override
        protected InternalServiceChainContextHolder initialValue() {
            return new InternalServiceChainContextHolder();
        }
    };

    public ThreadLocal<? extends ServiceChainContextHolder> getHolder() {
        return LOCAL;
    }

    public Map getServiceChainContext() {
        Object obj = attachments.get(Constants.SERVICE_CHAIN);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public void setServiceChainContext(Map serviceChainMap) {
        attachments.put(Constants.SERVICE_CHAIN, serviceChainMap);
    }

    /**
     * remove context.
     *
     */
    public void removeServiceChainContext() {
        LOCAL.remove();
    }

}