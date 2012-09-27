<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ page import="org.acegisecurity.Authentication" %>
<%@ page import="com.livedoor.flow_manager.IConstant.AuthenticationKeyConstant" %>
<%@ page import="import org.apache.log4j.Logger" %>

<%@ page  import="org.acegisecurity.GrantedAuthority" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>

</style>

</head>
<body>
<!-- Main-->

<%--	Authentication auth = SecurityContextHolder.getContext().getAuthentication();--%>
<%--	if (auth != null ) {--%>
<%--		GrantedAuthority[] gu= auth.getAuthorities();--%>
<%--		for(int i=0;i<gu.length;i++){--%>
<%--			GrantedAuthority gauth = gu[i];--%>
<%--			if(gauth.getAuthority()--%>
<%--				.equals(AuthenticationKeyConstant.ROLE_SUPERVISOR_KEY)){--%>
<%--				response.sendRedirect("/permission/admin/adminmenuindex.jsp");--%>
<%--			}--%>
<%--		}--%>
<%--	}--%>
<% 	
	Logger  LOGGER = Logger.getLogger(this.class);
	//SecurityContextHolder.getContext()
	LOGGER.info("SECURITY_CONTEXT:"+session.getAttribute("ACEGI_SECURITY_CONTEXT"));
	session.setAttribute("ACEGI_SECURITY_CONTEXT",null);
	LOGGER.info(session.getAttribute("ACEGI_SECURITY_LAST_USERNAME"));
	LOGGER.info("--------------------->session is invalidate()");
	//session.invalidate();
	response.sendRedirect("/permission/login_acegi.jsp");

%>
<!-- /Main-->
</body>
<script>
//window.close();
//window.open('http://localhost:8100/permission/login_acegi.jsp');
</script>
</html>
