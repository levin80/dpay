package com.mi.dpay.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbAccFavour;
import com.mi.dpay.dao.HbAccFavourDao;
@Repository
public class HbAccFavourDaoiBatis extends BaseDaoiBatis implements HbAccFavourDao {

	private static final String NAMESPACE = "com.mi.dpay.beans.HbAccFavour.";

	@Override
	public void saveHbAccountFavour(HbAccFavour bean) {
		// TODO Auto-generated method stub
		this.insert(NAMESPACE+"insertHbAccFavour",bean);

	}

	@Override
	public void deleteHbAccountFavourById(String id) {
		// TODO Auto-generated method stub
		this.delete(NAMESPACE+"deleteHbAccFavour",id);

	}

	@Override
	public List<HbAccFavour> findHbAccountFavourList(HbAccFavour bean) {
		// TODO Auto-generated method stub
		return this.queryForList(NAMESPACE+"findHbAccFavour",bean);
	}

	@Override
	public HbAccFavour findAccountFavourById(String id) {
		// TODO Auto-generated method stub
		return (HbAccFavour) this.queryForObject(NAMESPACE+"findHbAccFavour", id);
	}

	@Override
	public void updateAccountFavourById(HbAccFavour bean) {
		// TODO Auto-generated method stub
		this.update(NAMESPACE+"updateHbAccFavour", bean);

	}

	@Override
	public HbAccFavour findAccountFavourByAccId(String accountId) {
		// TODO Auto-generated method stub
		return (HbAccFavour) this.queryForObject(NAMESPACE+"findHbAccFavourByAccId", accountId);
	}

}
