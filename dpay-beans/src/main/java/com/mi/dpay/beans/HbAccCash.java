package com.mi.dpay.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * HbAccCash entity. @author MyEclipse Persistence Tools
 */

public class HbAccCash implements java.io.Serializable {

	// Fields

	private Integer cashAccid;
	private String accid;
	private String status;
	private Date createtime;
	private Date modifytime;
	private Integer cash;

	// Constructors

	/** default constructor */
	public HbAccCash() {
	}

	/** full constructor */


	// Property accessors

	public Integer getCashAccid() {
		return this.cashAccid;
	}

	public HbAccCash(Integer cashAccid, String accid, String status, Date createtime, Date modifytime, Integer cash) {
		super();
		this.cashAccid = cashAccid;
		this.accid = accid;
		this.status = status;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.cash = cash;
	}

	public void setCashAccid(Integer cashAccid) {
		this.cashAccid = cashAccid;
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
		return this.cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

}