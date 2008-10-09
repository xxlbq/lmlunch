<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-decorator.tld" prefix="decorator"%>
<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-page.tld" prefix="page"%>


<p><i>begin</i></>
<decorator:getProperty property="page.content1"/>
<decorator:getProperty property="page.content2"/>
<p><i>end</i></>

