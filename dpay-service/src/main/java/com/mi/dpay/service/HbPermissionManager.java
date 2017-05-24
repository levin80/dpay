package com.mi.dpay.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.springframework.ui.ModelMap;

import com.mi.dpay.beans.HbPermission;
import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.pages.Pagination;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbPermissionManager.java
 * @version 1.0 2015-3-13 上午10:42:00 
 */
public interface HbPermissionManager {

	/**
	 * Description: 获取用户分页
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 上午10:42:45 
	 * @param pageNo
	 * @param pageSize
	 * @param orderByStatus
	 * @param orderBy
	 * @param search
	 * @return 
	 * Pagination
	 */
	
	public Pagination getUserPage(int pageNo, int pageSize, int orderByStatus,String orderBy,String searchValue, ModelMap model);
	
	
	/**获取用户列表
	 * @param pageNo
	 * @param pageSize
	 * @param orderByStatus
	 * @param orderByVal
	 * @param searchValue
	 * @param model
	 * @return
	 */
	public List getUserList(int pageNo, int pageSize, int orderByStatus, String orderByVal, String searchValue,	ModelMap model,HbUser user,Map map) ;
	
	/**
	 * Description:获取启用的角色 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 下午2:57:36 
	 * @return 
	 * List<HbRole>
	 */
	public List<HbRole> listRole();
	
	/**
	 * Description:保存用户
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 下午3:09:49 
	 * @param entity
	 * @param roleIds 
	 * void
	 */
	public void saveUser(HbUser entity, String roleIds[]);

	/**
	 * Description: 获取角色分页
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午4:31:30 
	 * @param pageNo
	 * @param pageSize
	 * @param orderByStatus
	 * @param orderBy
	 * @param search
	 * @return 
	 * Pagination
	 */
	public Pagination getRolePage(int pageNo, int pageSize, int orderByStatus,String orderBy,String searchValue);
	

	/**
	 * Description:保存角色
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午5:19:02 
	 * @param rolename
	 * @param status
	 * @param description
	 * @param offerGroupAreaId
	 * @param orderAreaId
	 * @param orderType
	 * @param businessScope 
	 * void
	 */
	public void saveRole(String rolename, int status, String description,String flag,Long [] offerGroupAreaId,Long [] orderAreaId,Integer[] orderType,Integer[] businessScope);

	
	/**
	 * Description: 显示所有权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午5:39:08 
	 * @return 
	 * List<HbPermission>
	 */
	public List<HbPermission> listPermission();
	

	/**
	 * Description:保存权限信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-17 上午9:52:17 
	 * @param entity 
	 * void
	 */
	public void savePermission(HbPermission entity);
	
	/**
	 * Description:根据id获取权限信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-18 上午12:17:34 
	 * @param id
	 * @return 
	 * HbPermission
	 */
	public HbPermission getPermission(String id);
	
	/**
	 * Description:显示所有的权限排除excludesPermId指定的权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-18 上午12:22:05 
	 * @param excludesPermId
	 * @return 
	 * List<HbPermission>
	 */
	public List<HbPermission> listPermissionByExcludesPermId(String excludesPermId);
	
	/**
	 * Description:修改权限信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 上午10:08:34 
	 * @param entity 
	 * void
	 */
	public void updatePermission(HbPermission entity);
	
	
	/**
	 * Description: 根据角色id获取角色（只有id，角色名），这里会级联将角色对应的权限也一并列出来
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 上午10:54:34 
	 * @param id
	 * @return 
	 * HbRole
	 */
	public HbRole getRoleHigh(Long id);
	

	/**
	 * Description:前台portal按照类型选取
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-8-6 下午6:12:54 
	 * @param Type
	 * @return 
	 * HbRole
	 */
	public HbRole getRoleByType(Long Type);
	
	/**
	 * Description:分配权限到角色
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 下午12:45:42 
	 * @param roleId
	 * @param permIds 
	 * void
	 */
	public void assignPermToRole(String roleId, String permIds[]);
	

	/**
	 * Description:删除权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 下午5:54:53 
	 * @param permid 
	 * void
	 */
	public void deletePermById(String permid);
	
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
	 * Description:根据用户权限ID查询菜单对象---【会展云前台】
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-10 下午1:42:53 
	 * @param user_Id
	 * @return 
	 * HbRole
	 */
	
	public HbPermission findPermissionByPermId(String permId);
	
	/**
	 * 根据角色编号查询队形的权限信息
	 * @param roleId
	 * @return
	 */
	public List<HbPermission> findPermissionsByRoleId(String roleId);
	/**
	 * 根据用户Id查找用户
	 * @param id
	 * @return
	 */
	public HbUser getUser(String id);
	
	/**
	 * 根据邮箱查找用户
	 * @param id
	 * @return
	 */
	public HbUser getUserByEmail(String email);
	/**
	 * 修改用户状态
	 * @param id
	 * @param status
	 */
	public void updateUserStatus(String id,int status);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteUserById(String id);
	/**
	 * 批量修改用户状态
	 * @param ids
	 * @param status
	 */
	public void batchUpdateUserStatus(String[] ids,int status);
	/**
	 * 批量删除用户
	 * @param ids
	 */
	public void batchDelUserById(String[] ids);
	/**
	 * 更新用户
	 * @param user
	 * @param roleIds
	 */
	public void updateUser(HbUser user,String[] roleIds);
	
	/**更新用户信息
	 * @param user
	 */
	public void updateUserInfo(HbUser user);
	/**
	 * 根据用户名判断用户是否存在
	 * @param username
	 * @return
	 */
	public boolean isExistUserName(String username);
	/**
	 * 修改权限状态
	 * @param id
	 * @param status
	 */
	public void updatePermStatus(String id,int status);
	/**
	 * 批量修改权限状态
	 * @param ids
	 * @param status
	 */
	public void batchUpdatePermStatus(String[] ids,int status);
	/**
	 * 批量删权限
	 * @param ids
	 */
	public void batchDelPermById(String[] ids);
	/**
	 * 根据id获取角色信息
	 * @param id
	 * @return
	 */
	public HbRole getRole(String id);
	/**
	 * 更新角色
	 * @param role
	 */
	public void updateHbRole(String id,String name,int status,String description,String flag);

	/**
	 * 更新角色状态
	 * @param id
	 * @param status
	 */
	public void updateRoleStatus(String id, int status);

	/**
	 * 获取所有用户
	 * @return
	 */
	public List<HbUser> getAllUser();
    
	/**
	 * 根据id删除角色
	 * @param id
	 */
	public void deleteRoleById(String id);

	/**
	 * 批量修改角色状态
	 * @param ids
	 * @param status
	 */
	public void batchUpdateRoleStatus(String[] ids, int status);

	/**
	 * 批量删除角色
	 * @param ids
	 */
	public void batchDelRoleById(String[] ids);
	
	
	
	/**
	 * Description:根据用户id获取用户权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-30 下午5:33:37 
	 * @param userid
	 * @return 
	 * Set<String>
	 */
	public Set<String> findUserPermByuserId(String userid);

    /**
     * Description:根据前台用户id获取用户权限
     */
    public Set<String> findAccUserPermByUserId(String userId);
	
	/**
	 * Description:按照前后台查询角色信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-31 上午11:29:36 
	 * @param flag
	 * @return 
	 * List<HbRole>
	 */
	public List<HbRole> listRoleByFlag(String flag);

    public List<HbRole> getRoleListByFlagAndStatus(String flag, int status);
    
    
    /**
     * Description:加载权限静态化数据
     * @author 李晓伟 (xwlig@isoftstone.com)
     * @version 1.0 2015-12-29 上午12:53:27 
     * @return 
     * Vector<HbPermission>
     */
    public Vector <HbPermission> findPermissonVector();
    
    
    /**
     * Description:权限静态化数据-map
     * @author 李晓伟 (xwlig@isoftstone.com)
     * @version 1.0 2015-12-29 下午12:32:56 
     * @return 
     * HashMap<String,HbPermission>
     */
    public HashMap <String,HbPermission> findPermissonMap();
    
    /**
     * Description:批量刷新缓存
     * @author 李晓伟 (xwlig@isoftstone.com)
     * @version 1.0 2016-1-14 下午2:04:05  
     * void
     */
    public void batchRefresh();
    
}
