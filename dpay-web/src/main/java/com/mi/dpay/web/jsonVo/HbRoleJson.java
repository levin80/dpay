package com.mi.dpay.web.jsonVo;

import java.util.ArrayList;
import java.util.List;

import com.mi.dpay.beans.HbRole;

/**
 * </p>
 * Copyright(c) 2015 iSoftStone
 * </p>
 * 
 * @filename: HbRole.java
 * @version 1.0 2015-3-3 下午5:07:24
 */
public class HbRoleJson {
	private Long id;
	private String roleId;// 角色ID
	private String name;// 角色name
	private String description;// 描述
	private int priority;// 排列顺序
	private String isSuper;// 拥有所有权限
	private List<String> perms;// 权限集合
	private int status;// 状态：1：启用，0：停用
	private Long areaId;
	private String areaName;
	private String areaCode;

	public HbRoleJson() {
		super();
	}

	public HbRoleJson(Long id, String roleId, String name, String description, int priority, String isSuper,
			List<String> perms, int status, Long areaId, String areaName, String areaCode) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.isSuper = isSuper;
		this.perms = perms;
		this.status = status;
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaCode = areaCode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(String isSuper) {
		this.isSuper = isSuper;
	}

	public List<String> getPerms() {
		return perms;
	}

	public void setPerms(List<String> perms) {
		this.perms = perms;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	/**
	 * 数据转json
	 * 
	 * @param info
	 * @return
	 */
	public List toArray(List info) {
		List dataList = new ArrayList();
		for (Object obj : info) {
			HbRole role = (HbRole) obj;
			Object[] newArray = new Object[5];
			newArray[1] = role.getRoleId();
			newArray[2] = role.getName();
			newArray[3] = role.getDescription();
			newArray[4] = role.getStatus() == 1 ? "有效" : "无效";
			dataList.add(newArray);
		}
		return dataList;
	}

}
