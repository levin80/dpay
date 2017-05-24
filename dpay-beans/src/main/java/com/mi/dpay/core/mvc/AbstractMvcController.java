package com.mi.dpay.core.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

/**
 * The Class AbstractMvcController.
 * Description:
 * @version 1.0 2015-3-5 上午11:40:51 
 */

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractMvcController implements ServletContextAware,
		IMvcAppViewConnector {

	/** The Constant MESSAGES_KEY. */
	public static final String MESSAGES_KEY = "successMessages";

	/** The Constant ERRORS_KEY. */
	public static final String ERRORS_KEY = "errors";

	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory
			.getLogger(AbstractMvcController.class);

	/** The messages. */
	private MessageSourceAccessor messages;

	/** The servlet context. */
	private ServletContext servletContext;

	/**
	 * Instantiates a new abstract mvc controller.
	 */
	public AbstractMvcController() {
		super();
	}

	/**
	 * Sets the messages.
	 * 
	 * @param messageSource
	 *            the new messages
	 */
	@Autowired
	public void setMessages(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	/**
	 * Save error.
	 * 
	 * @param request
	 *            the request
	 * @param error
	 *            the error
	 */
	public void saveError(HttpServletRequest request, String error) {
		List errors = (List) request.getSession().getAttribute(ERRORS_KEY);
		if (errors == null) {
			errors = new ArrayList();
		}
		errors.add(error);
		request.getSession().setAttribute(ERRORS_KEY, errors);
	}

	/**
	 * Save message.
	 * 
	 * @param request
	 *            the request
	 * @param msg
	 *            the msg
	 */
	public void saveMessage(HttpServletRequest request, String msg) {
		List messages = (List) request.getSession().getAttribute(MESSAGES_KEY);

		if (messages == null) {
			messages = new ArrayList();
		}

		messages.add(msg);
		request.getSession().setAttribute(MESSAGES_KEY, messages);
	}

	/**
	 * Convenience method for getting a i18n key's value. Calling
	 * getMessageSourceAccessor() is used because the RequestContext variable is
	 * not set in unit tests b/c there's no DispatchServlet Request.
	 * 
	 * @param msgKey
	 *            the msg key
	 * @param locale
	 *            the current locale
	 * @return the text
	 */
	public String getText(String msgKey, Locale locale) {
		return messages.getMessage(msgKey, locale);
	}

	/**
	 * Convenient method for getting a i18n key's value with a single string
	 * argument.
	 * 
	 * @param msgKey
	 *            the msg key
	 * @param arg
	 *            the arg
	 * @param locale
	 *            the current locale
	 * @return the text
	 */
	public String getText(String msgKey, String arg, Locale locale) {
		return getText(msgKey, new Object[] { arg }, locale);
	}

	/**
	 * Convenience method for getting a i18n key's value with arguments.
	 * 
	 * @param msgKey
	 *            the msg key
	 * @param args
	 *            the args
	 * @param locale
	 *            the current locale
	 * @return the text
	 */
	public String getText(String msgKey, Object[] args, Locale locale) {
		return messages.getMessage(msgKey, args, locale);
	}

	/**
	 * Convenience method to get the Configuration HashMap from the servlet
	 * context.
	 * 
	 * @return the user's populated form from the session
	 */
	public Map getConfiguration() {
		Map config = (HashMap) servletContext.getAttribute("CONFIG");
		// so unit tests don't puke when nothing's been set
		if (config == null) {
			return new HashMap();
		}

		return config;
	}

	/**
	 * Set up a custom property editor for converting form inputs to real
	 * objects.
	 * 
	 * @param request
	 *            the current request
	 * @param binder
	 *            the data binder
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Integer.class, null,
				new CustomNumberEditor(Integer.class, null, true));
		binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(
				Long.class, null, true));
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}

	/**
	 * Sets the servlet context.
	 * 
	 * @param servletContext
	 *            the new servlet context
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * Gets the servlet context.
	 * 
	 * @return the servlet context
	 */
	protected ServletContext getServletContext() {
		return servletContext;
	}

}
