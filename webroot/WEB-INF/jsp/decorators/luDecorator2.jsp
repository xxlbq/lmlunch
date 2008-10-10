<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-decorator.tld" prefix="decorator"%>
<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-page.tld" prefix="page"%>


<html>
    <head>
        <title>My Site - <decorator:title default="Welcome!" /></title>
        <decorator:head />
    </head>

    <body>
        <decorator:body />

        <decorator:getProperty property="page.content1"/>
        <decorator:getProperty property="page.content2"/>
        
        <!-- do nothing -->
        <decorator:getProperty property="page.content3"/>
       
        <p>This message is in /decorators/mydecorator2.jsp</p>
    </body>
</html>