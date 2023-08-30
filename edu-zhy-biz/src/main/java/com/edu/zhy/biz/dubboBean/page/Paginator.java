package com.edu.zhy.biz.dubboBean.page;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by xuzhaopeng on 4/27/16.
 */
@ToString
@EqualsAndHashCode
public class Paginator implements Serializable {

    private static final long serialVersionUID = 6577936451268217276L;
    private int page;
    private int pageSize;
    private int totalCount;

    public Paginator(int totalCount) {
        this.totalCount = totalCount;
    }

    public Paginator(int page, int pageSize, int totalCount) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
