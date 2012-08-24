<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="com.livedoor.flow_manager.IConstant.PageConstant"%>

<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<script src="js/sourceJs.js" type="text/javascript"></script>

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

<script language="JavaScript" type="text/javascript">
<!--
	function pdfReportDisplay() {
		var url = 'sourceSearchPdfReport.do?sourceName=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="sourceName"/>&inputUserId=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="inputUserId"/>&inputeDatetime=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="inputeDatetime"/>&updateUserId=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="updateUserId"/>&updateDatetime=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="updateDatetime"/>';
		var rvalue = window.open(url,
			"sourceSearchWindow",
			"width=700,height=650,scrollbars=yes");
 
	}
	
	function pdfDownload(){
	var url ="sourceSearchPdfReport.do?sourceName=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="sourceName"/>&inputUserId=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="inputUserId"/>&inputeDatetime=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="inputeDatetime"/>&updateUserId=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="updateUserId"/>&updateDatetime=<bean:write name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="updateDatetime"/> ";
			
			window.open('',
			"sourceSearchWindow",
			"width=700,height=650,scrollbars=yes,resizable");
			
			document.blankform.action = url;
			
			document.blankform.target = "sourceSearchWindow";
			document.blankform.submit();
	}
	
//-->
</script>

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
				<tr><td>
					<table border="0" cellpadding="5" cellspacing="1" align="center"
					 style="margin-top:10px; margin-bottom:15px;" width="560">
					<tr><td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff"><bean:message key="source.name"/></font></strong></td>
						<td bgcolor="#B2BECE">
							<logic:present name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" scope="request">
							<html:text  maxlength="30" name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="sourceName" size="20" />
							</logic:present>
							
							<logic:notPresent name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" scope="request">
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
							<logic:present name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" scope="request">
							<html:text maxlength="8" name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>"  property="inputeDatetime" size="10"/>（YYYYMMDD）
							</logic:present>
							
							<logic:notPresent name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" scope="request">
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
					
					<logic:present name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" scope="request">
					<html:text name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>"  maxlength="8" property="updateDatetime" size="10"/>（YYYYMMDD）
					</logic:present>
					
					<logic:notPresent name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" scope="request">
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
	<td></td>		
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
	
		<div>
		<input type="hidden"  name="ec_i"  value="ec" />
		<input type="hidden"  name="ec_eti" />
		<input type="hidden"  name="ec_ev" />
		<input type="hidden"  name="ec_efn" />
		<input type="hidden"  name="ec_crd"  value="25" />
		<input type="hidden"  name="ec_p"  value="1" />
		<input type="hidden"  name="pageCount"  value="25" />
		<input type="hidden"  name="contractAmount"  value="" />
		<input type="hidden"  name="eventSubmit_search"  value="11" />
		<input type="hidden"  name="toDate"  value="20080806" />
		<input type="hidden"  name="currencyPair"  value="" />
		<input type="hidden"  name="flag"  value="1" />
		<input type="hidden"  name="flag"  value="1" />
		
		<input type="hidden"  name="fromDate"  value="20080801" />
		<input type="hidden"  name="side"  value="" />
		<input type="hidden"  name="counterpartyID"  value="" />
		<input type="hidden"  name="method"  value="search" />
		<input type="hidden"  name="method"  value="search" />
		<input type="hidden"  name="orderMethod"  value="" />
		</div>

	
	
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
			<td bgcolor="#B2BECE"><bean:write name="source" property="updateDatetimeAsString"/></td>

		</tr>

		</logic:iterate>
		</logic:present>
		
	<%--================================--%>
	<%--=======		更新   删除	========--%>
	<%--================================--%>
	
		<tr><td colspan ="7"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>
		<tr align="center">
			
			<td colspan ="7">
			<input type="button" name="aSourceButton" value="添加" onclick="addSource()"/>
			&nbsp;&nbsp;
			<input type="button" name="uSourceButton" value="更新" onclick="updateSource()"/>
			&nbsp;&nbsp;
			<input type="button" name="dSourceButton" value="删除" onclick="delSource()"/>
			&nbsp;&nbsp;
			
<%--			<a href="#" onclick="pdfReportDisplay()"><img src="images/component/pdf.gif"  border="0" /></a>--%>
			<a href="javascript:pdfDownload()">
				<img src="images/component/pdf.gif"  border="0" />
			</a>
			
			</td>
			
			
		</tr>
		<tr><td colspan ="8"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>
		
		</form>
	</table>
	</td>
</tr>

<form name="blankform" method="get">

</form>

<table border="0" cellpadding="4" cellspacing="1" align="center" 
style="margin-top:10px; margin-bottom:15px;" width="800">






<tr>
	<td align="center">
	
	<%-- ================================== --%>
	<%-- ========= pager taglib =========== --%>
	<%-- ================================== --%>
	
	<form name="pagerform" action="pagerSource.do" method="get">
	
	<pg:pager  
		id="lu"
	  	scope="request"
		url="pagerSource.do"
		itemsKeyName="<%=PageConstant.PAGER_VIEW_KEY%>"
		itemskeyProperty="page.recordsCount"
		maxPageItemsKeyName="<%=PageConstant.PAGER_VIEW_KEY%>"
		maxPageItemsKeyProperty="page.pageSize"
		
	  	index = "center"
	  	isOffset = "true"
	  	export="offset,currentPageNumber=pageNumber"
		>
	  
	<%-- ================================== --%>
	<%-- Define the parameter which append             	--%>
	<%-- 	the Url with '?' and '&'        			--%>
	<%-- example:<name = paramKey>,<property = name>,   --%>
	<%--    	 <scope = request>,						--%>
	<%-- it's will get the parameter from the 'request' --%>
	<%-- and append your URL like this:                 --%>
	<%--     yourURL?name=nameValue&...                 --%>
	<%--        (if more than one param,union with '&') --%>
	<%-- ================================== --%>
	  	
	  <pg:param id="lu" scope="request" 
	  name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="sourceName"/>
	  
	  <pg:param id="lu" scope="request" 
	  name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="sourceFoodId"/>
		
	  <pg:param id="lu" scope="request" 
	  name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="inputUserId"/>
		
	  <pg:param id="lu" scope="request" 
	  name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="inputeDatetime"/>
		
	  <pg:param id="lu" scope="request" 
	  name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="updateUserId"/>
		
	  <pg:param id="lu" scope="request" 
	  name="<%=PageConstant.SOURCE_QUERY_OBJECT_KEY%>" property="updateDatetime"/>
	  
  	 
	<!-- It's necessary for this hidden component ,example: 50~60 display ,offset=50 -->  
	<input type="hidden" name="lu.offset" value="<%= offset %>">
		
 	<pg:index id="lu" export="total=itemCount,curPageCount=pageCount" >
	
	共<c:out value ="${curPageCount}"/>页   <c:out value="${total}"/>条 ,当前第<c:out value="${currentPageNumber}"/>页 
	
	<jsp:include page="/WEB-INF/jsp/pager/commonpager.jsp" flush="true"/>
	
	</pg:index>
	
	</pg:pager>	
	<br>

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