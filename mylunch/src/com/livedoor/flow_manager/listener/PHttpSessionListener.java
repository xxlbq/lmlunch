package com.livedoor.flow_manager.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class PHttpSessionListener implements HttpSessionListener{
	
	protected transient final Logger logger =
		Logger.getLogger(this.getClass());
	
//	public void sessionCreated(HttpSessionEvent sEvent) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void sessionDestroyed(HttpSessionEvent sEvent) {
//		// TODO Auto-generated method stub
//		
//	}
	

	private static int timeout;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		
		if (timeout > 0)
			event.getSession().setMaxInactiveInterval(timeout);
		logger.info("CsSessionListener: session Created ->id:"+event.getSession().getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("CsSessionListener: session Destroyed ->id:"+event.getSession().getId());
//		delLoginOperator(event.getSession());
	}

	/**
	 * 获取全局loginMap，该全局变量存放了当前已登录用户及对应Session的Map。
	 * 
	 * @param session
	 * @return loginMap
	 */
//	public static Map getLoginMap(HttpSession session) {
//		ServletContext context = session.getServletContext();
//		Map loginMap = (Map) context.getAttribute(Constants.CONTEXT_LOGIN_MAP);
//
//		if (loginMap == null) {
//			loginMap = Collections
//					.synchronizedMap(new HashMap<String, HttpSession>());
//			context.setAttribute(Constants.CONTEXT_LOGIN_MAP, loginMap);
//		}
//
//		return loginMap;
//	}

	/**
	 * 把csId和当前的session加入loginMap中
	 * 
	 * @param request
	 * @throws AdminServiceException
	 */
//	@SuppressWarnings("unchecked")
//	public static void addLoginOperator(HttpServletRequest request)
//			throws Exception {
//		HttpSession session = request.getSession();
//		User user = (User) session
//				.getAttribute(AttributeKeyConstant.USER_INFO_KEY);
//		if (user == null)
//			throw new AdminServiceException(
//					AdminServiceException.NOT_LOGIN_ERROR,
//					"addLoginOperator Error: No User Login in this session");
//		String csId = user.getCsId();
//
//		String ip = request.getRemoteAddr();
//		session.setAttribute(Constants.SESSION_IP, ip);
//
//		Map loginMap = getLoginMap(session);
//
//		// if (loginMap.containsKey(csId)) {
//		// HttpSession se = (HttpSession)loginMap.get(csId);
//		// loginMap.remove(csId);
//		// se.invalidate()
//		// }
//
//		loginMap.put(csId, session);
//	}

	/**
	 * 把csId和当前的session从loginMap中移除
	 * 
	 * @param session
	 * @throws AdminServiceException
	 */
//	public static void delLoginOperator(HttpSession session) {
//		JhfCsOperator user = (JhfCsOperator) session
//				.getAttribute(Constants.CS_LOGIN_SESSION_KEY);
//		if (user == null)
//			return;
//		String csId = user.getCsId();
//
//		Map loginMap = getLoginMap(session);
//
//		if (session == loginMap.get(csId))
//			loginMap.remove(csId);
//	}
}
