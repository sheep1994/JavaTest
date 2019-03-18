package com.talent.reflect.vo;

import java.util.Date;

/**
 * @author guobing
 * @Title: Company
 * @ProjectName JavaTest
 * @Description: TODO
 * @date 2019/3/18上午10:54
 */
public class Company {

    private Integer cid;
    private String name;
    private String address;
    private Date create;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Date getCreate() {
        return create;
    }
    public void setCreate(Date create) {
        this.create = create;
    }
    @Override
    public String toString() {
        return "Company [cid=" + cid + ", name=" + name + ", address=" + address + ", create=" + create + "]";
    }
}
