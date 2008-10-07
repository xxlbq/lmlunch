<%@ page  language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>
<!doctype html public "-//w3c//dtd html 4.01//en""http//www.w3.org/tr/html4/strict.dtd>
<meta http-equiv="content-style=type"content="text/css">
<META name="robots" content="noindex">
<title>操作成功</title>
<style type="text/css">
<!--
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
<script>
function returnBack(backpath){
	//alert(v);
	 window.location=backpath;

}
</script>
</head>
<body>

<!-- Main-->

<table border="0" cellpadding="0" cellspacing="0" align="center" width="700">

<tr><td></td></tr>
<tr>
	<td><div class="menu"><strong>成功</strong></div></td>
<tr><td>&nbsp;</td></tr>
</tr>
<!-- form-->


<tr>
	<td align="left"></td>
</tr>
<tr>
	<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
</tr>
<tr align="center">
	<td>
		<table>
		<tr align="center">
		<td><html:errors/></td>
		</tr>
		<tr align="center">
			<td><form action="" method="post">
				<input type="button" style="width=60;" value="确定" onclick="returnBack('<%=request.getAttribute("SUCCESS_FORWARD")%>')"/>
				</form>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
</tr>
<tr>
	<td align="left">
 
	</td>
</tr>
</table>
</form>

<!-- /form -->
<!-- /Main -->
</body>
</html>