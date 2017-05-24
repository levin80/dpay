package com.mi.dpay.beans;
/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @filename: HbPermission.java
 * @version 1.0 2015-3-3 下午5:20:29 
 */
public class HbPermission extends BaseBean {
	private Long id;
	private String permId;  		//权限id
	private String permUpid;		//上级菜单id，这里只表示层级关系，并不表示权限之间的依赖关系
	private Integer permType;		//权限类型，比如菜单，按钮等 “0：menu，1：button”
	private String permName;	//权限名称
	private String permUrl; 	//权限可操作url
	private String dependentUrl;//该权限所依赖的url
	private Integer permUse;		//权限时否可用,1为启用，0为停用
	private Integer permOrder;		//排序标号
	private String permNote;	//权限说明
	private String levelStr;	//当前权限之上的层级关系
	private String recieveURL[];//接受相关URL
	
	private String jbpmRoleName;
	private String areaCode;
	
	
	public HbPermission() {
		super();
		this.permId = getID();
	}
	

	public HbPermission(Long id, String permId, String permUpid, Integer permType, String permName, String permUrl, String dependentUrl, Integer permUse, Integer permOrder, String permNote, String levelStr, String[] recieveURL, String jbpmRoleName, String areaCode) {
		super();
		this.id = id;
		this.permId = permId;
		this.permUpid = permUpid;
		this.permType = permType;
		this.permName = permName;
		this.permUrl = permUrl;
		this.dependentUrl = dependentUrl;
		this.permUse = permUse;
		this.permOrder = permOrder;
		this.permNote = permNote;
		this.levelStr = levelStr;
		this.recieveURL = recieveURL;
		this.jbpmRoleName = jbpmRoleName;
		this.areaCode = areaCode;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getPermId() {
		return permId;
	}


	public void setPermId(String permId) {
		this.permId = permId;
	}


	public String getPermUpid() {
		return permUpid;
	}


	public void setPermUpid(String permUpid) {
		this.permUpid = permUpid;
	}


	public Integer getPermType() {
		return permType;
	}
	public void setPermType(Integer permType) {
		this.permType = permType;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getPermUrl() {
		return permUrl;
	}
	public void setPermUrl(String permUrl) {
		this.permUrl = permUrl;
	}
	public String getDependentUrl() {
		return dependentUrl;
	}
	public void setDependentUrl(String dependentUrl) {
		this.dependentUrl = dependentUrl;
	}
	public Integer getPermUse() {
		return permUse;
	}
	public void setPermUse(Integer permUse) {
		this.permUse = permUse;
	}
	public Integer getPermOrder() {
		return permOrder;
	}
	public void setPermOrder(Integer permOrder) {
		this.permOrder = permOrder;
	}
	public String getPermNote() {
		return permNote;
	}
	public void setPermNote(String permNote) {
		this.permNote = permNote;
	}
	public String getLevelStr() {
		return levelStr;
	}
	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}
	public String[] getRecieveURL() {
		return recieveURL;
	}
	public void setRecieveURL(String[] recieveURL) {
		this.recieveURL = recieveURL;
	}
	public String getJbpmRoleName() {
		return jbpmRoleName;
	}
	public void setJbpmRoleName(String jbpmRoleName) {
		this.jbpmRoleName = jbpmRoleName;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	
}
