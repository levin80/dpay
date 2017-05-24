package com.mi.dpay.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbUser;
import com.mi.dpay.dao.HbUserDao;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserDaoiBatis.java
 * @version 1.0 2015-3-5 下午1:54:12
 */
@Repository
public class HbUserDaoiBatis extends BaseDaoiBatis implements HbUserDao {
	private static final String NAMESPACE = "com.mi.dpay.beans.HbUser.";

	public List<HbUser> findTsUserByNameAndPassword(String name, String password) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("password", password);
		return (List<HbUser>) this.queryForList(NAMESPACE + "findTsUserByNameAndPassword", map);
	}

	public int getTotalCount(Map<String,Object> page) {
		Integer total = (Integer) this.queryForObject(NAMESPACE + "getHbUserTotalCount", page);
		if (total == null) {
			return 0;
		}
		return total;
	}

	public List<HbUser> getPage(Map<String, Object> pageParam) {
		return (List<HbUser>) this.queryForList(NAMESPACE + "getHbUserPage", pageParam);
	}
	

	public int getTotalCountAndAccout(Map<String,Object> page){
		Integer total = (Integer) this.queryForObject(NAMESPACE + "getHbUserAgentTotalCount", page);
		if (total == null) {
			return 0;
		}
		return total;
	}

	public List<HbUser> getPageAndAccount(Map<String, Object> pageParam,HbUser hbuser) { 
		pageParam.put("userId", hbuser.getUserId());
		return (List<HbUser>) this.queryForList(NAMESPACE + "getHbUserAgentPage", pageParam);
	}
	
	public List<HbUser> getChildPage(Map<String, Object> pageParam,HbUser hbuser){
		pageParam.put("userUpid", hbuser.getUserId());
		return (List<HbUser>) this.queryForList(NAMESPACE + "getChildPage", pageParam);
	}
	
	
	
	
	public List<HbUser> findUserByName(String name) {
		return (List<HbUser>)this.queryForList(NAMESPACE+"findTsUserByName", name);
	}
	
	public void saveUser(HbUser entity) {
		this.insert(NAMESPACE+"saveHbUser", entity);
	}
	
	public HbUser findUserByUUid(String uuid){
			return (HbUser)this.queryForObject(NAMESPACE + "findHbUserByUUID", uuid);
	}

	@Override
	public HbUser findUserById(String id) {
		return (HbUser)this.queryForObject(NAMESPACE+"findUserById",id);
	}
	
	@Override
	public HbUser getUserByEmail(String id) {
		return (HbUser)this.queryForObject(NAMESPACE+"findUserByEmail",id);
	}
	
	@Override
	public void changeStatus(String[] ids, int status) {
		if(ids==null || ids.length==0){
			return ;
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<String> list= new ArrayList<String>();
		for(String id:ids){
			list.add(id);
		}
		map.put("ids", list);
		map.put("status", status);
		this.update(NAMESPACE+"changeTsUserStatus",map);
	}

	@Override
	public void deleteUserRoleByuserId(String userId) {
		this.delete(NAMESPACE+"deleteUserRoleByuserId",userId);
	}

	@Override
	public void deleteUserByIds(String[] ids) {
		if(ids==null || ids.length==0){
			return;
			//this.delete(NAMESPACE+"deleteUserByIds",ids);
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		for(String id:ids){
			list.add(id);
		}
		map.put("ids", list);
		this.delete(NAMESPACE+"deleteUserByIds",map);
	}

	@Override
	public void batchedelUserRoleByuserId(String[] ids) {
		if(ids==null || ids.length==0){
			return;
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			list.add(id);
		}
		map.put("ids", list);
		this.delete(NAMESPACE+"batchedelUserRoleByuserId",map);
	}

	@Override
	public void updateUser(HbUser user) {
		this.update(NAMESPACE+"updateUser", user);
	}

	@Override
	public void saveUserRole(String userId, String roleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		this.insert(NAMESPACE+"saveUserRole", map);
	}

	@Override
	public List<HbUser> getAllUsers() {
		return this.queryForList(NAMESPACE+"getAllUsers");
	}

	@Override
	public void deleteUserRoleByroleId(String roleId) {
		this.delete(NAMESPACE+"deleteUserRoleByroleId",roleId);
	}

	@Override
	public void batchedelUserRoleByroleId(String ids) {
		this.delete(NAMESPACE+"batchedelUserRoleByroleId",ids);
	}

	@Override
	public void recordUserInfo(HbUser user) {
		this.update(NAMESPACE+"recordUserInfo", user);
	}

    @Override
    public HbUser getUserById(Integer id) {
        return (HbUser)this.queryForObject(NAMESPACE+"getUserById",id);
    }
}
