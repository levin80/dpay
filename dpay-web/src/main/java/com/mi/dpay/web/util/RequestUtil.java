package com.mi.dpay.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mi.dpay.web.session.HttpSessionProvider;
import com.mi.dpay.web.session.SessionProvider;


/**
 * Convenience class for setting and retrieving cookies.
 */
public final class RequestUtil {

	public static SessionProvider sessionProvider = new HttpSessionProvider();

	private static final Log log = LogFactory.getLog(RequestUtil.class);

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private RequestUtil() {
	}

	/**
	 * Description:放置cookie
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-30 下午5:24:50 
	 * @param response
	 * @param key
	 * @param UUid 
	 * void
	 */
	public static void setCookie(HttpServletResponse response, String key,
			String UUid) {
		Cookie cookie = new Cookie(key, UUid);
		cookie.setMaxAge(Integer.MAX_VALUE);
		cookie.setPath("/");
		if (null != response) {
			response.addCookie(cookie);
		}
	}

	/**
	 * Description: 获取cookie
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-30 下午5:25:10 
	 * @param request
	 * @param UUidKey
	 * @return 
	 * String
	 */
	public static String getCookie(HttpServletRequest request, String UUidKey) {
		if (null != request) {
			Cookie[] cookies = request.getCookies();
			if (null != cookies) {
				for (int i = 0; i < cookies.length; i++) {
					if (null != UUidKey && UUidKey.equals(cookies[i].getName())) {
						return cookies[i].getValue();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Convenience method for deleting a cookie by name
	 * 
	 * @param response
	 *            the current web response
	 * @param cookie
	 *            the cookie to delete
	 * @param path
	 *            the path on which the cookie was set (i.e. /appfuse)
	 */
	public static void deleteCookie(HttpServletResponse response,
			Cookie cookie, String path) {
		if (cookie != null) {
			// Delete the cookie by setting its maximum age to zero
			cookie.setMaxAge(0);
			cookie.setPath(path);
			response.addCookie(cookie);
		}
	}

	/**
	 * Convenience method to get the application's URL based on request
	 * variables.
	 * 
	 * @param request
	 *            the current request
	 * @return URL to application
	 */
	public static String getAppURL(HttpServletRequest request) {
		if (request == null)
			return "";

		StringBuffer url = new StringBuffer();
		int port = request.getServerPort();
		if (port < 0) {
			port = 80; // Work around java.net.URL bug
		}
		String scheme = request.getScheme();
		url.append(scheme);
		url.append("://");
		url.append(request.getServerName());
		if ((scheme.equals("http") && (port != 80))
				|| (scheme.equals("https") && (port != 443))) {
			url.append(':');
			url.append(port);
		}
		url.append(request.getContextPath());
		return url.toString();
	}

	/**
	 * 获取QueryString的参数，并使用URLDecoder以UTF-8格式转码。如果请求是以post方法提交的，
	 * 那么将通过HttpServletRequest.getParameter获取。
	 * 
	 * @param request
	 *            web请求
	 * @param name
	 *            参数名称
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getQueryParam(HttpServletRequest request, String name)
			throws UnsupportedEncodingException {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		if (request.getMethod().equalsIgnoreCase("post")) {
			return request.getParameter(name);
		}
		String s = request.getQueryString();
		if (StringUtils.isBlank(s)) {
			return null;
		}
		s = URLDecoder.decode(s, "utf-8");

		String[] values = parseQueryString(s).get(name);
		if (values != null && values.length > 0) {
			return values[values.length - 1];
		} else {
			return null;
		}
	}

	/**
	 * 如果是Get请求，解析QueryString部分
	 * 
	 * @param s
	 * @return
	 */
	public static Map<String, String[]> parseQueryString(String s) {
		String valArray[] = null;
		if (s == null) {
			throw new IllegalArgumentException();
		}
		Map<String, String[]> ht = new HashMap<String, String[]>();
		StringTokenizer st = new StringTokenizer(s, "&");
		while (st.hasMoreTokens()) {
			String pair = (String) st.nextToken();
			int pos = pair.indexOf('=');
			if (pos == -1) {
				continue;
			}
			String key = pair.substring(0, pos);
			String val = pair.substring(pos + 1, pair.length());
			if (ht.containsKey(key)) {
				String oldVals[] = (String[]) ht.get(key);
				valArray = new String[oldVals.length + 1];
				for (int i = 0; i < oldVals.length; i++) {
					valArray[i] = oldVals[i];
				}
				valArray[oldVals.length] = val;
			} else {
				valArray = new String[1];
				valArray[0] = val;
			}
			ht.put(key, valArray);
		}
		return ht;
	}

	/**
	 * Description:从session中获取存在的变量
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-30 下午5:25:30 
	 * @param request
	 * @param name
	 * @return 
	 * Object
	 */
	public static Object getSessionValueByrequest(HttpServletRequest request,
			String name) {
		return sessionProvider.getAttribute(request, name);
	}

	/**
	 * Description:往cookie里面放置登陆信息
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2015-7-30 下午5:25:45 
	 * @param request
	 * @param response
	 * @param key
	 * @param obj 
	 * void
	 * @throws Exception 
	 */
	public static void setSessionValue(HttpServletRequest request,	HttpServletResponse response, String key, Object obj) throws Exception {
		sessionProvider.setAttribute(request, response, key, obj);
	}
}
