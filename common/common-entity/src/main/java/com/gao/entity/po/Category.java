package com.gao.entity.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@TableName("t_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 分类名称
	 */
	@TableField(value="category_name")
	private String categoryName;

	/**
	 * 
	 */
	@TableField(value="parent_id")
	private Long parentId;

	/**
	 * 
	 */
	private Integer sort;

	/**
	 * 创建时间
	 */
	@TableField(value="gmt_create")
	private Date gmtCreate;

	/**
	 * 更新时间
	 */
	@TableField(value="gmt_update")
	private Date gmtUpdate;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
