<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%--<%@ page isELIgnored ="false" %>--%>

<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>

<meta http-equiv="content-style=type"content="text/css">

<title>资源添加</title>
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
	
</script>
</head>
<body>

<!-- Main-->

<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">

<tr><td><div class="menu"><strong><bean:message key="source.addpage.tittle"/></strong></div></td></tr>
<!-- form-->
<tr>
	<td>
		<html:form action="addSource.do" method="post" >
		<tr>
		<tr><td>&nbsp;</td></tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center" width="800">
				<tr><td align="left"><input type="button" style="width=100;" value="返回" onclick="javascript:window.location='returnMenu.do'"/></td></tr>
				<tr><td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td></tr>
				<tr><td><table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="560">
				
				
				<tr>
					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff"><bean:message key="source.addpage.tittle"/></font></strong></td>
					<td bgcolor="#B2BECE">
					
					<logic:present name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text  maxlength="8" name="QUERY_SOURCE_OBJECT" property="sourceName" size="11" />
					</logic:present>
					
					<logic:notPresent name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text  maxlength="8" property="sourceName" size="11" />
					</logic:notPresent>
					
					<br>（xxx形式&nbsp;例xxx）
					</td>
				</tr>
<%--				<tr>--%>
<%--					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">资源功能入口</font></strong></td>--%>
<%--					<td bgcolor="#B2BECE"><html:text maxlength="4" name="QUERY_SOURCE_OBJECT" property="sourceDoor" size="8" /><br>（xxx形式&nbsp;&nbsp;例xxx）</td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">父资源</font></strong></td>--%>
<%--					<td bgcolor="#B2BECE"><html:text name="QUERY_SOURCE_OBJECT"  property="sourceFather" maxlength="62"  size="50"/></td>--%>
<%--				</tr>--%>

				<tr>
					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">资源描述</strong></td>
					<td bgcolor="#B2BECE">
					
					<logic:present name="SOURCE_FOOD_OBJ" scope="request">
					<html:select property="sourceFoodId" style="width=162;">
<%--							<logic:present name="SOURCE_FOOD" scope="request">--%>
								<html:options collection="SOURCE_FOOD" property="foodId" labelProperty="foodName" />
<%--							</logic:present>--%>
					</html:select>
					</logic:present>
					
					<logic:notPresent name="SOURCE_FOOD_OBJ" scope="request">
					<html:select property="sourceFoodId" style="width=162;" >
							<option value="">请选择</option>
							<logic:present name="SOURCE_FOOD" scope="request">
								<html:options collection="SOURCE_FOOD" property="foodId" labelProperty="foodName" />
							</logic:present>
					</html:select>
					</logic:notPresent>
					
					</td>
				</tr>
				
				<tr>
					<td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff"><bean:message key="source.addpage.count"/></font></strong></td>
					<td bgcolor="#B2BECE">
					
					<logic:present name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text  maxlength="8" name="QUERY_SOURCE_OBJECT" property="sourceFoodCount" size="11" />
					</logic:present>
					
					<logic:notPresent name="QUERY_SOURCE_OBJECT" scope="request">
					<html:text  maxlength="8" property="sourceFoodCount" size="11" />
					</logic:notPresent>
					
					<br>（xxx形式&nbsp;例xxx）
					</td>
				</tr>
				
			</table>
		</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td align="center"><html:submit  style="width=150;" value="添加"/></td>
		</tr>
		
		<tr><td align="right"></td></tr>
		<tr>
			<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade>
		</td>
		</tr>
		
		</table></td>
		</tr>
		</table>
		
		</html:form>
	</td>
</tr>





</table>




<!-- /form -->
<!-- /Main -->
</body>
</html>