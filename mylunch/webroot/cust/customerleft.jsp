<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
<title>menu list</title>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>
<link href="css/all.css" rel="stylesheet" type="text/css">
<script language="javascript">
 function showMenu(menuNum){
   var menu;
   var button;
   menu=eval("menu"+menuNum);
   button=eval("button"+menuNum);
   if(menu.style.display==''){
     menu.style.display="none";
	 button.background="images/leftlan02.jpg";
   }else if(menu.style.display=='none'){
     menu.style.display='';
	 button.background="images/leftlan01.jpg";
   }
 }
 
</script>
</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="31" align="center" bgcolor="808080"><span class="style1">Menu List</span></td>
  </tr>
</table>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="808080">
 
  <tr>
    <td id="button1" height="25" valign="middle" background="images/leftlan02.jpg">&nbsp;<a href="javascript:showMenu(1)">User管理</a></td>
  </tr>
  <tr id="menu1" style="display:none">
    <td height="65" valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="20">&nbsp;<a href="showUserSearch.do" target="main">查询User</a></td>
        </tr>
        
		<tr>
          <td height="20">&nbsp;<a href="showAddUser.do" target="main">增加User</a></td>
        </tr>

    </table></td>
  </tr>
 
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="808080">
 
  <tr>
    <td id="button2" height="25" valign="middle" background="images/leftlan02.jpg">&nbsp;<a href="javascript:showMenu(2)">资源管理</a></td>
  </tr>
  <tr id="menu2" style="display:none">
    <td height="65" valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="20">&nbsp;<a href="showSourceSearch.do" target="main">查询资源</a></td>
        </tr>
        
		<tr>
          <td height="20">&nbsp;<a href="showAddSource.do" target="main">增加资源</a></td>
        </tr>

    </table></td>
  </tr>
 
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="808080">
  
  <tr>
    <td id="button3" height="25" background="images/leftlan02.jpg">&nbsp;<a href="javascript:showMenu(3)">其他</a></td>
  </tr>
  <tr id="menu3" style="display:none">
    <td height="65" valign="top" bgcolor="#FFFFFF"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      
        <tr>
          <td height="20">&nbsp;<a href="toDownload.do" target="main">文件下载</a></td>
        </tr>
        <tr>
          <td height="20">&nbsp;<a href="toPageTemplate.do" target="main">Common Demo</a></td>
        </tr>
		<tr>
          <td height="20">&nbsp;<a href="toJmsSend.do" target="main">Queue消息发送</a></td>
        </tr>
        <tr>
          <td height="20">&nbsp;<a href="toJmsReceive.do" target="main">Queue消息接收</a></td>
        </tr>
        <tr>
          <td height="20">&nbsp;<a href="toTopicSend.do" target="main">Topic消息发送</a></td>
        </tr>
        <tr>
          <td height="20">&nbsp;<a href="toTopicReceive.do" target="main">Topic消息接收</a></td>
        </tr>
        <tr>
          <td height="20">&nbsp;<a href="toVelocity.do" target="main">velocity模版</a></td>
        </tr>
    </table></td>
  </tr>
 
</table>

</body>
</html>
