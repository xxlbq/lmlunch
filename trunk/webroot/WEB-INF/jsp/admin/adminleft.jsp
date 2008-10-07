<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/conf/tld/struts-menu.tld" prefix="menu" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<% response.addHeader("P3P","CP=CAO PSA OUR");%>

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
 <menu:useMenuDisplayer name="TabbedMenu"
  bundle="org.apache.struts.action.MESSAGE">
  <menu:displayMenu name="test1"/>
  
</menu:useMenuDisplayer>
</table>

</body>
</html>
