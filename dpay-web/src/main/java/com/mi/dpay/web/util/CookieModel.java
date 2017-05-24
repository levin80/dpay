package com.mi.dpay.web.util;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.mi.dpay.beans.HbUser;



/**
 * 
 * Description: 后台登陆往redis存储的信息
 */
public class CookieModel implements Serializable{
	


	private static final long serialVersionUID = -9139517682599248527L;

	private HbUser hbUser;//登录用户
	
	private Map<String,Object> objs = new HashMap<String,Object>();
	
	private boolean isChanged;
	
	public boolean isChanged() {
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}



	public Object getObjs(String key) {
		return objs.get(key);
	}

	public void setObjs(Map<String, Object> objs) {
		this.objs = objs;
	}

	public void setKeys(String key,Object o){
		objs.put(key, o);
	}
	
	public void removeObj(String key) {
		objs.remove(key);
	}

	public HbUser getHbUser() {
		return hbUser;
	}

	public void setHbUser(HbUser hbUser) {
		this.hbUser = hbUser;
	}

	public Map<String, Object> getObjs() {
		return objs;
	}
	
}
