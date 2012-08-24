<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="com.livedoor.flow_manager.IConstant.PageConstant"%>
<%@ page import="com.livedoor.flow_manager.enums.RoleEnum"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<script src="js/sourceJs.js" type="text/javascript"></script>

<title>发兵查询</title>

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

</head>





<body>

<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">

<tr><td><div class="menu">
<strong>发兵查询</strong>
</div></td></tr>
<tr><td>
		<html:form action="soldier_source_query.do" method="post">
		
		<tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td></tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center" width="800">
				<tr><td align="left"><input type="button" style="width=100;" value="返回" onclick="javascript:window.location='returnMenu.do'"></td></tr>
				<tr><td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td></tr>
				<tr><td>
					<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="560">
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">发兵会员ID</font></strong></td>
							<td bgcolor="#B2BECE">
							
								<logic:notEqual name="USER_INFO" property="userRole" value="1">
									<bean:write name="USER_INFO" property="userName"/>
								</logic:notEqual>
								<logic:equal name="USER_INFO" property="userRole" value="1">
									<html:text  maxlength="30" name="USER_INFO" property="userName" size="20" />
								</logic:equal>						
							
							</td>
						</tr>

						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">发兵国家</strong></td>
							<td bgcolor="#B2BECE">
								<html:select property="kingdomId" style="width=162;" >
									<option value="">请选择</option>
									<logic:present name="KINGDOM_LIST" scope="request">
										<html:options collection="KINGDOM_LIST" property="kingdomId" labelProperty="kingdomName" />
									</logic:present>
								</html:select>
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">发兵种类</strong></td>
							<td bgcolor="#B2BECE">
								<html:select property="sourceSoldierId" style="width=162;" >
									<option value="">请选择</option>
									<logic:present name="SOLDIER_LIST" scope="request">
										<html:options collection="SOLDIER_LIST" property="soldierId" labelProperty="soldierName" />
									</logic:present>
								</html:select>
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">发兵日期</font></strong></td>
							<td bgcolor="#B2BECE">
								
								<html:text maxlength="8"  property="sourceDate" size="10"/>（YYYYMMDD 例如:2012年8月24日，则填入 20120824）

							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">审批状态</font></strong></td>
							<td bgcolor="#B2BECE">
								
								<html:select property="approved" style="width=162;" >
									<option value="">请选择</option>
									<option value="1">已审批</option>
									<option value="0">未审批</option>
								</html:select>

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
	
	
	<logic:present name="<%=PageConstant.PAGER_VIEW_KEY %>" scope="request">
		<bean:define id="pageTemplate" name="<%=PageConstant.PAGER_VIEW_KEY %>" scope="request"></bean:define>
	</logic:present>
	
	
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
			<td bgcolor="#5F52A0" nowrap  width="100"><strong><font color="#ffffff">会员君主名称</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="90"><strong><font color="#ffffff">发兵国家</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100"><strong><font color="#ffffff">发兵种类</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="90"><strong><font color="#ffffff">发兵数量</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="220"><strong><font color="#ffffff">发兵时间</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="220"><strong><font color="#ffffff">是否审批</font></strong></td>
		</tr>
	
		<logic:present name="pageTemplate" >
			<logic:iterate name="pageTemplate" property="items" id="source">
			<tr>
				<td bgcolor="#B2BECE"><input type="checkbox" name="sId" value='<bean:write name="source" property="sourceId" />'/></td>
				<td bgcolor="#B2BECE"><bean:write name="source" property="user.userDisplayName" /></td>
				<td bgcolor="#B2BECE"><bean:write name="source" property="kingdom.kingdomName"/></td>
				<td bgcolor="#B2BECE"><bean:write name="source" property="soldier.soldierName"/></td>
				<td bgcolor="#B2BECE"><bean:write name="source" property="sourceSoliderCount"/></td>
				<td bgcolor="#B2BECE"><bean:write name="source" property="sourceDate"/></td>
				<td bgcolor="#B2BECE">
				<logic:equal name="source" property="approved" value="1"><font color="#111010">已审批</font></logic:equal>
				<logic:equal name="source" property="approved" value="0"><font color="#a71010">未审批</font></logic:equal>
				</td>
			</tr>
			</logic:iterate>
		</logic:present>
		
	<%--================================--%>
	<%--=======		更新   删除	========--%>
	<%--================================--%>
	
		<tr><td colspan ="7"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>
		<tr align="center">
			
			<td colspan ="7">
			<input type="button" name="aSourceButton" value="审批" onclick="addSource()"/>
			&nbsp;&nbsp;
			<input type="button" name="uSourceButton" value="取消审批" onclick="updateSource()"/>
			&nbsp;&nbsp;
			<input type="button" name="dSourceButton" value="修改" onclick="delSource()"/>
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

<table border="0" cellpadding="4" cellspacing="1" align="center" 
style="margin-top:10px; margin-bottom:15px;" width="800">






<tr>
	<td align="center">
	
	<%-- ================================== --%>
	<%-- ========= pager taglib =========== --%>
	<%-- ================================== --%>
	
	<form name="pagerform" action="soldier_source_query.do" method="get">
	
	<pg:pager  
		id="lu"
	  	scope="request"
		url="soldier_source_query.do"
		itemsKeyName="<%=PageConstant.PAGER_VIEW_KEY%>"
		itemskeyProperty="page.recordsCount"
		maxPageItemsKeyName="<%=PageConstant.PAGER_VIEW_KEY%>"
		maxPageItemsKeyProperty="page.pageSize"
		
	  	index = "center"
	  	isOffset = "true"
	  	export="offset,currentPageNumber=pageNumber">
	  
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

</form>
	</td>
</tr>
</table>

</form>




</body>
</html>