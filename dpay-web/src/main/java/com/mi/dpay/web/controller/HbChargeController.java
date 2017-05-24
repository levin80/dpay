package com.mi.dpay.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.dpay.beans.HbAccCash;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbAccountCashManager;
import com.mi.dpay.service.HbChargeManager;
import com.mi.dpay.service.HbPermissionManager;
import com.mi.dpay.util.DatatablesViewPage;
import com.mi.dpay.web.jsonVo.HbChargeRecordJson;
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
@RequestMapping(value = "/clouds/console/charge")
public class HbChargeController extends BaseFormController {
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private HbPermissionManager permissionManager;

	@Autowired
	private HbAccountCashManager cashManager;
	@Autowired
	private HbChargeManager chargeManager;

	/**
	 * 用户充值方法
	 * 
	 * @return
	 */
	@RequestMapping(value = "/accountCharge.do")
	public String accountCharge(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HbUser user = sessionProvider.getUser(request);
		if (user == null) {
			return "/login";
		}
		return "charge/accountCharge";
	}


	/**
	 * @param model
	 * @param request
	 * @param response
	 * @param pd_payment
	 * @param pd_amount
	 * @param pd_remittance_info
	 * @return
	 */
	@RequestMapping(value = "/charge.do")
	public String gotoCharge(ModelMap model, HttpServletRequest request, HttpServletResponse response, HbUser toUser,
			String cash) {
		// 首先生成充值记录，生成充值订单
		HbUser opUser = sessionProvider.getUser(request);
		if (opUser == null) {
			return "/login";
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HbUser userBean = permissionManager.getUserByEmail(toUser.getEmail());
		if (null != userBean) {
			HbAccCash accCash = cashManager.findAccountCashByUserId(userBean.getUserId());
			resultMap = cashManager.updateAccountCashIn2(userBean, accCash, cash, "", opUser);
		} else {
			resultMap.put("success", false);
			resultMap.put("message", "账户信息不存在，请联系管理员");
		}
		return "charge/chargeList";
	}

	@RequestMapping(value = "/toChargePage.do")
	public String toChargePage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "charge/chargeList";
	}

	@RequestMapping(value = "/toAccRecordList.do")
	public String toAccRecordList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "charge/accRecordList";
	}
	// /**
	// * 获取充值记录列表
	// *
	// * @param model
	// * @param request
	// * @param response
	// * @return
	// */
	// @RequestMapping(value = "/chargeList.do")
	// public String accountChargeList(ModelMap model, HttpServletRequest
	// request, HttpServletResponse response, Integer pageNo) {
	// HbUser user = sessionProvider.getUser(request);
	// if (user == null) {
	// return "/login";
	// }
	// if (null == pageNo) {
	// pageNo = 1;
	// }
	// String chargeType = "1"; // 表示 充值
	// Pagination pagination =
	// chargeManager.findPageAccChargeRecordByUserId(pageNo, 10, chargeType,
	// user.getUserId());
	// model.addAttribute("pagination", pagination);
	// model.addAttribute("pageSize", 10);
	// model.addAttribute("pageNo", pageNo);
	// return "/user/chargeList";
	// }

	/**
	 * @param model
	 * @param request
	 * @param response
	 * @param start
	 * @param length
	 * @param orderByStatus
	 * @param draw
	 * @return
	 */
	@RequestMapping(value = "/chargeList.do")
	public @ResponseBody Object chargeList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
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

		Integer nextOrderByStatus = (orderByStatus + 1) % 2;
		String chargeType = "1"; // 表示 充值
		Pagination pagination = chargeManager.findPageAccChargeRecordByUserId(start, length, chargeType,
				user.getUserId());
		// pagination = permissionManager.getUserPage(start, length,
		// orderByStatus, orderBy, searchValue, model);
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("pagination", pagination);
		model.addAttribute("orderByStatus", orderByStatus);
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);
		HbChargeRecordJson jsonArr = new HbChargeRecordJson();
		List retList = jsonArr.toArray(pagination.getList());

		DatatablesViewPage view = new DatatablesViewPage();
		view.setDraw(Integer.parseInt(draw == null ? "0" : draw) + 1);
		view.setData(retList);
		view.setRecordsTotal(pagination.getPageSize());
		view.setRecordsFiltered(pagination.getTotalCount());
		return view;
	}

	/**
	 * @param model
	 * @param request
	 * @param response
	 * @param start
	 * @param length
	 * @param orderByStatus
	 * @param draw
	 * @return
	 */
	@RequestMapping(value = "/accRecordList.do")
	public @ResponseBody Object accRecordList(ModelMap model, HttpServletRequest request, HttpServletResponse response,
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

		Integer nextOrderByStatus = (orderByStatus + 1) % 2;
		Pagination pagination = chargeManager.findPageAccChargeRecordByUserId(start, length, null, user.getUserId());
		// pagination = permissionManager.getUserPage(start, length,
		// orderByStatus, orderBy, searchValue, model);
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("pagination", pagination);
		model.addAttribute("orderByStatus", orderByStatus);
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);
		HbChargeRecordJson jsonArr = new HbChargeRecordJson();
		List retList = jsonArr.toAccRecordArray(pagination.getList());

		DatatablesViewPage view = new DatatablesViewPage();
		view.setDraw(Integer.parseInt(draw == null ? "0" : draw) + 1);
		view.setData(retList);
		view.setRecordsTotal(pagination.getPageSize());
		view.setRecordsFiltered(pagination.getTotalCount());
		return view;
	}

}
