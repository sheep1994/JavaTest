package com.talent.reflect.test;

import com.talent.reflect.action.EmpAction;

/**
 * @author guobing
 * @Title: TestDemo
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:57
 */
public class TestDemo {
	public static void main(String[] args) {
		String value = "emp.ename:张三|emp.job:研发工程师|emp.dept.dname:财务部|emp.dept.company.name:大搜车|emp.salary:1999.21|emp.hiredate:1999-10-10|emp.dept.count:1999|emp.dept.company.cid:10|emp.dept.company:1990-12-12";
		EmpAction action = new EmpAction();
		action.setValue(value);
		System.out.println(action.getEmp());
	}
}
