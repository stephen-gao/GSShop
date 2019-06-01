package com.gao.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-31
 */
@TableName("m_resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 父资源id
     */
    @TableField(value = "parent_id")
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
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     *
     */
    @TableField(value = "gmt_update")
    private Date gmtUpdate;

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

}
