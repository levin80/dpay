package com.mi.dpay.beans;

import java.util.Date;

/**
 * HbAccFavour entity. @author MyEclipse Persistence Tools
 */

public class HbAccFavour implements java.io.Serializable {

	// Fields

	private Integer cashFavourAccid;
	private String accid;
	private String status;
	private Date createtime;
	private Date modifytime;
	private Integer cash;

	// Constructors

	/** default constructor */
	public HbAccFavour() {
	}

	/** full constructor */


	// Property accessors

	public Integer getCashFavourAccid() {
		return this.cashFavourAccid;
	}

	public HbAccFavour(Integer cashFavourAccid, String accid, String status, Date createtime, Date modifytime,
			Integer cash) {
		super();
		this.cashFavourAccid = cashFavourAccid;
		this.accid = accid;
		this.status = status;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.cash = cash;
	}

	public void setCashFavourAccid(Integer cashFavourAccid) {
		this.cashFavourAccid = cashFavourAccid;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}



}