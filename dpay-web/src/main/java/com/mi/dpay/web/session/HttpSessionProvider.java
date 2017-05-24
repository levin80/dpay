package com.mi.dpay.web.session;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.dpay.beans.HbUser;
import com.mi.dpay.constants.HbConstants;

public class HttpSessionProvider implements SessionProvider {

	public HbUser getUser(HttpServletRequest request) {
		HbUser user = null;
		try {
			user = (HbUser) request.getSession().getAttribute(HbConstants.USER_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void setUser(HttpServletRequest request, HttpServletResponse response, HbUser user) {
		request.getSession().setAttribute(HbConstants.USER_KEY, user);
	}

	public Object getAttribute(HttpServletRequest request, String name) {
		return request.getSession().getAttribute(name);
	}

	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Object value) {
		request.getSession().setAttribute(name, value);
	}

	public void removeAttribute(HttpServletRequest request, String name) {
		request.getSession().removeAttribute(name);
	}

	public void invalidate(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
	}

	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		return request.getSession().getId();
	}

	public void setAttribute(HttpServletRequest request, HttpServletResponse response, Map map) {
		Set<String> set = map.keySet();
		for (String s : set) {
			setAttribute(request, response, s, map.get(s));
		}
	}

	public void setVerifyCode(HttpServletRequest request, HttpServletResponse response, String code) {
		request.getSession().setAttribute(HbConstants.VERIFY_SESSION_KEY, code.toUpperCase());
	}

	public boolean validateCode(HttpServletRequest request, String code) {
		Object obj = request.getSession().getAttribute(HbConstants.VERIFY_SESSION_KEY);
		if (obj == null || code == null || code.equals("")) {
			return false;
		}
		String s = (String) obj;
		if (code.toUpperCase().equals(s)) {
			return true;
		} else {
			return false;
		}
	}
}
