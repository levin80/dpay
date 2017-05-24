package com.mi.dpay.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mi.dpay.beans.HbPermission;
import com.mi.dpay.dao.HbPermissionDao;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbPermissionDaoiBatis.java
 * @version 1.0 2015-3-16 下午5:40:51 
 */
@Repository
public class HbPermissionDaoiBatis  extends BaseDaoiBatis implements HbPermissionDao {
	private static final String NAMESPACE = "com.mi.dpay.beans.HbPermission.";
	
	public List<HbPermission> listAllPermission(){
		return (List<HbPermission>)this.queryForList(NAMESPACE+"listAllPermission");
	}
	
	public List<HbPermission> findPermissionByName(String pid,String name) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("permUpid", pid);
		map.put("permName", name);
		return (List<HbPermission>)this.queryForList(NAMESPACE+"findPermissionByName", map);
	}
	
	public void savePermission(HbPermission entity) {
		this.insert(NAMESPACE+"savePermission", entity);
	}
	public HbPermission findPermissionById(String id) {
		return (HbPermission)this.queryForObject(NAMESPACE + "findPermissionById", id);
	}
	
	public HbPermission findPermissionByUUID(String id) {
		return (HbPermission)this.queryForObject(NAMESPACE + "findPermissionByUUID", id);
	}
	public List<HbPermission> listAllPermissionByExcludesPermId(String permId){
		return (List<HbPermission>)this.queryForList(NAMESPACE+"listAllPermissionByExcludesPermId",permId);
	}
	
	public void updatePermission(HbPermission entity) {
		this.update(NAMESPACE+"updatePermission", entity);
	}
	
	public void deletePermissionByIds(String[] ids) {
		if(ids != null && ids.length > 0){
			HashMap<String,Object> map = new HashMap<String, Object>();
			List<String> list = new ArrayList<String>();
			for(String id:ids){
				list.add(id);
			}
			map.put("ids", list);
			this.delete(NAMESPACE+"deletePermissionByIds", map);
		}
	}
	public List<HbPermission> listnextPermBylastPermId(String permid){
		return (List<HbPermission>)this.queryForList(NAMESPACE+"listnextPermBylastPermId",permid);
	}

	@Override
	public List<HbPermission> findPermissionsByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return this.queryForList(NAMESPACE+"findPermissionByRoleId", roleId);
	}

	@Override
	public void changeStatus(String[] ids, int status) {
		if(ids == null || ids.length == 0){
			return ;
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		for(String id:ids){
			list.add(id);
		}
		map.put("ids",list);
		map.put("status", status);
		this.update(NAMESPACE+"changePermissionStatus", map);
	}

	@Override
	public void deletePermissionByIds2(String ids) {
		this.delete(NAMESPACE+"deletePermissionByIds2", ids);
	}
	
	
	public List<HbPermission> findUserPermByuserId(String userid) {
		return (List<HbPermission>)this.queryForList(NAMESPACE+"findUserPermByuserId",userid);
	}

    @Override
    public List<HbPermission> findAccUserPermByUserId(String userId) {
        return (List<HbPermission>)this.queryForList(NAMESPACE+"findAccUserPermByUserId",userId);
    }
}
