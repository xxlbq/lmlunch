<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>

<html>
<head>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<title><decorator:title default="top..." /></title>
<link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css">
<decorator:head />
</head>

<body
<decorator:getProperty property="body.onload" writeEntireProperty="true" />>
<table border="0" cellspacing="0" cellpadding="0" class="logo">
  <tr>
    <td></td>
  </tr>
</table>
<admin:authmenu action="" layers=""></admin:authmenu>
<decorator:body />
</body>
</html>