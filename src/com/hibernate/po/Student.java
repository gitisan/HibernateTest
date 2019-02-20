package com.hibernate.po;

import java.util.Date;

public class Student {
	
	//1  公有的类
	//提供公有的不带参数的默认的构造方法
	//属性私有
	// 属性setter/getter 封装
	private Integer sid;
	private String sname;
	private Date birthday;
	private String address;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
