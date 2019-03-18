package com.talent.reflect.vo;

import java.util.Date;

/**
 * @author guobing
 * @Title: Emp
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:48
 */
public class Emp {

    private String ename;

    private Double salary;

    private Date hiredate;

    /**
     * 部门
     */
    private Dept dept;

    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Emp [ename=" + ename + ", salary=" + salary + ", hiredate=" + hiredate + ", dept=" + dept + ", job="
                + job + "]";
    }
}
