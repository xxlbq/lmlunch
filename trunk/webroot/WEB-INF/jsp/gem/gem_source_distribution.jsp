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

<title>宝石分配信息</title>

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

	<tr><td><div class="menu"><strong>宝石分配信息</strong></div></td></tr>
	<tr><td>
	
			<html:form action="gem_source_distribution_query.do" method="post">
				<table border="0" cellpadding="0" cellspacing="0" align="center" width="800">
					
					<tr><td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td></tr>
					<tr><td>
							<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="560">
								<tr><td bgcolor="#5F52A0" nowrap align="right"><strong><font color="#ffffff">产生宝石时间</font></strong></td>
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
										<strong><font color="#ffffff">发兵国家</strong></td>
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
						<td align="center"><html:submit  style="width=150;" value="查询"/></td>
					</tr>
				
					<tr>
						<td align="center"><hr color="#5F52A0" size="1" width="700" align="center" noshade></td>
					</tr>
				</table>
			</html:form>
		</td>
	</tr>

</table>



	<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">
	<tr>
		<td>
					<table border="0" cellpadding="5" cellspacing="1" align="center" style="margin-top:10px; margin-bottom:15px;" width="800">
						
						<logic:present name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID">
						
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">国家名称</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="kingdomName"/></td>
						</tr>
						
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">日期</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="sourceDate"/></td>
						</tr>
						
						
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">枪盾&nbsp;&nbsp; (单位：万)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="qiangdunSum"/> </td>

						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">大刀&nbsp;&nbsp; (单位：万)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="dadaoSum"/></td>
						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">骑枪&nbsp;&nbsp; (单位：万)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="qibingSum"/></td>
						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">重甲&nbsp;&nbsp; (单位：万)</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="SOLDIER_SOURCE_GROUPBY_SOLDIER_ID" property="zhongjiaSum"/></td>
						</tr>
						
						</logic:present>
						
						
						
						<logic:present name="soldierSourceTotalPoint">
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">本周兵力分合计</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="soldierSourceTotalPoint"/></td>
						</tr>
						<tr><td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">本周兵力分实际收益</font></strong></td>
							<td bgcolor="#B2BECE"><bean:write name="soldierSourceTotalPointRatio"/>&nbsp;&nbsp;&nbsp;&nbsp;(本周兵力分合计 * 受益率)</td>
						</tr>
						</logic:present>
						
						<logic:present name="gemSourceTotalPoint">
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">本周宝石分合计</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="gemSourceTotalPoint"/></td>
						</tr>
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">本周宝石分实际收益</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="gemSourceTotalPointRatio"/>&nbsp;&nbsp;&nbsp;&nbsp;(本周宝石分合计 * 受益率)</td>
						</tr>
						</logic:present>
						
						<logic:present name="gemPointPerSoldier">
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">本周宝石兵力比例</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="gemPointPerSoldier"/>&nbsp;&nbsp;&nbsp;&nbsp;(每1w防御对应的宝石 比率)</td>
						</tr>
						</logic:present>
						
						<logic:present name="ratio">
						<tr>
							<td bgcolor="#5F52A0" nowrap align="right">
								<strong><font color="#ffffff">受益率</strong></td>
							<td bgcolor="#B2BECE"><bean:write name="ratio"/>&nbsp;&nbsp;&nbsp;&nbsp;(若家族基金为 30%,则受益率为70%,即 0.7)</td>
						</tr>
						</logic:present>
						
					</table>

			</td>
		</tr>
	
	
	
	</table>
	
	<table border="0" cellpadding="0" cellspacing="0" align="center" width="1000">
		<tr>
			
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">国家</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">日期</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">君主</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">枪盾</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">大刀</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">骑兵</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="50" align="center"><strong><font color="#ffffff">重甲</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">原始兵分</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100" align="center"><strong><font color="#ffffff">实际收益兵分</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="80" align="center"><strong><font color="#ffffff">原始宝石分</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100" align="center"><strong><font color="#ffffff">实际收益宝石分</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100" align="center"><strong><font color="#ffffff">岗哨将令</font></strong></td>
			<td bgcolor="#5F52A0" nowrap  width="100" align="center"><strong><font color="#ffffff">最终宝石分</font></strong></td>
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
				<td align="center"><bean:write name="source" property="gangshaoJiangling"/></td>
				<td align="center"><bean:write name="source" property="finalSum"/></td>


			</tr>
			</logic:iterate>
		</logic:present>

		</td>
	</tr>


</table>



</body>
</html>