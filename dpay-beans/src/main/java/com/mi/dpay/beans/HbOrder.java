package com.mi.dpay.beans;

import java.util.Date;

/**
 * HbOrder entity. @author MyEclipse Persistence Tools
 */

public class HbOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orderId;
	private Integer skuId;
	private String skuName;
	private String phone;
	private Integer fee;
	private Integer cost;
	private Integer profits;
	private Integer payment;
	private Integer payPlatform;
	private Integer isPaid;
	private Integer state;
	private String paymentNo;
	private Date orderTime;
	private Date payTime;
	private Date depositTime;
	private Date successTime;
	private String userId;

	// Constructors

	/** default constructor */
	public HbOrder() {
	}

	

	public HbOrder(Integer id, String orderId, Integer skuId, String skuName, String phone, Integer fee, Integer cost,
			Integer profits, Integer payment, Integer payPlatform, Integer isPaid, Integer state, String paymentNo,
			Date orderTime, Date payTime, Date depositTime, Date successTime, String userId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.skuId = skuId;
		this.skuName = skuName;
		this.phone = phone;
		this.fee = fee;
		this.cost = cost;
		this.profits = profits;
		this.payment = payment;
		this.payPlatform = payPlatform;
		this.isPaid = isPaid;
		this.state = state;
		this.paymentNo = paymentNo;
		this.orderTime = orderTime;
		this.payTime = payTime;
		this.depositTime = depositTime;
		this.successTime = successTime;
		this.userId = userId;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Integer getFee() {
		return fee;
	}



	public void setFee(Integer fee) {
		this.fee = fee;
	}



	public Integer getCost() {
		return cost;
	}



	public void setCost(Integer cost) {
		this.cost = cost;
	}



	public Integer getProfits() {
		return profits;
	}



	public void setProfits(Integer profits) {
		this.profits = profits;
	}



	public Integer getPayment() {
		return payment;
	}



	public void setPayment(Integer payment) {
		this.payment = payment;
	}



	public Integer getPayPlatform() {
		return payPlatform;
	}



	public void setPayPlatform(Integer payPlatform) {
		this.payPlatform = payPlatform;
	}



	public Integer getIsPaid() {
		return isPaid;
	}



	public void setIsPaid(Integer isPaid) {
		this.isPaid = isPaid;
	}



	public Integer getState() {
		return state;
	}



	public void setState(Integer state) {
		this.state = state;
	}



	public String getPaymentNo() {
		return paymentNo;
	}



	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}



	public Date getOrderTime() {
		return orderTime;
	}



	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}



	public Date getPayTime() {
		return payTime;
	}



	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}



	public Date getDepositTime() {
		return depositTime;
	}



	public void setDepositTime(Date depositTime) {
		this.depositTime = depositTime;
	}



	public Date getSuccessTime() {
		return successTime;
	}



	public void setSuccessTime(Date successTime) {
		this.successTime = successTime;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}




	
}