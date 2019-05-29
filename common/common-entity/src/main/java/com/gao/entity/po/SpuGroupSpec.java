package com.gao.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@TableName("t_spu_group_spec")
public class SpuGroupSpec implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	@TableField(value="group_id")
	private Long groupId;

	/**
	 * 
	 */
	@TableField(value="spec_tree_id")
	private Long specTreeId;

	/**
	 * 
	 */
	@TableField(value="spec_name")
	private String specName;

	/**
	 * 
	 */
	@TableField(value="spec_value")
	private String specValue;

	/**
	 * 
	 */
	private Integer sort;

	/**
	 * 
	 */
	@TableField(value="gmt_create")
	private Date gmtCreate;

	/**
	 * 
	 */
	@TableField(value="gmt_update")
	private Date gmtUpdate;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getSpecTreeId() {
		return specTreeId;
	}

	public void setSpecTreeId(Long specTreeId) {
		this.specTreeId = specTreeId;
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
