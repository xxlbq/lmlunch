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

<title>宝石查询</title>

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
<strong>宝石查询</strong>
</div></td></tr>
<tr><td>
		<html:form action="gem_source_query.do" method="post">
		
		<tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td></tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center" width="800">
				<tr><td align="left"></td></tr>
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
<!--						<tr>-->
<!--							<td bgcolor="#5F52A0" nowrap align="right">-->
<!--								<strong><font color="#ffffff">发兵国家</strong></td>-->
<!--							<td bgcolor="#B2BECE">-->
<!--								<html:select property="kingdomId" style="width=162;" >-->
<!--									<option value="">请选择</option>-->
<!--									<logic:present name="KINGDOM_LIST" scope="request">-->
<!--										<html:options collection="KINGDOM_LIST" property="kingdomId" labelProperty="kingdomName" />-->
<!--									</logic:present>-->
<!--								</html:select>-->
<!--							</td>-->
<!--						</tr>-->
						
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
	
		<tr>
			
			<td bgcolor="#5F52A0" nowrap  width="30" align="center"><strong><font color="#ffffff">国家</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">日期</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">2级修罗宝石</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">2级奔雷宝石</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">2级防御宝石</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">2级疾风宝石</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">2级负载宝石</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">宝石总分</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">税后宝石总分(<bean:write name="RATIO_DISPLAY"/>)</font></strong></td>
		</tr>
	
		<logic:present name="GEM_SOURCE_LIST" >
			<logic:iterate name="GEM_SOURCE_LIST"  id="source" indexId="indexid">
			<% if(indexid % 2 != 0){%> <!--从1开始编号-->
			<tr bgcolor="#e4e7ea">
			<%}else { %>
			<tr bgcolor="#B2BECE">
			<%} %>
				<td align="center"><bean:write name="source" property="kongdomName" /></td>
				<td align="center"><bean:write name="source" property="gemSourceDate"/></td>
				<td align="center"><bean:write name="source" property="xiuluoSum"/></td>
				<td align="center"><bean:write name="source" property="benleiSum"/></td>
				<td align="center"><bean:write name="source" property="fangyuSum"/></td>
				<td align="center"><bean:write name="source" property="jifengSum"/></td>
				<td align="center"><bean:write name="source" property="fuzaiSum"/></td>
				<td align="center"><bean:write name="source" property="allDiamondPointSum"/></td>
				<td align="center"><bean:write name="source" property="allDiamondPointSumAfterTaxRatio"/></td>

			</tr>
			</logic:iterate>
		</logic:present>
		
	<%--================================--%>
	<%--=======		更新   删除	========--%>
	<%--================================--%>
	
		<tr>
			<td colspan ="9"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td>
		</tr>
		<tr>
			<td colspan ="9" align="middle" nowrap>宝石明细&nbsp;[可修改]</td>
		</tr>
		<tr>
			<td colspan ="9"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td>
		</tr>

		<tr>
			<td colspan ="9">
				<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top: 10px; margin-bottom: 15px;" width="400">
					<logic:present name="GEM_SOURCE_LIST_FOR_UPDATE" >
					<logic:iterate name="GEM_SOURCE_LIST_FOR_UPDATE" id="gemSource" indexId="indexid">
					
					<bean:define id="gemVar"  name="gemSource" property="gem" />
					<bean:define id="kingdomVar"  name="gemSource" property="kingdom" />
					<tr bordercolor="white">
						<td bgcolor="<bean:write name="kingdomVar" property="kingdomColor"/>" align="middle"  width="5"><strong><font color="#ffffff"><input type="checkbox" name="sId" value='<bean:write name="gemSource" property="gemSourcId" />'/></font></strong></td>
						<td bgcolor="<bean:write name="kingdomVar" property="kingdomColor"/>" align="middle"  width="5"><strong><font color="#ffffff">国家</font></strong></td>
						<td bgcolor="<bean:write name="kingdomVar" property="kingdomColor"/>" align="middle"  width="5"><bean:write name="kingdomVar" property="kingdomName"/></td>
						<td bgcolor="<bean:write name="kingdomVar" property="kingdomColor"/>" align="middle"  width="30"><strong><font color="#ffffff"><bean:write name="gemVar" property="gemDisplayName"/></font></strong></td>
						<td bgcolor="<bean:write name="kingdomVar" property="kingdomColor"/>" align="middle"  width="10"><bean:write name="gemSource" property="sourceGemCount"/></td>
					</tr>
					</logic:iterate>
					</logic:present>
				</table>
			</td>
		</tr>

		
		<tr align="center">
			
			<td colspan ="9" align="middle" nowrap>
			<logic:lessEqual name="<%=AttributeKeyConstant.USER_INFO_KEY %>" property="role.roleId" value="1" scope="session">
				<input type="button" name="dSourceButton" value="修改" onclick="updateGemSource()"/>
			</logic:lessEqual>
			</td>
			
		</tr>
		
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