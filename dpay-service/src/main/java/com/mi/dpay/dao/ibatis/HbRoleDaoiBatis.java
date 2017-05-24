package com.mi.dpay.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbPermission;
import com.mi.dpay.beans.HbRole;
import com.mi.dpay.dao.HbRoleDao;



/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbRoleDaoiBatis.java
 * @version 1.0 2015-3-10 下午1:44:40 
 */
@Repository
public class HbRoleDaoiBatis extends BaseDaoiBatis implements HbRoleDao {
	
	private static final String NAMESPACE = "com.mi.dpay.beans.HbRole.";

	public int getTotalCount(String search) {
		Integer total = (Integer)this.queryForObject(NAMESPACE+"getRoleTotalCount", search);
		if(total==null){
			return 0;
		}
		return total;
	}

	public List<HbRole> getPage(Map<String, Object> pageParam) {
		return (List<HbRole>) this.queryForList(NAMESPACE+"getRolePage", pageParam);
	}

	public HbRole getRoleById(Long id){
		return (HbRole)this.queryForObject(NAMESPACE + "getRoleById", id);
	}
	
	public HbRole getRoleByType(Long type){
		return (HbRole)this.queryForObject(NAMESPACE + "getRoleByType", type);
	}
	
	public void deletePermRoleBypermId(Long id){
		this.delete(NAMESPACE+"deletePermRoleBypermId", id);
	}
	
	public HbRole findRoleByuserId(String user_Id) {
		return (HbRole)this.queryForObject(NAMESPACE+"findRoleByuserId", user_Id);
	}
	
	public void deletePermRoleByroleId(Long id){
		this.delete(NAMESPACE+"deletePermRoleByroleId", id);
	}
	
	public void saveRolePerm(String permId,String roleId){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("permId", permId);
		map.put("roleId", roleId);
		this.insert(NAMESPACE+"saveRolePerm", map);
	}
	
	public List<HbRole> listRole(){
		return (List<HbRole>) this.queryForList(NAMESPACE + "listRole");
	}
	

	
	public void saveUserRole(String userId,String roleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		this.insert(NAMESPACE+"saveUserRole", map);
	}
	
	public List<HbRole> findRoleByName(String name) {
		return (List<HbRole>)this.queryForList(NAMESPACE+"findRoleByName", name);
	}
	public Long saveRole(HbRole entity) {
		return (Long)this.insert(NAMESPACE+"saveRole", entity);
	}
	public void deletePermRoleByroleId(String id){
		this.delete(NAMESPACE+"deletePermRoleByroleId", id);
	}

	public void deletePermRoleBypermId(String permid){
		this.delete(NAMESPACE+"deletePermRoleBypermId", permid);
	}

	@Override
	public HbRole findHzRoleByHzUserId(String userId) {
		return (HbRole)this.queryForObject(NAMESPACE+"findHzRoleByHzuserId", userId);
	}

	@Override
	public List<HbPermission> findPermissions(String permId) {
		return (List<HbPermission>) this.queryForList(NAMESPACE + "findPermissionBypermId",permId);
	}

	@Override
	public void batchedelPermRoleBypermId(String ids) {
		this.delete(NAMESPACE+"batchedelPermRoleBypermId", ids);
	}

	@Override
	public HbRole findRoleById(String id) {
		return (HbRole)this.queryForObject(NAMESPACE+"findRoleById", id);
	}

	@Override
	public void updateRole(HbRole entity) {
		this.update(NAMESPACE+"updateRole1", entity);
	}

	@Override
	public void changeStatus(String[] ids, int status) {
		if(ids==null || ids.length == 0){
			return;
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		for(String id:ids){
			list.add(id);
		}
		map.put("ids", list);
		map.put("status", status);
		this.update(NAMESPACE+"changeRoleStatus", map);
	}

	@Override
	public void deleteRoleByIds(String ids) {
	    if(!StringUtils.isEmpty(ids)){
	    	this.delete(NAMESPACE+"deleteRoleByIds",ids);
	    }
	}

	@Override
	public boolean testDeleteByIds(String ids) {
		Boolean res = true;
		Integer sum = -1;
		List<String> list = (List<String>) this.queryForList(NAMESPACE+"getNumByIds", ids);
		if(list != null){
			sum = list.size();
		}
		res = sum>0?false:true;
		return res;
	}

	@Override
	public void batchedelPermRoleByroleId(String ids) {
		this.delete(NAMESPACE+"batchedelPermRoleByroleId",ids);
	}

	@Override
	public void deleteRoleByIds2(String[] ids) {
		if(ids == null || ids.length == 0){
			return;
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		for(String id:ids){
			list.add(id);
		}
		map.put("ids",list);
		this.delete(NAMESPACE+"deleteRoleByIds2", map);
	}
	
	public List<HbRole> listRoleByFlag(String flag){
		return (List<HbRole>) this.queryForList(NAMESPACE + "listRoleByFlag",flag);
	}

    @Override
    public List<HbRole> getRoleListByFlagAndStatus(Map<String, Object> map) {
        return (List<HbRole>)this.queryForList(NAMESPACE+"getRoleListByFlagAndStatus",map);
    }
}
