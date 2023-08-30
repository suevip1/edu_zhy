package com.edu.zhy.biz.dubboBean.Result;

import com.edu.zhy.biz.dubboBean.Result.vo.ListWithPaginatorVO;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 带有分页功能的Result
 *
 * @author: chenhuajiang@youzan.com
 * @date: 15/8/21
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
public class PaginatorResult<T> extends BaseResult {

    private static final long serialVersionUID = 6990937518109539639L;

    private ListWithPaginatorVO<T> data;

    public ListWithPaginatorVO<T> getData() {
        return data;
    }

    public void setData(ListWithPaginatorVO<T> data) {
        this.data = data;
    }
}