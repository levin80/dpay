package com.mi.dpay.service;

import java.util.Map;

import com.mi.dpay.beans.HbAccCash;
import com.mi.dpay.beans.HbUser;

/**
 * 现金账户
 * 
 * @author yuanlin
 *
 */
public interface HbAccountCashManager {

	/**
	 * 新增现金账户信息
	 * 
	 * @param bean
	 */
	public void saveAccountCash(HbUser bean);

	/**
	 * 修改资金账户信息:充值
	 * 
	 * @param bean
	 */
	public Map<String, Object> updateAccountCashIn(HbUser bean, String cash, String desc);

	/**
	 * 修改资金账户信息：退款
	 * 
	 * @param flowId
	 * @param cash
	 * @param desc
	 * @return
	 */
	public Map<String, Object> updateAccountCashReturn(String flowId, String cash, String desc);

	/**
	 * Description:根据用户编号查询账户信息
	 * 
	 * @param email
	 *            邮箱
	 * @author 袁林 (linyuand@isoftstone.com)
	 * @version 1.0 2015-6-6 下午17:56:59
	 * @param userId
	 * @return HbAccount
	 */
	public HbAccCash findAccountCashByUserId(String userId);

	/**
	 * 生成充值记录订单
	 * 
	 * @param userAccountBean
	 * @param cash
	 * @param desc
	 * @return
	 */
	public Map<String, Object> updateAccountCashIn2(HbUser user, HbAccCash accCash, String cash, String desc,HbUser opUser);

	/**
	 * 修改充值记录状态
	 * 
	 * @param flowid
	 */
	public void updateAccChargeStatus(String flowid, String pd_amount);

	/**
	 * 更新账户
	 * 
	 * @param accCash
	 */
	public void updateCash(HbAccCash accCash);
	
	
	/**缴费
	 * @param bean
	 * @param accCash
	 * @param cash
	 * @param desc
	 * @param opUser
	 * @return
	 */
	public Map<String, Object> updateCash(HbUser bean, HbAccCash accCash, Integer cash, String desc,HbUser opUser);

}
