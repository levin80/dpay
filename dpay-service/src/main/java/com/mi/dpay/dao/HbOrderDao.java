package com.mi.dpay.dao;

import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbAccChargeRecord;
import com.mi.dpay.beans.HbOrder;

/**  
 * </p>Copyright(c) 2015 iSoftStone</p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbOrderDao.java
 * @version 1.0 2015-8-9 下午4:26:46 
 */
public interface HbOrderDao {
	

    /**保存订单
     * @param order
     */
    public void saveOrder(HbOrder order);

    /**
     * 获取订单数量
     * @param param
     * @return
     */
	public int getOrderTotalCount(Map<String, Object> param);

	/**
	 * 获取订单列表
	 * @param param
	 * @return
	 */
	public List<HbOrder> findOrderPageByUserId(	Map<String, Object> param);

	/**
	 * @return
	 */
	public Long getOrderId();
}
