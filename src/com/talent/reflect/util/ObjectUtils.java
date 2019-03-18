package com.talent.reflect.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author guobing
 * @Title: ObjectUtils
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:57
 */
public class ObjectUtils {
	private ObjectUtils() {}
	
	public static Field getObjectField(Object wrapObject, String attribute) throws Exception {
		// 找到本类中指定名称的属性
		Field field = wrapObject.getClass().getDeclaredField(attribute);
		if (Objects.isNull(field)) {
			field = wrapObject.getClass().getField(attribute);
		}
		if (Objects.isNull(field)) {
			return null;
		}
		return field;
	}
	
	/**
	 * 设置属性值
	 */
	public static void setObjectValue(Object wrapObject, String attribute, Object val) throws Exception {
		// 组装需要调用的setter方法
		String methodName = "set" + StringUtils.initcap(attribute);
		// 找到本类中指定名称的属性
		Field field = getObjectField(wrapObject, attribute);
		Method method = wrapObject.getClass().getMethod(methodName, field.getType());
		method.invoke(wrapObject, val);
	}
	
	/**
	 * 获取属性
	 * @param wrapObject
	 * @param attribute
	 * @return
	 * @throws Exception
	 */
	public static Object getObject(Object wrapObject, String attribute) throws Exception {
		// 组装需要调用的getter方法
		String methodName = "get" + StringUtils.initcap(attribute);
		// 找到本类中指定名称的属性
		Field field = getObjectField(wrapObject, attribute);
		Method method = wrapObject.getClass().getMethod(methodName);
		Object obj = method.invoke(wrapObject);
		// 如果obj对象为空，那么就自动实例化对象
		if (Objects.isNull(obj)) {
			obj = field.getType().newInstance();
			setObjectValue(wrapObject, attribute, obj);
		}
		return obj;
	}
}
