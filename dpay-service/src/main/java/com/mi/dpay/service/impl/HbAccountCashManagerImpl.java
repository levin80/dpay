package com.mi.dpay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.dpay.beans.HbAccCash;
import com.mi.dpay.beans.HbAccChargeRecord;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.common.DateUtil;
import com.mi.dpay.constants.HbConstants;
import com.mi.dpay.dao.HbAccCashDao;
import com.mi.dpay.dao.HbAccChargeRecordDao;
import com.mi.dpay.dao.HbAccFavourDao;
import com.mi.dpay.service.HbAccountCashManager;

@Service
public class HbAccountCashManagerImpl implements HbAccountCashManager {

	@Autowired
	private HbAccCashDao cashDao;

	@Autowired
	private HbAccFavourDao favourDao;

	@Autowired
	private HbAccChargeRecordDao chargeRecordDao;

	@Override
	public Map<String, Object> updateAccountCashIn2(HbUser bean, HbAccCash accCash, String cash, String desc,HbUser opUser) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//修改账户金额
			String accountId = bean.getAccountId();
			HbAccCash cashBean = cashDao.findAccountCashByAccId(accountId);
			Integer oldCash = cashBean.getCash();
			// 修改账户余额
			Integer dcash = Integer.valueOf(cash).intValue()*100;
			Integer newCash = oldCash + dcash;
			cashBean.setCash(newCash);
			Date modifyDate = new Date();
			cashBean.setModifytime(modifyDate);
			cashDao.updateAccountCash(cashBean);
			
			//修改充值记录
			HbAccChargeRecord record = new HbAccChargeRecord();
			record.setAccountId1(accCash.getAccid());
			record.setChargeNo(DateUtil.getDateRadomNo());
			record.setBalance(newCash.intValue());// 余额
			record.setFee(dcash);
			record.setUserId1(bean.getUserId());
			record.setOpUser(opUser.getUserId());
			record.setEmail(bean.getEmail());
			record.setUserName(bean.getFullName());

			initRecordData(record);
			chargeRecordDao.saveAccChargeRecord(record);

			resultMap.put("flowid", record.getChargeNo());
			resultMap.put("success", true);
			resultMap.put("message", "成功");

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("message", "系统错误");
		}
		return resultMap;
	}

	/**
	 * Description:充值数据填充
	 * 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-9-1 下午2:18:56
	 * @param record
	 *            void
	 */
	private void initRecordData(HbAccChargeRecord record) {
		record.setAccoutType(HbConstants.ACC_TYPE_CASH);
		record.setCreateTime(new Date());
		record.setChargeway(HbConstants.WAY_PORTAL_CHARGE);// 门户充值
		record.setType(HbConstants.TYPE_RECHARGE);// 充值
		record.setMemo("前台用户充值");
	}

	@Override
	public void saveAccountCash(HbUser bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> updateAccountCashIn(HbUser bean, String cash, String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateAccountCashReturn(String flowId, String cash, String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HbAccCash findAccountCashByUserId(String userId) {
		// TODO Auto-generated method stub
		return cashDao.findAccountCashByUserId(userId);
	}

	@Override
	public void updateAccChargeStatus(String flowid, String pd_amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCash(HbAccCash accCash) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Map<String, Object> updateCash(HbUser bean, HbAccCash accCash, Integer cash, String desc,HbUser opUser) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//修改账户金额
			String accountId = bean.getAccountId();
			HbAccCash cashBean = cashDao.findAccountCashByAccId(accountId);
			Integer oldCash = cashBean.getCash();
			// 修改账户余额
			Integer dcash = cash.intValue()*100;
			Integer newCash = oldCash - dcash;
			cashBean.setCash(newCash);
			Date modifyDate = new Date();
			cashBean.setModifytime(modifyDate);
			cashDao.updateAccountCash(cashBean);
			
			//修改充值记录
			HbAccChargeRecord record = new HbAccChargeRecord();
			record.setAccountId1(accCash.getAccid());
			record.setChargeNo(DateUtil.getDateRadomNo());
			record.setBalance(newCash.intValue());// 余额
			record.setFee(dcash);
			record.setUserId1(bean.getUserId());
			record.setOpUser(opUser.getUserId());
			record.setEmail(bean.getEmail());
			record.setUserName(bean.getFullName());

			record.setAccoutType(HbConstants.ACC_TYPE_CASH);
			record.setCreateTime(new Date());
			record.setChargeway(HbConstants.WAY_PORTAL_PAY);// 门户充值
			record.setType(HbConstants.TYPE_PAYFEE);// 充值
			record.setMemo("手机缴费");
			chargeRecordDao.saveAccChargeRecord(record);

			resultMap.put("flowid", record.getChargeNo());
			resultMap.put("success", true);
			resultMap.put("message", "成功");

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("message", "系统错误");
		}
		return resultMap;
	}

}
