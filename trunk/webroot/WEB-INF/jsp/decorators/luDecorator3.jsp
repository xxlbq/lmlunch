<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-decorator.tld" prefix="decorator"%>
<%@ taglib uri="/WEB-INF/conf/tld/sitemesh-page.tld" prefix="page"%>


<html>
    <head>
        <title>My Site - <decorator:title default="Welcome!" /></title>
        <decorator:head />
    </head>

    <body>
        <decorator:body />

        <page:applyDecorator name="luDecorator31">
            <content tag="content1"><p>This is content1</p></content>
            <content tag="content2"><p>This is content2</p></content>
        </page:applyDecorator>
    </body>
</html>
