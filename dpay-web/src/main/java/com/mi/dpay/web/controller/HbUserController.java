package com.mi.dpay.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.common.exception.InfoTipException;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbPermissionManager;
import com.mi.dpay.util.DatatablesViewPage;
import com.mi.dpay.web.jsonVo.HbUserJson;
import com.mi.dpay.web.session.SessionProvider;

/**
 * </p>
 * Copyright(c) 2015 iSoftStone
 * </p>
 * 
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbUserController.java
 * @version 1.0 2015-3-13 上午10:37:29
 */
@Controller
@RequestMapping(value = "/clouds/console/permission")
public class HbUserController extends BaseFormController {
	@Autowired
	private HbPermissionManager permissionManager;
	@Autowired
	private SessionProvider sessionProvider;
	
	@RequestMapping(value = "/user/listpage.do")
	public String listpage(ModelMap model) {

		return "permission/listuser";
	}
    
	@RequestMapping(value = "/user/listUser.do")
	public @ResponseBody Object  listUser(ModelMap model, HttpServletRequest request, HttpServletResponse response, Integer start,
			Integer length, Integer orderByStatus,String draw) {
		
		
		if (start == null) {
			start = 1;
		}
		if (length == null) {
			length = 10;
		}
		if (orderByStatus == null) {
			orderByStatus = 0;
		}
		String orderBy = null;
		String sortOrder = request.getParameter("order[0][column]");
		String sortDir = request.getParameter("order[0][dir]");
		String searchValue = request.getParameter("search[value]");
		
		if (sortOrder != null) {
			orderBy = sortOrder +" "+ sortDir;
		}else {
			orderBy = "id desc";
		}
		if (searchValue == null) {
			searchValue = "";
		}

		Integer nextOrderByStatus = (orderByStatus + 1) % 2;
		Pagination pagination = new Pagination();
		pagination = permissionManager.getUserPage(start, length, orderByStatus, orderBy, searchValue, model);
		model.addAttribute("roleList", permissionManager.getRoleListByFlagAndStatus("1", 1));// 后台启用的角色集合
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("pagination", pagination);
		model.addAttribute("orderByStatus", orderByStatus);
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);
		HbUserJson jsonArr = new HbUserJson();
		List retList = jsonArr.toArray(pagination.getList());
		
		DatatablesViewPage view = new DatatablesViewPage();
		view.setDraw(Integer.parseInt(draw == null ? "0": draw) + 1);
		view.setData(retList);
		view.setRecordsTotal(pagination.getPageSize());
		view.setRecordsFiltered(pagination.getTotalCount());
		return view;
	}

	/**
	 * 添加用户
	 * 
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-3-13 下午2:55:51
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/user/adduserpage.do")
	public String forwardAddPerm(ModelMap model) {
		List<HbRole> listrole = permissionManager.listRoleByFlag("1");

		model.addAttribute("listrole", listrole);

		return "permission/adduser";
	}

	@RequestMapping(value = "/user/addUser.do")
	public String addUser(ModelMap model, HttpServletRequest request,HbUser entity, String ids[], HttpServletResponse response) {
		HbUser user = sessionProvider.getUser(request);
		entity.setCurrLevel(user.getCurrLevel()+1);
		entity.setUserUpid(user.getUserId());
		entity.setHasChild(0);
		//entity.setRate(100 - entity.getPer().intValue());
		
		//int rate = (int)Math.rint(user.getRealRate().intValue() * entity.getRate().intValue());
		//entity.setRealRate(rate);
		
		
		try {
			permissionManager.saveUser(entity, ids);
			
			user.setHasChild(1);//设置有子节点
			permissionManager.updateUserInfo(user);
			
		} catch (InfoTipException ex) {
			model.addAttribute("userName", ex.getMessage());
			return "forward:forwarduser.do";
		}
		return "permission/listuser";
	}

	/**
	 * 获取用户
	 * 
	 * @param model
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/getUser.do")
	public String getUser(ModelMap model, String id, HttpServletResponse response) {
		HbUser user = permissionManager.getUser(id);
		List<HbRole> listrole = permissionManager.listRoleByFlag("1");
		model.addAttribute("listrole", listrole);
		model.addAttribute("user", user);
		return "permission/edituser";
	}

	/**
	 * 修改用户状态
	 * 
	 * @param id
	 * @param status
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/updateUserStatus.do")
	public String updateUserStatus(String id, int status, HttpServletResponse response) {
		permissionManager.updateUserStatus(id, status);
		return "forward:listUser.do";
	}

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/deleteUserById.do")
	public String deleteUserById(String id, HttpServletResponse response) {
		permissionManager.deleteUserById(id);
		return "permission/listuser";
	}

	/**
	 * 根据用户信息批量更新用户
	 * 
	 * @param ids
	 * @param status
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/batchUpdateUserStatus.do")
	public String batchUpdateUserStatus(String[] ids, int status, HttpServletResponse response) {
		permissionManager.batchUpdateUserStatus(ids, status);
		return "forward:listUser.do";
	}

	/**
	 * 根据用户信息批量删除用户
	 * 
	 * @param ids
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/batchDelUserById.do")
	public String batchDelUserById(String[] ids, HttpServletResponse response) {
		permissionManager.batchDelUserById(ids);
		return "forward:listUser.do";
	}

	/**
	 * 更新user
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/updateUser.do")
	public String updateUser(ModelMap model, HbUser entity, String[] ids, HttpServletResponse response) {
		try {
			permissionManager.updateUser(entity, ids);
		} catch (InfoTipException ex) {
			model.addAttribute("userName", ex.getMessage());
			return getUser(model, entity.getUserId(), response);
		}
		return "forward:listUser.do";
	}
}
