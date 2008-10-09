package com.livedoor.flow_manager.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lm.common.util.str.StringCommonUtil;

public abstract class BaseAction extends DispatchAction {

	protected  Logger logger = Logger.getLogger(getClass());

	protected void logInfo(Object obj) {
		if (logger.isInfoEnabled()) {
			logger.info(ObjectUtils.toString(obj, "-->NULL<--"));
		}
		
		
	}

	protected void logDebug(Object obj) {
		if (logger.isDebugEnabled()) {
			logger.debug(ObjectUtils.toString(obj, "-->NULL<--"));
		}
	}

	protected void logWarn(Object obj) {
		logger.warn(ObjectUtils.toString(obj, "-->NULL<--"));
	}

	protected Object getSessionObject(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
	}

	protected Object getRequestObject(HttpServletRequest req, String key) {
		return req.getAttribute(key);
	}

	protected String getRequestParameter(HttpServletRequest req, String key) {
		return req.getParameter(key);
	}

	protected void setSessionObject(HttpServletRequest req, String key,
			Object value) {
		req.getSession().setAttribute(key, value);
	}

	protected void setRequestObject(HttpServletRequest req, String key,
			Object value) {
		req.setAttribute(key, value);
	}

	protected String getMethodName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			String parameter) throws Exception {
		// Identify the method name to be dispatched to.
		// dispatchMethod() will call unspecified() if name is null
		if (StringCommonUtil.isNotEmpty(parameter))
			return parameter;
		return request.getParameter(parameter);
	}

}
