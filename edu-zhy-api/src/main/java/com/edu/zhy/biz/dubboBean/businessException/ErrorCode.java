package com.edu.zhy.biz.dubboBean.businessException;

public class ErrorCode {
    static final int CODE_LEN = 9;
    private static Integer prefix;
    private static int suffixLength;
    private static String format;

    public ErrorCode() {
    }

    public static Integer assembleErrorCode(Integer code) {
        code = Math.abs(code);
        String codeStr = String.valueOf(code);
        return codeStr.length() > suffixLength ? code : Integer.valueOf(String.format(format, code));
    }

    public static Integer getPrefix() {
        return prefix;
    }

    public static void setPrefix(Integer prefix) {
        ErrorCode.prefix = prefix;
        int prefixLength = String.valueOf(prefix).length();
        suffixLength = 9 - prefixLength;
        format = prefix + "%0" + suffixLength + "d";
    }
}
