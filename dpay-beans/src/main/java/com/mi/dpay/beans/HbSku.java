package com.mi.dpay.beans;

import java.util.Date;

/**
 * HbSku entity. @author MyEclipse Persistence Tools
 */

public class HbSku implements java.io.Serializable {

	// Fields

	private Integer skuId;
	private String skuName;
	private String shortName;//
	private Integer skuPrice;
	private Integer status;
	private Integer showStatus;
	private Integer skuSort;
	private Date createTime;
	private Date updateTime;
	private Integer createUserId;
	private Integer updateUserId;
	private Integer type;

	// Constructors

	/** default constructor */
	public HbSku() {
	}

	/** minimal constructor */
	public HbSku(Integer skuPrice) {
		this.skuPrice = skuPrice;
	}

	public HbSku(Integer skuId, String skuName, Integer skuPrice, Integer status, Integer showStatus, Integer skuSort,
			Date createTime, Date updateTime, Integer createUserId, Integer updateUserId) {
		super();
		this.skuId = skuId;
		this.skuName = skuName;
		this.skuPrice = skuPrice;
		this.status = status;
		this.showStatus = showStatus;
		this.skuSort = skuSort;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.createUserId = createUserId;
		this.updateUserId = updateUserId;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(Integer skuPrice) {
		this.skuPrice = skuPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	public Integer getSkuSort() {
		return skuSort;
	}

	public void setSkuSort(Integer skuSort) {
		this.skuSort = skuSort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	

	
}