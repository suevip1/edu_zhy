package com.edu.zhy.api.api.http.service.httputiljiagou.exception;
public class NoMatchBeanFoundException extends RuntimeException {

    private String shopRole;

    private String tClass;

    public NoMatchBeanFoundException(String shopRole, String tClass) {
        super(createMsg(shopRole, tClass));
        this.shopRole = shopRole;
        this.tClass = tClass;
    }

    private static String createMsg(String shopRole, String tClass) {
        return "cannot find a bean with shop=[" + shopRole + "],tClass=[" + tClass + "]";
    }

    public String getShopRole() {
        return shopRole;
    }

    public String gettClass() {
        return tClass;
    }
}
