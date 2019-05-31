package com.gao.entity.vo;

import java.util.List;

/**
 * @Author gs
 * @Date created time 2019/5/28 16:41
 * @Description
 */
public class BaseVO {

    //默认num
    private Long DEFAULT_PAGE_NUM = 1L;
    //默认size
    private Long DEFAULT_PAGE_SIZE = 10L;

    private String DEFAULT_SORT_TYPE = "ASC";

    private Long pageNum;

    private Long pageSize;

    private List<String> sortList;

    private String sortType;

    public Long getPageNum() {
        return null == this.pageNum ? this.DEFAULT_PAGE_NUM : this.pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return null == this.pageSize ? this.DEFAULT_PAGE_SIZE : this.pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public List<String> getSortList() {
        return sortList;
    }

    public void setSortList(List<String> sortList) {
        this.sortList = sortList;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
