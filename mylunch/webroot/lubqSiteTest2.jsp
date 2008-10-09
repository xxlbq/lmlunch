<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>This is test2</title>
    </head>
   
    <body>
    <b>This is test2</b>
    <b>Use &lt;decorator:getProperty&gt; tag</b>
   
    <content tag="content1"><p>This is content1</p></content>
    <content tag="content2">999<p>9This is content2</p></content>
    <content tag="content4"><p>This is content4, it shouldn't be display</p></content>
    </body>
</html>