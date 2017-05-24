package com.mi.dpay.core.mvc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

/**
 * The Class MvcAppViewInterceptor.
 */
public class MvcAppViewInterceptor implements HandlerInterceptor {
	

	/** The Constant APP_VIEW_NAME_SEPARATOR. */
	private static final String APP_VIEW_NAME_SEPARATOR = "::";

	/** The Constant VIEW_APP_FLAG_MAP_INIT_BUFFER. */
	private static final int VIEW_APP_FLAG_MAP_INIT_BUFFER = 50;

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(MvcAppViewInterceptor.class);

	private static final String WEB_CONTEXT_ROOT = "root";

	private static final String APP_CONTEXT_PATH = "base";

	private static final String APP_SYSTEM = "system";
	
	/** The view app flag map. */
	private static Map<String, String> viewAppFlagMap;

	/**
	 * Instantiates a new mvc app view interceptor.
	 */
	public MvcAppViewInterceptor() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		UrlPathHelper helper = new UrlPathHelper();
		String requestUrl = helper.getLookupPathForRequest(request);
		logger.debug("=======>[Mvc-web-request-url]:" + requestUrl);
		logger.debug("=======>[Mvc-handler-controller]:"+handler.getClass().getName());

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet
	 * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String appViewFlag = "";
		if(handler instanceof IMvcAppViewConnector){
			appViewFlag = ((IMvcAppViewConnector) handler).getAppViewFlag();
			
		}
		
		if(handler instanceof HandlerMethod){
			Object handlerBean = ((HandlerMethod)handler ).getBean();
			appViewFlag = ((IMvcAppViewConnector) handlerBean).getAppViewFlag();
			
		}
		if(StringUtils.isEmpty(appViewFlag)){
			appViewFlag="";
		}
		String viewName = "";
		if(null!=modelAndView){
			modelAndView.setViewName(appViewFlag+APP_VIEW_NAME_SEPARATOR+modelAndView.getViewName());
			viewName = modelAndView.getViewName();
			registerView(viewName, appViewFlag);
			
			Map<String, Object> model = modelAndView.getModel();
			model.put(WEB_CONTEXT_ROOT, request.getContextPath());
			model.put(APP_CONTEXT_PATH, request.getContextPath()+"/"+appViewFlag);
			model.put(APP_SYSTEM, appViewFlag);
		}
		

		logger.debug("=======>[Mvc-web-appview-name]:" + viewName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("=======>[Mvc-req-map-finish].");

	}

	/**
	 * Lookup app view flag.
	 * 
	 * @param viewName
	 *            the view name
	 * @return the string
	 */
	public static String lookupAppViewFlag(String viewName) {
		String appViewFlag = "";
		if (!StringUtils.isEmpty(viewName)) {
			if (!CollectionUtils.isEmpty(viewAppFlagMap)) {
				appViewFlag = viewAppFlagMap.get(viewName);
			}
		}

		return appViewFlag;
	}

	/**
	 * Register view.
	 * 
	 * @param viewName
	 *            the view name
	 * @param appViewFlag
	 *            the app view flag
	 */
	protected static void registerView(String viewName, String appViewFlag) {
		if (StringUtils.isEmpty(viewName)) {
			return;
		}
		if (StringUtils.isEmpty(appViewFlag)) {
			appViewFlag = "";
		}

		if (CollectionUtils.isEmpty(viewAppFlagMap)) {
			initViewAppFlagMap();
		}

		viewAppFlagMap.put(viewName, appViewFlag);
	}

	/**
	 * Inits the view app flag map.
	 */
	private static void initViewAppFlagMap() {
		viewAppFlagMap =Collections.synchronizedMap(new HashMap<String, String>(
				VIEW_APP_FLAG_MAP_INIT_BUFFER));

	}
	

	/**
	 * Lookup mvc view name.
	 *
	 * @param appViewName the app view name
	 * @return the string
	 */
	public static String lookupMvcViewName(String appViewName) {
		String mvcViewName=appViewName;

		String appViewFlag = lookupAppViewFlag(appViewName);
		String appViewPrefix =appViewFlag+APP_VIEW_NAME_SEPARATOR;
		
		if(mvcViewName.startsWith(appViewPrefix)){
			mvcViewName= mvcViewName.substring(appViewPrefix.length());

		}

		logger.debug("=======>[Mvc-web-view-name]:" + mvcViewName);

		return mvcViewName;
	}

}
