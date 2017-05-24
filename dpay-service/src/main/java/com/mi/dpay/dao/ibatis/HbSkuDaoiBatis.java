package com.mi.dpay.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbSku;
import com.mi.dpay.dao.HbSkuDao;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserDaoiBatis.java
 * @version 1.0 2015-3-5 下午1:54:12
 */
@Repository
public class HbSkuDaoiBatis extends BaseDaoiBatis implements HbSkuDao {
	private static final String NAMESPACE = "com.mi.dpay.beans.HbSku.";

	public List<HbSku> getSkuList(Map<String, Object> param) {
		return (List<HbSku>) this.queryForList(NAMESPACE + "getSkuList", param);
	}
	
	public HbSku findSkuById(Integer skuId){
		return (HbSku)this.queryForObject(NAMESPACE + "findSkuById", skuId);
	}
}
