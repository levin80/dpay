package com.mi.dpay.service;

import com.mi.dpay.beans.HbOrder;
import com.mi.dpay.pages.Pagination;

/**  
 * </p>Copyright(c) 2015 iSoftStone</p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbOrderDao.java
 * @version 1.0 2015-8-9 下午4:26:46 
 */
public interface HbOrderManager {
	

    /**保存订单
     * @param order
     */
    public void saveOrder(HbOrder order);

    /**
     * 获取订单列表
     * @param pageNo
     * @param zhPageSize
     * @param chargeType
     * @param userid
     * @return
     */
    public Pagination findOrderPageByUserId(Integer pageNo,Integer zhPageSize, String userid);
    
    /**
     * @return
     */
    public String getOrderId();

}
