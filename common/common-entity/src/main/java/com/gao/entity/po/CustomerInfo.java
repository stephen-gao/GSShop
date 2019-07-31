package com.gao.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaosheng
 * @since 2019-06-06
 */
@TableName("c_customer_info")
public class CustomerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private String id;

	/**
	 * 
	 */
	@TableField(value="login_id")
	private String loginId;

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
	@TableField(value="real_name")
	private String realName;

	/**
	 * 
	 */
	@TableField(value="id_card_type")
	private String idCardType;

	/**
	 * 
	 */
	@TableField(value="id_card_no")
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
	@TableField(value="photo_sm")
	private String photoSm;

	/**
	 * 
	 */
	@TableField(value="photo_md")
	private String photoMd;

	/**
	 * 
	 */
	@TableField(value="photo_src")
	private String photoSrc;

	/**
	 * 余额
	 */
	@TableField(value="user_money")
	private BigDecimal userMoney;

	/**
	 * 积分
	 */
	@TableField(value="user_point")
	private Integer userPoint;

	/**
	 * 
	 */
	@TableField(value="vip_level")
	private String vipLevel;

	/**
	 *
	 */
	private String state;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
