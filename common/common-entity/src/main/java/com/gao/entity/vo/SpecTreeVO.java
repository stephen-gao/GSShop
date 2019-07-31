package com.gao.entity.vo;

import java.util.Date;
import java.util.List;

/**
 * @Author gs
 * @Date created time 2019/6/12 11:12
 * @Description
 */
public class SpecTreeVO extends BaseVO{

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String id;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 规格值
     */
    private String specValue;

    /**
     * 父节点
     */
    private String parentId;

    /**
     * 区分sku/spu,0/spu,1/sku
     */
    private Integer type;

    /**
     * 是否是可选规格(叶子节点)标识
     */
    private Integer specFlag;

    /**
     *
     */
    private Integer sort;

    /**
     *
     */
    private Date gmtCreate;

    /**
     *
     */
    private Date gmtUpdate;

    private List<SpecTreeVO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSpecFlag() {
        return specFlag;
    }

    public void setSpecFlag(Integer specFlag) {
        this.specFlag = specFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public List<SpecTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<SpecTreeVO> children) {
        this.children = children;
    }
}
