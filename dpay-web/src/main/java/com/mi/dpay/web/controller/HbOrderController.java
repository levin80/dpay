package com.mi.dpay.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.dpay.beans.HbAccCash;
import com.mi.dpay.beans.HbOrder;
import com.mi.dpay.beans.HbSku;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.constants.HbOrderConstants;
import com.mi.dpay.pages.Pagination;
import com.mi.dpay.service.HbAccountCashManager;
import com.mi.dpay.service.HbOrderManager;
import com.mi.dpay.service.HbSkuManager;
import com.mi.dpay.util.DatatablesViewPage;
import com.mi.dpay.web.jsonVo.HbOrderJson;
import com.mi.dpay.web.session.SessionProvider;

/**
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 *
 * @author 袁林 (linyuand@isoftstone.com)
 * @version 1.0 2015-6-8 13:49
 * @filename: HbCatController.java
 */
@Controller
@RequestMapping(value = "/clouds/console/order")
public class HbOrderController extends BaseFormController {
    private static Log log = LogFactory.getLog(HbOrderController.class);
    @Autowired
    private HbSkuManager skuManager;
    @Autowired
	private SessionProvider sessionProvider;
    @Autowired
    private HbOrderManager orderManager;
    @Autowired
	private HbAccountCashManager cashManager;
    
	@RequestMapping(value = "/paypage")
	public String listpage(ModelMap model) {
		return "order/paypage";
	}
    
	/**获取产品列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/productList")
	public String productList(ModelMap model,HttpServletRequest request, HttpServletResponse response,String phone) {
		//1.判断手机号，移动/联通/电信
		
		//2.获取对应的产品配置
		Map<String, Object> param = new  HashMap<String, Object>() ;
		param.put("type", "1");
		param.put("status", "1");
		param.put("showStatus", "1");
		List productList = skuManager.getSkuList(param);
		model.addAttribute("plist", productList);
		model.addAttribute("phone", phone);

		return "order/payProduct";
	}
	
	/**充值
	 * @param model
	 * @param request
	 * @param response
	 * @param phone
	 * @param skuId
	 * @param orderForm
	 * @return
	 */
	@RequestMapping(value = "/pay")
	public @ResponseBody Object pay(ModelMap model,HttpServletRequest request, HttpServletResponse response,String phone,String skuId,@RequestBody HbOrder orderForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 记录入表
		HbSku sku = new HbSku();
		sku = skuManager.findSkuById(orderForm.getSkuId().intValue());
		
		HbUser user = sessionProvider.getUser(request);
		
		int realRate = user.getRealRate().intValue();
		int cost = sku.getSkuPrice().intValue()* realRate; //成本
		int profits = 0;
		profits = sku.getSkuPrice().intValue() - cost;//利润
		
		String orderId= orderManager.getOrderId();
		HbOrder order = new HbOrder();
		order.setSkuId(sku.getSkuId());
		order.setSkuName(sku.getShortName());
		order.setPhone(orderForm.getPhone());
		order.setFee(sku.getSkuPrice());
		order.setOrderId(orderId);
		order.setCost(cost);
		order.setProfits(profits);
		order.setOrderTime(new Date());
		order.setUserId(user.getUserId());
		order.setState(HbOrderConstants.OrderStateConstant.ORDER12);
		order.setIsPaid(HbOrderConstants.IsPaidConstant.PAY_SUCC);
		order.setPayPlatform(1);
		orderManager.saveOrder(order);
		
		//充值
		
		
		//记录
		HbAccCash accCash = cashManager.findAccountCashByUserId(user.getUserId());
		map = cashManager.updateCash(user,accCash, cost,"",user);

		return map;
	}
	
	@RequestMapping(value = "/toOrderList.do")
	public String toOrderList(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "order/orderList";
	}
	/**获取订单列表
	 * @param model
	 * @param request
	 * @param response
	 * @param start
	 * @param length
	 * @param orderByStatus
	 * @param draw
	 * @return
	 */
	@RequestMapping(value = "/orderList.do")
	public @ResponseBody Object  orderList(ModelMap model, HttpServletRequest request, HttpServletResponse response, Integer start,
			Integer length, Integer orderByStatus,String draw) {
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
			orderBy = sortOrder +" "+ sortDir;
		}else {
			orderBy = "id desc";
		}
		if (searchValue == null) {
			searchValue = "";
		}

		Integer nextOrderByStatus = (orderByStatus + 1) % 2;
		String chargeType = "1"; // 表示 充值
		Pagination pagination = orderManager.findOrderPageByUserId(start, length,  user.getUserId());
		//pagination = permissionManager.getUserPage(start, length, orderByStatus, orderBy, searchValue, model);
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("pagination", pagination);
		model.addAttribute("orderByStatus", orderByStatus);
		model.addAttribute("nextOrderByStatus", nextOrderByStatus);
		HbOrderJson jsonArr = new HbOrderJson();
		List retList = jsonArr.toArray(pagination.getList());
		
		DatatablesViewPage view = new DatatablesViewPage();
		view.setDraw(Integer.parseInt(draw == null ? "0": draw) + 1);
		view.setData(retList);
		view.setRecordsTotal(pagination.getPageSize());
		view.setRecordsFiltered(pagination.getTotalCount());
		return view;
	}
}
