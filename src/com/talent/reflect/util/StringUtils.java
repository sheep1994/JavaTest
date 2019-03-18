package com.talent.reflect.util;

/**
 * @author guobing
 * @Title: StringUtils
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:57
 */
public class StringUtils {
	private StringUtils() {}
	
	public static String initcap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
}
