package com.mi.dpay.dao.ibatis;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Description:dao基类
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-3-5 下午1:58:03 
 */

public abstract class BaseDaoiBatis extends SqlMapClientTemplate {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Resource(name = "sqlMapClient")
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
	
}
