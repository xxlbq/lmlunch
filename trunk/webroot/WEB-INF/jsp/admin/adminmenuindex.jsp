<%@ page language="java" contentType="text/html; charset=UTF-8" session="true"%>
    
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html:html>
<% response.addHeader("P3P","CP=CAO PSA OUR");%>

<head>
<meta name="description" content="权限管理">
<title>权限管理</title>
<style type="text/css">
<!--
.style1 {color: #000000}
-->
</style>
</head>
<%--    <html:frame frameborder="0"  frameName="carnoc"  noresize="false" styleId="carnoc"--%>
<%--    	href="/admin/adminleft.jsp" style="HEIGHT: 100%; VISIBILITY: inherit;WIDTH: 170px; Z-INDEX: 2">--%>
<%--    </html:frame>--%>
	
<%--	    <iframe frameBorder="0" id="carnoc" name="carnoc" scrolling="no"  --%>
<%--	    	src="/admin/adminleft.jsp" style="HEIGHT: 100%; VISIBILITY: inherit;WIDTH: 170px; Z-INDEX: 2">--%>
<%--	    </iframe>--%>
<%--	    <iframe frameBorder="0" id="carnoc" name="carnoc" scrolling="no"  --%>
<%--	    	src="left.do" style="HEIGHT: 100%; VISIBILITY: inherit;WIDTH: 170px; Z-INDEX: 2">--%>
<%--	    </iframe>--%>




<%--    <html:frame  frameborder="0" frameName="main"  noresize="false"  --%>
<%--    	href="/introduce.html" styleId="main">--%>
<%--	</html:frame>--%>

<%--	    <iframe frameBorder="0" id="main" name="main" scrolling="no" --%>
<%--	    	src="/introduce.html" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1">--%>
<%--	    </iframe>--%>
<%--	    <iframe frameBorder="0" id="main" name="main" scrolling="no" --%>
<%--	    	src="main.do" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1">--%>
<%--	    </iframe>--%>

  <frameset cols="225,*" frameborder="no" border="0" framespacing="0">
    <frame src="left.do" name="left" id="left" title="leftFrame" scrolling="yes" noresize="noresize"  />
    <frame src="main.do" name="main" id="main" title="mainFrame" scrolling="yes" noresize="noresize" />
    


<%--    <html:frame frameborder="0"  frameName="carnoc"  noresize="false" styleId="carnoc"--%>
<%--    	href="left.do" style="HEIGHT: 100%; VISIBILITY: inherit;WIDTH: 170px; Z-INDEX: 2">--%>
<%--    </html:frame>--%>
<%----%>
<%--        <html:frame  frameborder="0" frameName="main"  noresize="false"  --%>
<%--    	href="main.do" styleId="main">--%>
<%--    	</html:frame>--%>
  </frameset>
<body style="MARGIN: 0px" scroll=no 
>
</body>

</html:html>

