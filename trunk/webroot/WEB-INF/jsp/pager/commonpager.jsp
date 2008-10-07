<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page session="false" %>

<%--@ page import="com.livedoor.flow_manager.sources.beans.SourcePageInfoBean"--%>
<%@ include file="/common/taglibs.jsp" %>
<jsp:useBean id="currentPageNumber" type="java.lang.Integer" scope="request"/>

	<pg:first id="lu" export="first,pageUrl">
	<a href="<%= pageUrl %>&pageNo=1">Ê×Ò³</a>
	</pg:first> 
	
	<pg:prev  id="lu" export="first,pageUrl">
	<a href="<%= pageUrl %>&pageNo=<c:out value="${currentPageNumber-1}"/>">ÉÏÒ»Ò³</a>
	</pg:prev> 
	
	<pg:pages id="lu" export="first,pageNumber,pageUrl">
		
		<%if (pageNumber == currentPageNumber) {%>
  <b><%= pageNumber %></b>
  <%
  } else {%>
<%--  <a href="<%= pageUrl %>"><%= pageNumber %></a>--%>
  
  <a href="<%= pageUrl %>&pageNo=<c:out value="${pageNumber}"/>">
  <c:out value="${pageNumber}"/>#</a> 
  <%}%>
		
	
 	</pg:pages>

	<pg:next id="lu"  export="first,pageUrl">
	<a href="<%= pageUrl %>&pageNo=<c:out value="${currentPageNumber+1}"/>">ÏÂÒ³</a>
	</pg:next> 
	
	<pg:last id="lu"  export="first,pageUrl,lastNumber=pageNumber">
	<a href="<%= pageUrl %>&pageNo=<c:out value="${lastNumber}"/>">Î²Ò³</a>
	</pg:last> 
