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
@TableName("t_sku_spec")
public class SkuSpec implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	@TableField(value="sku_id")
	private Long skuId;

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

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
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
