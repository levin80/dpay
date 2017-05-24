package com.mi.dpay.service;

import com.mi.dpay.beans.HbAccount;

public interface HbAccountManager {
	
	/**
	 * 新增账户信息
	 * @param bean
	 */
	public void saveAccountInfo(HbAccount bean);
	
	/**
	 * Description:根据用户编号查询账户信息
     * @param email   邮箱
	 * @author 袁林 (linyuand@isoftstone.com)
	 * @version 1.0 2015-6-6 下午17:56:59
	 * @param userId
	 * @return HbAccount
	 */
	public HbAccount findAccountByUserId(String userId);


}
