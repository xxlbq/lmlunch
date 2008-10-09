<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp" %>


<html>
<head>
<title>permission</title>
</head>

<div id="content" style="width: 60%">
    <h2>CSS Tabs with Submenus</h2>
    <p>
        This example uses a Velocity template to render its HTML. Otherwise,
        it's the same as the <a href="tabbedMenu.jsp?Home">Tabbed Menu Example</a>.
        However, this one is much better (in my opinion) because you have full
        control over the HTML (via Velocity templates) and display logic. 
    </p>
</div>

<div id="content">
<b> the following is taken from a coolmenus3 example: </b>
<hr>
As you can see in this page there are form elements. In Netscape 4 there's a bug that makes ALL form elements
get the highest z-index. That means that the form elements "shines" trough the elements. In explorer and netscape 6 this only goes 
for select boxes. So I have made a check that you can turn on (oCMenu.checkselect) that checks for select boxes and
hides them if they come in the way of the menu. Unfortunatly this can not be done in Netscape so I have added another workaround to 
that problem on this page. Surround your entire form with a ILAYER tag (ilayers are positioned relative by default). Add a id to 
the layer and place that id inside the variable oCMenu.hideForm, like this: oCMenu.hideForm="document.LAYER_NAME"
<hr>
<br>

I have also found that Netscape 4 does not render the characters correctly after the form has been hidden if the content-type is set to UTF-8.  This may mean that you can't use this technique for netscape 4 and internationalized sites that are not ascii.  I haven't tested this thouroughly, but I think there definately some issues.  I've commented out the content-type directive in the jsp page.

</div>

<div id="source">
	<a href="/struts-menu-2.4.3/coolmenu2.jsp.src">View JSP Source</a>
  <br />
  <a href="/struts-menu-2.4.3/index.jsp">Back to Index</a>
</div>



<div class="note" style="margin: 20px; margin-right: 100px">
    This menu is based on <a href="http://www.alistapart.com/articles/horizdropdowns">this article</a>
    and <a href="http://www.nickrigby.com/examples/dropdown3/index.htm">demo</a> from Nick Rigby.
    <br/><br/>
    To use this menu in your application, you'll need to copy the CSS and IE-specific JavaScript from
    this page (view-source to get it).  Your &lt;menu:useMenuDisplayer&gt; tag should look as follows:
    <pre style="font-size: 12px; background: #ffd; padding: 5px; border: 1px solid silver">
&lt;menu:useMenuDisplayer name="CSSListMenu" id="primary-nav"&gt;</pre>
    If you change the "id" attribute, make sure you change it in your CSS/JavaScript as well. In
    menu-config.xml, you'll need to define the "CSSListMenu" displayer.
    <pre style="font-size: 12px; background: #ffd; padding: 5px; border: 1px solid silver">
&lt;Displayer name="CSSListMenu" type="net.sf.navigator.displayer.CSSListMenuDisplayer"/&gt;</pre>
    
    The CSSListMenuDisplayer was added to Struts Menu in version 2.4. 
    <br/><br/>
    <a href="/struts-menu-2.4.3/cssHorizontal.jsp.src">View Source</a> to see how the Velocity version of this menu
    or <a href="?velocity=true">click here to view it</a>.
    <br/><br/>
    <a href="/struts-menu-2.4.3/cssVertical.jsp">&raquo; View vertical version of this menu</a>
    <br/><br/>
    <a href="/struts-menu-2.4.3/">&laquo; Return to Index of Menus</a>
</div>
</html>