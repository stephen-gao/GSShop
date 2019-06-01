package com.gao.entity.vo;

import java.util.List;

public class SysDicVO extends BaseVO{

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String code;

    /**
     *
     */
    private String typeCode;

    /**
     *
     */
    private Integer sort;

    List<SysDicVO> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public List<SysDicVO> getItems() {
        return items;
    }

    public void setItems(List<SysDicVO> items) {
        this.items = items;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
