package com.mi.dpay.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.dpay.beans.HbOrder;
import com.mi.dpay.common.DateUtil;
import com.mi.dpay.dao.HbOrderDao;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbOrderManager;

@Service
public class HbOrderManagerImpl implements HbOrderManager {

	@Autowired
	private HbOrderDao orderDao;

	@Override
	public void saveOrder(HbOrder order) {
		orderDao.saveOrder(order);

	}

	@Override
	public Pagination findOrderPageByUserId(Integer pageNo, Integer zhPageSize, String userid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userid);
		// int startNum = (pageNo - 1) * zhPageSize;
		param.put("startNum", pageNo);
		param.put("pageSize", zhPageSize);

		int totalCount = orderDao.getOrderTotalCount(param);

		Pagination pagination = new Pagination(pageNo, zhPageSize, totalCount);
		pageNo = pagination.getPageNo();

		List<HbOrder> list = orderDao.findOrderPageByUserId(param);

		pagination.setList(list);
		return pagination;
	}

	public String getOrderId() {

		String no = String.valueOf(orderDao.getOrderId());
		int length = no.length();
		StringBuilder builder = new StringBuilder();
		if (length <= 5) {
			builder.append(no);
			for (int i = 0; i < 5 - length; i++) {
				builder.insert(0, "0");
			}
		} else {
			builder.append(no.substring(0, 5));
		}

		String date = DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss");
		builder.insert(0, date);
		return builder.toString();
	}
}
