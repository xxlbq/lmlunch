/*
 *  Pager Tag Library
 *
 *  Copyright (C) 2002  James Klicman <james@jsptags.com>
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.jsptags.navigation.pager;

import javax.servlet.jsp.JspException;

public final class ParamTag extends PagerTagSupport {

	private String name = null;
	private String value = null;
	
	private String property = null;
	private String scope = null;
	
	

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public final void setName(String val) {
		name = val;
	}

	public final String getName() {
		return name;
	}

	public final void setValue(String val) {
		value = val;
	}

	public final String getValue() {
		return value;
	}

	public int doStartTag() throws JspException {
		super.doStartTag();

//		pagerTag.addParam(name, value);
		pagerTag.addParamScope(name, value,scope,property);

		return EVAL_BODY_INCLUDE;
	}

	public void release() {
		name = null;
		value = null;
		super.release();
	}
}

/* vim:set ts=4 sw=4: */
