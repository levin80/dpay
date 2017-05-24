package com.mi.dpay.dao;

import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbPermission;
import com.mi.dpay.beans.HbRole;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbRoleDao.java
 * @version 1.0 2015-3-10 下午1:41:30 
 */
public interface HbRoleDao {

	/**
	 *  Description:获取角色总数
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:41 
	 * @param search
	 * @return 
	 * int
	 */
	
	public int getTotalCount(String search);
	

	/**
	 * Description:角色管理分页
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:30 
	 * @param pageParam
	 * @return 
	 * List<HbRole>
	 */
	
	public List<HbRole> getPage(Map<String, Object> pageParam);

	/**
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:27 
	 * @param id
	 * @return 
	 * HbRole
	 */
	
	public HbRole getRoleById(Long id);
	

	/**
	 * Description:前台portal按照类型选取
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-8-6 下午6:14:25 
	 * @param type
	 * @return 
	 * HbRole
	 */
	public HbRole getRoleByType(Long type);
	
	/**
	 * Description:根据权限删除角色关联表
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 下午6:08:36 
	 * @param permid 
	 * void
	 */
	public void deletePermRoleBypermId(String permid);
	

	/**
	 * Description:根据用户查询角色信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:53 
	 * @param user_Id
	 * @return 
	 * HbRole
	 */
	
	public HbRole findRoleByuserId(String user_Id);
	

	/**
	 * Description:根据角色删除角色关联表
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:55 
	 * @param roleId 
	 * void
	 */
	
	public void deletePermRoleByroleId(String roleId);
	

	/**
	 * Description: 保存角色对应的权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:59 
	 * @param permId
	 * @param roleId 
	 * void
	 */
	
	public void saveRolePerm(String permId, String roleId);
	
	/**
	 * Description:获取所有启用角色
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 下午2:59:27 
	 * @return 
	 * List<EbRole>
	 */
	public List<HbRole> listRole();
	
	/**
	 * Description: 保存用户和角色关系
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午3:26:58 
	 * @param userId
	 * @param roleId 
	 * void
	 */
	public void saveUserRole(String userId,String roleId);
	
	
	
	/**
	 * Description:根据角色名称查询角色，用来判断是否重名
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午5:21:35 
	 * @param name
	 * @return 
	 * List<EbRole>
	 */
	public List<HbRole> findRoleByName(String name);
	
	/**
	 * Description:保存角色
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午5:22:26 
	 * @param entity
	 * @return 
	 * Long
	 */
	public Long saveRole(HbRole entity);
	
	/**
	 * Description:根据用户查询角色信息--【会展云前台】
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:53 
	 * @param user_Id
	 * @return 
	 * HbRole
	 */
	
	public HbRole findHzRoleByHzUserId(String userId);
	
	
	/**
	 * Description:根据用户权限ID查询菜单列表---【会展云前台】
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:53 
	 * @param user_Id
	 * @return 
	 * HbRole
	 */
	
	public List<HbPermission> findPermissions(String permId);
	/**
	 * 根据权限ID批量删除角色关联表
	 * @param ids
	 */
	public void batchedelPermRoleBypermId(String ids);

	/**
	 * 根据id获取角色
	 * @param id
	 * @return
	 */
	public HbRole findRoleById(String id);
	
    /**
     * 更新角色
     * @param entity
     */
	public void updateRole(HbRole entity);

    /**
     * 更新角色状态
     * @param ids
     * @param status
     */
	public void changeStatus(String[] ids, int status);


	/**
	 * 根据ids批量删除角色
	 * @param ids
	 */
	public void deleteRoleByIds(String ids);


	/**
	 * 
	 * @param string
	 * @return
	 */
	public boolean testDeleteByIds(String string);


	/**
	 * 根据角色id批量删除权限角色关联关系
	 * @param ids
	 */
	public void batchedelPermRoleByroleId(String ids);


	public void deleteRoleByIds2(String[] ids);
	
	
	/**
	 * Description:按照前后台查询角色信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-31 上午11:21:36 
	 * @param flag
	 * @return 
	 * List<HbRole>
	 */
	public List<HbRole> listRoleByFlag(String flag);

    public List<HbRole> getRoleListByFlagAndStatus(Map<String,Object> map);
}
