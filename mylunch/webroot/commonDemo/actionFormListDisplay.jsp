<%@ page language="java" contentType="text/html; charset=gb2312"%>


<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>

<%@ taglib prefix="c" uri="/WEB-INF/conf/tld/c.tld" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="cn">
<head>
<!doctype html public "-//w3c//dtd html 4.01//en""http//www.w3.org/tr/html4/strict.dtd>
<meta http-equiv="content-style=type"content="text/css">
<META name="robots" content="noindex">
<title>×ÊÔ´²éÑ¯</title>
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
<script>	
</script>
</head>
<body>

<!-- Main-->

<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">

<tr>
	<td><div class="menu"><strong>demo link</strong></div></td>

</tr>
<!-- form-->


<html:form action="demoValid.do">
<tr>
	<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
</tr>


<html:errors/>
<tr>
	<td>
	<table border="0" cellpadding="4" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="800">
		
	<logic:iterate id = "pmIter" name="listActionForm" property="pm" indexId="i">
<%--		<hr>--%>
<%if(i % 5 == 0 ){ %>
		<tr>
	<% }%>	
			<td bgcolor="#B2BECE"><li>machineType:<html:text name="pmIter" property="machineType"></html:text> </li></td>
			<td bgcolor="#B2BECE"><li>machineCount:<html:text name="pmIter" property="machineCount"/></li></td>
		
		<%if((i+1) % 5 == 0 ){ %>
		</tr>
		<% }%>
		
		
		
		
		
		
		
			
			

	</logic:iterate>
	</table>
	</td>
</tr>
<html:submit></html:submit>
</html:form>

<table border="0" cellpadding="4" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="800">

</table>
<tr>
	<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
</tr>

</table>




</body>
</html>