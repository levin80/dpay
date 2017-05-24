package com.mi.dpay.dao;

import java.util.List;
import java.util.Map;

import com.mi.dpay.beans.HbUser;

/**
 * </p> Copyright(c) 2015 iSoftStone </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserDao.java
 * @version 1.0 2015-3-5 下午1:45:14
 */
public interface HbUserDao {

	/**
	 * 根据用户名和密码查找用户
	 * 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-5 下午1:49:48
	 * @param name
	 * @param password
	 * @return List<HbUser>
	 */

	public List<HbUser> findTsUserByNameAndPassword(String name, String password);

	/**
	 * Description: 获取总用户数
	 * 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 上午10:51:38
	 * @param search
	 * @return int
	 */
	public int getTotalCount(Map<String,Object> page);
	
	
	/**
	 * 当前分页数据
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 上午10:53:35 
	 * @param pageParam
	 * @return 
	 * List<User>
	 */
	public List<HbUser> getPage(Map<String, Object> pageParam);
	
	
	/**
	 * Description: 获取总用户数
	 * 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 上午10:51:38
	 * @param search
	 * @return int
	 */
	public int getTotalCountAndAccout(Map<String,Object> page);
	
	
	/**
	 * 当前分页数据
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 上午10:53:35 
	 * @param pageParam
	 * @return 
	 * List<User>
	 */
	public List<HbUser> getPageAndAccount(Map<String, Object> pageParam,HbUser hbuser);
	
	/**查询子节点
	 * @param pageParam
	 * @param hbuser
	 * @return
	 */
	public List<HbUser> getChildPage(Map<String, Object> pageParam,HbUser hbuser);


	/**
	 * Description:根据用户名查询用户
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 下午3:11:59 
	 * @param name
	 * @return 
	 * List<TsUser>
	 */
	public List<HbUser> findUserByName(String name);
	
	
	/**
	 * Description: 保存用户
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 下午3:16:00 
	 * @param entity 
	 * void
	 */
	public void saveUser(HbUser entity);

	/**
	 * Description:根据用户uuid查找用户 会级联将该用户角色查出来
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-22 下午4:59:09 
	 * @param uuid
	 * @return 
	 * TsUHbUserer
	 */
	public HbUser findUserByUUid(String uuid);
	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	public HbUser findUserById(String id);
	
	
	/**依据Email获取用户
	 * @param email
	 * @return
	 */
	public HbUser getUserByEmail(String email);
	/**
	 * 修改用户状态
	 */
	public void changeStatus(String[] ids,int status);
	/**
	 * 根据用户信息删除用户和角色表信息
	 * @param userId
	 */
	public void deleteUserRoleByuserId(String userId);
	/**
	 * 根据用户id删除用户
	 * @param ids
	 */
	public void deleteUserByIds(String[] ids);
	/**
	 * 根据用户信息集合批量删除用户和角色关联表
	 * @param ids
	 */
	public void batchedelUserRoleByuserId(String[] ids);
	/**
	 * 更新user
	 * @param user
	 */
	public void updateUser(HbUser user);
	/**
	 * 保存用户和角色关系
	 * @param userId
	 * @param roleId
	 */
	public void saveUserRole(String userId,String roleId);

	/**
	 * 获取所有用户
	 * @return
	 */
	public List<HbUser> getAllUsers();

	/**
	 * 根据角色删除用户和角色信息
	 * @param id
	 */
	public void deleteUserRoleByroleId(String id);

	/**
	 * 根据角色ids 批量删除用户角色关联关系
	 * @param string
	 */
	public void batchedelUserRoleByroleId(String ids);

	/**
	 * 记录用户最后登录信息
	 * @param user
	 */
	public void recordUserInfo(HbUser user);

    public HbUser getUserById(Integer creator);
}
