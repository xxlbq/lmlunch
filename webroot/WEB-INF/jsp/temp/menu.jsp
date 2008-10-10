<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:import url="/common/meta.jsp"/>
<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
<title>JHF</title>
<style type="text/css">
<!--
body { background-image: url(img/menu_bg.gif);}
a:hover { color:#428EFF;text-decoration:underline; }
.menu_title  { font-size: 12px; color: #000000; padding-left: 15px; }
.menu_title span  { }
.menu_title2  { font-size: 12px; color: #5d6d6d; padding-left: 15px;}
.menu_title2 span  { }
-->
</style>
<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
	if (sid < 10){

		whichEl = eval("submenu000" + sid);
		if (whichEl.style.display == "none")
		{
			eval("submenu000" + sid + ".style.display=\"\";");
			
			eval("menuTitle000" + sid + ".background=\"images/skin/default/menu_title3.gif\";");
		}
		else
		{
			eval("submenu000" + sid + ".style.display=\"none\";");
		}

		for(i=1;i<10;i++)
		{
			if(i != sid)
			{
			    eval("submenu000" + i + ".style.display=\"none\";");
			    eval("menuTitle000" + i + ".background=\"images/skin/default/menu_title1.gif\";");
			}
		
		}
		
	}else{
		whichEl = eval("submenu00" + sid);
		if (whichEl.style.display == "none")
		{
		eval("submenu00" + sid + ".style.display=\"\";");
		}
		else
		{
		eval("submenu00" + sid + ".style.display=\"none\";");
		}
	}
}
</SCRIPT>
</head>

<body>
<table width="207" border="0" cellspacing="0" cellpadding="0" >
<c:forEach var="pare" items="${pare}">
  <tr><td height="26" class="menu_text" onmouseover="this.className='menu_title2';" onmouseout="this.className='menu_title';" background="images/skin/default/menu_title1.gif" id="menuTitle${pare.parentMenuSeq}" onclick="showsubmenu(${pare.parentMenuSeq})">
    ${pare.parentMenuName}
    </td>
  </tr>
  <tr>
    <td height="26" style="display:none" id="submenu${pare.parentMenuSeq}"><table cellpadding="0" cellspacing="0" width="207" class="menu_text_color">
      <c:forEach var="son" items="${son}">
      <c:if test="${pare.parentMenuSeq==son.parentMenuSeq}" var="uino">
      <tr>
        <td height="26" background="images/skin/default/menu_title2.gif"><a href="${son.sonMenuUrl}" target="mainFrame">${son.sonMenuName}</a></td>
      </tr>
     </c:if>
     </c:forEach>
    </table></td>
  </tr>
 </c:forEach>
</table>
<table width="207" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td height="26" class="menu_text" onMouseOver="this.className='menu_title2';" onMouseOut="this.className='menu_title';" background="images/skin/default/menu_title5.gif"><a href='chgpwd.do' target="mainFrame">パスワード修正</a></td>
  </tr>
  <tr>
    <td height="26" class="menu_text" onMouseOver="this.className='menu_title2';" onMouseOut="this.className='menu_title';" background="images/skin/default/menu_title5.gif"><a href='logout.do' >ログアウト</a></td>
  </tr>
</table>
</body>
</html>
