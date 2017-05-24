package com.mi.dpay.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * @filename: HbUser.java
 * @version 1.0 2015-3-3 下午5:04:24
 */
public class HbUser extends BaseBean implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private Long id;// 主键ID
	private String userId;// 用户ID
	private String username;// 用户名称
	private String password;// 用户密码
	private String fullName;// 用户全名
	private int gender;// 性别
	private String email;// 邮箱
	private int status;// 0-禁用 1-启用
	private Date registerTime;// 注册时间
	private String registerIp;// 注册IP
	private Date lastLoginTime;// 最后登录时间
	private String lastLoginIp;// 最后登录IP
	private int loginCount;// 登录次数
	private int isAdmin;// 0-不是管理员 1-是管理员
	private String roleNames;
	private String jbpmNames;
	private List<HbRole> roles;// 用户对应角色
	private String validateCodes;

    private Integer sysFlag;//系统标识
    private String returnUrl;
	private Integer currLevel;//当前层次
	private String userUpid; //父节点ID
	private String accountId; //账户ID
	private Integer per;//百分比费率
	private Integer rate;//代理商设置的佣金费率
	private Integer realRate;//真实费率
	private Integer hasChild;//	是否有子节点
	private HbAccount accounts;// 用户对应的账户
	public List<HbUser> children;
	
	

	public HbUser() {
		super();
		this.userId = getID();
	}

	public HbUser(Long id, String userId, String username, String password,
			String fullName, int gender, String email, int status,
			Date registerTime, String registerIp, Date lastLoginTime,
			String lastLoginIp, int loginCount, int isAdmin, String roleNames,
			String jbpmNames, List<HbRole> roles) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.status = status;
		this.registerTime = registerTime;
		this.registerIp = registerIp;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.loginCount = loginCount;
		this.isAdmin = isAdmin;
		this.roleNames = roleNames;
		this.jbpmNames = jbpmNames;
		this.roles = roles;
	}

	
	public String getValidateCodes() {
		return validateCodes;
	}

	public void setValidateCodes(String validateCodes) {
		this.validateCodes = validateCodes;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getJbpmNames() {
		return jbpmNames;
	}

	public void setJbpmNames(String jbpmNames) {
		this.jbpmNames = jbpmNames;
	}

	public void setRoles(SerializableList<HbRole> roles) {
		this.roles = roles;
	}

	public List<HbRole> getRoles() {
		return roles;
	}

	public void setRoles(List<HbRole> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public Integer getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(Integer sysFlag) {
        this.sysFlag = sysFlag;
    }

    @Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public Integer getCurrLevel() {
		return currLevel;
	}

	public void setCurrLevel(Integer currLevel) {
		this.currLevel = currLevel;
	}


	public String getUserUpid() {
		return userUpid;
	}

	public void setUserUpid(String userUpid) {
		this.userUpid = userUpid;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getRealRate() {
		return realRate;
	}

	public void setRealRate(Integer realRate) {
		this.realRate = realRate;
	}

	public HbAccount getAccounts() {
		return accounts;
	}

	public void setAccounts(HbAccount accounts) {
		this.accounts = accounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<HbUser> getChildren() {
		return children;
	}

	public void setChildren(List<HbUser> children) {
		this.children = children;
	}

	public Integer getHasChild() {
		return hasChild;
	}

	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}

	public Integer getPer() {
		return per;
	}

	public void setPer(Integer per) {
		this.per = per;
	}
	
}
