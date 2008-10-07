<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-decorator.tld" prefix="decorator"%>
<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-page.tld" prefix="page"%>
<html>
    <head>
        <title>(decorator:title) -> <decorator:title default="no title set ! this is default tittle ." /></title>
        <decorator:head />
    </head>
    <body>
        <decorator:body />
        <p>This message is in /decorators/luTest.jsp</p>       
    </body>
</html>