package com.mi.dpay.dao;

import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbAccChargeRecord;

/**  
 * </p>Copyright(c) 2015 iSoftStone</p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbAccChargeRecordDao.java
 * @version 1.0 2015-8-9 下午4:26:46 
 */
public interface HbAccChargeRecordDao {
	
    /**
     * Description:保存账户交易记录
     * @author 李晓伟 (xwlig@isoftstone.com)
     * @version 1.0 2015-8-9 下午4:27:18  
     * void
     */
    public void saveAccChargeRecord(HbAccChargeRecord record);

    /**
     * 获取total数
     * @param param
     * @return
     */
	public int getAccChargeRecordTotalCount(Map<String, Object> param);

	/**
	 * 获取充值记录列表
	 * @param param
	 * @return
	 */
	public List<HbAccChargeRecord> findPageAccChargeRecordByUserId(
			Map<String, Object> param);

	public HbAccChargeRecord findAccChargeRecordById(String chargeId);

	
	public void updateAccChargeRecordStatus(String flowid, String pd_amount);

	public void deleteAccChargeByChargeNo(String flowId);
    
    public Integer getTotalCount(Map<String,Object> cdt);
    
    public List<HbAccChargeRecord> getTotalByPage(Map<String,Object> cdt);
}
