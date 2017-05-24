package com.mi.dpay.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbAccount;
import com.mi.dpay.dao.HbAccountDao;
@Repository
public class HbAccountDaoiBatis extends BaseDaoiBatis implements HbAccountDao {

	private static final String NAMESPACE = "com.mi.dpay.beans.HbAccount.";

	/**
	 * 保存主账户信息
	 */
	@Override
	public void saveHbAccount(HbAccount bean) {
		// TODO Auto-generated method stub
		this.insert(NAMESPACE+"insertHbAccount", bean);

	}

	/**
	 * 根据主键删除主账户信息
	 */
	@Override
	public void deleteHbAccountById(String id) {
		// TODO Auto-generated method stub
		this.delete(NAMESPACE+"deleteHbAccount", id);

	}

	/**
	 * 查询所有主账户列表信息
	 */
	@Override
	public List<HbAccount> findHbAccountList(HbAccount bean) {
		// TODO Auto-generated method stub
		return this.queryForList(NAMESPACE+"findHbAccount"+bean);
	}

	/**
	 * 根据主键查询主账户信息
	 */
	@Override
	public HbAccount findAccountById(String id) {
		// TODO Auto-generated method stub
		return (HbAccount) this.queryForObject(NAMESPACE+"findHbAccountById",id);
	}

	/**
	 * 根据主键修改主账户信息
	 */
	@Override
	public void updateAccountById(HbAccount bean) {
		// TODO Auto-generated method stub
		this.update(NAMESPACE+"updateHbAccount",bean);
	}

	@Override
	public HbAccount findAccountByUserId(String userId) {
		// TODO Auto-generated method stub
		return (HbAccount) this.queryForObject(NAMESPACE+"findAccountByUserId", userId);
	}

}
