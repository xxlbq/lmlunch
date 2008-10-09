package com.livedoor.flow_manager.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import com.sun.corba.se.internal.core.Response;

public class FrameSetSessionFilter implements Filter {
	private  Logger logger = Logger.getLogger(this.getClass());
	
	private String headerKey = null;
	private String headerValue = null; 
	
	protected FilterConfig filterConfig = null; 
	
	public void init(FilterConfig fc) throws ServletException {
		this.filterConfig 	= fc;
		this.headerKey 		= filterConfig.getInitParameter("responseHeaderKey"); 
		this.headerValue 	= filterConfig.getInitParameter("responseHeaderValue");
		logger.info("FrameSetSessionFilter  init ==============>");
		logger.info("headerKey  init :==>"+headerKey);
		logger.info("headerKey  init :==>"+headerValue);
	}
	
	public void doFilter(ServletRequest req, 
							ServletResponse res,
							FilterChain chain)
				throws IOException, ServletException {

		
		//
//		if(StringUtils.isNotEmpty(headerKey)
//				&& StringUtils.isNotEmpty(headerValue)){
//		
//			((HttpServletResponse)res)
//				.addHeader(headerKey, headerValue);
//		}
//		
//		chain.doFilter(req, res);
		
		
		
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

//		response.setHeader("P3P","CP=CAO PSA OUR");
		response.addHeader("P3P","CP=CAO PSA OUR");
		chain.doFilter(request, response);
	}
	
	
	public void destroy() {
		this.headerKey 		= null;
		this.headerValue 	= null;
		this.filterConfig 	= null;
	}
	
}

