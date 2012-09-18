package com.livedoor.flow_manager.tools;

import javax.servlet.http.HttpServletRequest;

public class SystemTools {
	
	public static final Integer SAME_IP_MAX_REG = 5 ;
	
	
	public static String getIpAddr(HttpServletRequest request) {   
	    String ip = request.getHeader("x-forwarded-for");   
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	        ip = request.getHeader("Proxy-Client-IP");   
	    }   
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	        ip = request.getHeader("WL-Proxy-Client-IP");   
	    }   
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	        ip = request.getRemoteAddr();   
	    }   
	    return ip;   
	}  
}
