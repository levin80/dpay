package com.mi.dpay.beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户交易记录信息表
 * HbAccChargeRecord entity. @author MyEclipse Persistence Tools
 */

public class HbAccChargeRecord implements java.io.Serializable {
	
	private static final long serialVersionUID = -638655400469255444L;
	// Fields
	private Integer id;   //主键id
	private String chargeNo;   //交易流水（年月日时分秒14位+5位随机码）
	private String accountId1;  //账户ID 1
	private String accountId2;  //账户ID 2
	private String accoutType;//账户类型 ：CASH-现金账本，FAVOUR-优惠账本
	private Integer balance;  //账户余额
	private Integer type;     //类型：1-充值、2-扣费，3-冲正
	private Integer fee;       //金额（分）
	private Date createTime;    //创建时间
	private String memo;   //备注
	private String chargeway;   //记录方式，1-系统，2-充值
	private String userId1;   //用户ID1
	private String userId2;   //用户ID1
	private Integer chargeStatus;//充值状态
	private BigDecimal originNo;  //原交易流水
	private String email;//用户邮箱
	private String userName;//用户名称
	private String opUser;//操作用户

	// Constructors

	/** default constructor */
	public HbAccChargeRecord() {
	}
	
	/** full constructor */
	public HbAccChargeRecord(Integer id, String chargeNo, String accountId1, String accountId2, String accoutType, Integer balance, Integer type, Integer fee, Date createTime, String memo, String chargeway, String userId1, String userId2, Integer chargeStatus, BigDecimal originNo) {
		super();
		this.id = id;
		this.chargeNo = chargeNo;
		this.accountId1 = accountId1;
		this.accountId2 = accountId2;
		this.accoutType = accoutType;
		this.balance = balance;
		this.type = type;
		this.fee = fee;
		this.createTime = createTime;
		this.memo = memo;
		this.chargeway = chargeway;
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.chargeStatus = chargeStatus;
		this.originNo = originNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChargeNo() {
		return chargeNo;
	}

	public void setChargeNo(String chargeNo) {
		this.chargeNo = chargeNo;
	}

	public String getAccountId1() {
		return accountId1;
	}

	public void setAccountId1(String accountId1) {
		this.accountId1 = accountId1;
	}

	public String getAccountId2() {
		return accountId2;
	}

	public void setAccountId2(String accountId2) {
		this.accountId2 = accountId2;
	}

	public String getAccoutType() {
		return accoutType;
	}

	public void setAccoutType(String accoutType) {
		this.accoutType = accoutType;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getChargeway() {
		return chargeway;
	}

	public void setChargeway(String chargeway) {
		this.chargeway = chargeway;
	}

	public String getUserId1() {
		return userId1;
	}

	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}

	public String getUserId2() {
		return userId2;
	}

	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}

	public Integer getChargeStatus() {
		return chargeStatus;
	}

	public void setChargeStatus(Integer chargeStatus) {
		this.chargeStatus = chargeStatus;
	}

	public BigDecimal getOriginNo() {
		return originNo;
	}

	public void setOriginNo(BigDecimal originNo) {
		this.originNo = originNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOpUser() {
		return opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}
	
	
}