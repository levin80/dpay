package com.mi.dpay.service;

import java.util.Date;
import java.util.List;

import com.mi.dpay.beans.HbAccCharge;
import com.mi.dpay.beans.HbAccChargeRecord;
import com.mi.dpay.pages.Pagination;
/**
 * 用户充值记录服务层
 * @author yuanlin
 *
 */
public interface HbChargeManager {
	
	/**
	 * Description:根据用户编号查询用户交易记录
     * @param email   邮箱
	 * @author 袁林 (linyuand@isoftstone.com)
	 * @version 1.0 2015-6-6 下午17:56:59
	 * @param userId
	 * @return HbAccount
	 */
	public List<HbAccCharge> findAccChargeByUserId(String userId);
	
	/**
	 * Description:分页查询
     * @param email   邮箱
	 * @author 袁林 (linyuand@isoftstone.com)
	 * @version 1.0 2015-6-6 下午17:56:59
	 * @param userId
	 * @return HbAccount
	 */
	public Pagination findPageAccChargeByUserId(int pageNo, int pageSize,String chargeType, String userId,Date beginTime, Date endTime);
	
	public Pagination findPageAccChargeRecordByUserId(int pageNo, int pageSize,String chargeType, String userId,Date beginTime, Date endTime);

	/**
	 * 查找充值记录
	 * @param chargeId
	 * @return
	 */
	public HbAccCharge findAccChargeById(String chargeId);

	/**
	 * 根据订单号删除充值记录
	 * @param flowId
	 */
	public void deleteAccChargeByflowId(String flowId);

	/**
	 * 获取充值记录page
	 * @param pageNo
	 * @param zhPageSize
	 * @param chargeType
	 * @param userid
	 * @return
	 */
	public Pagination findPageAccChargeRecordByUserId(Integer pageNo,
			Integer zhPageSize, String chargeType, String userid);


	/**
	 * 查找充值记录
	 * @param chargeId
	 * @return
	 */
	public HbAccChargeRecord findAccChargeRecordById(String chargeId);


}
