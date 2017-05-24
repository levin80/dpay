package com.mi.dpay.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.dpay.beans.HbSku;
import com.mi.dpay.dao.HbSkuDao;
import com.mi.dpay.service.HbSkuManager;

/**
 * </p>
 * Copyright(c) 2015 iSoftStone
 * </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserServiceImpl.java
 * @version 1.0 2015-3-5 下午1:40:58
 */
@Service
public class HbSkuManagerImpl implements HbSkuManager {
	@Autowired
	protected HbSkuDao skuDao;

	public List<HbSku> getSkuList(Map<String, Object> param) {
		return skuDao.getSkuList(param);
	}

	public HbSku findSkuById(Integer skuId) {
		return skuDao.findSkuById(skuId);
	}

}
