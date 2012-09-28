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

<title>会员查询</title>

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
<strong>会员查询</strong>
</div></td></tr>
<tr><td>
		<html:form action="member_query.do" method="post">
		
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
								<strong><font color="#ffffff">会员ID关键字</font></strong></td>
							<td bgcolor="#B2BECE">
								<html:text property="userName"></html:text>
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">会员名称关键字</strong></td>
							<td bgcolor="#B2BECE">
								<html:text property="userDisplayName"></html:text>
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
	<table border="0" cellpadding="4" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="800">

		<form name="middleform">
	
		<tr>
			
			<td bgcolor="#5F52A0" nowrap  width="30" align="center"><strong><font color="#ffffff"><input type="checkbox" name="allchecked" onclick="checkedAll()">审批</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="30" align="center"><strong><font color="#ffffff">会员ID</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">会员名称</font></strong></td>
		</tr>
		<tr>
			<td colspan ="9">
				<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top: 10px; margin-bottom: 15px;" width="400">
					<logic:present name="USER_LIST" >
					<logic:iterate name="USER_LIST" id="userEntity" indexId="indexid">
					
					<% if(indexid % 2 != 0){%> <!--从1开始编号-->
					<tr bgcolor="#e4e7ea">
					<%}else { %>
					<tr bgcolor="#B2BECE">
					<%} %>
	
						<td align="middle"  width="5"><strong><font color="#ffffff"><input type="checkbox" name="sId" value='<bean:write name="userEntity" property="userId" />'/></font></strong></td>
						<td align="middle"  width="30"><strong><font color="#ffffff"><bean:write name="userEntity" property="userName"/></font></strong></td>
						<td align="middle"  width="10"><bean:write name="userEntity" property="userDisplayName"/></td>
					</tr>
					</logic:iterate>
					</logic:present>
					
							
					<tr align="center">
						
						<td colspan ="9" align="middle" nowrap>
						<logic:lessEqual name="<%=AttributeKeyConstant.USER_INFO_KEY %>" property="role.roleId" value="1" scope="session">
							<input type="button" name="dSourceButton" value="修改" onclick="updateGemSource()"/>
						</logic:lessEqual>
						</td>
						
					</tr>
					</logic:present>
				</table>
			</td>
		</tr>


		
		</form>
	</table>
	</td>
</tr>


</form>




</body>
</html>