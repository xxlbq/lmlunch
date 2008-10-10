<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="org.acegisecurity.ui.rememberme.TokenBasedRememberMeServices" %>
<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%
System.out.println(" this is test");
session.invalidate();
SecurityContextHolder.getContext().setAuthentication(null);
Cookie terminate = new Cookie(TokenBasedRememberMeServices.ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE_KEY, null);
terminate.setMaxAge(0);
response.addCookie(terminate);
//response.sendRedirect(request.getContextPath()+"/");
%>



<html>
<head>
<title>logout page ! </title>
</head>
<body>
<P>this is test of <code>(body)</code> <font color="red">logout page ! </P>
</body>
</html>