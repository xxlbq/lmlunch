<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%--<%@ page isELIgnored ="false" %>--%>

<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="content-style=type" content="text/css">
<script src="js/sourceJs.js" type="text/javascript"></script>
<title>会员注册</title>
<style type="text/css">
<!--
body {
	background: #ffffff;
	background-image: url("img/background.gif");
	background-attachment: scroll;
	background-repeat: repeat-x;
}

a:link {
	color: #000000;
}

a:hover {
	color: #999999;
	text-decoration: none;
}

a.blue:link {
	color: #3366cc;
}

a.blue:hover {
	color: #999999;
	text-decoration: none;
}

a.white:link {
	color: #ffffff;
}

a.white:hover {
	color: #999999;
	text-decoration: none;
}

.ldfbg {
	background: #dcdcdc;
}

div {
	font-size: 10pt;
	text-align: center;
}

td {
	font-size: 10pt;
}

.menu {
	font-size: 15pt;
	text-align: center;
}

.right {
	text-align: right;
}
-->
</style>
<script>
	
</script>
</head>
<body>

<!-- Main-->

<table border="0" cellpadding="0" cellspacing="0" align="center"
	width="1000">

	<tr>
		<td>
		<logic:present name="USER_UPDATE_KEY">
		<div class="menu"><strong>会员信息修改</strong></div>
		</logic:present>
		<logic:notPresent name="USER_UPDATE_KEY">
		<div class="menu"><strong>会员注册</strong></div>
		</logic:notPresent>
		</td>
	</tr>
	<!-- form-->
	<tr>
		<td>
		<html:form action="member_add.do" method="post">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center"
				width="800">
	
				<tr>
					<td align="center" class="error"> 
						<font color="red">
						<html:messages id="errmsg"  name="ERROR_MESSAGE_INFO" message="false">
							<bean:write name="errmsg"/>
							<br/>
						</html:messages>
						</font>	
					</td>
				</tr>
				<tr>
					<td>
					<table border="0" cellpadding="5" cellspacing="1" align="center"
						style="margin-top: 10px; margin-bottom: 15px;" width="560">

						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">君主名称</font></strong></td>
							<td bgcolor="#B2BECE"><html:hidden property="id"></html:hidden>
									<html:text  maxlength="30"  property="userDisplayName" size="20" />
							</td>
						</tr>
						
						<logic:present name="USER_UPDATE_KEY">
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">输入原始密码</font></strong></td>
							<td bgcolor="#B2BECE"><html:password  maxlength="30" property="previousPassword" size="20" />
							</td>
						</tr>
						</logic:present>
						
						<tr>
						
							<logic:present name="USER_UPDATE_KEY">
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">输入新密码</font></strong></td>
							</logic:present>
							<logic:notPresent name="USER_UPDATE_KEY">
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">输入设定密码</font></strong></td>
							</logic:notPresent>
						
							<td bgcolor="#B2BECE"><html:password  maxlength="30" property="userPassword" size="20" />
							</td>
						</tr>
						<tr>
						
							<logic:present name="USER_UPDATE_KEY">
								<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">再次输入新密码</font></strong></td>
							</logic:present>
							<logic:notPresent name="USER_UPDATE_KEY">
								<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">再次输入密码</font></strong></td>
							</logic:notPresent>
							
							<td bgcolor="#B2BECE"><html:password  maxlength="30"  property="userPassword2" size="20" />
							</td>
						</tr>

					</table>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
		
					<logic:present name="USER_UPDATE_KEY">
						<td align="center"><input type="button" name="dSourceButton" value="修改" onclick="updateUser()"/></td>
					</logic:present>
					<logic:notPresent name="USER_UPDATE_KEY">
						<td align="center"><input type="button" name="dSourceButton" value="添加" onclick="addUser()"/></td>
					</logic:notPresent>
				

				</tr>

				<tr>
					<td align="right"></td>
				</tr>
				<tr>
					<td align="center">
					<hr color="#5F52A0" size="1" width="700" align="center" />
					</td>
				</tr>

			</table>
			</td>
	</tr>
</table>

</html:form>
</td>
</tr>
</table>
</body>
</html>