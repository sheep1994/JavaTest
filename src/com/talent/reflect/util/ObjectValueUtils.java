package com.talent.reflect.util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 本类的功能是将字符串的内容根据属性独享的类型变为各种数据类型
 * 支持的类型：int（Integer）、double（Double）、long（Long）、String、Date
 * @author guobing
 *
 */
public class ObjectValueUtils {
	private ObjectValueUtils() {}
	
	/**
	 * 负责将传入的字符串变为与指定属性类型相复合的数据类型
	 * @param wrapObject
	 * @param attribute
	 * @param value
	 * @return
	 */
	public static Object getValue(Object wrapObject, String attribute, String value) throws Exception {
		Field field = ObjectUtils.getObjectField(wrapObject, attribute);
		if (field == null) {
			return null;
		}
		return stringToType(field.getType().getSimpleName(), value);
	}
	
	/**
	 * 根据指定的类型将字符串进行转型处理
	 * @param type
	 * @param value
	 * @return
	 */
	public static Object stringToType(String type, String value) {
		if ("String".equals(type)) {
			if (isNotEmpty(value)) {
				return value;
			} else {
				return null;
			}
		} else if ("int".equals(type) || "Integer".equals(type)) {
			if (isInt(value)) {
				return Integer.parseInt(value);
			}
		} else if ("double".equals(type) || "Double".equals(type)) {
			if (isDouble(value)) {
				return Double.parseDouble(value);
			}
		} else if ("long".equals(type) || "Long".equals(type)) {
			if (isInt(value)) {
				return Long.parseLong(value);
			}
		} else if ("Date".equals(type)) {
			String pattern = null;
			if (isDate(value)) {
				pattern = "yyyy-MM-dd";
			} else if (isDateTime(value)) {
				pattern = "yyyy-MM-dd hh:mm:ss";
			}
			if (pattern != null) {
				try {
					return new SimpleDateFormat(pattern).parse(value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				return null;
			}
		}
		return null;
	}
	
	
	private static boolean isDateTime(String str) {
		if (isNotEmpty(str)) {
			 return str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		}
		return false;
	}
	
	private static boolean isDate(String str) {
		if (isNotEmpty(str)) {
			return str.matches("\\d{4}-\\d{2}-\\d{2}");
		}
		return false;
	}
	
	private static boolean isDouble(String str) {
		if (isNotEmpty(str)) {
			return str.matches("\\d+(\\.\\d+)?");
		}
		return false;
	}
	
	private static boolean isInt(String str) {
		if (isNotEmpty(str)) {
			return str.matches("\\d+");
		}
		return false;
	}
	
	private static boolean isNotEmpty(String str) {
		return !(str == null || str.isEmpty() || "".equals(str));
	}
}
