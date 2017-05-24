package com.mi.dpay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.dpay.beans.HbAccCharge;
import com.mi.dpay.beans.HbAccChargeRecord;
import com.mi.dpay.dao.HbAccChargeRecordDao;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbChargeManager;
@Service
public class HbChargeMagagerImpl implements HbChargeManager {

	@Autowired
	private HbAccChargeRecordDao chargeRecordDao;


	@Override
	public Pagination findPageAccChargeRecordByUserId(Integer pageNo,Integer zhPageSize, String chargeType, String userid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("chargeType", chargeType);
		param.put("userId1", userid);
//		int startNum = (pageNo - 1) * zhPageSize;
		param.put("startNum", pageNo);
		param.put("pageSize",zhPageSize);
		
		int totalCount = chargeRecordDao.getAccChargeRecordTotalCount(param);

		Pagination pagination = new Pagination(pageNo,zhPageSize,totalCount);
		pageNo=pagination.getPageNo();

		List <HbAccChargeRecord>list =chargeRecordDao.findPageAccChargeRecordByUserId(param);

        pagination.setList(list);
		return pagination;
	}

	

	@Override
	public List<HbAccCharge> findAccChargeByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Pagination findPageAccChargeByUserId(int pageNo, int pageSize, String chargeType, String userId,
			Date beginTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Pagination findPageAccChargeRecordByUserId(int pageNo, int pageSize, String chargeType, String userId,
			Date beginTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HbAccCharge findAccChargeById(String chargeId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAccChargeByflowId(String flowId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public HbAccChargeRecord findAccChargeRecordById(String chargeId) {
		// TODO Auto-generated method stub
		return null;
	}


	


}
