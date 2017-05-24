package com.mi.dpay.beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * HbAccCharge entity. @author MyEclipse Persistence Tools
 */

public class HbAccCharge implements java.io.Serializable {

	// Fields

	private Integer id;
	private String accountid;
	private Integer cash;
	private Integer chargeCash;
	private Date chargeTime;
	private String describ;
	private String accountsonid;
	private String chargetype;
	private String createperson;
	private Integer chargestatus;
	private String flowid;
	private String flowidold;

	// Constructors

	/** default constructor */
	public HbAccCharge() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public HbAccCharge(Integer id, String accountid, Integer cash, Integer chargeCash, Date chargeTime, String describ,
			String accountsonid, String chargetype, String createperson, Integer chargestatus, String flowid,
			String flowidold) {
		super();
		this.id = id;
		this.accountid = accountid;
		this.cash = cash;
		this.chargeCash = chargeCash;
		this.chargeTime = chargeTime;
		this.describ = describ;
		this.accountsonid = accountsonid;
		this.chargetype = chargetype;
		this.createperson = createperson;
		this.chargestatus = chargestatus;
		this.flowid = flowid;
		this.flowidold = flowidold;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Integer getCash() {
		return this.cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public Integer getChargeCash() {
		return this.chargeCash;
	}

	public Date getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public String getAccountsonid() {
		return accountsonid;
	}

	public void setAccountsonid(String accountsonid) {
		this.accountsonid = accountsonid;
	}

	public String getChargetype() {
		return chargetype;
	}

	public void setChargetype(String chargetype) {
		this.chargetype = chargetype;
	}

	public String getCreateperson() {
		return createperson;
	}

	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}

	public Integer getChargestatus() {
		return chargestatus;
	}

	public void setChargestatus(Integer chargestatus) {
		this.chargestatus = chargestatus;
	}

	public String getFlowid() {
		return flowid;
	}

	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}

	public String getFlowidold() {
		return flowidold;
	}

	public void setFlowidold(String flowidold) {
		this.flowidold = flowidold;
	}

	public void setChargeCash(Integer chargeCash) {
		this.chargeCash = chargeCash;
	}

	

}