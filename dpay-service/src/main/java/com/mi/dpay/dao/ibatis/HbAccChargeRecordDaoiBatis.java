package com.mi.dpay.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbAccChargeRecord;
import com.mi.dpay.dao.HbAccChargeRecordDao;
@Repository
public class HbAccChargeRecordDaoiBatis extends BaseDaoiBatis implements HbAccChargeRecordDao {

	private static final String NAMESPACE = "com.mi.dpay.beans.HbAccChargeRecord.";

	@Override
	public void saveAccChargeRecord(HbAccChargeRecord record) {
		this.insert(NAMESPACE+"saveChargeRecord", record);
	}

	@Override
	public int getAccChargeRecordTotalCount(Map<String, Object> param) {
		return (Integer)this.queryForObject(NAMESPACE+"getAccChargeRecordTotalCount", param);
	}

	@Override
	public List<HbAccChargeRecord> findPageAccChargeRecordByUserId(
			Map<String, Object> param) {
		return this.queryForList(NAMESPACE+"findPageAccChargeRecordByUserId", param);
	}

	@Override
	public HbAccChargeRecord findAccChargeRecordById(String chargeId) {
		List<HbAccChargeRecord> list = this.queryForList(NAMESPACE+"findAccChargeRecordById", chargeId);
		return list!=null?list.get(0):null;
	}

	@Override
	public void updateAccChargeRecordStatus(String flowid, String pd_amount) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flowid", flowid);
		map.put("amount", pd_amount);
		this.update(NAMESPACE+"updateAccChargeRecordStatus", map);
	}

	@Override
	public void deleteAccChargeByChargeNo(String flowId) {
		this.delete(NAMESPACE+"deleteAccChargeByChargeNo", flowId);
	}
	

	@Override
	public Integer getTotalCount(Map<String, Object> cdt) {
	    // TODO Auto-generated method stub
	    return (Integer) this.queryForObject(NAMESPACE+"getTotalCount", cdt);
	}

	@Override
	public List<HbAccChargeRecord> getTotalByPage(Map<String, Object> cdt) {
	    // TODO Auto-generated method stub
	    return this.queryForList(NAMESPACE+"getTotalByPage", cdt);
	}
}
