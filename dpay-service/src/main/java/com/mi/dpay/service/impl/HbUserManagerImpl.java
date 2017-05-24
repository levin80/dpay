package com.mi.dpay.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mi.dpay.beans.HbUser;
import com.mi.dpay.common.exception.InfoTipException;
import com.mi.dpay.dao.HbUserDao;
import com.mi.dpay.service.HbUserManager;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserServiceImpl.java
 * @version 1.0 2015-3-5 下午1:40:58
 */
@Service
public class HbUserManagerImpl implements HbUserManager {
	@Autowired
	protected HbUserDao hbUserDao;

	@Override
	public HbUser getUserByNameAndPassword(String name, String password) {
		List<HbUser> listuser = hbUserDao.findTsUserByNameAndPassword(name, password);
		if (listuser != null && listuser.size() > 0) {
			HbUser user = listuser.get(0);
			if (user.getStatus() == 0) {
				throw new InfoTipException("用户已经被停用");
			}
			return user;
		} else {
			throw new InfoTipException("请输入正确的用户名或密码！");
		}
	}
	
	public HbUser getUser(String uuid){
		return hbUserDao.findUserByUUid(uuid);
	}

	@Override
	public void recordUserLoginInfo(HbUser user) {
		user.setLastLoginTime(new Date());
		hbUserDao.recordUserInfo(user);
	}
	

}
