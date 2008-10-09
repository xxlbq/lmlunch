<%@ include file="/common/taglibs.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Nice Tabs! Menu (with Velocity) Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" type="text/css" media="screen" href="css/strutsMenu/global.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/strutsMenu/nicetabs.css" />

    <script type="text/javascript" src="js/strutsMenu/nicetabs.js"></script>
</head>
<body id="nicetabs">

<div id="header">
<menu:useMenuDisplayer name="Velocity" config="/templates/nicetabs.html"
    bundle="org.apache.struts.action.MESSAGE" >
    <ul class="menuList">
    <menu:displayMenu name="TabbedHome"/>
    <menu:displayMenu name="TabbedAbout"/>
    <menu:displayMenu name="TabbedContact"/>
    <menu:displayMenu name="TabbedExit"/>
    </ul>
</menu:useMenuDisplayer>
</div>

    <iframe frameBorder="0" id="mainFrame" name="mainFrame" scrolling="no" 
    	src="main.do" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1">
    </iframe>

<div id="source">
    <a href="<%=request.getRequestURI()%>.src">View JSP Source</a><br />
    <a href="<%=request.getContextPath()%>/index.jsp">Back to Index</a>
</div>

</body>
</html>
