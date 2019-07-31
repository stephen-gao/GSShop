package com.gao.entity.vo;

import java.util.Date;

/**
 * @Author gs
 * @Date created time 2019/6/10 17:55
 * @Description
 */
public class BrandVO extends BaseVO{

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String brandName;

    /**
     *
     */
    private String detail;

    private String imageSm;

    private String imageMd;

    private String imageSrc;


    /**
     *
     */
    private String letter;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageSm() {
        return imageSm;
    }

    public void setImageSm(String imageSm) {
        this.imageSm = imageSm;
    }

    public String getImageMd() {
        return imageMd;
    }

    public void setImageMd(String imageMd) {
        this.imageMd = imageMd;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
