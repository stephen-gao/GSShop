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
@TableName("t_spec_tree")
public class SpecTree implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;

	/**
	 * 规格名称
	 */
	@TableField(value="spec_name")
	private String specName;

	/**
	 * 规格值
	 */
	@TableField(value="spec_value")
	private String specValue;

	/**
	 * 父节点
	 */
	@TableField(value="parent_id")
	private Long parentId;

	/**
	 * 区分sku/spu,0/spu,1/sku
	 */
	private Integer type;

	/**
	 * 是否是可选规格(叶子节点)标识
	 */
	@TableField(value="spec_flag")
	private Integer specFlag;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
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

}
