package com.mi.dpay.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mi.dpay.beans.HbRole;
import com.mi.dpay.beans.HbUser;
import com.mi.dpay.common.Md5Util;
import com.mi.dpay.service.HbPermissionManager;
import com.mi.dpay.service.HbUserManager;
import com.mi.dpay.util.Config;
import com.mi.dpay.web.session.SessionProvider;
import com.mi.dpay.web.util.CookieModel;
import com.mi.dpay.web.util.RedisClientWrapper;
import com.mi.dpay.web.util.RequestUtil;

@Controller
@RequestMapping("/clouds/console")
public class LoginController extends BaseFormController {
	private static Log log = LogFactory.getLog(LoginController.class);
	@Autowired
	private HbUserManager hbUserManager;
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private HbPermissionManager permissionManager;
	@Resource
	Config config;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public @ResponseBody Object login(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@RequestBody HbUser userbean) {
		boolean vcodeValidate = sessionProvider.validateCode(request, userbean.getValidateCodes());
		Map restMap = new HashMap();
		try {
			log.debug("进入" + "/enter.do");
			HbUser user = hbUserManager.getUserByNameAndPassword(userbean.getUsername(),new Md5Util(userbean.getPassword()).compute().toUpperCase());
			log.debug("查询到用户信息：" + user.getUsername());
			if (user != null) {
				StringBuilder builder = new StringBuilder("");

				for (HbRole role : user.getRoles()) {
					if (builder.toString().length() > 0) {
						builder.append(",");
					}
					builder.append(role.getName());
				}
				user.setRoleNames(builder.toString());
			}
			Set<String> permset = permissionManager.findUserPermByuserId(user.getUserId());
			// 权限集合存放cookie
			CookieModel cm = new CookieModel();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(RedisClientWrapper.REDIS_HZCLOUDS_KEY, permset);
			cm.setObjs(map);
			cm.setHbUser(user);
			RequestUtil.setSessionValue(request, response, RedisClientWrapper.REDIS_KEY, cm);

			sessionProvider.setUser(request, response, user);
			// 权限集合存放session
			Map redisMap = new HashMap();
			redisMap.put(SessionProvider.HZCLOUDS_KEY, permset);
			sessionProvider.setAttribute(request, response, redisMap);
			sessionProvider.setAttribute(request, response, "portalUrl", (String) config.get("portalUrl"));

			HbUser user1 = (HbUser) user.clone();
			hbUserManager.recordUserLoginInfo(user1);
			
			restMap.put("message", "登录成功");
			restMap.put("result", "true");
			if (userbean.getReturnUrl() != null && !"".equals(userbean.getReturnUrl())) {
				restMap.put("ReturnUrl", userbean.getReturnUrl());
			}

		} catch (Exception ex) {
			log.error("error info :" + ex.getMessage());
			restMap.put("result", "false");
			restMap.put("message", "系统异常");
		}
		return restMap;
	}

	@RequestMapping(value = "logout.do")
	public void logoutAction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	@RequestMapping(value = "/main.do")
	public String main(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "mainMenu";
	}

}
