<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="com.livedoor.flow_manager.IConstant.PageConstant"%>
<%@ page import="com.livedoor.flow_manager.tools.lbq.Page"%>
<%@ page import="com.livedoor.flow_manager.tools.lbq.PageTemplate"%>

<%--@ page import="com.livedoor.flow_manager.sources.beans.SourcePageInfoBean"--%>
<%@ include file="/common/taglibs.jsp" %>
<jsp:useBean id="currentPageNumberInt" type="java.lang.Integer" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="cn">
<head>
<%@ include file="/common/meta.jsp" %>

<title>资源查询</title>
<style type="text/css"><!--
body{background:#ffffff;background-image:url("img/background.gif");background-attachment:scroll;background-repeat:repeat-x;}
a:link{color:#000000;}
a:hover{color:#999999;text-decoration:none;}
a.blue:link{color:#3366cc;}
a.blue:hover{color:#999999;text-decoration:none;}
a.white:link{color:#ffffff;}
a.white:hover{color:#999999;text-decoration:none;}
.ldfbg{background:#dcdcdc;}
div{font-size:10pt;text-align:center;}
td{font-size:10pt;}
.menu{font-size:15pt;text-align:center;}
.right{text-align:right;}
-->
</style>
<script src="js/sourceJs.js" type="text/javascript"></script>

</head>
<body>

<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">

<tr><td><div class="menu">
<strong><bean:message key="source.searchpage.tittle"/></strong>
</div></td></tr>
<tr><td>
		<html:form action="querySource.do" method="post">
		
		<tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td></tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center" width="800">
				<tr><td align="left"><input type="button" style="width=100;" value="返回" onclick="javascript:window.location='returnMenu.do'"></td></tr>
				<tr><td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td></tr>
				<tr>
					<td>
					<table border="0" cellpadding="5" cellspacing="1" align="center"
					 style="margin-top:10px; margin-bottom:15px;" width="560">
				
				
					<tr>
						<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff"><bean:message key="source.name"/></font></strong></td>
						<td bgcolor="#B2BECE">
						
							<logic:present name="QUERY_SOURCE_OBJECT" scope="request">
							<html:text  maxlength="30" name="QUERY_SOURCE_OBJECT" property="sourceName" size="20" />
							</logic:present>
							
							<logic:notPresent name="QUERY_SOURCE_OBJECT" scope="request">
							<html:text  maxlength="30" property="sourceName" size="20" />
							</logic:notPresent>
							
							(xxx形式&nbsp;例xxx）
						</td>
					</tr>
				
					<tr>
						<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff"><bean:message key="source.desc"/></strong></td>
						<td bgcolor="#B2BECE">
	
	
							<html:select property="sourceFoodId" style="width=162;" >
								<option value="">请选择</option>
								<logic:present name="SOURCE_FOOD" scope="request">
									<html:options collection="SOURCE_FOOD" property="foodId" labelProperty="foodName" />
								</logic:present>
							</html:select>
						</td>
					</tr>
				
					<tr>
						<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">资源创建者</font></strong></td>
						<td bgcolor="#B2BECE">
							<html:select property="inputUserId" style="width=162;" >
								<option value="">请选择</option>
								<logic:present name="INSERT_USER" scope="request">
									<html:options collection="INSERT_USER" property="userId" labelProperty="userName" />
								</logic:present>
							</html:select>
						</td>
					</tr>
				
				
				
				<tr>
					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">资源创建日期</font></strong></td>
					<td bgcolor="#B2BECE">
					<logic:present name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text maxlength="8" name="QUERY_SOURCE_OBJECT"  property="inputeDatetime" size="10"/>（YYYYMMDD）
					</logic:present>
					
					<logic:notPresent name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text maxlength="8"  property="inputeDatetime" size="10"/>（YYYYMMDD）
					</logic:notPresent>
					
					<font color="red">
					<html:messages property="source-inputTime" message="true" id="msg"> 
                    	<bean:write name="msg"/>
          			</html:messages> 
					</font>
					
					</td>
				</tr>
				
			
				
				<tr>
					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">资源修改者</font></strong></td>
					<td bgcolor="#B2BECE">
						<html:select property="updateUserId" style="width=162;" >
							<option value="">请选择</option>
							<logic:present name="UPDATE_USER" scope="request">
								<html:options collection="UPDATE_USER" property="userId" labelProperty="userName" />
							</logic:present>
						</html:select>
					
					</td>
				</tr>
				
				<tr>
					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">资源修改日期</font></strong></td>
					<td bgcolor="#B2BECE">
					
					<logic:present name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text name="QUERY_SOURCE_OBJECT"  maxlength="8" property="updateDatetime" size="10"/>（YYYYMMDD）
					</logic:present>
					
					<logic:notPresent name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text maxlength="8" property="updateDatetime" size="10"/>（YYYYMMDD）
					</logic:notPresent>
					
					<font color="red">
					<html:messages property="source-updateTime" message="true" id="msg"> 
                    	<bean:write name="msg"/>
          			</html:messages>
					</font>
					
					</td>
				</tr>
				
				
				
			</table>
		</td>
		</tr>
		
		<tr>
			<td align="center"><html:submit  style="width=150;" value="查询"/></td>
		</tr>
		
		
		<tr>
			<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
		</tr>
		
		</table>
		</td>
		</tr>
		</table>
		
		</html:form>
	</td>
</tr>





<tr>
	<td>&nbsp;</td>		
			
			<td></td>
			<td>
	<table border="0" cellpadding="4" cellspacing="1" align="center" 
	style="margin-top:10px; margin-bottom:15px;" width="800">
	
	<%-- ================================ --%>
	<%-- ========= bean define=========== --%>
	<%-- ================================ --%>
	
	<bean:define id="pageTemplate" name="<%=PageConstant.PAGER_VIEW_KEY %>" scope="request"></bean:define>
	
	<%-- ================================ --%>
	
		<form name="middleform">

		<tr>
			<td bgcolor="#5F52A0" nowrap  width="50"><strong><font color="#ffffff"><input type="checkbox" name="allchecked" onclick="checkedAll()"></font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="150"><strong><font color="#ffffff"><bean:message key="source.name"/></font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100"><strong><font color="#ffffff"><bean:message key="source.desc"/></font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="90"><strong><font color="#ffffff"><bean:message key="source.price"/></font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100"><strong><font color="#ffffff"><bean:message key="source.count"/></font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="90"><strong><font color="#ffffff"><bean:message key="source.sum"/></font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="220"><strong><font color="#ffffff"><bean:message key="source.updatetime"/></font></strong></td>
		</tr>
	
		<logic:present name="pageTemplate" >

		<logic:iterate name="pageTemplate" property="items" id="source">
		<tr>
			<td bgcolor="#B2BECE"><input type="checkbox" name="sId" value='<bean:write name="source" property="sourceId" />'/></td>
			<td bgcolor="#B2BECE"><bean:write name="source" property="sourceName" /></td>
			<td bgcolor="#B2BECE"><bean:write name="source" property="sourceFoodName"/></td>
			<td bgcolor="#B2BECE"><bean:write name="source" property="sourceFoodPriceString"/></td>
			<td bgcolor="#B2BECE"><bean:write name="source" property="sourceFoodCount"/></td>
			<td bgcolor="#B2BECE"><bean:write name="source" property="sourceFoodSum"/></td>
			

<%--			<td bgcolor="#B2BECE"><bean:write name="source" property="inputUserName"/></td>--%>
<%--			<td bgcolor="#B2BECE"><bean:write name="source" property="inputeDatetimeAsString"/></td>--%>
<%--			<td bgcolor="#B2BECE"><bean:write name="source" property="updateUserName"/></td>--%>
			<td bgcolor="#B2BECE"><bean:write name="source" property="updateDatetimeAsString"/></td>
			
			
			
			
		</tr>

		</logic:iterate>
		</logic:present>
		
<%--===============================================================================--%>
<%--===============================		更新   删除	===============================--%>
<%--===============================================================================--%>
			<tr><td colspan ="8"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>
			<tr align="center"><td colspan ="8"><input type="button" name="uSourceButton" value="更新" onclick="updateSource()"/>&nbsp;
												
												<input type="button" name="dSourceButton" value="删除" onclick="delSource()"/>
								</td>
			</tr>
			<tr><td colspan ="8"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>
		</form>
	</table>
	</td>
</tr>


<table border="0" cellpadding="4" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="800">





<form name="bottomform">
<tr>
	<td align="center">
	
	<%-- ================================== --%>
	<%-- ========= pager taglib =========== --%>
	<%-- ================================== --%>
	
<%--	<pg:pager  --%>
<%--		id="lu"--%>
<%--		items="<%= ((PageTemplate)request.getAttribute(PageConstant.PAGER_VIEW_KEY))--%>
<%--										.getPage().getRecordsCount()%>"--%>
<%--	  	index = "center"	--%>
<%--	  	maxPageItems="<%= ((PageTemplate)request.getAttribute(PageConstant.PAGER_VIEW_KEY))--%>
<%--	  									.getPage().getPageSize()%>"--%>
<%--	  	isOffset = "false"--%>
<%--	  	export="currentPageNumber=pageNumber"--%>
<%--	  	scope="request">--%>
	<pg:pager  
		id="lu"
	  	scope="request"
		url="/pagerSource.do"
		itemsKeyName="<%=PageConstant.PAGER_VIEW_KEY%>"
		itemskeyProperty="page.recordsCount"
		maxPageItemsKeyName="<%=PageConstant.PAGER_VIEW_KEY%>"
		maxPageItemsKeyProperty="page.pageSize"
		
	  	index = "center"	
	  	isOffset = "true"
	  	export="offset,currentPageNumber=pageNumber"
		>
	<input type="hidden" name="pager.offset" value="<%= offset %>">
		
 	<pg:index id="lu" export="total=itemCount,curPageCount=pageCount" >
	
	共<c:out value ="${curPageCount}"/>页   <c:out value="${total}"/>条 
	
	<jsp:include page="/WEB-INF/jsp/altavista.jsp" flush="true"/>
	
	<pg:page id="lu" export="firstItem,lastItem">
	
	当前第 <c:out value="${currentPageNumber}"/> 页    <c:out value="${firstItem}"/> - <c:out value="${lastItem}"/> 条
	</pg:page>
	
	
	<pg:first id="lu" ><a href="sourceQueryFirstPage.do?pageNo=1
										&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
										&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
										&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
										&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
										&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
										">首页</a>
		
	</pg:first> 
	
	<pg:prev ifnull="true" id="lu"><a href="sourceQueryPreviousPage.do?pageNo=<c:out value="${currentPageNumber-1}"/>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									">上一页</a>
	</pg:prev> 
	
	<pg:pages id="lu" export="curPageNumber=pageNumber,firstItem,lastItem">
		
		
		<%if (pageNumber == currentPageNumberInt) {%>
			<font color="red"><c:out value="${curPageNumber}" /></font> 
		<% }%>

		<%if(curPageNumber.intValue() != currentPageNumber.intValue()){ %>
		
			<a href="sourceQueryAssignPage.do?pageNo=<c:out value="${curPageNumber}"/>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									"><c:out value="${curPageNumber}"/>#</a> 
		
		<% }%>
 	</pg:pages>
	
	
	<pg:next id="lu" ><a href="sourceQueryNextPage.do?pageNo=<c:out value="${pgnumber+1}"/>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									">下页</a>
	</pg:next> 
	<pg:last id="lu" ><a href="sourceQueryLastPage.do?pageNo=<c:out value="${curPageCount}"/>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									">尾页</a>
	</pg:last> 

	
	
	</pg:index>
	
	</pg:pager>	

<br>

	
<hr>	
<%-- ==============================================================--%>
	<logic:present name="<%= PageConstant.PAGER_VIEW_KEY%>" >
	共 		<bean:write name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.pageCount"/> 页 &nbsp;&nbsp;
	表示：	<bean:write name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.recordsCount"/>  条中&nbsp;
			<bean:write name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.beginIndex" /> - 
		 	<bean:write name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.endIndex"/> 条
		 	&nbsp;&nbsp;&nbsp;&nbsp;
	
	

	
	<logic:equal name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasPrePage" value="false">
	首页
	</logic:equal>
	<logic:notEqual name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasPrePage" value="false">
	<a href="sourceQueryFirstPage.do?pageNo=1
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									"
	>首页</a>
	</logic:notEqual>
	
	
	
	<logic:equal name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasPrePage" value="false">
	上一页
	</logic:equal>
	<logic:notEqual name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasPrePage" value="false">
	<a href="sourceQueryPreviousPage.do?pageNo=<c:out value="${pageTemplate.page.currentPageNumber - 1 }"></c:out>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									"
	
	>上一页</a>
	</logic:notEqual>
	
	
	
	<logic:greaterThan name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.pageCount" value="0">
	<c:forEach begin="1" end="${pageTemplate.page.pageCount }" var="iter">
		<c:if test="${iter==pageTemplate.page.currentPageNumber}" >
			<c:out value="${iter}"></c:out>
		</c:if>
		<c:if test="${iter!=pageTemplate.page.currentPageNumber}">
			<a href="sourceQueryAssignPage.do?pageNo=<c:out value="${iter}"></c:out>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									"
	
			
			
			>[<c:out value="${iter}"/>]</a>
		</c:if>
<%--		<a href="showSourceSearch.do?pageNo=<c:out value="${iter}"></c:out>">[<c:out value="${iter}"/>]</a>--%>
	</c:forEach>
	</logic:greaterThan>
	
	
	
	<logic:equal name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasNextPage" value="false">
	下一页
	</logic:equal>
	<logic:notEqual name="pageTemplate" property="page.hasNextPage" value="false">
	<a href="sourceQueryNextPage.do?pageNo=<c:out value="${pageTemplate.page.currentPageNumber + 1 }"></c:out>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									"
	
			
	>下一页</a>
	</logic:notEqual>

	<logic:equal name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasNextPage" value="false">
	尾页
	</logic:equal>
	<logic:notEqual name="<%= PageConstant.PAGER_VIEW_KEY%>" property="page.hasNextPage" value="false">
	<a href="sourceQueryLastPage.do?pageNo=<bean:write name="pageTemplate" property="page.pageCount"/>
									&sourceName=<bean:write name="QUERY_SOURCE_OBJECT" property="sourceName"/>
									&inputUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="inputUserId"/>
									&inputeDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="inputeDatetime"/>
									&updateUserId=<bean:write name="QUERY_SOURCE_OBJECT" property="updateUserId"/>
									&updateDatetime=<bean:write name="QUERY_SOURCE_OBJECT" property="updateDatetime"/>
									"
	
	
	
	
	>尾页</a>
	</logic:notEqual>

	</logic:present>
	
	
<%-- ==============================================================--%>
	</td>
</tr>
</form>
</table>
<tr>
	<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
</tr>

</table>





</body>
</html>