package com.mi.dpay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.dpay.beans.HbAccount;
import com.mi.dpay.dao.HbAccountDao;
import com.mi.dpay.service.HbAccountManager;
@Service
public class HbAccountManagerImpl implements HbAccountManager {
	
	@Autowired
	private HbAccountDao accountDao;

	/**
	 * 新增主账户信息
	 * @param bean
	 */
	@Override
	public void saveAccountInfo(HbAccount bean) {
		// TODO Auto-generated method stub
		accountDao.saveHbAccount(bean);

	}

	@Override
	public HbAccount findAccountByUserId(String userId) {
		// TODO Auto-generated method stub
		return accountDao.findAccountByUserId(userId);
	}

	
}
