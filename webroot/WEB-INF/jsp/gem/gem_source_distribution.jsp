<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="com.livedoor.flow_manager.IConstant.PageConstant"%>
<%@ page import="com.livedoor.flow_manager.enums.RoleEnum"%>
<%@ page import="com.livedoor.flow_manager.IConstant.AttributeKeyConstant"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>

<head>

<script src="js/sourceJs.js" type="text/javascript"></script>

<title>��ʯ������Ϣ</title>

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

</head>





<body>

<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">

<tr><td><div class="menu">
<strong>��ʯ������Ϣ</strong>
</div></td></tr>
<tr><td>
		<html:form action="gem_source_distribution_query.do" method="post">
		
		<tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td></tr>
			<td>
			<table border="0" cellpadding="0" cellspacing="0" align="center" width="800">
				<tr><td align="left"><input type="button" style="width=100;" value="����" onclick="javascript:window.location='returnMenu.do'"></td></tr>
				<tr><td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td></tr>
				<tr><td>
					<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="560">
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">������ʯʱ��</font></strong></td>
							<td bgcolor="#B2BECE">
											
								<html:select property="sourceGemDate" style="width=162;" >
									<logic:present name="GEM_SOURCE_DATE_LIST" scope="request">
										<html:options collection="GEM_SOURCE_DATE_LIST" property="value" labelProperty="label"/>
									</logic:present>
								</html:select>
							
							
							
							</td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">��������</strong></td>
							<td bgcolor="#B2BECE">
								<html:select property="kingdomId" style="width=162;" >
									
									<logic:present name="KINGDOM_LIST" scope="request">
										<html:options collection="KINGDOM_LIST" property="kingdomId" labelProperty="kingdomName" />
									</logic:present>
								</html:select>
							</td>
						</tr>
						
					</table>
				</td>
			</tr>

			<tr>
				<td align="center"><html:submit  style="width=150;" value="��ѯ"/></td>
			</tr>
			
			<tr>
				<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
			</tr>
			
			</table>
			</td>
			</tr>
		</table>
		</html:form>
	</td>
</tr>

<tr>
	<td></td>		
	<td></td>
	<td>
	<table border="0" cellpadding="4" cellspacing="1" align="center" 
	style="margin-top:10px; margin-bottom:15px;" width="800">
	

	
	<%-- ================================ --%>
	
		<form name="gem_source_distribution_query.do">
				<tr><td colspan="11">
					<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="560">
						
						
						
						
						
						<logic:present name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID">
						
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">��������</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="kingdomName"/></td>
						</tr>
						
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">����</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="sourceDate"/></td>
						</tr>
						
						
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">ǹ��&nbsp;&nbsp; (��λ����)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="qiangdunSum"/> </td>

						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">��&nbsp;&nbsp; (��λ����)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="dadaoSum"/></td>
						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">��ǹ&nbsp;&nbsp; (��λ����)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="qibingSum"/></td>
						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">�ؼ�&nbsp;&nbsp; (��λ����)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="zhongjiaSum"/></td>
						</tr>
						
						
						
						</logic:present>
						
						
						
						<logic:present name="soldierSourceTotalPoint">
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">���ܱ����ֺϼ�</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="soldierSourceTotalPoint"/></td>
						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">���ܱ�����ʵ������</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="soldierSourceTotalPointRatio"/>&nbsp;&nbsp;&nbsp;&nbsp;(���ܱ����ֺϼ� * ������)</td>
						</tr>
						</logic:present>
						
						<logic:present name="gemSourceTotalPoint">
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">���ܱ�ʯ�ֺϼ�</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="gemSourceTotalPoint"/></td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">���ܱ�ʯ��ʵ������</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="gemSourceTotalPointRatio"/>&nbsp;&nbsp;&nbsp;&nbsp;(���ܱ�ʯ�ֺϼ� * ������)</td>
						</tr>
						</logic:present>
						
						<logic:present name="gemPointPerSoldier">
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">���ܱ�ʯ��������</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="gemPointPerSoldier"/>&nbsp;&nbsp;&nbsp;&nbsp;(ÿ1w������Ӧ�ı�ʯ ����)</td>
						</tr>
						</logic:present>
						
						<logic:present name="ratio">
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">������</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="ratio"/>&nbsp;&nbsp;&nbsp;&nbsp;(���������Ϊ 30%,��������Ϊ70%,�� 0.7)</td>
						</tr>
						</logic:present>
						
						
					</table>
				</td>
			</tr>
	
	
	
	
	
	
		<tr>
			
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">����</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">����</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">����</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">ǹ��</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">��</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">���</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">�ؼ�</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">ԭʼ����</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100" align="center"><strong><font color="#ffffff">ʵ���������</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">ԭʼ��ʯ��</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100" align="center"><strong><font color="#ffffff">ʵ�����汦ʯ��</font></strong></td>
		</tr>
	
		<logic:present name="SOLDIER_SOURCE_SUM_INFO" >
			<logic:iterate name="SOLDIER_SOURCE_SUM_INFO"  id="source" indexId="indexid">
			<% if(indexid % 2 != 0){%> 
			<tr bgcolor="#e4e7ea">
			<%}else { %>
			<tr bgcolor="#B2BECE">
			<%} %>
				<td align="center"><bean:write name="source" property="kingdomName" /></td>
				<td align="center"><bean:write name="source" property="sourceDate"/></td>
				<td align="center"><bean:write name="source" property="userName"/></td>
				<td align="center"><bean:write name="source" property="qiangdunSum"/></td>
				<td align="center"><bean:write name="source" property="dadaoSum"/></td>
				<td align="center"><bean:write name="source" property="qibingSum"/></td>
				<td align="center"><bean:write name="source" property="zhongjiaSum"/></td>
				<td align="center"><bean:write name="source" property="soldierPointSum"/></td>
				<td align="center"><bean:write name="source" property="soldierPointSumAfterTax"/></td>
				<td align="center"><bean:write name="source" property="gemPointSum"/></td>
				<td align="center"><bean:write name="source" property="gemPointSumAfterTax"/></td>
			</tr>
			</logic:iterate>
		</logic:present>
		
	<%--================================--%>
	<%--=======		����   ɾ��	========--%>
	<%--================================--%>
	
		<tr><td colspan ="7"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>
<!--		<tr align="center">-->
<!--			-->
<!--			<td colspan ="7">-->
<!--			<input type="button" name="aSourceButton" value="����" onclick="addSource()"/>-->
<!--			&nbsp;&nbsp;-->
<!--			<input type="button" name="uSourceButton" value="ȡ������" onclick="updateSource()"/>-->
<!--			&nbsp;&nbsp;-->
<!--			<input type="button" name="dSourceButton" value="�޸�" onclick="delSource()"/>-->
<!--			&nbsp;&nbsp;-->
<!--			-->
<!--			<a href="javascript:pdfDownload()">-->
<!--				<img src="images/component/pdf.gif"  border="0" />-->
<!--			</a>-->
<!--			-->
<!--			</td>-->
<!--			-->
<!--			-->
<!--		</tr>-->
<!--		<tr><td colspan ="8"><hr color="#5F52A0" size="1" width="300" align="center" noshade></td></tr>-->
		
		</form>
	</table>
	</td>
</tr>

<table border="0" cellpadding="4" cellspacing="1" align="center" 
style="margin-top:10px; margin-bottom:15px;" width="800">






<tr>
	<td align="center">
	
	<%-- ================================== --%>
	<%-- ========= pager taglib =========== --%>
	<%-- ================================== --%>
	
	
	</td>
</tr>
</table>

</form>




</body>
</html>