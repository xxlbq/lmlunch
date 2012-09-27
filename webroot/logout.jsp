<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="org.acegisecurity.ui.rememberme.TokenBasedRememberMeServices" %>
<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ page import="import org.apache.log4j.Logger" %>
<%
Logger  LOGGER = Logger.getLogger(this.class);
LOGGER.info(" this is test");
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