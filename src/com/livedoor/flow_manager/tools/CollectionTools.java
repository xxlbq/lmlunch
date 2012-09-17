package com.livedoor.flow_manager.tools;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

public class CollectionTools {
	
	public static List<LabelValueBean> toCollection(List<String> gsList) {
		List<LabelValueBean> ds = new ArrayList<LabelValueBean>();
		for (Object obj : gsList) {
			LabelValueBean bean = new LabelValueBean((String)obj, (String)obj);
			ds.add(bean);
		}
		return ds;
	}
}
