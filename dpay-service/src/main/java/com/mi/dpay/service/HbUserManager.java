package com.mi.dpay.service;

import com.mi.dpay.beans.HbUser;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserService.java
 * @version 1.0 2015-3-5 下午1:29:00 
 */
public interface HbUserManager {
	/**
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-5 下午1:29:16 
	 * @param name
	 * @param password
	 * @return 
	 * User
	 */
	
	public HbUser getUserByNameAndPassword(String name, String password);
	
	
	/**
	 * Description:获取用户信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-22 下午4:57:22 
	 * @param uuid
	 * @return 
	 * HbUser
	 */
	public HbUser getUser(String uuid);


	/**
	 * 记录用户最后登录信息
	 * @param user
	 */
	public void recordUserLoginInfo(HbUser user);
	
	

}
