package com.gao.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author gs
 * @Date created time 2019/5/28 14:26
 * @Description
 */
public class UserVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String tel;

    /**
     * 头像
     */
    private String photo;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * vip 0/普通用户 1/v1
     */
    private Integer vip;

    /**
     * 账号状态 0/正常 1/监控 2/异常 3/冻结 5/锁定 6/暂停 9/注销
     */
    private Integer status;

    /**
     * 盐值
     */
    private String salt;

    /**
     *
     */
    private Date gmtCreate;

    /**
     *
     */
    private Date gmtUpdate;

    /**
     * 用户访问token
     */
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
