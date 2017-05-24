package com.mi.dpay.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.common.CalculateUtil;
import com.mi.dpay.common.exception.InfoTipException;
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
@RequestMapping(value = "/clouds/console/agent")
public class HbAgentController extends BaseFormController {
	@Autowired
	private HbPermissionManager permissionManager;
	@Autowired
	private SessionProvider sessionProvider;

	@RequestMapping(value = "/listpage.do")
	public String listpage(ModelMap model) {
		return "agent/listagent";
	}

	/**
	 * 代理商列表
	 * @param model
	 * @param request
	 * @param response
	 * @param start
	 * @param length
	 * @param orderByStatus
	 * @param draw
	 * @return
	 */
	@RequestMapping(value = "/listUser.do")
	public @ResponseBody Object listUser(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			Integer start, Integer length, Integer orderByStatus, String draw) {
		HbUser user = sessionProvider.getUser(request);

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
			orderBy = sortOrder + " " + sortDir;
		} else {
			orderBy = "id desc";
		}
		if (searchValue == null) {
			searchValue = "";
		}

		List list = new ArrayList();
		Map<String, List> childMap = new HashMap<String, List>();
		list = permissionManager.getUserList(start, length, orderByStatus, orderBy, searchValue, model, user, childMap);

		model.addAttribute("roleList", permissionManager.getRoleListByFlagAndStatus("1", 1));// 后台启用的角色集合

		HbUserJson jsonArr = new HbUserJson();
		List retList = jsonArr.toAgentArray(list, childMap);

		DatatablesViewPage view = new DatatablesViewPage();
		view.setDraw(Integer.parseInt(draw == null ? "0" : draw) + 1);
		view.setData(retList);
		view.setRecordsTotal(list.size());
		view.setRecordsFiltered((Integer) model.get("totalCount"));
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
	@RequestMapping(value = "/adduserpage.do")
	public String forwardAddPerm(ModelMap model) {
		
		List<HbRole> listrole = permissionManager.listRoleByFlag("1");
		model.addAttribute("listrole", listrole);

		return "permission/adduser";
	}

	/**
	 * 添加代理商
	 * @param model
	 * @param request
	 * @param entity
	 * @param ids
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addUser.do")
	public String addUser(ModelMap model, HttpServletRequest request, HbUser entity, String ids[],HttpServletResponse response) {
		HbUser user = sessionProvider.getUser(request);
		
		entity.setCurrLevel(user.getCurrLevel() + 1);
		entity.setUserUpid(user.getUserId());
		//int rate = CalculateUtil.calcRealRate(user.getRealRate().intValue(), entity.getRate().intValue());
		//int rate = (int) Math.rint(user.getRealRate().intValue() * entity.getRate().intValue());
		//entity.setRealRate(rate);

		try {
			permissionManager.saveUser(entity, ids);
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
	@RequestMapping(value = "/getUser.do")
	public String getUser(ModelMap model, String id, HttpServletResponse response) {
		HbUser user = permissionManager.getUser(id);
		List<HbRole> listrole = permissionManager.listRoleByFlag("1");
		model.addAttribute("listrole", listrole);
		model.addAttribute("user", user);
		return "permission/edituser";
	}

	/**
	 * @param model
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/viewUser.do")
	public String viewUser(ModelMap model, String id, HttpServletResponse response) {
		HbUser user = permissionManager.getUser(id);
		List<HbRole> listrole = permissionManager.listRoleByFlag("1");
		model.addAttribute("listrole", listrole);
		model.addAttribute("user", user);
		return "agent/viewuser";
	}

	/**
	 * 代理商总体信息
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/info.do")
	public String getUseList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HbUser user = sessionProvider.getUser(request);

		// 账户余额
		// HbAccCash cashBean =
		// cashService.findAccountCashByUserId(user.getUserId());
		// model.addAttribute("cashBean", cashBean);
		// 我的订单数量
		// Integer orderNumber =
		// hbOrderManager.findOrderNumberByUserId(user.getUserid());
		// model.addAttribute("orderNumber", orderNumber);

		// 用户角色

		return "agent/info";
	}

}
