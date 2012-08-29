<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>
<html>
<head>

<link href="<c:url value="css/mj/style.css"/>" rel="stylesheet" type="text/css">

<title>烽火管理</title>
<script type="text/javascript">

</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="32%" bgcolor="#492702"><img src="images/logo.gif" alt="logo_mj"  height="43" /></td>
    <td width="68%" height="65" align="right" background="images/top_right.gif" bgcolor="#492702"><img src="images/mj_logo.gif" alt="logo" width="171" height="45" /></td>
  </tr>
</table>





<html:form action="login.do" >
<table width="100%" border="0" cellpadding="10" cellspacing="1" bgcolor="#FFFFFF">
	<tr>
		<td width="6%" bgcolor="#F7EEDF"><table width="443" border="0" cellspacing="0" cellpadding="5">
	        <tr>
	          <td width="52%" align="right" bgcolor="#F7EEDF">会员ID</td>
	          <td width="37%" bgcolor="#F7EEDF"><input type="text" name="loginID" value="MEI" size="14"style="height:20" tabindex="1"/></td>
	<!--          <td width="37%" bgcolor="#F7EEDF"><input type="text" name="j_username" value="MEI" size="14"style="height:20" tabindex="1"/></td>-->
	          <td width="11%" bgcolor="#F7EEDF"><input type="submit" value="登陆" /></td>
	        </tr>
        	<tr>
	          <td align="right" bgcolor="#F7EEDF">密码</td>
	          <td bgcolor="#F7EEDF"><input type="password" value="3333" size="16" maxlength="8" name="loginPwd" style="height:20" tabindex="2"/></td>
	<!--          <td bgcolor="#F7EEDF"><input type="password" value="3333" size="16" maxlength="8" name="j_password" style="height:20" tabindex="2"/></td>-->
	          <td bgcolor="#F7EEDF"><input type="reset" value="重设" /></td>
        	</tr>
	        <tr align="left">
	         <td ></td>
				<td  class="error">
				<html:errors property="loginIdOrPwd"  />
				<br>
				<html:errors property="userExpired"  />
				</td>
				 <td ></td>
			</tr>
		
		</td>
    </tr>
     		<tr align="right">
 			<td></td>
 			<td>如果没有账户请</td>
         	<td ><a href="reg.do" target="_blank"><font color="#a71010">注册</font></a></td>
		</tr>
</table>
</html:form>

</body>
</html>
