package com.gao.entity.vo;


import java.util.Date;
import java.util.List;

public class ResourceVO {

    /**
     *
     */
    private String id;

    /**
     * 父资源id
     */
    private String parentId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String code;

    /**
     * 路由节点
     */
    private String path;

    /**
     *
     */
    private String icon;

    /**
     * 节点类型
     */
    private String type;

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

    private List<ResourceVO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<ResourceVO> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceVO> children) {
        this.children = children;
    }
}
