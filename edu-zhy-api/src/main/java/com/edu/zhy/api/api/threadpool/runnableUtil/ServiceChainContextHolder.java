package com.edu.zhy.api.api.threadpool.runnableUtil;

import java.util.Map;

public interface ServiceChainContextHolder {

    ThreadLocal<? extends ServiceChainContextHolder> getHolder();

    Map getServiceChainContext();

    void setServiceChainContext(Map serviceChain);
}
