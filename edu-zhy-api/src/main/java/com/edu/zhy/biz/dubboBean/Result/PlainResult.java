package com.edu.zhy.biz.dubboBean.Result;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class PlainResult<T> extends BaseResult {

    private static final long serialVersionUID = -7348340262762007793L;

    /**
     * 调用返回的数据
     */
    private T data;

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

}
