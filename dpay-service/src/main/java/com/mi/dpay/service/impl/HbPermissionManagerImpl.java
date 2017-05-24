package com.mi.dpay.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.mi.dpay.beans.HbAccCash;
import com.mi.dpay.beans.HbAccFavour;
import com.mi.dpay.beans.HbAccount;
import com.mi.dpay.beans.HbPermission;
import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.common.Constants;
import com.mi.dpay.common.Md5Util;
import com.mi.dpay.common.StringUtil;
import com.mi.dpay.common.exception.InfoTipException;
import com.mi.dpay.dao.HbAccCashDao;
import com.mi.dpay.dao.HbAccFavourDao;
import com.mi.dpay.dao.HbAccountDao;
import com.mi.dpay.dao.HbPermissionDao;
import com.mi.dpay.dao.HbRoleDao;
import com.mi.dpay.dao.HbUserDao;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbPermissionManager;

/**
 * </p>
 * Copyright(c) 2015 iSoftStone
 * </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbPermissionManagerImpl.java
 * @version 1.0 2015-3-13 上午10:46:47
 */
@Service
public class HbPermissionManagerImpl implements HbPermissionManager {
	private static Log log = LogFactory.getLog(HbPermissionManagerImpl.class);

	private static Vector<HbPermission> permissionVector = null;

	private static HashMap<String, HbPermission> permissionMap = null;

	@Autowired
	public HbUserDao userDao;
	@Autowired
	public HbRoleDao roleDao;
	@Autowired
	public HbAccountDao accountDao;
	@Autowired
	private HbAccCashDao cashDao;
	@Autowired
	private HbAccFavourDao favourDao;

	@Autowired
	public HbPermissionDao permDao;

	public Pagination getUserPage(int pageNo, int pageSize, int orderByStatus, String orderByVal, String searchValue,
			ModelMap model) {
		Pagination pagination;
		if (pageSize == 0) {
			pageSize = 10;
		}
		Map<String, Object> page = new HashMap<String, Object>();
		String searchName = null;
		String searchEmail = null;
		String searchRole = null;
		String searchStatus = null;
		Integer nextOrderByStatus = (orderByStatus + 1) % 2;// 通过除2取余来改变orderByStatus的值（要么是0要么是1）
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);

		if (searchValue != null) {
			page.put("searchStatus", searchValue);
			page.put("searchRole", searchValue);
			page.put("searchEmail", searchValue);
			page.put("searchName", searchValue);
		}

		page.put("orderByVal", orderByVal);
		page.put("startNum", pageNo);
		page.put("pageSize", pageSize);
		int totalCount = userDao.getTotalCount(page);
		pagination = new Pagination(pageNo, pageSize, totalCount);
		List<HbUser> list = userDao.getPage(page);

		pagination.setList(list);
		model.addAttribute("pageNo", pageNo);
		return pagination;
	}
	
	

	public List getUserList(int pageNo, int pageSize, int orderByStatus, String orderByVal, String searchValue,	ModelMap model,HbUser hbuser,Map childMap) {
		
		if (pageSize == 0) {
			pageSize = 10;
		}
		Map<String, Object> page = new HashMap<String, Object>();
		String searchName = null;
		String searchEmail = null;
		String searchRole = null;
		String searchStatus = null;
		Integer nextOrderByStatus = (orderByStatus + 1) % 2;// 通过除2取余来改变orderByStatus的值（要么是0要么是1）
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);

		if (searchValue != null) {
			page.put("searchStatus", searchValue);
			page.put("searchRole", searchValue);
			page.put("searchEmail", searchValue);
			page.put("searchName", searchValue);
		}

		page.put("orderByVal", orderByVal);
		page.put("startNum", pageNo);
		page.put("pageSize", pageSize);
		page.put("userId", hbuser.getUserId());
		
		List<HbUser> list = userDao.getChildPage(page,hbuser);
		
		int totalCount = 0;//用户数量
		
		for(HbUser user :list){
			List <HbUser>childList = new ArrayList<HbUser>();
			if (user.getHasChild().intValue() != 0) {
				reverseList(user,page,childList);//递归查询子用户
			}
			childList.add(user);
			totalCount += childList.size();
			childMap.put(user.getUserId(),childList);
			
		}

		model.addAttribute("pageNo", pageNo);
		model.addAttribute("totalCount", totalCount);
		return list;
	}

	private void reverseList(HbUser user,Map<String, Object> page,List <HbUser>childList) {
		List<HbUser> list = userDao.getChildPage(page,user);
		childList.addAll(list);
		user.setChildren(list);
		for(HbUser childObj :list){
			if (childObj.getHasChild().intValue() != 0) {//递归出口
				reverseList(childObj,page,childList);//递归查询子用户
			}
		}
	}

	public List<HbRole> listRole() {
		return roleDao.listRole();
	}

	public void saveUser(HbUser entity, String roleIds[]) {
		//1.校验用户是否存在
		if (isExistUserName(entity.getUsername())) {
			throw new InfoTipException("用户名称已经存在");
		}
		
		// entity.setStatus(1);
		//2.1保存账户信息
		HbAccount accountBean = new HbAccount();
		String accid=UUID.randomUUID().toString().replace("-", "");
		accountBean.setAccid(accid);
		accountBean.setStatus(Constants.USER_STATUS_ACTIVE);
		String defaultPwd=Md5Util.MD5String("123456");
		accountBean.setTranPasswd(defaultPwd);
		accountBean.setPasswd(defaultPwd);
		accountBean.setCreatetime(new Date());
		accountDao.saveHbAccount(accountBean);
		
		
		//2.2插入现金账户信息
		HbAccCash cashBean = new HbAccCash();
		cashBean.setAccid(accid);
		cashBean.setStatus(Constants.USER_STATUS_ACTIVE);
		cashBean.setCash(0);
		cashBean.setCreatetime(new Date());
		cashDao.saveHbAccountCash(cashBean);
		//2.3插入优惠券账户信息
		HbAccFavour favourBean = new HbAccFavour();
		favourBean.setAccid(accid);
		favourBean.setStatus(Constants.USER_STATUS_ACTIVE);
		favourBean.setCash(0);
		favourDao.saveHbAccountFavour(favourBean);
		
		//3.插入账户信息
		entity.setIsAdmin(0);
		entity.setLastLoginIp("");
		entity.setLoginCount(0);
		entity.setRegisterIp("");
		entity.setRegisterTime(new Date());
		entity.setPassword(new Md5Util(entity.getPassword()).compute().toUpperCase());
		entity.setAccountId(accid);
		//3.保存用户信息
		userDao.saveUser(entity);
		if (roleIds != null && roleIds.length > 0) {
			for (String roleId : roleIds) {
				roleDao.saveUserRole(entity.getUserId(), roleId);
			}
		}

	}

	public boolean isExistUserName(String userName) {
		List<?> list = userDao.findUserByName(userName);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	// 角色管理
	public Pagination getRolePage(int pageNo, int pageSize, int orderByStatus,String orderBy,String searchValue) {

		int totalCount = roleDao.getTotalCount(searchValue);
		Pagination pagination = new Pagination(pageNo, pageSize, totalCount);
		Map<String, Object> page = new HashMap<String, Object>();
		page.put("startNum", pagination.getStartNum());
		page.put("endNum", pagination.getEndNum());
		page.put("pageSize", pageSize);
		page.put("orderByStatus", orderByStatus);
		page.put("orderBy", orderBy);
		page.put("searchValue", searchValue);
		List<HbRole> list = roleDao.getPage(page);
		pagination.setList(list);
		return pagination;
	}

	public void saveRole(String rolename, int status, String description, String flag, Long[] offerGroupAreaId,
			Long[] orderAreaId, Integer[] orderType, Integer[] businessScope) {
		HbRole entity = new HbRole();
		if (isExistRoleName(rolename)) {
			throw new InfoTipException("角色名已经存在");
		}
		entity.setName(rolename);
		entity.setPriority(1);
		entity.setIsSuper("1");
		entity.setDescription(description);
		entity.setStatus(status);
		Long roleId = roleDao.saveRole(entity);

	}

	public boolean isExistRoleName(String name) {
		List<?> list = roleDao.findRoleByName(name);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public List<HbPermission> listPermission() {
		List<HbPermission> list = permDao.listAllPermission();

		return list;
	}

	public void savePermission(HbPermission entity) {
		if (isExistPermName(entity.getPermUpid(), entity.getPermName())) {
			throw new InfoTipException("同级别权限名已经存在");
		}
		String recieveURL[] = entity.getRecieveURL();
		StringBuilder builder = new StringBuilder();
		if (recieveURL != null && recieveURL.length > 0) {
			for (String url : recieveURL) {
				if (!StringUtils.isEmpty(url)) {
					if (!StringUtils.isEmpty(builder.toString())) {
						builder.append("|");
					}
					builder.append(url);
				}
			}
		}
		if (builder.toString().length() > 0) {
			entity.setDependentUrl(builder.toString());
		}
		permDao.savePermission(entity);
	}

	public boolean isExistPermName(String pid, String permName) {
		List<?> list = permDao.findPermissionByName(pid, permName);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public HbPermission getPermission(String id) {
		return permDao.findPermissionById(id);
	}

	public List<HbPermission> listPermissionByExcludesPermId(String excludesPermId) {
		List<HbPermission> list = permDao.listAllPermissionByExcludesPermId(excludesPermId);
		for (HbPermission perm : list) {
			StringBuilder builder = new StringBuilder("");
			builder.append(perm.getPermName());
			perm.setLevelStr(getLevelStrByPerm(perm, builder));
		}
		return list;
	}

	public String getLevelStrByPerm(HbPermission perm, StringBuilder builder) {
		HbPermission lastPerm = permDao.findPermissionByUUID(perm.getPermUpid());
		if (lastPerm != null && !StringUtil.isEmpty(lastPerm.getPermUpid())) {
			if (builder.toString().length() > 0) {
				builder.insert(0, "->");
			}
			builder.insert(0, lastPerm.getPermName());
			getLevelStrByPerm(lastPerm, builder);
		}
		return builder.toString();
	}

	public void updatePermission(HbPermission entity) {
		HbPermission temp = permDao.findPermissionById(entity.getPermId());
		if (isExistPermName(entity.getPermUpid(), entity.getPermName())
				&& !entity.getPermName().equals(temp.getPermName())) {
			throw new InfoTipException("同级别权限名已经存在");
		}
		String recieveURL[] = entity.getRecieveURL();
		StringBuilder builder = new StringBuilder();
		if (recieveURL != null && recieveURL.length > 0) {
			for (String url : recieveURL) {
				if (!StringUtils.isEmpty(url)) {
					if (!StringUtils.isEmpty(builder.toString())) {
						builder.append("|");
					}
					builder.append(url);
				}
			}
		}
		if (builder.toString().length() > 0) {
			entity.setDependentUrl(builder.toString());
		}
		permDao.updatePermission(entity);
	}

	public HbRole getRoleHigh(Long id) {
		return roleDao.getRoleById(id);
	}

	public HbRole getRoleByType(Long Type) {
		return roleDao.getRoleByType(Type);
	}

	public void assignPermToRole(String roleId, String permIds[]) {
		roleDao.deletePermRoleByroleId(roleId);
		if (permIds != null && permIds.length > 0) {
			for (String permId : permIds) {
				roleDao.saveRolePerm(permId, roleId);
			}
		}
	}

	public void deletePermById(String permid) {
		List<?> list = permDao.listnextPermBylastPermId(permid);
		if (list != null && list.size() > 0) {
			throw new InfoTipException("删除不合法，请先删除下层功能");
		}
		roleDao.deletePermRoleBypermId(permid);
		permDao.deletePermissionByIds(new String[] { permid });

	}

	@Override
	public HbRole findHzRoleByHzUserId(String userId) {
		return roleDao.findHzRoleByHzUserId(userId);
	}

	@Override
	public List<HbPermission> findPermissions(String permId) {
		return roleDao.findPermissions(permId);
	}

	@Override
	public HbPermission findPermissionByPermId(String permId) {
		return permDao.findPermissionByUUID(permId);
	}

	@Override
	public List<HbPermission> findPermissionsByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return permDao.findPermissionsByRoleId(roleId);
	}

	@Override
	public HbUser getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	@Override
	public void updateUserStatus(String id, int status) {
		// TODO Auto-generated method stub
		userDao.changeStatus(new String[] { id }, status);
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		userDao.deleteUserRoleByuserId(id);
		userDao.deleteUserByIds(new String[] { id });
	}

	@Override
	public void batchUpdateUserStatus(String[] ids, int status) {
		// TODO Auto-generated method stub
		userDao.changeStatus(ids, status);
	}

	@Override
	public void batchDelUserById(String[] ids) {
		// TODO Auto-generated method stub
		userDao.batchedelUserRoleByuserId(ids);
		userDao.deleteUserByIds(ids);
	}

	@Override
	public void updateUser(HbUser user, String[] roleIds) {
		// TODO Auto-generated method stub
		HbUser temp = userDao.findUserById(user.getUserId());
		if (isExistUserName(user.getUsername()) && !user.getUsername().equals(temp.getUsername())) {
			throw new InfoTipException("用户名已经存在");
		}
		userDao.updateUser(user);
		userDao.deleteUserRoleByuserId(user.getUserId());
		if (roleIds != null && roleIds.length > 0) {
			for (String roleId : roleIds) {
				userDao.saveUserRole(user.getUserId(), roleId);
			}
		}
	}
    
	public void updateUserInfo(HbUser user) {
		// TODO Auto-generated method stub
		HbUser temp = userDao.findUserById(user.getUserId());
		temp.setHasChild(user.getHasChild());
		userDao.updateUser(temp);
	}
	
	
	@Override
	public void updatePermStatus(String id, int status) {
		permDao.changeStatus(new String[] { id }, status);
	}

	@Override
	public void batchUpdatePermStatus(String[] ids, int status) {
		permDao.changeStatus(ids, status);
	}

	@Override
	public void batchDelPermById(String[] ids) {
		if (ids != null && ids.length > 0) {
			StringBuilder builder = new StringBuilder("");
			for (int i = 0; i < ids.length; i++) {
				HbPermission perm = permDao.findPermissionById(ids[i]);
				getLevelPermidByPerm(perm, builder);
			}
			roleDao.batchedelPermRoleBypermId(builder.toString());
			permDao.deletePermissionByIds2(builder.toString());
		}
	}

	public String getLevelPermidByPerm(HbPermission perm, StringBuilder builder) {
		List<HbPermission> list = permDao.listnextPermBylastPermId(perm.getPermId());
		if (builder.toString().length() > 0) {
			builder.append(",");
		}
		builder.append("'");
		builder.append(perm.getPermId());
		builder.append("'");
		if (list != null && list.size() > 0) {
			for (HbPermission p : list) {
				getLevelPermidByPerm(p, builder);
			}
		}
		return builder.toString();
	}

	@Override
	public HbRole getRole(String id) {
		HbRole role = roleDao.findRoleById(id);
		return role;
	}

	@Override
	public void updateHbRole(String id, String name, int status, String description, String flag) {
		HbRole entity = new HbRole();
		// HbRole temp = roleDao.findRoleById(id);
		/*
		 * if(isExistRoleName(name) && name.equals(temp.getName())){ throw new
		 * InfoTipException("角色名已经存在"); }
		 */
		entity.setRoleId(id);
		entity.setName(name);
		entity.setStatus(status);
		entity.setDescription(description);
		roleDao.updateRole(entity);
	}

	@Override
	public void updateRoleStatus(String id, int status) {
		roleDao.changeStatus(new String[] { id }, status);
	}

	@Override
	public List<HbUser> getAllUser() {
		List<HbUser> list = userDao.getAllUsers();
		return list;
	}

	@Override
	public void deleteRoleById(String id) {
		roleDao.deletePermRoleByroleId(id);
		userDao.deleteUserRoleByroleId(id);
		roleDao.deleteRoleByIds2(new String[] { id });
	}

	@Override
	public void batchUpdateRoleStatus(String[] ids, int status) {
		roleDao.changeStatus(ids, status);
	}

	@Override
	public void batchDelRoleById(String[] ids) {
		if (ids != null && ids.length > 0) {
			StringBuilder builder = new StringBuilder("");
			for (int i = 0; i < ids.length; i++) {
				builder.append("'");
				builder.append(ids[i]);
				builder.append("'");
				if (i < ids.length - 1) {
					builder.append(",");
				}
			}
			if (!roleDao.testDeleteByIds(builder.toString())) {
				throw new InfoTipException("存在角色已被关联用户无法删除");
			}
			roleDao.batchedelPermRoleByroleId(builder.toString());
			userDao.batchedelUserRoleByroleId(builder.toString());
			roleDao.deleteRoleByIds(builder.toString());
		}
	}

	public Set<String> findUserPermByuserId(String userid) {
		List<HbPermission> list = permDao.findUserPermByuserId(userid);
		Set<String> listperm = new HashSet<String>();
		for (HbPermission obj : list) {
			if (!StringUtils.isEmpty(obj.getPermUrl())) {
				listperm.add(obj.getPermUrl());
			}
			if (!StringUtils.isEmpty(obj.getDependentUrl())) {
				String dependentURL[] = obj.getDependentUrl().split("\\|");
				for (String url : dependentURL) {
					listperm.add(url.trim());
				}
			}
		}
		return listperm;
	}

	@Override
	public Set<String> findAccUserPermByUserId(String userId) {
		List<HbPermission> list = permDao.findAccUserPermByUserId(userId);
		Set<String> listperm = new HashSet<String>();
		for (HbPermission obj : list) {
			if (!StringUtils.isEmpty(obj.getPermUrl())) {
				listperm.add(obj.getPermUrl());
			}
			if (!StringUtils.isEmpty(obj.getDependentUrl())) {
				String dependentURL[] = obj.getDependentUrl().split("\\|");
				for (String url : dependentURL) {
					listperm.add(url.trim());
				}
			}
		}
		return listperm;
	}

	public List<HbRole> listRoleByFlag(String flag) {
		return roleDao.listRoleByFlag(flag);
	}

	@Override
	public List<HbRole> getRoleListByFlagAndStatus(String flag, int status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		map.put("status", status);
		return roleDao.getRoleListByFlagAndStatus(map);
	}

	public Vector<HbPermission> findPermissonVector() {
		if (permissionVector == null || permissionVector.isEmpty()) {
			permissionVector = new Vector<HbPermission>();
			permissionMap = new HashMap<String, HbPermission>();

			List<HbPermission> list = permDao.listAllPermission();
			permissionVector.addAll(list);
			for (HbPermission perm : list) {
				permissionMap.put(perm.getPermId(), perm);
			}
		}
		return permissionVector;
	}

	public HashMap<String, HbPermission> findPermissonMap() {
		return permissionMap;
	}

	public void batchRefresh() {
		permissionVector = null;
		permissionMap = null;
		findPermissonVector();
	}
	
	
	
	public HbUser getUserByEmail(String email){
		
	   return userDao.getUserByEmail(email);
	}
}
