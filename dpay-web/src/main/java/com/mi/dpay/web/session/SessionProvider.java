package com.mi.dpay.web.session;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.dpay.beans.HbUser;

/**
 * session服务提供类，主要负责session的查询、设置、清除及session中用户信息的设置等操作
 * 
 * @author miaofch
 * 
 */
public interface SessionProvider {

	public final static String CRMMESSAGEKEY = "CRMMESSAGEKEY";

	public final static String RANDOMPASSWORD = "RANDOMPASSWORD";

	public final static String LOGIN_TYPE = "com.iss.hzclouds.webapp.login.loginType";

	final static String HZCLOUDS_KEY = "isoftstone-internet-product" + ".hzclouds";

	/**
	 * 获得session中的用户信息
	 * 
	 * @param request http请求
	 * @return session中的用户信息
	 */
	public HbUser getUser(HttpServletRequest request);

	/**
	 * 设置session中的用户信息
	 * 
	 * @param request http请求
	 * @param user user信息
	 * @throws Exception
	 */
	public void setUser(HttpServletRequest request, HttpServletResponse response, HbUser user) throws Exception;

	/**
	 * 通过名称，获得session中除用户外的其他信息
	 * 
	 * @param request http请求
	 * @param name session值存储名称
	 * @return session值
	 */
	public Object getAttribute(HttpServletRequest request, String name);

	/**
	 * 设置session中的存储信息
	 * 
	 * @param request http请求
	 * @param name 存储名
	 * @param value 存储值
	 * @throws Exception
	 */
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Object value) throws Exception;

	/**
	 * 通过名称，清除指定的sessin信息
	 * 
	 * @param request http请求
	 * @param name 存储名
	 */
	public void removeAttribute(HttpServletRequest request, String name);

	/**
	 * 使session失效
	 * 
	 * @param request http请求
	 * @throws Exception
	 */
	public void invalidate(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 获取当前用户的sessionId，如果当前用户没有session则首先构造一个session
	 * 
	 * @param request http请求
	 * @return sessionId
	 */
	public String getSessionId(HttpServletRequest request, HttpServletResponse response);

	public void setAttribute(HttpServletRequest request, HttpServletResponse response, Map map);
	
    /**
    * Description:设置验证码
    * @author 李晓伟 (xwlig@isoftstone.com)
    * @version 1.0 2016-1-22 下午5:13:41 
    * @param request
    * @param response
    * @param code 
    * void
    */
   public void setVerifyCode(HttpServletRequest request, HttpServletResponse response, String code);
	/**
	 * Description:验证码校验
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2016-1-22 下午5:13:43 
	 * @param request
	 * @param code
	 * @return 
	 * boolean
	 */
	public boolean validateCode(HttpServletRequest request, String code);
    

}
