package com.mi.dpay.web.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.mi.dpay.beans.HbUser;
import com.mi.dpay.constants.HbConstants;

/**
 * Description:权限拦截器
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-8-4 下午1:16:56 
 */

public class PermissionInterceptor extends HandlerInterceptorAdapter {

	private static Log log = LogFactory.getLog(PermissionInterceptor.class);
	private List<String> excludes = new ArrayList<String>();

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Boolean result = super.preHandle(request, response, handler);
		if (true == result) {
			UrlPathHelper helper = new UrlPathHelper();
			String urlmap = helper.getLookupPathForRequest(request);
			HbUser user = (HbUser) request.getSession().getAttribute(HbConstants.USER_KEY);
			log.debug(urlmap);
			if (!excludes.contains(urlmap) && null == user) {
				response.sendRedirect(request.getContextPath() +("/clouds/console/login.jsp?ReturnUrl=" + urlmap));
				result = false;
			}
		}
		return result;
	}

	public List<String> getExcludes() {
		return excludes;
	}

	public void setExcludes(List<String> excludes) {
		this.excludes = excludes;
	}

}
