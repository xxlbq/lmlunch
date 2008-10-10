///*
// *  Pager Tag Library
// *
// *  Copyright (C) 2007  lu baoqiang <xxlbq@163.com>
// *
// *   
// *  
// */
//
//package com.livedoor.flow_manager.common.lm.pager;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.jsp.*;
//import javax.servlet.jsp.tagext.*;
//
//import org.springframework.web.struts.MappingDispatchActionSupport;
//
//import java.io.IOException;
//import com.jsptags.navigation.pager.parser.*;
//
//public final class LmPagerTag extends TagSupport {
//	
//
//	static final String DEFAULT_ID = "lmPager";
//
//	private static final int
//		DEFAULT_ITEMS_COUNT = Integer.MAX_VALUE,
//		DEFAULT_MAX_PAGE_ITEMS = 10,
//		DEFAULT_PAGE_NO = 1;
//
////	static final String
////		OFFSET_PARAM = ".offset";
//
//	static final String
//		// scope values
//		PAGE = "page",
//		REQUEST = "request",
//		SESSION = "session";
//
//	/*
//	 * Tag Properties
//	 */
//	private String url = null;
//	private String index = null;
//	private int itemsCount = 0;
////	private int maxPageItems = DEFAULT_MAX_PAGE_ITEMS;
////	private int maxIndexPages = DEFAULT_MAX_INDEX_PAGES;
////	private boolean isOffset = false;
////	private String export = null;
//	private String scope = null;
//
//	/*
//	 * Tag Variables
//	 */
//	private StringBuffer uri = null;
//	private String paramsMap = null;
////	private int offset = 0;
//	
//	private int pageNumber = 0;
//	private Integer pageNumberInteger = null;
//
////	private String idOffsetParam = DEFAULT_ID+OFFSET_PARAM;
////	private PagerTagExport pagerTagExport = null;
////	private Object oldPager = null;
////	private Object oldOffset = null;
////	private Object oldPageNumber = null;
//
//
//	public LmPagerTag() {
//		id = DEFAULT_ID;
//	}
//
//	public final void setId(String sid) {
//		super.setId(sid);
////		idOffsetParam = sid+OFFSET_PARAM;
//	}
//
//	
//
//
////	public final void setIndex(String val) throws JspException {
////		if (!(val == null ||
////		      CENTER.equals(val) ||
////		      FORWARD.equals(val) ||
////			  HALF_FULL.equals(val)))
////		{
////			throw new JspTagException("value for attribute \"index\" " +
////				"must be either \"center\", \"forward\" or \"half-full\".");
////		}
////		index = val;
////	}
////
//
//	
//
//	public final void setScope(String val) throws JspException {
//		if (!(val == null || PAGE.equals(val) 
//				|| REQUEST.equals(val) || SESSION.equals(val)))
//		{
//			throw new JspTagException("value for attribute \"scope\" " +
//				"must be either \"page\" or \"request\" or \"session\".");
//		}
//		scope = val;
//	}
//
//	public final String getScope() {
//		return scope;
//	}
//
//
//
////	final void addParam(String name, String value) {
////		if (value != null) {
////			name = java.net.URLEncoder.encode(name);
////			value = java.net.URLEncoder.encode(value);
////
////			uri.append(params == 0 ? '?' : '&')
////			   .append(name).append('=').append(value);
////
////		   params++;
////
////		} else {
////			String[] values = pageContext.getRequest().getParameterValues(name);
////
////			if (values != null) {
////				name = java.net.URLEncoder.encode(name);
////				for (int i = 0, l = values.length; i < l; i++) {
////					value = java.net.URLEncoder.encode(values[i]);
////					uri.append(params == 0 ? '?' : '&')
////					   .append(name).append('=').append(value);
////
////					params++;
////				}
////			}
////		}
////	}
//
////	final boolean nextItem() {
////		boolean showItem = false;
////		if (itemCount < maxItems) {
////			showItem = (itemCount >= offset &&
////			            itemCount < (offset + maxPageItems));
////			itemCount++;
////		}
////		return showItem;
////	}
//
//
////	final int getOffset() {
////		return offset;
////	}
//
//
////	final boolean isIndexNeeded() {
////		return (offset != 0 || getItemCount() > maxPageItems);
////	}
//
//
//	final boolean hasPrevPage() {
//		return (offset > 0);
//	}
//
////	final boolean hasNextPage() {
////		return (getItemCount() > getNextOffset());
////	}
//
//	final boolean hasPage(int page) {
//		return (page >= 0 && getItemCount() > (page * maxPageItems));
//	}
//
//
////	final int getPrevOffset() {
////		return Math.max(0, offset - maxPageItems);
////	}
////
////	final int getNextOffset() {
////		return offset + maxPageItems;
////	}
//
//
////	final String getOffsetUrl(int pageOffset) {
////		int uriLen = uri.length();
////		uri.append(params == 0 ? '?' : '&')
////		   .append(idOffsetParam).append('=').append(pageOffset);
////		String offsetUrl = uri.toString();
////		uri.setLength(uriLen);
////		return offsetUrl;
////	}
//
////	final String getPageUrl(int i) {
////		return getOffsetUrl(maxPageItems * i);
////	}
//
//
//	final Integer getOffsetPageNumber(int pageOffset) {
//		return new Integer(1+pageNumber(pageOffset));
//	}
//
//	final Integer getPageNumber(int i) {
//		if (i == pageNumber)
//			return pageNumberInteger;
//		return new Integer(1+i);
//	}
//
//	final int getPageNumber() {
//		return pageNumber;
//	}
//
//	final int getPageCount() {
//		return pageNumber(getItemCount());
//	}
//
//
//	final int getFirstIndexPage() {
//		int firstPage = 0;
//		int halfIndexPages = maxIndexPages / 2;
//
//		if (FORWARD.equals(index)) {
//			firstPage = Math.min(pageNumber + 1, getPageCount());
//		} else if (!(HALF_FULL.equals(index) && pageNumber < halfIndexPages)) {
//			int pages = getPageCount();
//			if (pages > maxIndexPages) {
//				// put the current page in middle of the index
//				firstPage = Math.max(0, pageNumber - halfIndexPages);
//
//				int indexPages = pages - firstPage;
//				if (indexPages < maxIndexPages)
//					firstPage -= (maxIndexPages - indexPages);
//			}
//		}
//
//		return firstPage;
//	}
//
//	final int getLastIndexPage(int firstPage) {
//		int pages = getPageCount();
//		int halfIndexPages = maxIndexPages / 2;
//		int maxPages;
//		if (HALF_FULL.equals(index) && pageNumber < halfIndexPages) {
//			maxPages = pageNumber + halfIndexPages;
//		} else {
//			maxPages = firstPage + maxIndexPages; 
//		}
//		return (pages <= maxPages ? pages : maxPages) - 1;
//	}
//
//
//	final int getItemCount() {
//		return (items != 0 ? items : itemCount);
//	}
//
//	private final int pageNumber(int offset) {
//		return (offset / maxPageItems) + (offset % maxPageItems == 0 ? 0 : 1);
//	}
//
//
//	public int doStartTag() throws JspException {
//
//		String baseUri;
//		if (url != null) {
//			baseUri = url;
//		} else {
//			baseUri = ((HttpServletRequest)pageContext.getRequest())
//				.getRequestURI();
//			int i = baseUri.indexOf('?');
//			if (i != -1)
//				baseUri = baseUri.substring(0, i);
//		}
//		if (uri == null)
//			uri = new StringBuffer(baseUri.length() + 32);
//		else
//			uri.setLength(0);
//		uri.append(baseUri);
//
//
//		params = 0;
//		offset = 0;
//		itemCount = 0;
//
//		String offsetParam =
//			pageContext.getRequest().getParameter(idOffsetParam);
//		if (offsetParam != null) {
//			try {
//				offset = Math.max(0, Integer.parseInt(offsetParam));
//				if (isOffset)
//					itemCount = offset;
//			} catch (NumberFormatException ignore) {
//			}
//		}
//
//		pageNumber = pageNumber(offset);
//		pageNumberInteger = new Integer(1+pageNumber);
//
//
//		if (REQUEST.equals(scope)) {
//			ServletRequest request = pageContext.getRequest();
//
//			oldPager = request.getAttribute(id);
//			request.setAttribute(id, this);
//
//			if (pagerTagExport != null) {
//				String name;
//				if ((name = pagerTagExport.getPageOffset()) != null) {
//					oldOffset = request.getAttribute(name);
//					request.setAttribute(name, new Integer(offset));
//				}
//				if ((name = pagerTagExport.getPageNumber()) != null) {
//					oldPageNumber = request.getAttribute(name);
//					request.setAttribute(name, pageNumberInteger);
//				}
//			}
//		} else {
//			if (pagerTagExport != null) {
//				String name;
//				if ((name = pagerTagExport.getPageOffset()) != null) {
//					oldOffset = pageContext.getAttribute(name);
//					pageContext.setAttribute(name, new Integer(offset));
//				}
//				if ((name = pagerTagExport.getPageNumber()) != null) {
//					oldPageNumber = pageContext.getAttribute(name);
//					pageContext.setAttribute(name, pageNumberInteger);
//				}
//			}
//		}
//
//		return EVAL_BODY_INCLUDE;
//	}
//
//	private static void restoreAttribute(ServletRequest request, String name,
//		Object oldValue)
//	{
//		if (oldValue != null)
//			request.setAttribute(name, oldValue);
//		else 
//			request.removeAttribute(name);
//	}
//
//	private static void restoreAttribute(PageContext pageContext, String name,
//		Object oldValue)
//	{
//		if (oldValue != null)
//			pageContext.setAttribute(name, oldValue);
//		else 
//			pageContext.removeAttribute(name);
//	}
//
//
//	public int doEndTag() throws JspException {
//		if (REQUEST.equals(scope)) {
//			ServletRequest request = pageContext.getRequest();
//
//			restoreAttribute(request, id, oldPager);
//			oldPager = null;
//
////			if (pagerTagExport != null) {
////				String name;
////				if ((name = pagerTagExport.getPageOffset()) != null) {
////					restoreAttribute(request, name, oldOffset);
////					oldOffset = null;
////				}
////
////				if ((name = pagerTagExport.getPageNumber()) != null) {
////					restoreAttribute(request, name, oldPageNumber);
////					oldPageNumber = null;
////				}
////			}
//		} else {
////			if (pagerTagExport != null) {
////				String name;
////				if ((name = pagerTagExport.getPageOffset()) != null) {
////					restoreAttribute(pageContext, name, oldOffset);
////					oldOffset = null;
////				}
////
////				if ((name = pagerTagExport.getPageNumber()) != null) {
////					restoreAttribute(pageContext, name, oldPageNumber);
////					oldPageNumber = null;
////				}
////			}
//		}
//
//		// limit size of re-usable StringBuffer
//		if (uri.capacity() > 1024)
//			uri = null;
//
//		pageNumberInteger = null;
//
//		return EVAL_PAGE;
//	}
//
//	public void release() {
//		url = null;
//		index = null;
////		items = 0;
////		maxItems = DEFAULT_MAX_ITEMS;
////		maxPageItems = DEFAULT_MAX_PAGE_ITEMS;
////		maxIndexPages = DEFAULT_MAX_INDEX_PAGES;
////		isOffset = false;
////		export = null;
//		scope = null;
//
//		uri = null;
////		params = 0;
////		offset = 0;
////		itemCount = 0;
//		pageNumber = 0;
//		pageNumberInteger = null;
//
////		idOffsetParam = DEFAULT_ID+OFFSET_PARAM;
////		pagerTagExport = null;
////		oldPager = null;
////		oldOffset = null;
////		oldPageNumber = null;
//
//		super.release();
//	}
//	
//	
//	
//	
//
////	public final String getIndex() {
////		return index;
////	}
//
//
////	public final void setItems(int value) {
////		items = value;
////	}
////
////	public final int getItems() {
////		return items;
////	}
////
////
////	public final void setMaxItems(int value) {
////		maxItems = value;
////	}
////
////	public final int getMaxItems() {
////		return maxItems;
////	}
////
////
////	public final void setMaxPageItems(int value) {
////		maxPageItems = value;
////	}
////
////	public final int getMaxPageItems() {
////		return maxPageItems;
////	}
//
//
////	public final void setMaxIndexPages(int value) {
////		maxIndexPages = value;
////	}
////
////	public final int getMaxIndexPages() {
////		return maxIndexPages;
////	}
//
//
////	public final void setIsOffset(boolean val) {
////		isOffset = val;
////	}
////
////	public final boolean getIsOffset() {
////		return isOffset;
////	}
//	
//	public final void setUrl(String value) {
//		url = value;
//	}
//
//	public final String getUrl() {
//		return url;
//	}
//
//}
//
///* vim:set ts=4 sw=4: */
