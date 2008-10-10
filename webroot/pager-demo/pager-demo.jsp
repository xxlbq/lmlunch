<%@ page language="java" contentType="text/html; charset=gb2312"%>

<%@ taglib uri="/WEB-INF/conf/tld/pager-taglib.tld" prefix="pg" %>

<pg:pager>
  <pg:param name="keywords"/>

  <ex:searchresults>
    <pg:item>
      <%= searchResult %>
    </pg:item>
  </ex:searchresults>

  <pg:index>

    <pg:first>
      <a href="<%= pageUrl %>">[ (<%= pageNumber %>) |&lt; Previous ]</a>
    </pg:first>

    <pg:prev>
      <a href="<%= pageUrl %>">[ (<%= pageNumber %>) &lt;&lt; Previous ]</a>
    </pg:prev>

    <pg:pages>
       <a href="<%= pageUrl %>"><%= pageNumber %></a> 
    </pg:pages>

    <pg:next>
      <a href="<%= pageUrl %>">[ Next &gt;&gt; (<%= pageNumber %>) ]</a>
    </pg:next>

    <pg:last>
      <a href="<%= pageUrl %>">[ Last &gt;| (<%= pageNumber %>) ]</a>
    </pg:last>

  </pg:index>
</pg:pager>
