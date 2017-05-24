package com.mi.dpay.core.mvc;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * The Class MvcAppViewResolver.
 */
public class MvcAppViewResolver implements ViewResolver {

	/** The Constant APP_VIEW_RESOLVER_MAP_INIT_BUFFER. */
	private static final int APP_VIEW_RESOLVER_MAP_INIT_BUFFER = 5;

	/** The logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(MvcAppViewResolver.class);

	/** The app view resolver map. */
	private Map<String, ViewResolver> appViewResolverMap;

	/**
	 * Instantiates a new mvc app view resolver.
	 */
	public MvcAppViewResolver() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang
	 * .String, java.util.Locale)
	 */
	public View resolveViewName(String appViewName, Locale locale)
			throws Exception {
		View resultView = null;

		ViewResolver mvcViewResolver = findMvcViewResolver(appViewName);

		String mvcViewName = findMvcViewName(appViewName);

		String msg = "";
		if (mvcViewResolver != null) {
			resultView = mvcViewResolver.resolveViewName(mvcViewName, locale);
			msg = mvcViewResolver.getClass().getName();
			if (null == resultView) {
				msg += ".But has not found the view!";

			}
		} else {
			msg = " has not found the view-resolver!";
		}
		logger.debug("=======>[Mvc-view-resolver]:" + msg);

		return resultView;
	}

	/**
	 * Find mvc view name.
	 * 
	 * @param appViewName
	 *            the app view name
	 * @return the string
	 */
	private String findMvcViewName(String appViewName) {
		return MvcAppViewInterceptor.lookupMvcViewName(appViewName);
	}

	/**
	 * Find mvc view resolver.
	 * 
	 * @param appViewName
	 *            the app view name
	 * @return the view resolver
	 */
	private ViewResolver findMvcViewResolver(String appViewName) {
		String appViewFlag = MvcAppViewInterceptor.lookupAppViewFlag(appViewName);
		return getAppViewResolverMap().get(appViewFlag);
	}

	/**
	 * Inits the app view resolver map.
	 */
	private void initAppViewResolverMap() {
		appViewResolverMap = new HashMap<String, ViewResolver>(
				APP_VIEW_RESOLVER_MAP_INIT_BUFFER);
	}

	/**
	 * Gets the app view resolver map.
	 * 
	 * @return the app view resolver map
	 */
	public Map<String, ViewResolver> getAppViewResolverMap() {
		if (CollectionUtils.isEmpty(appViewResolverMap)) {
			initAppViewResolverMap();
		}

		return appViewResolverMap;
	}

	/**
	 * Sets the app view resolver map.
	 * 
	 * @param appViewResolverMap
	 *            the app view resolver map
	 */
	public void setAppViewResolverMap(
			Map<String, ViewResolver> appViewResolverMap) {
		this.appViewResolverMap = appViewResolverMap;
	}

}
