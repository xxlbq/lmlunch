package com;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

public class ww extends HttpJspBase {


  private static java.util.Vector _jspx_includes;

  static {
    _jspx_includes = new java.util.Vector(2);
    _jspx_includes.add("/common/taglibs.jsp");
    _jspx_includes.add("/common/meta.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_decorator_title_default;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_decorator_head;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_decorator_getProperty_writeEntireProperty_property;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_admin_authmenu_layers_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_decorator_body;

  public ww() {
    _jspx_tagPool_decorator_title_default = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_c_url_value = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_decorator_head = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_decorator_getProperty_writeEntireProperty_property = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_admin_authmenu_layers_action = new org.apache.jasper.runtime.TagHandlerPool();
    _jspx_tagPool_decorator_body = new org.apache.jasper.runtime.TagHandlerPool();
  }

  public java.util.List getIncludes() {
    return _jspx_includes;
  }

  public void _jspDestroy() {
    _jspx_tagPool_decorator_title_default.release();
    _jspx_tagPool_c_url_value.release();
    _jspx_tagPool_decorator_head.release();
    _jspx_tagPool_decorator_getProperty_writeEntireProperty_property.release();
    _jspx_tagPool_admin_authmenu_layers_action.release();
    _jspx_tagPool_decorator_body.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    javax.servlet.jsp.PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n");
      out.write("\r\n\r\n\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-store\" />\r\n");
      out.write("<!-- meta http-equiv=\"Cache-Control\" content=\"no-cache\" / -->\r\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-cache\" />\r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\" />\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"copyright\" content=\"Nanerdang Co.,Ltd\" />\r\n\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/strutsMenu/global.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/strutsMenu/nicetabs.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"css/component/button.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/strutsMenu/nicetabs.js\">");
      out.write("</script>\r\n\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n\r\n\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n\r\n");
      out.write("<title>");
      if (_jspx_meth_decorator_title_0(pageContext))
        return;
      out.write("</title>\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_url_0(pageContext))
        return;
      out.write("\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      if (_jspx_meth_decorator_head_0(pageContext))
        return;
      out.write("\r\n");
      out.write("</head>\r\n\r\n");
      out.write("<body\r\n");
      if (_jspx_meth_decorator_getProperty_0(pageContext))
        return;
      out.write(">\r\n");
      out.write("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"logo\">\r\n  ");
      out.write("<tr>\r\n    ");
      out.write("<td>");
      out.write("</td>\r\n  ");
      out.write("</tr>\r\n");
      out.write("</table>\r\n\r\n\r\n");
      if (_jspx_meth_admin_authmenu_0(pageContext))
        return;
      out.write("\r\n\r\n");
      if (_jspx_meth_decorator_body_0(pageContext))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n\r\n");
    } catch (Throwable t) {
      out = _jspx_out;
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
    }
  }

  private boolean _jspx_meth_decorator_title_0(javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  decorator:title ---- */
    com.opensymphony.module.sitemesh.taglib.decorator.TitleTag _jspx_th_decorator_title_0 = (com.opensymphony.module.sitemesh.taglib.decorator.TitleTag) _jspx_tagPool_decorator_title_default.get(com.opensymphony.module.sitemesh.taglib.decorator.TitleTag.class);
    _jspx_th_decorator_title_0.setPageContext(pageContext);
    _jspx_th_decorator_title_0.setParent(null);
    _jspx_th_decorator_title_0.setDefault("top...");
    int _jspx_eval_decorator_title_0 = _jspx_th_decorator_title_0.doStartTag();
    if (_jspx_th_decorator_title_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_decorator_title_default.reuse(_jspx_th_decorator_title_0);
    return false;
  }

  private boolean _jspx_meth_c_url_0(javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  c:url ---- */
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _jspx_tagPool_c_url_value.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(pageContext);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/css/main.css");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_url_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_decorator_head_0(javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  decorator:head ---- */
    com.opensymphony.module.sitemesh.taglib.decorator.HeadTag _jspx_th_decorator_head_0 = (com.opensymphony.module.sitemesh.taglib.decorator.HeadTag) _jspx_tagPool_decorator_head.get(com.opensymphony.module.sitemesh.taglib.decorator.HeadTag.class);
    _jspx_th_decorator_head_0.setPageContext(pageContext);
    _jspx_th_decorator_head_0.setParent(null);
    int _jspx_eval_decorator_head_0 = _jspx_th_decorator_head_0.doStartTag();
    if (_jspx_th_decorator_head_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_decorator_head.reuse(_jspx_th_decorator_head_0);
    return false;
  }

  private boolean _jspx_meth_decorator_getProperty_0(javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  decorator:getProperty ---- */
    com.opensymphony.module.sitemesh.taglib.decorator.PropertyTag _jspx_th_decorator_getProperty_0 = (com.opensymphony.module.sitemesh.taglib.decorator.PropertyTag) _jspx_tagPool_decorator_getProperty_writeEntireProperty_property.get(com.opensymphony.module.sitemesh.taglib.decorator.PropertyTag.class);
    _jspx_th_decorator_getProperty_0.setPageContext(pageContext);
    _jspx_th_decorator_getProperty_0.setParent(null);
    _jspx_th_decorator_getProperty_0.setProperty("body.onload");
    _jspx_th_decorator_getProperty_0.setWriteEntireProperty("true");
    int _jspx_eval_decorator_getProperty_0 = _jspx_th_decorator_getProperty_0.doStartTag();
    if (_jspx_th_decorator_getProperty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_decorator_getProperty_writeEntireProperty_property.reuse(_jspx_th_decorator_getProperty_0);
    return false;
  }

  private boolean _jspx_meth_admin_authmenu_0(javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  admin:authmenu ---- */
    com.livedoor.flow_manager.common.taglib.AuthMenuTag _jspx_th_admin_authmenu_0 = (com.livedoor.flow_manager.common.taglib.AuthMenuTag) _jspx_tagPool_admin_authmenu_layers_action.get(com.livedoor.flow_manager.common.taglib.AuthMenuTag.class);
    _jspx_th_admin_authmenu_0.setPageContext(pageContext);
    _jspx_th_admin_authmenu_0.setParent(null);
    _jspx_th_admin_authmenu_0.setAction("");
    _jspx_th_admin_authmenu_0.setLayers("");
    int _jspx_eval_admin_authmenu_0 = _jspx_th_admin_authmenu_0.doStartTag();
    if (_jspx_th_admin_authmenu_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_admin_authmenu_layers_action.reuse(_jspx_th_admin_authmenu_0);
    return false;
  }

  private boolean _jspx_meth_decorator_body_0(javax.servlet.jsp.PageContext pageContext)
          throws Throwable {
    JspWriter out = pageContext.getOut();
    /* ----  decorator:body ---- */
    com.opensymphony.module.sitemesh.taglib.decorator.BodyTag _jspx_th_decorator_body_0 = (com.opensymphony.module.sitemesh.taglib.decorator.BodyTag) _jspx_tagPool_decorator_body.get(com.opensymphony.module.sitemesh.taglib.decorator.BodyTag.class);
    _jspx_th_decorator_body_0.setPageContext(pageContext);
    _jspx_th_decorator_body_0.setParent(null);
    int _jspx_eval_decorator_body_0 = _jspx_th_decorator_body_0.doStartTag();
    if (_jspx_th_decorator_body_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_decorator_body.reuse(_jspx_th_decorator_body_0);
    return false;
  }
}
