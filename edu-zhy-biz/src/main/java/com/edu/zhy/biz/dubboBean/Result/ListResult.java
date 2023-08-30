package com.edu.zhy.biz.dubboBean.Result;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * ListResult，实现具有List功能的Result
 *
 * @author: chenhuajiang@youzan.com
 * @date: 15/8/21
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class ListResult<T> extends BaseResult {

    private static final long serialVersionUID = -6058763157094169276L;

    private List<T> data;

    /**
     * 本次查询的对应的所有条目数量
     */
    private int count;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}