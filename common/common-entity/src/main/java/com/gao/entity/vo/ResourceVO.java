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
     * 布局
     */
    private String component;

    /**
     *
     */
    private String icon;

    /**
     * 是否判断权限
     */
    private Integer reqauth;

    /**
     * 状态
     */
    private Integer state;

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

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getReqauth() {
        return reqauth;
    }

    public void setReqauth(Integer reqauth) {
        this.reqauth = reqauth;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
