package com.mi.dpay.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mi.dpay.beans.HbPermission;
import com.mi.dpay.beans.HbRole;
import com.mi.dpay.common.ResponseUtils;
import com.mi.dpay.common.exception.InfoTipException;
import com.mi.dpay.service.HbPermissionManager;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbPermissionController.java
 * @version 1.0 2015-3-16 下午5:36:13 
 */
@Controller
@RequestMapping(value="/clouds/console/permission")
public class HbPermissionController extends BaseFormController {
	@Autowired
	HbPermissionManager permissionManager;
	
	@RequestMapping(value = "/perm/listPerm.do")
	public String listAllPerm(ModelMap model) {
		List<HbPermission> list = permissionManager.listPermission();
		model.addAttribute("listperm", list);
		return "permission/listperm";
	}
	
	@RequestMapping(value = "/perm/forwardperm.do")
	public String forwardAddPerm(ModelMap model) {
		List<HbPermission> list = permissionManager.listPermission();
		model.addAttribute("listperm", list);
		return "permission/addperm";
	}
	
	@RequestMapping(value = "/perm/addPerm.do")
	public String addPerm(ModelMap model, HttpServletRequest request,HbPermission entity) {
		try {
			permissionManager.savePermission(entity);
		} catch (InfoTipException ex) {
			model.addAttribute("permname", ex.getMessage());
			return forwardAddPerm(model);
		}
		return "forward:listPerm.do";
	}
	@RequestMapping(value = "/perm/getPerm.do")
	public String getPerm(ModelMap model, String id, HttpServletResponse response) {
		HbPermission perm = permissionManager.getPermission(id);
		List<HbPermission> list = permissionManager.listPermissionByExcludesPermId(id);
		model.addAttribute("listperm", list);
		model.addAttribute("perm", perm);
		return "permission/editperm";
	}
	@RequestMapping(value = "/perm/updatePerm.do")
	public String updatePerm(ModelMap model, HttpServletResponse response,	HbPermission entity) {
		try {
			permissionManager.updatePermission(entity);
		} catch (InfoTipException ex) {
			model.addAttribute("permname", ex.getMessage());
			return getPerm(model, entity.getPermId(), response);
		}
		return "forward:listPerm.do";
	}

	@RequestMapping(value = "/perm/forwardPermission.do")
	public String forwardPermission(ModelMap model, Long id) {
		List<HbPermission> list = permissionManager.listPermission();
		HbRole role = permissionManager.getRoleHigh(id);
		model.addAttribute("listperm", list);
		model.addAttribute("role", role);
		return "permission/permission";
	}
	
	@RequestMapping(value = "/perm/assignPermForRole.do")
	public void assignPermForRole(ModelMap model, String roleId, String ids[],
			HttpServletResponse response) {
		String result = "{result:'success',message:'权限分配成功'}";
		try {
			permissionManager.assignPermToRole(roleId, ids);
		} catch (InfoTipException ex) {
			result = "{result:'error',message:'" + ex.getMessage() + "'}";
		} catch (Exception ex) {
			ex.printStackTrace();
			result = "{result:'error',message:'系统异常'}";
		}
		ResponseUtils.printText(response, result);

	}
	
	@RequestMapping(value = "/perm/deletePermById.do")
	public String deletePermById(ModelMap model, String id, HttpServletResponse response) {
		try {
			permissionManager.deletePermById(id);
		} catch (InfoTipException info) {
			model.addAttribute("message", info.getMessage());
		}
		return "forward:listPerm.do";
	}
	@RequestMapping(value="/perm/updatePermStatus.do")
	public String updatePermStatus(String id,int status,
			HttpServletResponse response){
		permissionManager.updatePermStatus(id, status);
		return "forward:listPerm.do";
	}
	
	@RequestMapping(value="/perm/batchUpdatePermStatus.do")
	public String batchUpdatePermStatus(String[] ids,int status,
			HttpServletResponse response){
		permissionManager.batchUpdatePermStatus(ids, status);
		return "forward:listPerm.do";
	}
	@RequestMapping(value="/perm/batchDelPermById.do")
	public String batchDelPermById(String[] ids,
			HttpServletResponse response){
		permissionManager.batchDelPermById(ids);
		return "forward:listPerm.do";
	}
}