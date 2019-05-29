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
@TableName("t_spu")
public class Spu implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 子标题
	 */
	@TableField(value="sub_title")
	private String subTitle;

	/**
	 * 描述
	 */
	private String describe;

	/**
	 * 分类ID
	 */
	@TableField(value="category_id")
	private Long categoryId;

	/**
	 * 品牌ID
	 */
	@TableField(value="brand_id")
	private Long brandId;

	/**
	 * 品牌名称
	 */
	private String brand;

	/**
	 * 产地国家ID
	 */
	@TableField(value="country_id")
	private Long countryId;

	/**
	 * 产地国家
	 */
	private String country;

	/**
	 * 列表图
	 */
	private String banner;

	/**
	 * 状态
	 */
	private Integer state;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
