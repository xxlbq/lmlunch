
package com.livedoor.flow_manager.sources.enums;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.enums.ValuedEnum;


public class DeleteFlagEnum extends ValuedEnum{

	private static final int DELETE = 1;
	private static final int NOT_DELETE = 0;
	
	protected DeleteFlagEnum(String name, int value) {
		super(name, value);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final DeleteFlagEnum DELETE_ENUM = new DeleteFlagEnum("DELETE", DELETE);
	
	public static final DeleteFlagEnum NOT_DELETE_ENUM = new DeleteFlagEnum("NOT_DELETE", NOT_DELETE);
	
	public static DeleteFlagEnum getEnum(String status) {
		return (DeleteFlagEnum) getEnum(DeleteFlagEnum.class,status);
	}

	public static DeleteFlagEnum getEnum(int status) {
		return (DeleteFlagEnum) getEnum(DeleteFlagEnum.class,status);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Integer> getEnumMap() {
		return getEnumMap(DeleteFlagEnum.class);
	}

	@SuppressWarnings("unchecked")
	public static List<DeleteFlagEnum> getEnumList() {
		return getEnumList(DeleteFlagEnum.class);
	}

	@SuppressWarnings("unchecked")
	public static Iterator<DeleteFlagEnum> iterator() {
		return iterator(DeleteFlagEnum.class);
	}
	
	
}
