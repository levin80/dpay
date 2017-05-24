package com.mi.dpay.dao;

import java.util.List;

import com.mi.dpay.beans.HbAccFavour;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 袁林(linyuand@isoftstone.com)
 * @filename: HbDistributorDao.java
 * @version 1.0 2015-5-14 上午11:58:18 
 */
public interface HbAccFavourDao {

	/**
	 * 子工程账户管理
	 * 新增主账户
	 * @param user
	 */
	public void saveHbAccountFavour(HbAccFavour bean);
	
	/**
	 * 子工程账户管理
	 * 删除客户信息
	 * @param id
	 */
	public void deleteHbAccountFavourById(String id);
	
	/**
	 * 子工程账户管理
	 * 主账户列表信息
	 * @return
	 */
	public List<HbAccFavour> findHbAccountFavourList(HbAccFavour bean);
	
	/**
	 * 子工程账户管理
	 * 根据账户编号账户信息
	 * @param id
	 * @return
	 */
	public HbAccFavour findAccountFavourById(String id);
	
	/**
	 * 子工程账户管理
	 * 根据账户编号修改账户信息
	 * @param id
	 */
	public void updateAccountFavourById(HbAccFavour bean);
	
	/**
	 * 根据主账户编号查询优惠账户信息
	 * @param accountId
	 * @return
	 */
	public HbAccFavour findAccountFavourByAccId(String accountId);

}
