<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="com.livedoor.flow_manager.IConstant.PageConstant"%>
<%@ page import="com.livedoor.flow_manager.enums.RoleEnum"%>
<%@ page import="com.livedoor.flow_manager.IConstant.AttributeKeyConstant"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<script src="js/sourceJs.js" type="text/javascript"></script>

<title>宝石分配信息</title>

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
<strong>宝石分配信息</strong>
</div></td></tr>
<tr><td>
		<html:form action="gem_source_distribution_query.do" method="post">
		
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
								<strong><font color="#ffffff">产生宝石时间</font></strong></td>
							<td bgcolor="#B2BECE">
											
								<html:select property="sourceGemDate" style="width=162;" >
									<logic:present name="GEM_SOURCE_DATE_LIST" scope="request">
										<html:options collection="GEM_SOURCE_DATE_LIST" property="value" labelProperty="label"/>
									</logic:present>
								</html:select>
							
							
							
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
	
		<form name="gem_source_distribution_query.do">
	
		<tr>
			
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">国家</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">日期</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">君主</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">枪盾</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">大刀</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">骑兵</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">重甲</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">产生宝石分</font></strong></td>
		</tr>
	
<!--		<logic:present name="GEM_SOURCE_LIST" >-->
<!--			<logic:iterate name="GEM_SOURCE_LIST"  id="source" indexId="indexid">-->
<!--			<% if(indexid % 2 != 0){%> 从1开始编号-->
<!--			<tr bgcolor="#e4e7ea">-->
<!--			<%}else { %>-->
<!--			<tr bgcolor="#B2BECE">-->
<!--			<%} %>-->
<!--				<td align="center"><bean:write name="source" property="kongdomName" /></td>-->
<!--				<td align="center"><bean:write name="source" property="gemSourceDate"/></td>-->
<!--				<td align="center"><bean:write name="source" property="xiuluoSum"/></td>-->
<!--				<td align="center"><bean:write name="source" property="benleiSum"/></td>-->
<!--				<td align="center"><bean:write name="source" property="fangyuSum"/></td>-->
<!--				<td align="center"><bean:write name="source" property="jifengSum"/></td>-->
<!--				<td align="center"><bean:write name="source" property="fuzaiSum"/></td>-->
<!---->
<!--			</tr>-->
<!--			</logic:iterate>-->
<!--		</logic:present>-->
		
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
	
	
	</td>
</tr>
</table>

</form>




</body>
</html>