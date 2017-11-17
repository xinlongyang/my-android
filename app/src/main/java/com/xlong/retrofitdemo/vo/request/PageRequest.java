package com.xlong.retrofitdemo.vo.request;

import com.xlong.retrofitdemo.app.Constants;
import com.xlong.retrofitdemo.base.BaseRequestParams;

/**
 * Created by Administrator on 2017/6/9.
 */

public class PageRequest extends BaseRequestParams {
    private int pageSize = Constants.PAGE_SIZE;
    private int pageNum = Constants.PAGE_NUM;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
