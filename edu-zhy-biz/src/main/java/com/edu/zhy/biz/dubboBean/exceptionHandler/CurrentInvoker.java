package com.edu.zhy.biz.dubboBean.exceptionHandler;

public class CurrentInvoker {

    private static final ThreadLocal<String> currentInvokerClassName = new ThreadLocal<>();

    public static void set(String s) {
        currentInvokerClassName.set(s);
    }

    protected static String get() {
        return currentInvokerClassName.get();
    }

    public static void clear() {
        currentInvokerClassName.remove();
    }
}
