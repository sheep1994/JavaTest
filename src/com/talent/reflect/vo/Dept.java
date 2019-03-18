package com.talent.reflect.vo;

/**
 * @author guobing
 * @Title: Dept
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:53
 */
public class Dept {
    private String dname;

    private String loc;

    /**
     * 总员工数
     */
    private Long count;

    private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Dept [dname=" + dname + ", loc=" + loc + ", count=" + count + ", company=" + company + "]";
    }
}
