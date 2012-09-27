package com.livedoor.flow_manager.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//import com.sun.corba.se.internal.core.Response;

public class URLEncodingFilter implements Filter {
	
	private String encoding = null;
	private String ConfigUsername = null; 
	
	protected FilterConfig filterConfig = null; 
	
	public void init(FilterConfig fc) throws ServletException {
		this.filterConfig = fc;
		this.encoding = filterConfig.getInitParameter("encoding"); 
		this.ConfigUsername = filterConfig.getInitParameter("username");
//		System.out.println("TestFilter filter init==============================-=================>");
	}
	
	public void doFilter(ServletRequest req, 
							ServletResponse res,
							FilterChain chain)
				throws IOException, ServletException {
		
		String encoding = selectEncoding(req);
		if (encoding != null){
			req.setCharacterEncoding(encoding);
		}
//		---------------------
		if(ConfigUsername != null) { 
			String username=((HttpServletRequest)req).getParameter("username");
//			System.out.println("username :"+username);
//			System.out.println("ConfigUsername :"+ConfigUsername);
			if(username!=null && username.equals(ConfigUsername)){
//				System.out.println("filter done!");
				res.setContentType("text/html;charset");
				PrintWriter out = res.getWriter();
				out.print("<html><body>username is  only you !</body></html>");
				out.flush();
				return;
			}
		}
		
		chain.doFilter(req, res);
		
		
	}
	
	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}
	
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
		
	}
}

