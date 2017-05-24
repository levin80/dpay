package com.mi.dpay.web.jsonVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.beans.SerializableList;
import com.mi.dpay.common.DateUtil;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * @filename: HbUser.java
 * @version 1.0 2015-3-3 下午5:04:24
 */
public class HbUserJson {
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
	


	public HbUserJson() {
		super();
	}


	public HbUserJson(Long id, String userId, String username, String password,
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
	
	/**数据转json
	 * @param info
	 * @return
	 */
	public List toArray(List info) {
		List dataList = new ArrayList();
		for (Object obj : info) {
			HbUser user = (HbUser) obj;
			Object[] newArray = new Object[8];
			newArray[1] = user.getUserId();
			newArray[2] = user.getUsername();
			List roles = user.getRoles();
			for (Object o : roles) {
				StringBuffer sb = new StringBuffer();
				HbRole role = (HbRole) o;
				sb.append(role.getName());
				newArray[3] = sb.toString();

			}
			newArray[4] = user.getStatus() == 1 ? "有效" : "无效";
			newArray[5] = DateUtil.formatDate(user.getRegisterTime(), DateUtil.bDATE);
			newArray[6] = DateUtil.formatDate(user.getLastLoginTime(), DateUtil.bDATE);
			newArray[7] = user.getEmail();
			dataList.add(newArray);
		}
		return dataList;
	}
	
	public List toAgentArray(List info,Map map) {
		List dataList = new ArrayList();
        for(Object obj : info){
        	HbUser user = (HbUser)obj;
        	
        	List <HbUser>subUserList =  (List)map.get(user.getUserId());
        	if(subUserList != null){
        		for(HbUser agent : subUserList){
            		Object [] newArray = new Object[11];
            		newArray[1] = agent.getUserId();
                	newArray[2] = DateUtil.formatDate(user.getRegisterTime(), DateUtil.bDATE);
                	newArray[3] = user.getFullName();
                	newArray[4] = agent.getId();
                	newArray[5] = agent.getFullName();
                	newArray[6] = new Float(agent.getAccounts().getCash().getCash()).floatValue()/100;
                	newArray[7] = new Float(agent.getAccounts().getFavour().getCash()).floatValue()/100;
                	newArray[8] = agent.getUserId();
                	newArray[9] = agent.getStatus()==1?"有效":"无效";
                	dataList.add(newArray);
            	}
        	}
        }
        return dataList;
}

}
