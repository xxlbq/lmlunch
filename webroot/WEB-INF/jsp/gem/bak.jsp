<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%--<%@ page isELIgnored ="false" %>--%>

<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>

<meta http-equiv="content-style=type" content="text/css">

<title>宝石添加</title>
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
		<logic:present name="GEM_SOURCE_UPDATE_KEY">
			<div class="menu"><strong>宝石修改</strong></div>
		</logic:present>
		<logic:notPresent name="GEM_SOURCE_UPDATE_KEY">
			<div class="menu"><strong>宝石添加</strong></div>
		</logic:notPresent>
		</td>
	</tr>
	<!-- form-->
	<tr>
		<td>
		<logic:present name="GEM_SOURCE_UPDATE_KEY">
		<html:form action="gem_source_update.do" method="post">
		</logic:present>
		<logic:notPresent name="GEM_SOURCE_UPDATE_KEY">
		<html:form action="gem_source_add.do" method="post">
		</logic:notPresent>
		
		

			<tr>
				<td>&nbsp;</td>
			</tr>
			<td>
							<tr align="left">
		         <td ></td>
					<td  class="error"><font color="red">
					<html:messages id="msg"  name="SUCCESS_MESSAGE_INFO" message="false">
						<bean:write name="msg"/>
						<br>
					</html:messages></font>	
					</td>
					 <td ></td>
				</tr>
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
						
						<logic:present name="GEM_SOURCE_UPDATE_KEY">
							<html:hidden property="gemSourcId"></html:hidden>
						</logic:present>
						
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">发宝石国家</font></strong></td>
							<td bgcolor="#B2BECE">
								
								<logic:present name="GEM_SOURCE_UPDATE_KEY">
									<bean:write name="kingdomId"/>
								</logic:present>
								<logic:notPresent name="GEM_SOURCE_UPDATE_KEY">
									<logic:present name="KINGDOM_LIST" scope="request">
										<html:select property="kingdomId" style="width=162;">
											<option value="-1">请选择</option>
											<logic:present name="KINGDOM_LIST" scope="request">
												<html:options collection="KINGDOM_LIST" property="kingdomId" labelProperty="kingdomName" />
											</logic:present>
										</html:select>
									</logic:present>
								</logic:notPresent>
								

							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">宝石种类</font></strong></td>
							<td bgcolor="#B2BECE">
							
								<logic:present name="GEM_SOURCE_UPDATE_KEY">
									<bean:write name="gemId"/>
								</logic:present>
								<logic:notPresent name="GEM_SOURCE_UPDATE_KEY">
									<logic:present name="GEM_LIST" scope="request">
										<html:select property="gemId" style="width=162;">
											<option value="-1">请选择</option>
											<logic:present name="GEM_LIST" scope="request">
												<html:options collection="GEM_LIST" property="gemId" labelProperty="gemDisplayName" />
											</logic:present>
										</html:select>
									</logic:present>
								</logic:notPresent>
							
							

							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" align="right"><strong><font color="#ffffff">宝石数量</font></strong></td>
							<td bgcolor="#B2BECE"><html:text property="sourceGemCount" size="14"style="height:20" tabindex="1"/>
							</td>
						</tr>
				        <tr align="left">
				         <td ></td>
						<td  class="error">
								<font color="red">
								<html:messages id="errmsg"  name="ERROR_MESSAGE_INFO" message="false">
									<bean:write name="errmsg"/>
									<br/>
								</html:messages>
								</font>	
							</td>
							 <td ></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>

					<logic:present name="GEM_SOURCE_UPDATE_KEY">
					<td align="center"><html:submit style="width=150;" value="修改" /></td>
					</logic:present>
					<logic:notPresent name="GEM_SOURCE_UPDATE_KEY">
					<td align="center"><html:submit style="width=150;" value="添加" /></td>
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