package com.mi.dpay.dao;

import java.util.List;

import com.mi.dpay.beans.HbAccount;


/**
 * @author Administrator
 *
 */
public interface HbAccountDao {
	
	/**
	 * 子工程账户管理
	 * 新增主账户
	 * @param user
	 */
	public void saveHbAccount(HbAccount bean);
	
	/**
	 * 子工程账户管理
	 * 删除客户信息
	 * @param id
	 */
	public void deleteHbAccountById(String id);
	
	/**
	 * 子工程账户管理
	 * 主账户列表信息
	 * @return
	 */
	public List<HbAccount> findHbAccountList(HbAccount bean);
	
	/**
	 * 子工程账户管理
	 * 根据账户编号账户信息
	 * @param id
	 * @return
	 */
	public HbAccount findAccountById(String id);
	
	/**
	 * 子工程账户管理
	 * 根据账户编号修改账户信息
	 * @param id
	 */
	public void updateAccountById(HbAccount bean);
	
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
