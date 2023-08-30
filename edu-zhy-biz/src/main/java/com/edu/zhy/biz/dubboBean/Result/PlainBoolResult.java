package com.edu.zhy.biz.dubboBean.Result;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单的布尔值返回类，继承<code>BaseResult</code>
 * 解决泛型导致布尔结果值直接返回一个value，而不是key-value的结果
 * Created by Loops on 25/04/2017.
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class PlainBoolResult extends BaseResult {

    private static final long serialVersionUID = -8868847413114874703L;

    private final static String BOOLEAN_KEY = "isSuccess";

    private Map<String, Boolean> data;

    public Map<String, Boolean> getData() {
        return data;
    }

    public void setData(boolean isSuccess) {
        if (data == null) {
            data = new HashMap<String, Boolean>();
        }
        data.put(BOOLEAN_KEY, isSuccess);
    }
}
