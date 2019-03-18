package com.talent.reflect.util;

/**
 * @author guobing
 * @Title: BeanOperation
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:57
 */
public class BeanOperation {
	
	private BeanOperation() {}
	
	public static void setBeanValue(Object actionObject, String msg) throws Exception {
		// 拆分字符串
		String[] result = msg.split("\\|");
		for (int i = 0; i < result.length; i++) {
			String[] temp = result[i].split(":", 2);
			String attribute = temp[0];
			String[] field = attribute.split("\\.");
			// 多级
			if (field.length > 2) {
				Object currentObject = actionObject;
				for (int j = 0; j < field.length - 1; j ++) {
					currentObject = ObjectUtils.getObject(currentObject, field[j]);
				}
				Object value = ObjectValueUtils.getValue(currentObject, field[field.length - 1], temp[1]);
				// 在给emp设置属性
				ObjectUtils.setObjectValue(currentObject, field[field.length - 1], value);
			} else {
				// 获取到emp对象
				Object currentObject = ObjectUtils.getObject(actionObject, field[0]);
				Object value = ObjectValueUtils.getValue(currentObject, field[1], temp[1]);
				// 在给emp设置属性
				ObjectUtils.setObjectValue(currentObject, field[1], value);
			}
		}
	}

}
