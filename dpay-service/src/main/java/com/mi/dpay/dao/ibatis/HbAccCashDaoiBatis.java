package com.mi.dpay.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbAccCash;
import com.mi.dpay.dao.HbAccCashDao;
@Repository
public class HbAccCashDaoiBatis extends BaseDaoiBatis implements HbAccCashDao {

	private static final String NAMESPACE = "com.mi.dpay.beans.HbAccCash.";

	/**
	 * 新增现金账户信息
	 */
	@Override
	public void saveHbAccountCash(HbAccCash bean) {
		// TODO Auto-generated method stub
		this.insert(NAMESPACE+"insertHbAccCash", bean);

	}

	/**
	 * 根据主键删除现金账户信息
	 */
	@Override
	public void deleteHbAccountCashById(String id) {
		// TODO Auto-generated method stub
		this.delete(NAMESPACE+"deleteHbAccCash",id);

	}

	/**
	 * 查询所有现金账户
	 */
	@Override
	public List<HbAccCash> findHbAccountCashList(HbAccCash bean) {
		// TODO Auto-generated method stub
		return this.queryForList(NAMESPACE+"findHbAccCash", bean);
	}

	/**
	 * 根据主键查询账户信息
	 */
	@Override
	public HbAccCash findAccountCashByAccId(String accountid) {
		// TODO Auto-generated method stub
		return (HbAccCash) this.queryForObject(NAMESPACE+"findHbAccCashByAccId", accountid);
	}

	/**
	 *根据主键修改账户信息
	 */
	@Override
	public void updateAccountCash(HbAccCash bean) {
		// TODO Auto-generated method stub
		this.update(NAMESPACE+"updateHbAccCash", bean);
	}

	@Override
	public HbAccCash findAccountCashByUserId(String userId) {
		// TODO Auto-generated method stub
		return (HbAccCash) this.queryForObject(NAMESPACE+"findAccountCashByUserId", userId);
	}
	
	public void reduceCash(Map map){
		  this.update(NAMESPACE+"reduceCash", map);
	}
}
