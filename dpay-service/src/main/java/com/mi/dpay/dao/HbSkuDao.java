package com.mi.dpay.dao;

import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbSku;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserDao.java
 * @version 1.0 2015-3-5 下午1:45:14
 */
public interface HbSkuDao {

	/**
	 * 根据用户名和密码查找用户
	 * 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-5 下午1:49:48
	 * @param name
	 * @param password
	 * @return List<HbUser>
	 */

	public List<HbSku> getSkuList(Map<String, Object> param);

	/**
	 * @param skuId
	 * @return
	 */
	public HbSku findSkuById(Integer skuId);
}
