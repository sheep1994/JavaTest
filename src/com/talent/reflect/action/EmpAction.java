package com.talent.reflect.action;

import com.talent.reflect.util.BeanOperation;
import com.talent.reflect.vo.Emp;

/**
 * @author guobing
 * @Title: EmpAction
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:57
 */
public class EmpAction {
	private Emp emp;
	
	public void setValue(String val) {
		try {
			BeanOperation.setBeanValue(this, val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
