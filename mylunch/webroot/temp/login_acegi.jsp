<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html"%>
<%@ taglib prefix="c" uri="/WEB-INF/conf/tld/c.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<%
	request.getSession(true);
	%>
	<head>
		<META name="robots" content="noindex">
		<title>定餐登录</title>
		<style type="text/css">

body {
	background: #ffffff;
	background-image: url("images/background.gif");
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

.menu {
	font-size: 15pt;
	text-align: center;
}

td {
	font-size: 10pt;
}

.color {
	background: #ffcocb;
}

.mono {
	background: #cccccc;
}

.txt {
	BORDER-BOTTOM: #333333 1px ridge;
	BORDER-LEFT: #333333 1px ridge;
	BORDER-RIGHT: #333333 1px ridge;
	BORDER-TOP: #333333 1px ridge;
	font-weight: bold;
	text-align: left;
}
-->
</style>

	</head>
	<body>

		<!-- Main-->


		<table border="0" cellpadding="0" cellspacing="0" align="center"
			width="700">
			<tr></tr>
			<tr></tr>
			<tr>
				<td>
					<div class="menu">
						<strong>定餐登录</strong>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<!-- form-->

					<table width="210" border="0" bordercolor="#bc8f8f" cellpadding="5"
						cellspacing="1" align="center"
						style="margin-top: 10px; margin-bottom: 15px;">
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<%--<html:form action="/login.do">--%>
						<form action="login.in">
						<tr>
							<td bgcolor="#5F52A0" nowrap>
								<strong><font color="#ffffff">Login ID</font> </strong>
							</td>
							<td bgcolor="B2BECE">
								<input type="text" name="j_username" maxlength="12" size="18"
									value="MEI" />
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap>
								<strong><font color="#ffffff">Password</font> </strong>
							</td>
							<td bgcolor="#B2BECE">
								<input type="password" name="j_password" maxlength="12"
									size="20" value="3333" />
							</td>
						</tr>
						<tr>
							<td bgcolor="ffffff">
								&nbsp;
							</td>
							<td bgcolor="ffffff">
								&nbsp;
							</td>
						</tr>

						<tr>
							<td bgcolor="ffffff" colspan="2">
								&nbsp;
								<c:if test="${not empty param.error}">
									<font color="red"> <%--        <c:out value="${param.error}"/>--%>
										Your Access is Denied ! </font>
      &nbsp;&nbsp;&nbsp;


								</c:if>

							</td>
						</tr>

						<tr>

						</tr>

						<tr>
							<td bgcolor="#ffffff" colspan="2" align="center">
								<input type="submit" style="" value="enter" />
							</td>
							<%--	<td><a href="logout.do">注销</a></td>--%>
							<%--	<td><a href="logout.out">注销</a></td>--%>
						</tr>


						</form>
					</table>
				</td>
			</tr>
		</table>

		<!-- /form-->
		<!-- /Main-->
	</body>
</html>