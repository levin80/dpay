package com.mi.dpay.dao;

import java.util.List;

import com.mi.dpay.beans.HbPermission;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbPermissionDao.java
 * @version 1.0 2015-3-16 下午5:40:26 
 */
public interface HbPermissionDao {

	/**
	 * Description:显示所有权限列表
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-16 下午5:42:44 
	 * @return 
	 * List<HbPermission>
	 */
	public List<HbPermission> listAllPermission();
	
	/**
	 * Description: 根据权限名称,以及上级权限id，查找权限，这个主要用来判断同级是否有相同的权限名
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-17 上午9:54:09 
	 * @param pid
	 * @param name
	 * @return 
	 * List<HbPermission>
	 */
	public List<HbPermission> findPermissionByName(String pid,String name);
	
	/**
	 * Description:保存权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-17 上午9:56:14 
	 * @param entity 
	 * void
	 */
	public void savePermission(HbPermission entity);
	
	/**
	 * Description: 根据权限id查找权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-18 上午12:19:08 
	 * @param id
	 * @return 
	 * HbPermission
	 */
	public HbPermission findPermissionById(String id);
	
	
	/**
	 * Description: 根据权限父UUID查找权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-18 上午12:19:08 
	 * @param PermUpid
	 * @return 
	 * HbPermission
	 */
	public HbPermission findPermissionByUUID(String permUpid);
	
	
	/**
	 * Description:显示所有权限列表,但是排除permid指定的权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-18 上午12:24:55 
	 * @param permId
	 * @return 
	 * List<HbPermission>
	 */
	public List<HbPermission> listAllPermissionByExcludesPermId(String permId);
	
	/**
	 * Description:修改权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 上午10:11:18 
	 * @param entity 
	 * void
	 */
	public void updatePermission(HbPermission entity);
	
	/**
	 * Description:根据上一个权限的id获取下层权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 下午5:55:45 
	 * @param permid
	 * @return 
	 * List<EbPermission>
	 */
	public List<HbPermission> listnextPermBylastPermId(String permid);
	
	
	/**
	 * Description:根据id删除权限
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-19 下午5:56:51 
	 * @param ids 
	 * void
	 */
	public void deletePermissionByIds(String[] ids);
	
	/**
	 * 根据角色编号查询队形的权限信息
	 * @param roleId
	 * @return
	 */
	public List<HbPermission> findPermissionsByRoleId(String roleId);

	/**
	 * 修改权限状态
	 * @param ids
	 * @param status
	 */
    public void changeStatus(String[] ids,int status);
    /**
     * 根据ids字符串删除权限
     * @param ids
     */
    public void deletePermissionByIds2(String ids);
    
    /**
     * Description:
     * @author 李晓伟 (xwlig@isoftstone.com)
     * @version 1.0 2015-7-30 下午5:39:47 
     * @param userid
     * @return 
     * List<HbPermission>
     */
    public List<HbPermission> findUserPermByuserId(String userid);

    public List<HbPermission> findAccUserPermByUserId(String userId);
}
