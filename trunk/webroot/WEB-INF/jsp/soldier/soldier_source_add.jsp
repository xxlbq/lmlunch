<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%--<%@ page isELIgnored ="false" %>--%>

<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>

<meta http-equiv="content-style=type" content="text/css">

<title>添加发兵</title>
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
		<div class="menu"><strong>添加发兵</strong></div>
		</td>
	</tr>
	<!-- form-->
	<tr>
		<td>
		<html:form action="soldier_source_add.do" method="post">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center"
				width="800">
	
				<tr>
					<td align="center">
					<hr color="#5F52A0" size="1" width="700" align="center" />
					</td>
				</tr>
				<tr>
					<td>
					<table border="0" cellpadding="5" cellspacing="1" align="center"
						style="margin-top: 10px; margin-bottom: 15px;" width="560">

						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">发兵会员ID</font></strong></td>
							<td bgcolor="#B2BECE">
								<logic:present name="USER_INFO" scope="request">
									<bean:write name="USER_INFO" property="userName"/>
								</logic:present> 
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">发兵会员名称</font></strong></td>
							<td bgcolor="#B2BECE">
								<logic:present name="USER_INFO" scope="request">
									<bean:write name="USER_INFO" property="userDisplayName"/>
								</logic:present> 
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">发兵国家</font></strong></td>
							<td bgcolor="#B2BECE">
								<logic:present name="KINGDOM_LIST" scope="request">
									<html:select property="kingdomId" style="width=162;">
										<option value="-1">请选择</option>
										<logic:present name="KINGDOM_LIST" scope="request">
											<html:options collection="KINGDOM_LIST" property="kingdomId" labelProperty="kingdomName" />
										</logic:present>
									</html:select>
								</logic:present>
							</td>
						</tr>


						<tr>
							<td bgcolor="#5F52A0"  align="right"><strong><font color="#ffffff">发兵种类</font></strong></td>
							<td bgcolor="#B2BECE">

								 
								<logic:present name="SOLDIER_LIST" scope="request">
									<html:select property="sourceSoldierId" style="width=162;">
										<option value="-1">请选择</option>
										<logic:present name="SOLDIER_LIST" scope="request">
											<html:options collection="SOLDIER_LIST" property="soldierId" labelProperty="soldierName" />
										</logic:present>
									</html:select>
								</logic:present>
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">发兵数量</font></strong></td>
							<td bgcolor="#B2BECE"><input type="text" name="sourceSoliderCount" value="" size="14"style="height:20" tabindex="1"/>
							&nbsp;&nbsp;( 单位:万&nbsp;&nbsp;例如:&nbsp;实际数量为10万, 请填入10 )
							</td>
						</tr>

					</table>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center"><html:submit style="width=150;" value="添加" /></td>
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