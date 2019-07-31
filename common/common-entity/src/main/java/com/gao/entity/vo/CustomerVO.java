package com.gao.entity.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author gs
 * @Date created time 2019/6/6 15:31
 * @Description
 */
public class CustomerVO extends BaseVO{

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String loginId;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String accessToken;

    /**
     *
     */
    private String state;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String nickname;

    /**
     *
     */
    private String tel;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     *
     */
    private String idCardType;

    /**
     *
     */
    private String idCardNo;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private String birthday;

    /**
     *
     */
    private String photoSm;

    /**
     *
     */
    private String photoMd;

    /**
     *
     */
    private String photoSrc;

    /**
     * 余额
     */
    private BigDecimal userMoney;

    /**
     * 积分
     */
    private Integer userPoint;

    /**
     *
     */
    private String vipLevel;

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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhotoSm() {
        return photoSm;
    }

    public void setPhotoSm(String photoSm) {
        this.photoSm = photoSm;
    }

    public String getPhotoMd() {
        return photoMd;
    }

    public void setPhotoMd(String photoMd) {
        this.photoMd = photoMd;
    }

    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
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
