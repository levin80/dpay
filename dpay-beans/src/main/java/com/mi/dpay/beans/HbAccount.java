package com.mi.dpay.beans;

import java.util.Date;

/**
 * HbAccount entity. @author MyEclipse Persistence Tools
 */

public class HbAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private String accid;
	private String status;
	private String passwd;
	private Date createtime;
	private Date canceltime;
	private Date modifytime;
	private String tranPasswd;
	private HbAccCash cash;  //现金账户
	private HbAccFavour favour;//优惠账户

	// Constructors

	/** default constructor */
	public HbAccount() {
	}

	/** minimal constructor */
	public HbAccount(String accid) {
		this.accid = accid;
	}

	/** full constructor */
	public HbAccount(String accid, String status, String passwd, Date createtime, Date canceltime, Date modifytime, String tranPasswd) {
		this.accid = accid;
		this.status = status;
		this.passwd = passwd;
		this.createtime = createtime;
		this.canceltime = canceltime;
		this.modifytime = modifytime;
		this.tranPasswd = tranPasswd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccid() {
		return this.accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getCanceltime() {
		return canceltime;
	}

	public void setCanceltime(Date canceltime) {
		this.canceltime = canceltime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getTranPasswd() {
		return tranPasswd;
	}

	public void setTranPasswd(String tranPasswd) {
		this.tranPasswd = tranPasswd;
	}

	public HbAccCash getCash() {
		return cash;
	}

	public void setCash(HbAccCash cash) {
		this.cash = cash;
	}

	public HbAccFavour getFavour() {
		return favour;
	}

	public void setFavour(HbAccFavour favour) {
		this.favour = favour;
	}

	

}