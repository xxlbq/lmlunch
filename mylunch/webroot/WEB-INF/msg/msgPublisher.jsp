<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/conf/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/conf/tld/struts-logic.tld" prefix="logic" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib prefix="c" uri="/WEB-INF/conf/tld/c.tld" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Topic消息发送</title>
<link href="css/all.css" rel="stylesheet" type="text/css" />
<script language="javascript">
  function loginCheck(){
      if(document.login.loginName.value==''){
       alert("请输入登录帐号！");
	   document.login.loginName.focus();
	   return false;
	 }else if(document.login.loginPwd.value==''){
	   alert("请输入登录密码！");
	   document.login.loginPwd.focus();
	   return false;
	 }
  }

</script>
</head>

<body>
 
 <table width="800" height="600" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" background="images/009.jpg"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="18%" height="598" rowspan="2">&nbsp;</td>
        <td height="362" colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td width="40%" height="238" align="center"><table width="229"  border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td width="239">
           
			<html:form action="jmsTopicSend.do" method="post">
			
			
			
			
              <table width="95%" height="153" border="0" align="center" cellpadding="0" cellspacing="0">
               
  
             
                <tr><td><p>发送Topic消息</td></tr>
                <tr>
                  <td width="72%">消息:
                      <input type="text" name="sendmsg" style="border-style: solid; border-width: 1" size="15"/></td>
                </tr>
                
              <tr>
                <td>
                  <div align="center"><html:submit style="width=60;" value="发送" /></div></td>
              </tr>
            </table>
            </html:form>
            </td>
          </tr>
        </table></td>
        <td width="42%" align="center">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html:html>
