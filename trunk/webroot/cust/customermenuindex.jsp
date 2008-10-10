<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>

<meta name="description" content="权限管理">
<title>权限管理</title>
<style type="text/css">
<!--
.style1 {color: #000000}
-->
</style>
</head>
<body style="MARGIN: 0px" scroll=no onResize=javascript:parent.carnoc.location.reload()>

<script>
if(self!=top){top.location=self.location;}
function switchSysBar(){
if (switchPoint.innerText==3){
switchPoint.innerText=4
document.all("frmTitle").style.display="none"
}else{
switchPoint.innerText=3
document.all("frmTitle").style.display=""
}}
</script>

<style type="text/css">.navPoint {COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt}
</style>

<table border="0" cellPadding="0" cellSpacing="0" height="100%" width="100%">
  <tr>
    <td align="middle" style="width:172px" " id="frmTitle" noWrap vAlign="center" name="frmTitle">
   
    <iframe frameBorder="0" id="carnoc" name="carnoc" scrolling=no src="left.do" style="HEIGHT: 100%; VISIBILITY: inherit;WIDTH: 170px; Z-INDEX: 2">
    </iframe>
    </td>
    <td class=a2 style="WIDTH: 9pt">
    <table border="0" bgcolor="F6F5F4" cellPadding="0" cellSpacing="0" height="100%">
      <tr>
        <td style="HEIGHT: 100%" onclick="switchSysBar()">
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <span class="navPoint" id="switchPoint" title="关闭/打开左栏">1</span><br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <span class="style1"><br>
        </span></td>
      </tr>
    </table>
    </td>
    <td style="WIDTH: 100%">
    <iframe frameBorder="0" id="main" name="main" scrolling="yes" src="main.do" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1">
    </iframe>
   </td>
  </tr>
</table>
</html>
<script>
if(window.screen.width<'1024'){switchSysBar()}
</script>
