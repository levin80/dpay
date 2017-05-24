package com.mi.dpay.web.controller;


import java.util.Iterator;
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
import com.mi.dpay.common.ResponseUtils;
import com.mi.dpay.common.exception.InfoTipException;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbPermissionManager;
import com.mi.dpay.util.DatatablesViewPage;
import com.mi.dpay.web.jsonVo.HbRoleJson;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbRoleController.java
 * @version 1.0 2015-3-16 下午4:28:55 
 */
@Controller
@RequestMapping(value = "/clouds/console/permission")
public class HbRoleController extends BaseFormController{

	@Autowired
	HbPermissionManager permissionManager;
	
	@RequestMapping(value = "/role/listpage.do")
	public String listpage(ModelMap model) {

		return "permission/listrole";
	}
	
	@RequestMapping(value = "/role/listRole.do")
	public @ResponseBody Object  listRole(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, Integer start,Integer length,
			Integer orderByStatus, String draw) {
		
		String orderBy = null;
		String sortOrder = request.getParameter("order[0][column]");
		String sortDir = request.getParameter("order[0][dir]");
		String searchValue = request.getParameter("search[value]");
		
		if (start == null) {
			start = 1;
		}
		if (length == null) {
			length = 10;
		}
		if (orderByStatus == null) {
			orderByStatus = 0;
		}
		
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
		pagination = permissionManager.getRolePage(start, length,orderByStatus, orderBy, searchValue);
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("pagination", pagination);
		model.addAttribute("orderByStatus", orderByStatus);
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);
		
		HbRoleJson jsonArr = new HbRoleJson();
		List retList = jsonArr.toArray(pagination.getList());
		DatatablesViewPage view = new DatatablesViewPage();
		view.setDraw(Integer.parseInt(draw == null ? "0": draw) + 1);
		view.setData(retList);
		view.setRecordsTotal(pagination.getPageSize());
		view.setRecordsFiltered(pagination.getTotalCount());
		return view;
	}
	
	@RequestMapping(value = "/role/perAddRole.do")
	public String perAddRole(ModelMap model, HttpServletRequest request,HttpServletResponse response) {
		return "permission/addrole";
	}
	@RequestMapping(value = "/role/addRole.do")
	public String addRole(ModelMap model, HttpServletRequest request,
			String name, Integer status, String description,String flag,Long [] offerGroupArea,Long [] orderArea,Integer[] orderType,Integer[] businessScope,HttpServletResponse response) {
		try {
			permissionManager.saveRole(name, status, description,flag,offerGroupArea,orderArea,orderType,businessScope);
		} catch (InfoTipException ex) {
			model.addAttribute("rolename", ex.getMessage());
			return "permission/addrole";
		}
		return "permission/listrole";
	}
	@RequestMapping(value="/role/getRole.do")
	public String getRole(ModelMap model,String id,
			HttpServletResponse response){
		HbRole role = permissionManager.getRole(id);
		model.addAttribute("role", role);
		return "permission/editrole";
	}
	@RequestMapping(value="/role/updateRole.do")
	public String updateRole(ModelMap model,String id,String name,int status,String description,String flag,HttpServletResponse response){
		try {
			permissionManager.updateHbRole(id,name,status,description,flag);
		} catch (InfoTipException e) {
			model.addAttribute("rolename", e.getMessage());
			return getRole(model, id, response);
		}
		return "permission/listrole";
	}
	@RequestMapping(value="/role/updateRoleStatus.do")
	public String updateRoleStatus(String id,int status,
			HttpServletResponse response){
		permissionManager.updateRoleStatus(id,status);
		return "forward:listRole.do";
	}
	/**
	 * 删除角色前判断是否关联用户，若关联，则不能删除
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="role/deleteRoleById.do")
	public void deleteRoleById(String id,ModelMap model,HttpServletRequest request,
			HttpServletResponse response){
		List<HbUser> list = permissionManager.getAllUser(); 
		for(Iterator<HbUser> userIterator=list.iterator(); userIterator.hasNext();){
			HbUser user = userIterator.next();
			System.out.println(user.getUsername());
			List<HbRole> roles = user.getRoles();
			for(Iterator<HbRole> roleIterator = roles.iterator();roleIterator.hasNext();){
				HbRole role = roleIterator.next();
				String id2 = role.getRoleId();
				System.out.println(role.getName());
				if(id.equals(id2)){
					ResponseUtils.printText(response, "{_status:'false',_mes:'该角色已关联用户'}");
					return;
				}
			}
		}
		permissionManager.deleteRoleById(id);
		ResponseUtils.printText(response, "{_status:'true'}");
	}
	@RequestMapping(value="/role/batchUpdateRoleStatus.do")
	public String batchUpdateRoleStatus(String[] ids,int status,
			HttpServletResponse response){
		permissionManager.batchUpdateRoleStatus(ids,status);
		return "forward:listRole.do";
	}
	@RequestMapping(value="/role/batchDelRoleById.do")
	public String batchDelRoleById(ModelMap model,String[] ids,
			HttpServletResponse response){
		try {
			permissionManager.batchDelRoleById(ids);
		} catch (InfoTipException e) {
			model.put("message", e.getMessage());
		}
		return "forward:listRole.do";
	}
}
