package com.mi.dpay.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbOrder;
import com.mi.dpay.dao.HbOrderDao;
@Repository
public class HbOrderDaoiBatis extends BaseDaoiBatis implements HbOrderDao {

	private static final String NAMESPACE = "com.mi.dpay.beans.HbOrder.";

	@Override
	public void saveOrder(HbOrder order) {
		this.insert(NAMESPACE+"saveOrder", order);
	}

	@Override
	public int getOrderTotalCount(Map<String, Object> param) {
		return (Integer)this.queryForObject(NAMESPACE+"getOrderTotalCount", param);
	}

	@Override
	public List<HbOrder> findOrderPageByUserId(Map<String, Object> param) {
		return this.queryForList(NAMESPACE+"findOrderPageByUserId", param);
	}
	public Long getOrderId(){
		return (Long)queryForObject(NAMESPACE+"getOrderId");
	}
}
