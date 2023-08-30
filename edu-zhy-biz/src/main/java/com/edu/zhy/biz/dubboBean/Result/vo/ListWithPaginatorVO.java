package com.edu.zhy.biz.dubboBean.Result.vo;

import com.edu.zhy.biz.dubboBean.page.Paginator;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuzhaopeng on 4/27/16.
 */
@ToString
@EqualsAndHashCode
public class ListWithPaginatorVO<T> implements Serializable {

    private static final long serialVersionUID = -2401500271424252921L;
    private Paginator paginator;
    private List<T> items;

    public ListWithPaginatorVO(Paginator paginator, List<T> items) {
        this.paginator = paginator;
        this.items = items;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

}
