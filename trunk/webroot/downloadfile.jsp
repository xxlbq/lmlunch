<%@ page 
language="java"
contentType="text/html; charset=utf-8" %>
<%--<%@ page isELIgnored ="false" %>--%>
<%--<jsp:directive.page import="java.io.File"/>--%>

<%@ page import="java.io.File"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>

<%@ taglib prefix="c" uri="/WEB-INF/conf/tld/c.tld" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<!doctype html public "-//w3c//dtd html 4.01//en""http//www.w3.org/tr/html4/strict.dtd>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META name="robots" content="noindex">
<title>download</title>
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
<script language="javascript">
	

function selectdel(){
	var c;
		for (var i=0;i<document.form.elements.length;i++) {
			 var e = document.form.elements[i];
			  if(e.name='id' && e.checked==true){
			  	wasChecked=true;
			  	c=e.value;
			  }
		 }
		window.location='downloaddel.do?id='+c;
}
function selectdownload(){
	var c;
		for (var i=0;i<document.form.elements.length;i++) {
			 var e = document.form.elements[i];
			  if(e.name='id' && e.checked==true){
			  	wasChecked=true;
			  	c=e.value;
			  }
		 }
		window.location='download.do?id='+c;
}
<%
 String url=(String)request.getAttribute("url");
  if(url!=null){ 
  %>
  eval(window.open("<%=url%>"));
  <%
  }

%>

function goback(){ 
window.location.href="GoMenuTopAction.do?param=server";
}
function backTop(){ 
window.location.href="GoMenuTopAction.do";
}
</script>

</head>

<BODY><!-- Main-->
<TABLE cellSpacing=0 cellPadding=0 width=700 align=center border=0>
<form name="form" action="download.do">
  <TBODY>
  <tr>
	<td>
<div class="right">
&nbsp;
</div></td>
</tr>
    <TD>
      <DIV class=menu><STRONG>download</STRONG></DIV></TD>
  <TR>
    <TD>
      <hr align=center width=700 color=#5f52a0 noshade size=1>
      <p><br>
      </p></TD></TR>
  <TR>
    <TD align=left><table width="70%" align=center border=0>
      <tbody>
        <tr>
          <td nowrap align=middle width="10%" bgcolor=#5f52a0><strong><font 
      color=#ffffff>选择</font></strong></td>
          <td nowrap align=middle width="35%" bgcolor=#5f52a0><strong><font 
      color=#ffffff>文件名称</font></strong></td>
          <td nowrap align=middle width="30%" bgcolor=#5f52a0><strong><font 
      color=#ffffff>文件大小(KB)</font></strong></td>
          <td nowrap align=middle width="30%" bgcolor=#5f52a0><strong><font 
      color=#ffffff>更新时间</font></strong></td>
        </tr>
        
<%--  <tr>--%>
<%--    <td bgcolor="#B2BECE"><input type="checkbox" name="id" value='<%=(request.getSession().getServletContext().getRealPath("/"))+"download"+File.separator+"a.txt" %>'/></td>--%>
<%--	<td bgcolor="#B2BECE">11</td>--%>
<%--    <td bgcolor="#B2BECE">11</td>--%>
<%--    <td bgcolor="#B2BECE">11</td>--%>
<%--    <td bgcolor="#B2BECE">11</td>--%>
<%--  </tr>--%>
<%--  <tr>--%>
<%--    <td bgcolor="#B2BECE"><input type="checkbox" name="id" value='<%=(request.getSession().getServletContext().getRealPath("/"))+"download"+File.separator+"b.txt" %>' /></td>--%>
<%--	<td bgcolor="#B2BECE">11</td>--%>
<%--    <td bgcolor="#B2BECE">11</td>--%>
<%--    <td bgcolor="#B2BECE">11</td>--%>
<%--    <td bgcolor="#B2BECE">11</td>--%>
<%--  </tr>--%>

<%-- ## row area ##--%>
	
		<logic:present name="PAGE_INFO_BEAN" property="items">
		<logic:iterate name="PAGE_INFO_BEAN" property="items" id="iter">
	
		<tr>
			<td bgcolor="#B2BECE"><input type="checkbox" name="id" value="<bean:write name="iter" property="path" />"/></td>
		    <td bgcolor="#B2BECE"><bean:write name="iter" property="fileName" /></td>
		    <td bgcolor="#B2BECE"><bean:write name="iter" property="fileSize" /></td>
		    <td bgcolor="#B2BECE"><bean:write name="iter" property="lastModifyDate" /></td>
		</tr>
		</logic:iterate>
		</logic:present>

<%-- ##         ##--%>

		
        <tr>
          <td align=middle colspan=5>&nbsp;
          <input name="download" type="submit" value="[下载]" />&nbsp;</td>
        </tr>
		
      </tbody>
    </table></TD></TR>
	<TR><TD align="center">
<HR align=center width=700 color=#5f52a0 noShade SIZE=1>
</TD></TR>
</form>
</TABLE>
<!-- /Main-->
</BODY>
</html:html>
