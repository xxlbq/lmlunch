<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ page import="org.acegisecurity.ui.AbstractProcessingFilter" %>
<%@ page import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.acegisecurity.AuthenticationException" %>
<%@ taglib prefix="c" uri="/WEB-INF/conf/tld/c.tld" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
</head>
<body>
	<p>This is error page !</p>
	<br></br>
	<p>error message <strong><%=request.getParameter("error") %></strong></p>
	<br><a href="logout.do">注销</a></br>

</body>
</html:html>