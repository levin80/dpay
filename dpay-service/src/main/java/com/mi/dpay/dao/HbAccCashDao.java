package com.mi.dpay.dao;

import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbAccCash;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 袁林(linyuand@isoftstone.com)
 * @filename: HbDistributorDao.java
 * @version 1.0 2015-5-14 上午11:58:18 
 */
public interface HbAccCashDao {
	/**
	 * 子工程账户管理
	 * 现在子账户新增
	 * @param user
	 */
	public void saveHbAccountCash(HbAccCash bean);
	
	/**
	 * 子工程账户管理
	 * 删除现金子账户信息
	 * @param id
	 */
	public void deleteHbAccountCashById(String id);
	
	/**
	 * 子工程账户管理
	 * 查询所有现金账户
	 * @return
	 */
	public List<HbAccCash> findHbAccountCashList(HbAccCash bean);
	
	/**
	 * 子工程账户管理
	 * 根据主键查询账户现金信息
	 * @param id
	 * @return
	 */
	public HbAccCash findAccountCashByAccId(String accid);
	
	/**
	 * 子工程账户管理
	 * 根据主键修改主账户信息
	 * @param id
	 */
	public void updateAccountCash(HbAccCash bean);
	
	/**
	 * Description:根据用户编号查询账户信息
     * @param email   邮箱
	 * @author 袁林 (linyuand@isoftstone.com)
	 * @version 1.0 2015-6-6 下午17:56:59
	 * @param userId
	 * @return HbAccount
	 */
	public HbAccCash findAccountCashByUserId(String userId);
	
	
    
	/**
	 * Description:现金账户扣费
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-8-9 下午12:53:26 
	 * @param map
	 * @return 
	 * int
	 */
	public void reduceCash(Map map);
	
	
}
